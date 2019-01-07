package com.metalsa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.metalsa.domain.MmrHeaderAttributeMasterUt;
import com.metalsa.domain.MmrSearchDataSheetView;

public class SearchModel {

	private String staticBaseAttributeIds;
	private boolean isShowRevision;
	private List<MmrHeaderAttributeMasterUt> textBasedHeader = new ArrayList<>();
	private List<MmrHeaderAttributeMasterUt> rangeBaseHeader = new ArrayList<>();
	private List<SearchBaseModel> rangeBaseParameterList = new ArrayList<>();
	private List<SearchBaseModel> textBaseAttributeList = new ArrayList<>();
	private List<SearchBaseModel> textMasterAttributeList = new ArrayList<>();
	private Map<String, List<MmrSearchDataSheetView>> searchDatamp = new LinkedHashMap<>();
	private List<Long> datasheetIds;	
	public String getStaticBaseAttributeIds() {
		return staticBaseAttributeIds;
	}
	public void setStaticBaseAttributeIds(String staticBaseAttributeIds) {
		this.staticBaseAttributeIds = staticBaseAttributeIds;
	}
	public boolean isShowRevision() {
		return isShowRevision;
	}
	public void setShowRevision(boolean isShowRevision) {
		this.isShowRevision = isShowRevision;
	}
	
	public List<MmrHeaderAttributeMasterUt> getTextBasedHeader() {
		return textBasedHeader;
	}
	public void setTextBasedHeader(List<MmrHeaderAttributeMasterUt> textBasedHeader) {
		this.textBasedHeader = textBasedHeader;
	}
	public List<MmrHeaderAttributeMasterUt> getRangeBaseHeader() {
		return rangeBaseHeader;
	}
	public void setRangeBaseHeader(List<MmrHeaderAttributeMasterUt> rangeBaseHeader) {
		this.rangeBaseHeader = rangeBaseHeader;
	}
	
	public List<SearchBaseModel> getTextBaseAttributeList() {
		return textBaseAttributeList;
	}
	public void setTextBaseAttributeList(List<SearchBaseModel> textBaseAttributeList) {
		this.textBaseAttributeList = textBaseAttributeList;
	}
	public List<SearchBaseModel> getTextMasterAttributeList() {
		return textMasterAttributeList;
	}
	public void setTextMasterAttributeList(List<SearchBaseModel> textMasterAttributeList) {
		this.textMasterAttributeList = textMasterAttributeList;
	}
	public List<SearchBaseModel> getRangeBaseParameterList() {
		return rangeBaseParameterList;
	}
	public void setRangeBaseParameterList(List<SearchBaseModel> rangeBaseParameterList) {
		this.rangeBaseParameterList = rangeBaseParameterList;
	}
	public Map<String, List<MmrSearchDataSheetView>> getSearchDatamp() {
		return searchDatamp;
	}
	public void setSearchDatamp(Map<String, List<MmrSearchDataSheetView>> searchDatamp) {
		this.searchDatamp = searchDatamp;
	}
	public List<Long> getDatasheetIds() {
		return datasheetIds;
	}
	public void setDatasheetIds(List<Long> datasheetIds) {
		this.datasheetIds = datasheetIds;
	}
	
}
