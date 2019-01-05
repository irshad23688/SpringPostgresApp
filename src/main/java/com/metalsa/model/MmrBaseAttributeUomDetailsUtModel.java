package com.metalsa.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_UOM_DETAILS_UT database table.
 * 
 */
public class MmrBaseAttributeUomDetailsUtModel extends MetalsaAbstractEntityModel {

	private String som1ConversionFactor;
	private String som1Uom;
	private String som2ConversionFactor;
	private String isPrimary;
	private String som2Uom;

	public MmrBaseAttributeUomDetailsUtModel() {
	}

	public String getSom1ConversionFactor() {
		return this.som1ConversionFactor;
	}

	public void setSom1ConversionFactor(String som1ConversionFactor) {
		this.som1ConversionFactor = som1ConversionFactor;
	}
	 
	public String getSom1Uom() {
		return this.som1Uom;
	}

	public void setSom1Uom(String som1Uom) {
		this.som1Uom = som1Uom;
	}

	public String getSom2ConversionFactor() {
		return this.som2ConversionFactor;
	}

	public void setSom2ConversionFactor(String som2ConversionFactor) {
		this.som2ConversionFactor = som2ConversionFactor;
	}

	public String getSom2Uom() {
		return this.som2Uom;
	}

	public void setSom2Uom(String som2Uom) {
		this.som2Uom = som2Uom;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	
}