package com.metalsa.model;

import java.util.ArrayList;
import java.util.List;

import com.metalsa.domain.MmrCompareDataSheetView;

public class CompareModel {
	
	private String headerName;
	List<MmrCompareDataSheetView> compareDataSheets = new ArrayList<>();
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public List<MmrCompareDataSheetView> getCompareDataSheets() {
		return compareDataSheets;
	}
	public void setCompareDataSheets(List<MmrCompareDataSheetView> compareDataSheets) {
		this.compareDataSheets = compareDataSheets;
	}
}
