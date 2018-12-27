package com.metalsa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.metalsa.domain.MmrHeaderAttributeMasterUt;

public class SearchModel {

	private boolean isShowRevision;
	private boolean isShowSupplier;
	// will contain text base and range base paramter of dropdown list
	private List<MmrHeaderAttributeMasterUt> dropDownList = new ArrayList<>();
	private Map<String, String> textBaseParameterMap = new LinkedHashMap<>();
	private List<RangeBaseModel> rangeBaseParameterList = new ArrayList<>();
	private Map<String, Map<String, String>> searchDataMap = new LinkedHashMap<>();
		
	public boolean isShowRevision() {
		return isShowRevision;
	}
	public void setShowRevision(boolean isShowRevision) {
		this.isShowRevision = isShowRevision;
	}
	public boolean isShowSupplier() {
		return isShowSupplier;
	}
	public void setShowSupplier(boolean isShowSupplier) {
		this.isShowSupplier = isShowSupplier;
	}
	public List<MmrHeaderAttributeMasterUt> getDropDownList() {
		return dropDownList;
	}
	public void setDropDownList(List<MmrHeaderAttributeMasterUt> dropDownList) {
		this.dropDownList = dropDownList;
	}
	public Map<String, String> getTextBaseParameterMap() {
		return textBaseParameterMap;
	}
	public void setTextBaseParameterMap(Map<String, String> textBaseParameterMap) {
		this.textBaseParameterMap = textBaseParameterMap;
	}
	 
	public List<RangeBaseModel> getRangeBaseParameterList() {
		return rangeBaseParameterList;
	}
	public void setRangeBaseParameterList(List<RangeBaseModel> rangeBaseParameterList) {
		this.rangeBaseParameterList = rangeBaseParameterList;
	}
	public Map<String, Map<String, String>> getSearchDataMap() {
		return searchDataMap;
	}
	public void setSearchDataMap(Map<String, Map<String, String>> searchDataMap) {
		this.searchDataMap = searchDataMap;
	}
	
	
}
