package com.metalsa.repository.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metalsa.model.SearchModel;
import com.metalsa.repository.SearchNCompareRepository;

@Repository
public class SearchNCompareRepositoryImpl  {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public List<Object[]> searchData(SearchModel model) {
		
		String sql;
		sql = "select ds.test_sheet_id,bam.display_name, dsd.testing_information, ds.revision_id, " + 
				"from  " + 
				"test_sheet_detail_ut tsd, data_sheet_detail_ut dsd, base_attribute_master_ut bam , data_sheet_ut ds " + 
				"where tsd.base_attribute_id in( 1,2,3,14) and tsd.id = dsd.test_sheet_detail_id " + 
				"and tsd.base_attribute_id = bam.id and ds.test_sheet_id=tsd.test_sheet_id " + 
				"";
		if(model.isShowRevision()) {
			//fetch revision
		}
		
		return getResultList(sql);
	}

	private List<Object[]> getResultList(String sql) {
		Query query = entityManagerFactory.createEntityManager().createNativeQuery(sql);
		return query.getResultList();
	}


}
