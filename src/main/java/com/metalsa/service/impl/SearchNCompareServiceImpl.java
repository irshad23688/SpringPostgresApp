package com.metalsa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrDataSheetUt;
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
		List<MmrSearchDataSheetView> results = customRepository.getSearchDataSheetView(model);
		final Map<String,List<MmrSearchDataSheetView>> materialMap = new LinkedHashMap<>();
		for (MmrSearchDataSheetView viewObj : results) {
			if(0l!=viewObj.getDataSheetId()) {
				List<MmrSearchDataSheetView> lst=null;
				if(materialMap.keySet().contains(viewObj.getDataSheetId()+"")){
					 lst = materialMap.get(viewObj.getDataSheetId()+"");
				}else {
					lst = new ArrayList<>();
				}
				lst.add(viewObj);
				materialMap.put(viewObj.getDataSheetId()+"",lst);
			}
		}	
		model.setSearchDatamp(materialMap);		
		return model;
	}

	@Override
	public List<MmrDataSheetUt> getDataSheetByIds(List<Long> datasheetIds) {
		return customRepository.getDataSheetByIds(datasheetIds);
	}

}
