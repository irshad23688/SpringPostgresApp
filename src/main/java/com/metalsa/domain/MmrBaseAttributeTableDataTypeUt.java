package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_TABLE_DATA_TYPE_UT database table.
 * 
 */
@Entity
@Table(name="MMR_BASE_ATTRIBUTE_TABLE_DATA_TYPE_UT")
public class MmrBaseAttributeTableDataTypeUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private Long mmrParameterBaseAttributeId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false,insertable=false)
	private Timestamp createdOn;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON",insertable=false)
	private Timestamp modifiedOn;

	@Column(nullable=false, precision=38,insertable=false)
	private BigDecimal status;

	//bi-directional many-to-one association to MmrBaseAttributeMasterUt
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BASE_ATTRIBUTE_ID", nullable=false)
	//@JsonManagedReference
	private MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt;

	//bi-directional many-to-one association to MmrHeaderAttributeMasterUt
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="PARAMETER_BASE_ATTRIBUTE_ID", nullable=false)
	private MmrBaseAttributeMasterUt mmrParameterBaseAttributeMasterUt;

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

	public MmrBaseAttributeMasterUt getMmrBaseAttributeMasterUt() {
		return this.mmrBaseAttributeMasterUt;
	}

	public void setMmrBaseAttributeMasterUt(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt) {
		this.mmrBaseAttributeMasterUt = mmrBaseAttributeMasterUt;
	}

	
	/*public MmrHeaderAttributeMasterUt getMmrHeaderAttributeMasterUt() {
		return this.mmrHeaderAttributeMasterUt;
	}

	public void setMmrHeaderAttributeMasterUt(MmrHeaderAttributeMasterUt mmrHeaderAttributeMasterUt) {
		this.mmrHeaderAttributeMasterUt = mmrHeaderAttributeMasterUt;
	}*/
	
	
	@JsonIgnore
	public MmrBaseAttributeMasterUt getMmrParameterBaseAttributeMasterUt() {
		return mmrParameterBaseAttributeMasterUt;
	}

	public void setMmrParameterBaseAttributeMasterUt(MmrBaseAttributeMasterUt mmrParameterBaseAttributeMasterUt) {
		this.mmrParameterBaseAttributeMasterUt = mmrParameterBaseAttributeMasterUt;
	}

	public Long getMmrParameterBaseAttributeId() {
		return mmrParameterBaseAttributeId;
	}

	public void setMmrParameterBaseAttributeId(Long mmrParameterBaseAttributeId) {
		this.mmrParameterBaseAttributeId = mmrParameterBaseAttributeId;
	}

	
	
	
	

}