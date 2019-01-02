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
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.model.SearchBaseModel;
import com.metalsa.model.SearchModel;
import com.metalsa.repository.CustomRepository;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
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
		//TODO: TO CHANGE ACCORDINGLY
		// Considering only one active sheet
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
		populateTextBaseAttributePredicate(model, cb, root, predicates);
		populateTextMasterAttributePredicate(model, cb, root, predicates);
		populateRangeBaseAttributePredicate(model, cb, root, predicates);
		if(!model.isShowRevision()) {
			predicates.add(cb.equal(root.get("status"),MetalsaConstant.STATUS.PENDING));
		}
		for (Predicate predicate : predicates) {
			cr.select(root).where(cb.and(predicate));
		}
		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();

		Query<MmrSearchDataSheetView> query = session.createQuery(cr);
		return query.getResultList();
	}

	private void populateRangeBaseAttributePredicate(SearchModel model, CriteriaBuilder cb,
			Root<MmrSearchDataSheetView> root, List<Predicate> predicates) {
		if(null!= model.getRangeBaseParameterList() && !model.getRangeBaseParameterList().isEmpty()) {
			for (SearchBaseModel searchBaseModel  : model.getRangeBaseParameterList()) {
				predicates.add(cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty())));
				if(MetalsaConstant.UOM.PERCENT.equals(searchBaseModel.getUom())) {
					predicates.add(cb.le(root.get("userUom1"),new BigDecimal(searchBaseModel.getMaxValue())));
					predicates.add(cb.ge(root.get("userUom1"),new BigDecimal(searchBaseModel.getMinValue())));
				}else if(MetalsaConstant.UOM.PPM.equals(searchBaseModel.getUom())){
					predicates.add(cb.le(root.get("userUom2"),new BigDecimal(searchBaseModel.getMaxValue())));
					predicates.add(cb.ge(root.get("userUom2"),new BigDecimal(searchBaseModel.getMinValue())));
					
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
				predicates.add(cb.equal(root.get("baseAttributeId"),Long.parseLong(searchBaseModel.getProperty())));
				predicates.add(cb.like(root.get("testingInformation"), "%"+searchBaseModel.getValue()+"%"));
			}
		}
	}

	@Override
	public List<MmrDataSheetUt> getDataSheetByIds(List<Long> datasheetIds) {
		Session session = (Session)entityManagerFactory.createEntityManager().getDelegate();
		MultiIdentifierLoadAccess <MmrDataSheetUt> multiLoadAccess = session.byMultipleIds(MmrDataSheetUt.class);
		return multiLoadAccess.multiLoad(datasheetIds);
	}
}
