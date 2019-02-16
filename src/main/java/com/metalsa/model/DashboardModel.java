package com.metalsa.model;

import java.util.List;

public class DashboardModel {
	
	private Long status;
	private Long id; 
	private Long approvedby;
	private List<DataSheetDashboardModel> datasheetPendingList ;
	private List<DataSheetDashboardModel> datasheetHistory ;
	private Integer pendingListCount;
	private UserMasterModel userData;
	private String lastDesignation;
	private String lastUpdatedOn;

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
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(Long approvedby) {
		this.approvedby = approvedby;
	}
	public UserMasterModel getUserData() {
		return userData;
	}
	public void setUserData(UserMasterModel userData) {
		this.userData = userData;
	}
	
	public String getLastDesignation() {
		return lastDesignation;
	}
	public void setLastDesignation(String lastDesignation) {
		this.lastDesignation = lastDesignation;
	}
	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
	
	
}
