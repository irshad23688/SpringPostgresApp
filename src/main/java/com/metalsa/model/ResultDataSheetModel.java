package com.metalsa.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.metalsa.domain.MmrSearchDataSheetView;

public class ResultDataSheetModel {

	private Long dataSheetId;
	private Set<MmrSearchDataSheetView> dataSheetIdList = new LinkedHashSet<>();
	public Long getDataSheetId() {
		return dataSheetId;
	}
	public void setDataSheetId(Long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}
	public Set<MmrSearchDataSheetView> getDataSheetIdList() {
		return dataSheetIdList;
	}
	public void setDataSheetIdList(Set<MmrSearchDataSheetView> dataSheetIdList) {
		this.dataSheetIdList = dataSheetIdList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSheetId == null) ? 0 : dataSheetId.hashCode());
		result = prime * result + ((dataSheetIdList == null) ? 0 : dataSheetIdList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultDataSheetModel other = (ResultDataSheetModel) obj;
		if (dataSheetId == null) {
			if (other.dataSheetId != null)
				return false;
		} else if (!dataSheetId.equals(other.dataSheetId))
			return false;
		if (dataSheetIdList == null) {
			if (other.dataSheetIdList != null)
				return false;
		} else if (!dataSheetIdList.equals(other.dataSheetIdList))
			return false;
		return true;
	}
	 
	
	 	
}
