package com.metalsa.model;

import java.util.ArrayList;
import java.util.List;

import com.metalsa.domain.MmrSearchDataSheetView;

public class ResultDataSheetModel {

	private Long dataSheetId;
	private List<MmrSearchDataSheetView> dataSheetIdList = new ArrayList<>();
	public Long getDataSheetId() {
		return dataSheetId;
	}
	public void setDataSheetId(Long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}
	public List<MmrSearchDataSheetView> getDataSheetIdList() {
		return dataSheetIdList;
	}
	public void setDataSheetIdList(List<MmrSearchDataSheetView> dataSheetIdList) {
		this.dataSheetIdList = dataSheetIdList;
	} 
	
	
	 	
}
