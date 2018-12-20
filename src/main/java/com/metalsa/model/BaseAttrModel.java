package com.metalsa.model;

import java.util.List;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrDataTypeMasterUt;
import com.metalsa.domain.MmrHeaderAttributeMasterUt;

public class BaseAttrModel {
	
	private List<MmrHeaderAttributeMasterUt> headerAttrList;
	private List<MmrBaseAttributeMasterUt> baseAttrList;
	private List<MmrDataTypeMasterUt> dataTypeList;
	
	public List<MmrHeaderAttributeMasterUt> getHeaderAttrList() {
		return headerAttrList;
	}
	public void setHeaderAttrList(List<MmrHeaderAttributeMasterUt> headerAttrList) {
		this.headerAttrList = headerAttrList;
	}
	public List<MmrBaseAttributeMasterUt> getBaseAttrList() {
		return baseAttrList;
	}
	public void setBaseAttrList(List<MmrBaseAttributeMasterUt> baseAttrList) {
		this.baseAttrList = baseAttrList;
	}
	public List<MmrDataTypeMasterUt> getDataTypeList() {
		return dataTypeList;
	}
	public void setDataTypeList(List<MmrDataTypeMasterUt> dataTypeList) {
		this.dataTypeList = dataTypeList;
	}
	
	

}
