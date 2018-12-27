package com.metalsa.repository.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrTestSheetUt;
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
		predicates[1] = cb.equal(root.get("subClassId"), subClassId);
		cr.select(root).where(predicates);
		Session session = entityManagerFactory.unwrap(Session.class);
	
		Query<MmrDataSheetUt> query = session.createQuery(cr);
		return query.getResultList();
	}
	
	@Override
	public MmrTestSheetUt getTestSheetByClassNSubclass(Long classId, Long subClassId) {
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<MmrTestSheetUt> cr = cb.createQuery(MmrTestSheetUt.class);
		Root<MmrTestSheetUt> root = cr.from(MmrTestSheetUt.class);
		
		Predicate[] predicates = new Predicate[3];
		predicates[0] = cb.equal(root.get("classId"),classId);
		predicates[1] = cb.equal(root.get("subClassId"), subClassId);
		// TODO: TO CHECK STATUS
		//predicates[2] = cb.equal(root.get("status"), 1);
		cr.select(root).where(predicates);
		Session session = entityManagerFactory.unwrap(Session.class);
		
		Query<MmrTestSheetUt> query = session.createQuery(cr);
		//TODO: TO CHANGE ACCORDINGLY
		// Considering only one active active sheet
		if(!query.getResultList().isEmpty()) {
			return query.getResultList().get(0);
		}
		return new MmrTestSheetUt();
	}
	
	public void saveOrUpdate(Object obj) {
		Session session = entityManagerFactory.unwrap(Session.class);
		session.saveOrUpdate(obj);
	}

}
