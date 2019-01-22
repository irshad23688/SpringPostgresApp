package com.metalsa.model;

import java.util.List;

public class DashboardModel {
	
	private List<DataSheetDashboardModel> datasheetPendingList ;
	private List<DataSheetDashboardModel> datasheetHistory ;
	private Integer pendingListCount;

	public List<DataSheetDashboardModel> getDatasheetPendingList() {
		return datasheetPendingList;
	}
	public void setDatasheetPendingList(List<DataSheetDashboardModel> datasheetPendingList) {
		this.datasheetPendingList = datasheetPendingList;
	}
	public List<DataSheetDashboardModel> getDatasheetHistory() {
		return datasheetHistory;
	}
	public void setDatasheetHistory(List<DataSheetDashboardModel> datasheetHistory) {
		this.datasheetHistory = datasheetHistory;
	}
	public Integer getPendingListCount() {
		return pendingListCount;
	}
	public void setPendingListCount(Integer pendingListCount) {
		this.pendingListCount = pendingListCount;
	}
}
