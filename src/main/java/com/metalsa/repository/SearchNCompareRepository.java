package com.metalsa.repository;

import java.util.List;

import com.metalsa.model.SearchModel;


public interface SearchNCompareRepository {

	List<Object[]> searchData(SearchModel model);
	
}
