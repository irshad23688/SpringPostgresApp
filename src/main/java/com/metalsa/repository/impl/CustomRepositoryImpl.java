package com.metalsa.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metalsa.constant.MetalsaConstant;
import com.metalsa.domain.MmrCompareDataSheetView;
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.domain.MmrSysConfigUt;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.model.DataSheetDashboardModel;
import com.metalsa.model.SearchBaseModel;
import com.metalsa.model.SearchModel;
import com.metalsa.model.UserMasterModel;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.MMRSearchDataSheetviewRepository;
import com.metalsa.repository.SysConfigRepository;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private SysConfigRepository sysConfigRepository;
	@Autowired
	private MMRSearchDataSheetviewRepository dataSheetviewRepository;

	@Override
	public List<MmrDataSheetUt> getDataSheetByClassNSubclass(Long classId, Long subClassId) {
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrDataSheetUt> cr = cb.createQuery(MmrDataSheetUt.class);
		Root<MmrDataSheetUt> root = cr.from(MmrDataSheetUt.class);

		Predicate[] predicates = new Predicate[2];
		predicates[0] = cb.equal(root.get("classId"),classId);
		predicates[1] = cb.equal(root.get("subclassId"), subClassId);
		cr.select(root).where(predicates);
		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();

		Query<MmrDataSheetUt> query = session.createQuery(cr);
		return query.getResultList();
	}

	@Override
	public MmrTestSheetUt getTestSheetByClassNSubclass(Long classId, Long subClassId) {
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrTestSheetUt> cr = cb.createQuery(MmrTestSheetUt.class);
		Root<MmrTestSheetUt> root = cr.from(MmrTestSheetUt.class);

		Predicate[] predicates = new Predicate[3];
		predicates[0] = cb.equal(root.get("mmrClassMasterUt"),classId);
		predicates[1] = cb.equal(root.get("mmrSubclassMasterUt"), subClassId);
		predicates[2] = cb.equal(root.get("status"), 1);
		cr.select(root).where(predicates);
		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();

		Query<MmrTestSheetUt> query = session.createQuery(cr);
		if(!query.getResultList().isEmpty()) {
			return query.getResultList().get(0);
		}
		return new MmrTestSheetUt();
	}

	@Override
	public List<MmrSearchDataSheetView> getSearchDataSheetView(SearchModel model) {

		List<Long> datasheets = new ArrayList<>();
		if(!model.getTextBaseAttributeList().isEmpty()) {
			CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
			CriteriaQuery<MmrSearchDataSheetView> cr = cb.createQuery(MmrSearchDataSheetView.class);
			Root<MmrSearchDataSheetView> root = cr.from(MmrSearchDataSheetView.class);
			List<Predicate> predicates = new ArrayList<>();
			populateTextBaseAttributePredicate(model,cb,root,predicates);
			Predicate predicate = cb.or((Predicate[]) predicates.toArray(new Predicate[0]));
			cr.select(root).where(predicate);
			Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();
			Query<MmrSearchDataSheetView> query = session.createQuery(cr);
			List<MmrSearchDataSheetView> lst = query.getResultList();
			for (MmrSearchDataSheetView mmrSearchDataSheetView : lst) {
				datasheets.add(mmrSearchDataSheetView.getDataSheetId());
			}
		}

		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrSearchDataSheetView> cr = cb.createQuery(MmrSearchDataSheetView.class);
		Root<MmrSearchDataSheetView> root = cr.from(MmrSearchDataSheetView.class);
		List<Predicate> predicates = new ArrayList<>();
		Predicate revisionPredicate = null;
		if(!model.isShowRevision()) {
			revisionPredicate = cb.equal(root.get("status"),MetalsaConstant.STATUS.APPROVED);
		}

		Predicate dataSheetPredicate = null;
		if(!datasheets.isEmpty()) {
			List<Predicate> datasheetPredicates = new ArrayList<>();
			for (Long dataSheetId : datasheets) {
				datasheetPredicates.add(cb.equal(root.get("dataSheetId"),dataSheetId));
			}
			dataSheetPredicate = cb.or((Predicate[]) datasheetPredicates.toArray(new Predicate[0]));
			predicates.add(dataSheetPredicate);
		}else if(!model.getTextBaseAttributeList().isEmpty()){
			predicates.add(cb.equal(root.get("dataSheetId"),-1l));
		}
		//populateTextBaseAttributePredicate(model, cb, root, predicates);
		//populateTextMasterAttributePredicate(model, cb, root, predicates);
		//populateRangeBaseAttributePredicate(model, cb, root, predicates,datasheets);
		List <Predicate> pred = new ArrayList();
		populateRangeBaseAttributePredicate(model, cb, root, pred,datasheets);
		if(!pred.isEmpty()) {
		Predicate rangebasepredicate = cb.or((Predicate[]) pred.toArray(new Predicate[0]));
		predicates.add(rangebasepredicate);
		}
		if(!predicates.isEmpty()) {
			Predicate predicate = cb.and((Predicate[]) predicates.toArray(new Predicate[0]));
			if(null!=revisionPredicate) {
				Predicate pred1 = cb.and(revisionPredicate);
				Predicate pred2 = cb.and(predicate);
				cr.select(root).where(cb.and(pred1,pred2));
			}else {
				cr.select(root).where(cb.and(predicate));
			}
		}else {
			cr.select(root);
		}

		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();
		Query<MmrSearchDataSheetView> query = session.createQuery(cr);
		List<MmrSearchDataSheetView> mainData = new ArrayList<>();
		List<MmrSearchDataSheetView> data = query.getResultList();
		if(!data.isEmpty()) {
			List<Long> datasheetIds= new ArrayList<>();
			for (MmrSearchDataSheetView dataSheetId : data) {
				
				if(!datasheetIds.contains(dataSheetId.getDataSheetId())) {
					datasheetIds.add(dataSheetId.getDataSheetId());
				}
			}
			List<MmrSearchDataSheetView> basicList=getBasicFieldsSearchDataSheetView(datasheetIds);
			mainData.addAll(basicList);
			mainData.addAll(data);
		}
		return mainData;
	}

	private void populateRangeBaseAttributePredicate(SearchModel model, CriteriaBuilder cb,
			Root<MmrSearchDataSheetView> root, List<Predicate> predicates , List <Long> dataSheetIds) {
		if(null!= model.getRangeBaseParameterList() && !model.getRangeBaseParameterList().isEmpty()) {
			for (SearchBaseModel searchBaseModel  : model.getRangeBaseParameterList()) {
				if(null!=searchBaseModel.getProperty() && !searchBaseModel.getProperty().isEmpty()) {
					model.getUomMap().put(searchBaseModel.getProperty(), searchBaseModel.getUom());
					Predicate predicate1 = cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty()));
					Predicate predicate2 = null;
					List<MmrSearchDataSheetView> lst = dataSheetviewRepository.getViewByBaseAttributeId(Long.parseLong(searchBaseModel.getProperty()));
					if(!lst.isEmpty()) {
						MmrSearchDataSheetView dataSheetView = lst.get(0);
						if(dataSheetView.getSom1Uom().equals(searchBaseModel.getUom())) {
							predicate2 =cb.between(root.get("userUom1"), new BigDecimal(searchBaseModel.getMinValue()), new BigDecimal(searchBaseModel.getMaxValue()));
						}else if(dataSheetView.getSom2Uom().equals(searchBaseModel.getUom())) {
							predicate2 =cb.between(root.get("userUom2"), new BigDecimal(searchBaseModel.getMinValue()), new BigDecimal(searchBaseModel.getMaxValue()));
						}
						predicates.add(cb.and(predicate1,predicate2));
					}
				}
			}
		}
	}


	private void populateTextBaseAttributePredicate(SearchModel model, CriteriaBuilder cb,
			Root<MmrSearchDataSheetView> root, List<Predicate> predicates) {
		if(null!= model.getTextBaseAttributeList() && !model.getTextBaseAttributeList().isEmpty()) {
			for (SearchBaseModel searchBaseModel  : model.getTextBaseAttributeList()) {
				Predicate pred1 = cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty()));
				Expression<String> path = root.get("testingInformation");
				Expression<String> upper =cb.upper(path);
				
				Predicate pred2 = cb.like(upper, "%"+searchBaseModel.getValue()+"%");
				
				predicates.add(cb.and(pred1,pred2));
			}
		}
	}

	@Override
	public List<MmrCompareDataSheetView> compareDataSheetByIds(List<Long> datasheetIds) {
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrCompareDataSheetView> cr = cb.createQuery(MmrCompareDataSheetView.class);
		Root<MmrCompareDataSheetView> root = cr.from(MmrCompareDataSheetView.class);
		List<Predicate> predicates = new ArrayList<>();
		for (Long id : datasheetIds) {
			predicates.add(cb.equal(root.get("dataSheetId"),id));
		}
		Predicate predicate = cb.or((Predicate[]) predicates.toArray(new Predicate[0]));
		cr.select(root).where(predicate);
		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();
		Query<MmrCompareDataSheetView> query = session.createQuery(cr);
		return query.getResultList();
	}

	@Override
	public List<DataSheetDashboardModel> getDatasheetForDashboard(BigDecimal user) {

		List<DataSheetDashboardModel> lstResultModel = new ArrayList();
		String sql;
		sql = String.format(" Select datasheet.id as datasheetId, datasheet.DATA_SHEET_NAME as datasheetName, (Select USERNAME from MMR_USER_UT where id = datasheet.created_by) as addedBy," + 
				" to_char(datasheet.created_on, 'DD-MM-YYYY') as createdOn, to_char(datasheet.approved_on, 'DD-MM-YYYY') as apprivedOn, " + 
				" (Select USERNAME from MMR_USER_UT where id = datasheet.approved_by) as approvedBy, datasheet.status as status  " + 
				" FROM MMR_DATA_SHEET_UT datasheet WHERE datasheet.modified_by = %s ORDER BY datasheet.approved_on desc ",user);

		Query query = (Query) entityManagerFactory.createEntityManager().createNativeQuery(sql);
		List<Object[]> result = query.getResultList(); 
		for (Object[] objects : result) {
			DataSheetDashboardModel model = new DataSheetDashboardModel();
			model.setDatasheetId(objects[0].toString());
			model.setDatasheetName(objects[1].toString());
			model.setAddedBy((objects[2] == null )? null : objects[2].toString());
			model.setCreatedOn((objects[3] == null )? null : objects[3].toString());
			model.setApprovedOn((objects[4] == null )? null : objects[4].toString());
			model.setApprovedBy((objects[5] == null )? null : objects[5].toString());
			model.setStatus((objects[6] == null )? null : objects[6].toString());
			lstResultModel.add(model);
		}

		return lstResultModel;
	}

	@Override
	public List<DataSheetDashboardModel> findDatasheetByStatus(BigDecimal status) {
		List<DataSheetDashboardModel> lstResultModel = new ArrayList();
		String sql;
		sql = String.format(" Select datasheet.id as datasheetId, datasheet.DATA_SHEET_NAME as datasheetName, (Select USERNAME from MMR_USER_UT where id = datasheet.created_by) as addedBy, " + 
				" to_char(datasheet.created_on, 'DD-MM-YYYY') as createdOn " + 
				" FROM MMR_DATA_SHEET_UT datasheet WHERE datasheet.status = %s ",status);

		Query query = (Query) entityManagerFactory.createEntityManager().createNativeQuery(sql);
		List<Object[]> result = query.getResultList(); 
		for (Object[] objects : result) {
			DataSheetDashboardModel model = new DataSheetDashboardModel();
			model.setDatasheetId((objects[1] == null )? null : objects[0].toString());
			model.setDatasheetName((objects[1] == null )? null : objects[1].toString());
			model.setAddedBy((objects[2] == null )? null : objects[2].toString());
			model.setCreatedOn((objects[3] == null )? null : objects[3].toString());

			lstResultModel.add(model);
		}

		return lstResultModel;

	}


	public List<MmrSearchDataSheetView> getBasicFieldsSearchDataSheetView(List<Long> datasheetIds) {
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrSearchDataSheetView> cr = cb.createQuery(MmrSearchDataSheetView.class);
		Root<MmrSearchDataSheetView> root = cr.from(MmrSearchDataSheetView.class);
		List<Predicate> predicates = new ArrayList<>();

		MmrSysConfigUt configUt =  sysConfigRepository.findByParamName("STATIC_SEARCH_BASE_ATTRIBUTE_IDS");
		Predicate staticPredicate = null;
		if(null!= configUt) {
			List<Predicate> staticPredicates = new ArrayList<>();
			String[] baseAttributeIds = configUt.getParamValue().split(",");
			for (String id : baseAttributeIds) {
				staticPredicates.add(cb.equal(root.get("baseAttributeId"),id));
			}
			staticPredicate = cb.or((Predicate[]) staticPredicates.toArray(new Predicate[0]));
		}
		for (Long id : datasheetIds) {
			predicates.add(cb.equal(root.get("dataSheetId"),id));
		}
		//		Predicate predicate = cb.or((Predicate[]) predicates.toArray(new Predicate[0]));
		//		cr.select(root).where(predicate);

		if(!predicates.isEmpty()) {
			Predicate predicate = cb.or((Predicate[]) predicates.toArray(new Predicate[0]));

			cr.select(root).where(cb.and(predicate,staticPredicate));
		} 

		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();

		Query<MmrSearchDataSheetView> query = session.createQuery(cr);
		return query.getResultList();
	}

	@Override
	@Transactional
	public String updateDatasheetByStatus(BigDecimal status, Long id) {
		String sql = String.format(" update MMR_DATA_SHEET_UT datasheet set datasheet.status = %s  where datasheet.id =%s ",status,id);

		
		int query = (int) entityManagerFactory.createEntityManager().createNativeQuery(sql).executeUpdate();
		return query+"";
	}


	@Override
	public UserMasterModel findUserDetailsByUserId(Long userId) {
		UserMasterModel userMasterModel = new UserMasterModel();
		String sql;
		sql = String.format(" Select usr.id as userid, usr.NAME as name, lvl.description as role, rgn.description as region, sysdate as currentDate\n" + 
				"from mmr_user_ut usr, mmr_Level_function_ut lvlFunc, mmr_Level_ut lvl  , mmr_region_master_ut rgn\n" + 
				"where lvl.id = lvlFunc.level_id and lvlFunc.status = 1 and lvlFunc.id = usr.level_function_id \n" + 
				"and rgn.id = usr.region_id and usr.status =1 and usr.id = %s ",userId);

		Query query = (Query) entityManagerFactory.createEntityManager().createNativeQuery(sql);
		List<Object[]> resultSet = query.getResultList(); 
		System.out.println(" result :"+resultSet.toString());
		for (Object[] result : resultSet) {

			if (null!=result) {
				userMasterModel.setUserId((result[0] == null )? null : result[0].toString());
				userMasterModel.setUserName((result[1] == null )? null : result[1].toString());
				userMasterModel.setRole((result[2] == null )? null : result[2].toString());
				userMasterModel.setRegion((result[3] == null )? null : result[3].toString());
				userMasterModel.setCurrentDate((result[4] == null )? null : result[4].toString());
				break;	
			}
		}

		return userMasterModel;

	}
}
