package com.metalsa.model;

import java.util.ArrayList;
import java.util.List;

public class MmrCompareDataSheetModel {
	
	private Long headerAttributeId;
	private String headerAttributeName;
	List<CompareBaseModel> baseAttribute = new ArrayList<>();
	
	public Long getHeaderAttributeId() {
		return headerAttributeId;
	}
	public void setHeaderAttributeId(Long headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}
	public String getHeaderAttributeName() {
		return headerAttributeName;
	}
	public void setHeaderAttributeName(String headerAttributeName) {
		this.headerAttributeName = headerAttributeName;
	}
	public List<CompareBaseModel> getBaseAttribute() {
		return baseAttribute;
	}
	public void setBaseAttribute(List<CompareBaseModel> baseAttribute) {
		this.baseAttribute = baseAttribute;
	}
	
}
