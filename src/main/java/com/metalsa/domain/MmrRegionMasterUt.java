package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_REGION_MASTER_UT database table.
 * 
 */
@Entity
@Table(name="MMR_REGION_MASTER_UT")
public class MmrRegionMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(nullable=false, length=100)
	private String abbreviation;

	@Column(name="CREATED_BY", precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON",insertable=false)
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

	public MmrRegionMasterUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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