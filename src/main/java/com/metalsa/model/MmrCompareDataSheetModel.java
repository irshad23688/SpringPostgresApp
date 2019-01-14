package com.metalsa.model;

import java.util.ArrayList;
import java.util.List;

public class MmrCompareDataSheetModel {
	
	private Long dataSheetId;
	List<CompareModel> headerDetails = new ArrayList<>();
	public Long getDataSheetId() {
		return dataSheetId;
	}
	public void setDataSheetId(Long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}
	public List<CompareModel> getHeaderDetails() {
		return headerDetails;
	}
	public void setHeaderDetails(List<CompareModel> headerDetails) {
		this.headerDetails = headerDetails;
	}
	
}
