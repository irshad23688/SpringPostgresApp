package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the base_attribute_uom_details_ut database table.
 * 
 */
@Entity
@Table(name="base_attribute_uom_details_ut")
@NamedQuery(name="BaseAttributeUomDetailsUt.findAll", query="SELECT b FROM BaseAttributeUomDetailsUt b")
public class BaseAttributeUomDetailsUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="base_attribute_id")
	private Integer baseAttributeId;

	@Column(name="som1_conversion_factor")
	private String som1ConversionFactor;

	@Column(name="som1_isprimary")
	private String som1Isprimary;

	@Column(name="som1_uom")
	private String som1Uom;

	@Column(name="som2_conversion_factor")
	private String som2ConversionFactor;

	@Column(name="som2_isprimary")
	private String som2Isprimary;

	@Column(name="som2_uom")
	private String som2Uom;

	public BaseAttributeUomDetailsUt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseAttributeId() {
		return this.baseAttributeId;
	}

	public void setBaseAttributeId(Integer baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}

	public String getSom1ConversionFactor() {
		return this.som1ConversionFactor;
	}

	public void setSom1ConversionFactor(String som1ConversionFactor) {
		this.som1ConversionFactor = som1ConversionFactor;
	}

	public String getSom1Isprimary() {
		return this.som1Isprimary;
	}

	public void setSom1Isprimary(String som1Isprimary) {
		this.som1Isprimary = som1Isprimary;
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

	public String getSom2Isprimary() {
		return this.som2Isprimary;
	}

	public void setSom2Isprimary(String som2Isprimary) {
		this.som2Isprimary = som2Isprimary;
	}

	public String getSom2Uom() {
		return this.som2Uom;
	}

	public void setSom2Uom(String som2Uom) {
		this.som2Uom = som2Uom;
	}

}