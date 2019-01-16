package com.metalsa.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.MultiIdentifierLoadAccess;
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
import com.metalsa.model.SearchBaseModel;
import com.metalsa.model.SearchModel;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.SysConfigRepository;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private SysConfigRepository sysConfigRepository;

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
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrSearchDataSheetView> cr = cb.createQuery(MmrSearchDataSheetView.class);
		Root<MmrSearchDataSheetView> root = cr.from(MmrSearchDataSheetView.class);
		List<Predicate> predicates = new ArrayList<>();
		Predicate revisionPredicate = null;
		if(!model.isShowRevision()) {
			revisionPredicate = cb.equal(root.get("status"),MetalsaConstant.STATUS.APPROVED);
		}
		
		MmrSysConfigUt configUt =  sysConfigRepository.findByParamName("STATIC_SEARCH_BASE_ATTRIBUTE_IDS");
		if(null!= configUt) {
			String[] baseAttributeIds = configUt.getParamValue().split(",");
			for (String id : baseAttributeIds) {
				predicates.add(cb.equal(root.get("baseAttributeId"),id));
			}
		}
		
		populateTextBaseAttributePredicate(model, cb, root, predicates);
		populateTextMasterAttributePredicate(model, cb, root, predicates);
		populateRangeBaseAttributePredicate(model, cb, root, predicates);

		if(!predicates.isEmpty()) {
			Predicate predicate = cb.or((Predicate[]) predicates.toArray(new Predicate[0]));
			if(null!=revisionPredicate) {
				cr.select(root).where(cb.and(predicate,revisionPredicate));
			}else {
				cr.select(root).where(predicate);
			}
		}else {
			cr.select(root);
		}

		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();

		Query<MmrSearchDataSheetView> query = session.createQuery(cr);
		return query.getResultList();
	}

	private void populateRangeBaseAttributePredicate(SearchModel model, CriteriaBuilder cb,
			Root<MmrSearchDataSheetView> root, List<Predicate> predicates) {
		if(null!= model.getRangeBaseParameterList() && !model.getRangeBaseParameterList().isEmpty()) {
			for (SearchBaseModel searchBaseModel  : model.getRangeBaseParameterList()) {
				if(null!=searchBaseModel.getProperty() && !searchBaseModel.getProperty().isEmpty()) {
					Predicate predicate1 = cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty()));
					Predicate predicate2 = null;
					if(MetalsaConstant.UOM.PERCENT.equals(searchBaseModel.getUom())) {
						predicate2 =cb.between(root.get("userUom1"), new BigDecimal(searchBaseModel.getMinValue()), new BigDecimal(searchBaseModel.getMaxValue()));
					}else if(MetalsaConstant.UOM.PPM.equals(searchBaseModel.getUom())){
						predicate2 =cb.between(root.get("userUom2"), new BigDecimal(searchBaseModel.getMinValue()), new BigDecimal(searchBaseModel.getMaxValue()));
					}
					predicates.add(cb.and(predicate1,predicate2));
				}
			}
		}
	}

	private void populateTextMasterAttributePredicate(SearchModel model, CriteriaBuilder cb,
			Root<MmrSearchDataSheetView> root, List<Predicate> predicates) {
		if(null!= model.getTextMasterAttributeList() && !model.getTextMasterAttributeList().isEmpty()) {
			for (SearchBaseModel searchBaseModel  : model.getTextMasterAttributeList()) {
				predicates.add(cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty())));
			}
		}
	}

	private void populateTextBaseAttributePredicate(SearchModel model, CriteriaBuilder cb,
			Root<MmrSearchDataSheetView> root, List<Predicate> predicates) {
		if(null!= model.getTextBaseAttributeList() && !model.getTextBaseAttributeList().isEmpty()) {
			for (SearchBaseModel searchBaseModel  : model.getTextBaseAttributeList()) {
				Predicate pred1 = cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty()));
				Predicate pred2 = cb.like(root.get("testingInformation"), "%"+searchBaseModel.getValue()+"%");
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
	public List<Object[]> getDatasheetForDashboard(BigDecimal user) {
		String sql;
		sql = String.format(" Select datasheet.id as datasheet_id, datasheet.DATA_SHEET_NAME, (Select USERNAME from MMR_USER_UT where id = datasheet.modified_by) as username," + 
				" to_char(datasheet.created_on, 'DD-MM-YYYY') as created_on, to_char(datasheet.approved_on, 'DD-MM-YYYY') as apprived_on, " + 
				" (Select USERNAME from MMR_USER_UT where id = datasheet.approved_by) as approved_by  " + 
				" FROM MMR_DATA_SHEET_UT datasheet WHERE datasheet.modified_by = %s and datasheet.status =1 ",user);
		
		Query query = (Query) entityManagerFactory.createEntityManager().createNativeQuery(sql);
		return query.getResultList();
	}

	@Override
	public List<Object[]> findDatasheetByStatus(BigDecimal status) {
		String sql;
		sql = String.format(" Select datasheet.id as datasheet_id, datasheet.DATA_SHEET_NAME, (Select USERNAME from MMR_USER_UT where id = datasheet.created_by) as added_by, " + 
				" to_char(datasheet.created_on, 'DD-MM-YYYY') as created_on " + 
				" FROM MMR_DATA_SHEET_UT datasheet WHERE datasheet.status = %s ",status);
		
		Query query = (Query) entityManagerFactory.createEntityManager().createNativeQuery(sql);
		return query.getResultList();
	}
	
}
