package com.metalsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.model.SearchModel;
import com.metalsa.repository.SearchNCompareRepository;
import com.metalsa.service.SearchNCompareService;

@Service
public class SearchNCompareServiceImpl implements SearchNCompareService {
	
	@Autowired
	private SearchNCompareRepository repository;

	@Override
	public SearchModel getConfigParameters() {
		SearchModel model = new SearchModel();
		model.setDropDownList(repository.getConfigParameters());
		return model;
	}

	@Override
	public SearchModel getSearchdata(final SearchModel model) {
		// manipulation according to filters
		
		return model;
	}

	@Override
	public SearchModel getFilterData(final SearchModel model) {
		
		if(model.isShowRevision()) {
			//fetch revision
		}
		if(model.isShowSupplier()) {
			// fetch supplier info
		}
		
		return model;
	}
	

}
