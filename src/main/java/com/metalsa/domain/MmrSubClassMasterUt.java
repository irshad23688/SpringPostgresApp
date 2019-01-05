package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the MMR_SUBCLASS_MASTER_UT database table.
 * 
 */
@Entity
@Table(name="MMR_SUBCLASS_MASTER_UT")
public class MmrSubClassMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(length=100)
	private String abbreviation;

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

	@Column(nullable=false, precision=38,insertable=false)
	private BigDecimal status;

	//bi-directional many-to-one association to MmrClassMasterUt
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CLASS_ID", nullable=false)
	@JsonBackReference
	private MmrClassMasterUt mmrClassMasterUt;
 
	public MmrSubClassMasterUt() {
	}

	
	public MmrSubClassMasterUt(long id, String abbreviation, BigDecimal createdBy, Timestamp createdOn,
			String description, BigDecimal modifiedBy, Timestamp modifiedOn, String name, BigDecimal status) {
		super();
		this.id = id;
		this.abbreviation = abbreviation;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.description = description;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.name = name;
		this.status = status;
	}


	public MmrSubClassMasterUt(MmrClassMasterUt mmrClassMasterUt2) {
		this.mmrClassMasterUt=mmrClassMasterUt2;
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

	public MmrClassMasterUt getMmrClassMasterUt() {
		return this.mmrClassMasterUt;
	}

	public void setMmrClassMasterUt(MmrClassMasterUt mmrClassMasterUt) {
		this.mmrClassMasterUt = mmrClassMasterUt;
	}

}