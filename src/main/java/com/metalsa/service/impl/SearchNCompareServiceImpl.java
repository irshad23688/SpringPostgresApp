package com.metalsa.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrHeaderAttributeMasterUt;
import com.metalsa.domain.MmrManufacturerMasterUt;
import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.domain.MmrSysConfigUt;
import com.metalsa.model.SearchModel;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.repository.SysConfigRepository;
import com.metalsa.service.SearchNCompareService;


@Service
public class SearchNCompareServiceImpl implements SearchNCompareService {

	@Autowired
	private HeaderAttrRepository headerAttrRepository;

	@Autowired
	private CustomRepository customRepository;

	@Autowired
	private SysConfigRepository sysConfigRepository;


	@Override
	public SearchModel getConfigParameters() {
		List textIds= new ArrayList<>();
		MmrSysConfigUt textBasedAtriIds =  sysConfigRepository.findByParamName("TEXT_BASED_BASE_ATTRIBUTE_IDS");
		if(null!= textBasedAtriIds) {
			textIds = Arrays.asList(textBasedAtriIds.getParamValue().split(","));
		}
		List rangeIds= new ArrayList<>();
		MmrSysConfigUt rangeBasedAtriIds =  sysConfigRepository.findByParamName("RANGE_BASED_BASE_ATTRIBUTE_IDS");
		if(null!= rangeBasedAtriIds) {
			rangeIds = Arrays.asList(rangeBasedAtriIds.getParamValue().split(","));
		}
		SearchModel model = new SearchModel();
		List<MmrHeaderAttributeMasterUt> textBasedHeader = new ArrayList<>();
		List<MmrHeaderAttributeMasterUt> rangeBaseHeader = new ArrayList<>();
		for (MmrHeaderAttributeMasterUt header : headerAttrRepository.findAll()) {
			List<MmrBaseAttributeMasterUt> textBaseAttribute = new ArrayList<>();
			List<MmrBaseAttributeMasterUt> rangeBaseAttribute = new ArrayList<>();
			for (MmrBaseAttributeMasterUt baseAttribute : header.getMmrBaseAttributeMasterUts()) {
				if(textIds.contains(baseAttribute.getMmrDataTypeMasterUt().getId()+"")){
					textBaseAttribute.add(baseAttribute);
				}
				if(rangeIds.contains(baseAttribute.getMmrDataTypeMasterUt().getId()+"")){
					rangeBaseAttribute.add(baseAttribute);
				}
			}
			MmrHeaderAttributeMasterUt modelHeader=header;
			if(textBaseAttribute.size()>0){
				modelHeader.setMmrBaseAttributeMasterUts(textBaseAttribute);
			}else{
				modelHeader.setMmrBaseAttributeMasterUts(new ArrayList<>());
			}
			textBasedHeader.add(modelHeader);

			if(rangeBaseAttribute.size()>0){
				modelHeader.setMmrBaseAttributeMasterUts(rangeBaseAttribute);
			}else {
				modelHeader.setMmrBaseAttributeMasterUts(new ArrayList<>());
			}
			rangeBaseHeader.add(modelHeader);
		}
		model.setRangeBaseHeader(rangeBaseHeader);
		model.setTextBasedHeader(textBasedHeader);
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
				model.getHeaderSet().add(viewObj.getBaseAttributeName());
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
