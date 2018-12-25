package com.metalsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.model.BaseAttrModel;
import com.metalsa.repository.BaseAttributeRepository;
import com.metalsa.repository.DataTypeRepository;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.service.BaseAttrService;

@Service
public class BaseAttrServiceImpl implements BaseAttrService {
	
	@Autowired
	private HeaderAttrRepository headerRepository;
	
	@Autowired
	private BaseAttributeRepository baseAttributeRepository;
	
	@Autowired
	private DataTypeRepository dataTypeRepository;

	@Override
	public BaseAttrModel getBaseAttrData() {
		return getBaseAttrModel();
	}

	@Override
	public BaseAttrModel persistBaseAttr(BaseAttrModel baseAttrModel) {
		// TODO Auto-generated method stub
		baseAttrModel.getHeaderAttrList().get(0).getId();
		baseAttrModel.getDataTypeList().get(0).getId();
		MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt = baseAttrModel.getBaseAttrList().get(0);
		//mmrBaseAttributeMasterUt.setMmrHeaderAttributeMasterUt(baseAttrModel.getHeaderAttrList().get(0));
		mmrBaseAttributeMasterUt.setMmrDataTypeMasterUt(baseAttrModel.getDataTypeList().get(0));
		baseAttributeRepository.save(mmrBaseAttributeMasterUt);
		
		return getBaseAttrModel();
	}
	
	private BaseAttrModel getBaseAttrModel() {
		BaseAttrModel baseAttrModel = new BaseAttrModel();
		baseAttrModel.setHeaderAttrList(headerRepository.findAll(new Sort(Sort.Direction.ASC,"name")));
		baseAttrModel.setBaseAttrList(baseAttributeRepository.findAll(new Sort(Sort.Direction.DESC,"createdOn")));
		baseAttrModel.setDataTypeList(dataTypeRepository.findAll(new Sort(Sort.Direction.ASC,"name")));
		return baseAttrModel;
	}

	
	

	

}
