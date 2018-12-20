package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_UOM_DETAILS_UT database table.
 * 
 */
@Entity
@Table(name="MMR_BASE_ATTRIBUTE_UOM_DETAILS_UT")
public class MmrBaseAttributeUomDetailsUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false)
	private Timestamp createdOn;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(name="SOM1_CONVERSION_FACTOR", nullable=false, length=50)
	private String som1ConversionFactor;

	@Column(name="SOM1_ISPRIMARY", nullable=false, length=50)
	private String som1Isprimary;

	@Column(name="SOM1_UOM", nullable=false, length=50)
	private String som1Uom;

	@Column(name="SOM2_CONVERSION_FACTOR", nullable=false, length=50)
	private String som2ConversionFactor;

	@Column(name="SOM2_ISPRIMARY", nullable=false, length=50)
	private String som2Isprimary;

	@Column(name="SOM2_UOM", nullable=false, length=50)
	private String som2Uom;

	@Column(nullable=false, precision=38)
	private BigDecimal status;

	//bi-directional many-to-one association to MmrBaseAttributeMasterUt
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BASE_ATTRIBUTE_ID", nullable=false)
	private MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt;

	public MmrBaseAttributeUomDetailsUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public BigDecimal getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
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

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public MmrBaseAttributeMasterUt getMmrBaseAttributeMasterUt() {
		return this.mmrBaseAttributeMasterUt;
	}

	public void setMmrBaseAttributeMasterUt(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt) {
		this.mmrBaseAttributeMasterUt = mmrBaseAttributeMasterUt;
	}

}