package com.metalsa.model;

import java.util.ArrayList;
import java.util.List;

import com.metalsa.domain.MmrCompareDataSheetView;

public class MmrCompareDataSheetModel {
	
	private Long dataSheetId;
	List<MmrCompareDataSheetView> compareDataSheets = new ArrayList<>();
	public Long getDataSheetId() {
		return dataSheetId;
	}
	public void setDataSheetId(Long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}
	public List<MmrCompareDataSheetView> getCompareDataSheets() {
		return compareDataSheets;
	}
	public void setCompareDataSheets(List<MmrCompareDataSheetView> compareDataSheets) {
		this.compareDataSheets = compareDataSheets;
	}
}
