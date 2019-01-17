package com.metalsa.model;

import java.util.List;

public class CompareBaseModel {
	
	private String baseAttributeDefaultDisplayName;
	private Long baseAttributeId;
	List<CompareMaterialModel> materialValue ;
	
	public String getBaseAttributeDefaultDisplayName() {
		return baseAttributeDefaultDisplayName;
	}
	public void setBaseAttributeDefaultDisplayName(String baseAttributeDefaultDisplayName) {
		this.baseAttributeDefaultDisplayName = baseAttributeDefaultDisplayName;
	}
	public Long getBaseAttributeId() {
		return baseAttributeId;
	}
	public void setBaseAttributeId(Long baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}
	public List<CompareMaterialModel> getMaterialValue() {
		return materialValue;
	}
	public void setMaterialValue(List<CompareMaterialModel> materialValue) {
		this.materialValue = materialValue;
	}
	
	
}
