package com.metalsa.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.model.SearchModel;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.repository.SearchNCompareRepository;
import com.metalsa.service.SearchNCompareService;


@Service
public class SearchNCompareServiceImpl implements SearchNCompareService {

	@Autowired
	private SearchNCompareRepository repository;
	
	@Autowired
    private HeaderAttrRepository headerAttrRepository;

	@Override
	public SearchModel getConfigParameters() {
		SearchModel model = new SearchModel();
		model.setDropDownList(headerAttrRepository.findAll());
		return model;
	}

	@Override
	public SearchModel getSearchdata(final SearchModel model) {
		List<Object[]> results = repository.searchData(model);
		Map<String,Map<String, String>> materialMap = new LinkedHashMap<>();
		results.stream().forEach((record) -> {
			if(null!=record[0]) {
				if(materialMap.keySet().contains(record[0].toString())){
					Map<String,String> material = materialMap.get(record[0].toString());
					if(null!=record[1] && null!=record[2]) {
						material.put(record[1].toString(), record[2].toString());
					}
				}else {
					Map<String,String> material = new HashMap<>();
					if(null!=record[1] && null!=record[2]) {
						material.put(record[1].toString(), record[2].toString());
					}
					if(null!=record[3]) {
						material.put("Revision", record[3].toString());
					}
					if(null!=record[4]) {
						material.put("Supplier", record[4].toString());
					}
					materialMap.put(record[0].toString(),material);
				}
			}
		});	
		model.setSearchDataMap(materialMap);		
		return model;
	}

}
