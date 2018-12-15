package com.metalsa.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchDataListModel {
	
	private String materialName;
	private String materialDesignation;
	private String revisionNumber;
	private String materialCondition;
	private String materialClass;
	// add the properties on the fly in map
	private Map<String,String> propertyMap = new LinkedHashMap<>();
	private String supplierInfo;
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialDesignation() {
		return materialDesignation;
	}
	public void setMaterialDesignation(String materialDesignation) {
		this.materialDesignation = materialDesignation;
	}
	public String getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public String getMaterialCondition() {
		return materialCondition;
	}
	public void setMaterialCondition(String materialCondition) {
		this.materialCondition = materialCondition;
	}
	public String getMaterialClass() {
		return materialClass;
	}
	public void setMaterialClass(String materialClass) {
		this.materialClass = materialClass;
	}
	public Map<String, String> getPropertyMap() {
		return propertyMap;
	}
	public void setPropertyMap(Map<String, String> propertyMap) {
		this.propertyMap = propertyMap;
	}
	public String getSupplierInfo() {
		return supplierInfo;
	}
	public void setSupplierInfo(String supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

}
