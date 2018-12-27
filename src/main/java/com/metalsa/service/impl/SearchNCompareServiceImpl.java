package com.metalsa.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.model.SearchModel;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.repository.SearchNCompareRepository;
import com.metalsa.service.SearchNCompareService;


@Service
public class SearchNCompareServiceImpl implements SearchNCompareService {

	@Autowired
	private SearchNCompareRepository repository;

	@Autowired
	private HeaderAttrRepository headerAttrRepository;
	@Autowired
	private CustomRepository customRepository;

	@Override
	public SearchModel getConfigParameters() {
		SearchModel model = new SearchModel();
		model.setDropDownList(headerAttrRepository.findAll());
		return model;
	}

	@Override
	public SearchModel getSearchdata(final SearchModel model) {
		List<MmrSearchDataSheetView> results = repository.findAll();
		final Map<String,Map<String, String>> materialMap = new LinkedHashMap<>();
		for (MmrSearchDataSheetView viewObj : results) {
			
			if(0l!=viewObj.getDataSheetId()) {
				if(materialMap.keySet().contains(viewObj.getDataSheetId()+"")){
					Map<String,String> material = materialMap.get(viewObj.getDataSheetId()+"");
					if(null!=viewObj.getBaseAttributeName()) {
						material.put(viewObj.getBaseAttributeName(), 
								viewObj.getTestingInformation()!=null? viewObj.getTestingInformation():"");
					}
				}else {
					Map<String,String> material = new HashMap<>();
					if(null!=viewObj.getBaseAttributeName()) {

						material.put(viewObj.getBaseAttributeName(), 
								viewObj.getTestingInformation()!=null?viewObj.getTestingInformation():"");
					}
					if(null!=viewObj.getRevision()) {
						material.put("Revision", viewObj.getRevision());
					}
					if(null!=viewObj.getSupplierInfo()) {
						material.put("Supplier", viewObj.getSupplierInfo());
					}
					materialMap.put(viewObj.getDataSheetId()+"",material);
				}
			}
		}	
		model.setSearchDataMap(materialMap);		
		return model;
	}

}
