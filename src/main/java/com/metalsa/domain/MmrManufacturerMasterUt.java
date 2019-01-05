package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_MANUFACTURER_MASTER_UT database table.
 * 
 */
@Entity
@Table(name="MMR_MANUFACTURER_MASTER_UT")
public class MmrManufacturerMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false,insertable=false)
	private Timestamp createdOn;

	@Column(nullable=false, length=500)
	private String description;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON",insertable=false)
	private Timestamp modifiedOn;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=38)
	private BigDecimal status;

	public MmrManufacturerMasterUt() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}