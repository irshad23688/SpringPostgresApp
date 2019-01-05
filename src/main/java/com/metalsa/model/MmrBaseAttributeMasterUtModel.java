package com.metalsa.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.metalsa.domain.MmrDataTypeMasterUt;
import com.metalsa.domain.MmrHeaderAttributeMasterUt;


/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_MASTER_UT database table.
 * 
 */
public class MmrBaseAttributeMasterUtModel extends MetalsaAbstractEntityModel {

	private String defaultValue;
	private String description;
	private String displayNameUom1;
	private String displayNameUom2;
	private String placeHolderText;
	private String name;
	private String symbol;
	private String tooltip;
	private MmrDataTypeMasterUt mmrDataTypeMasterUt;
	private MmrHeaderAttributeMasterUtModel mmrHeaderAttributeMasterUt;
	private List<MmrBaseAttributeUomDetailsUtModel> mmrBaseAttributeUomDetailsUts;
	private List<MmrBaseAttributeTableDataTypeUtModel> mmrBaseAttributeTableDataTypeUts;

	public MmrBaseAttributeMasterUtModel() {
	}

	public MmrBaseAttributeMasterUtModel(MmrHeaderAttributeMasterUt headerMaster) {
		
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayNameUom1() {
		return displayNameUom1;
	}

	public void setDisplayNameUom1(String displayNameUom1) {
		this.displayNameUom1 = displayNameUom1;
	}

	public String getDisplayNameUom2() {
		return displayNameUom2;
	}

	public void setDisplayNameUom2(String displayNameUom2) {
		this.displayNameUom2 = displayNameUom2;
	}

	public String getPlaceHolderText() {
		return placeHolderText;
	}

	public void setPlaceHolderText(String placeHolderText) {
		this.placeHolderText = placeHolderText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public MmrDataTypeMasterUt getMmrDataTypeMasterUt() {
		return mmrDataTypeMasterUt;
	}

	public void setMmrDataTypeMasterUt(MmrDataTypeMasterUt mmrDataTypeMasterUt) {
		this.mmrDataTypeMasterUt = mmrDataTypeMasterUt;
	}

	public MmrHeaderAttributeMasterUtModel getMmrHeaderAttributeMasterUt() {
		return mmrHeaderAttributeMasterUt;
	}

	public void setMmrHeaderAttributeMasterUt(MmrHeaderAttributeMasterUtModel mmrHeaderAttributeMasterUt) {
		this.mmrHeaderAttributeMasterUt = mmrHeaderAttributeMasterUt;
	}

	public List<MmrBaseAttributeUomDetailsUtModel> getMmrBaseAttributeUomDetailsUts() {
		return mmrBaseAttributeUomDetailsUts;
	}

	public void setMmrBaseAttributeUomDetailsUts(List<MmrBaseAttributeUomDetailsUtModel> mmrBaseAttributeUomDetailsUts) {
		this.mmrBaseAttributeUomDetailsUts = mmrBaseAttributeUomDetailsUts;
	}

	public List<MmrBaseAttributeTableDataTypeUtModel> getMmrBaseAttributeTableDataTypeUts() {
		return mmrBaseAttributeTableDataTypeUts;
	}

	public void setMmrBaseAttributeTableDataTypeUts(
			List<MmrBaseAttributeTableDataTypeUtModel> mmrBaseAttributeTableDataTypeUts) {
		this.mmrBaseAttributeTableDataTypeUts = mmrBaseAttributeTableDataTypeUts;
	}
	
	
 
}