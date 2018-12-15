package com.metalsa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchModel {

	private boolean isShowRevision;
	private boolean isShowSupplier;
	// will contain text base and range base paramter of dropdown list
	private List<ParameterConfig> dropDownList = new ArrayList<>();
	private Map<String, String> textBaseParameterMap = new LinkedHashMap<>();
	private List<RangeBaseModel> rangeBaseParameterList = new ArrayList<>();
	private List<String> uomList = new ArrayList<>();
	private List<SearchDataListModel> searchDataList = new ArrayList<>();
	
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
	public List<ParameterConfig> getDropDownList() {
		return dropDownList;
	}
	public void setDropDownList(List<ParameterConfig> dropDownList) {
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
	public List<String> getUomList() {
		return uomList;
	}
	public void setUomList(List<String> uomList) {
		this.uomList = uomList;
	}
	public List<SearchDataListModel> getSearchDataList() {
		return searchDataList;
	}
	public void setSearchDataList(List<SearchDataListModel> searchDataList) {
		this.searchDataList = searchDataList;
	}
	
}
