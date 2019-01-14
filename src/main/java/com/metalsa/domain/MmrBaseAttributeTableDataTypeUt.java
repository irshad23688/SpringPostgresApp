package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_TABLE_DATA_TYPE_UT database table.
 * 
 */
@Entity
@Table(name="MMR_BASE_ATTRIBUTE_TABLE_DATA_TYPE_UT")
public class MmrBaseAttributeTableDataTypeUt implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", insertable=false,updatable=false)
	private Timestamp createdOn;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON",insertable=false,updatable=true)
	private Timestamp modifiedOn;

	@Column(nullable=false, precision=38,insertable=false)
	private BigDecimal status;

	/*//bi-directional many-to-one association to MmrBaseAttributeMasterUt
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BASE_ATTRIBUTE_ID", nullable=false)
	//@JsonManagedReference
	private MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt;*/

	@Column(name="BASE_ATTRIBUTE_ID", nullable=false)
	private Long mmrBaseAttributeMasterUt;

	/*//bi-directional many-to-one association to MmrHeaderAttributeMasterUt
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="PARAMETER_BASE_ATTRIBUTE_ID", nullable=false)
	private MmrBaseAttributeMasterUt mmrParameterBaseAttributeUt;*/

	@Column(name="PARAMETER_BASE_ATTRIBUTE_ID", nullable=false)
	private Long mmrParameterBaseAttributeUt;

	public MmrBaseAttributeTableDataTypeUt() {
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

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	 
	
	/*public MmrHeaderAttributeMasterUt getMmrHeaderAttributeMasterUt() {
		return this.mmrHeaderAttributeMasterUt;
	}

	public void setMmrHeaderAttributeMasterUt(MmrHeaderAttributeMasterUt mmrHeaderAttributeMasterUt) {
		this.mmrHeaderAttributeMasterUt = mmrHeaderAttributeMasterUt;
	}*/
	
	
	 
	public Long getMmrBaseAttributeMasterUt() {
		return mmrBaseAttributeMasterUt;
	}

	public void setMmrBaseAttributeMasterUt(Long mmrBaseAttributeMasterUt) {
		this.mmrBaseAttributeMasterUt = mmrBaseAttributeMasterUt;
	}

	public Long getMmrParameterBaseAttributeUt() {
		return mmrParameterBaseAttributeUt;
	}

	public void setMmrParameterBaseAttributeUt(Long mmrParameterBaseAttributeUt) {
		this.mmrParameterBaseAttributeUt = mmrParameterBaseAttributeUt;
	}

	
	
	
	

}