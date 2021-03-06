package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_TEST_SHEET_DETAIL_UT database table.
 * 
 */
@Entity
@Table(name="MMR_TEST_SHEET_DETAIL_UT")
public class MmrTestSheetDetailUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="BASE_ATTRIBUTE_SEQUENCE_NO", nullable=false, precision=38)
	private BigDecimal baseAttributeSequenceNo;

	
	@Column(name="HEADER_ATTRIBUTE_SEQUENCE_NO",  precision=38)
	private BigDecimal headerAttributeSequenceNo;
	
	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", insertable=false,updatable=false)
	private Timestamp createdOn;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON",insertable=false,updatable=true)
	private Timestamp modifiedOn;

	@Column(nullable=false, precision=38)
	private BigDecimal status;

	@Column(name="BASE_ATTRIBUTE_ID", nullable=false)
	private Long mmrBaseAttributeMasterUt;

	@Column(name="HEADER_ATTRIBUTE_ID", nullable=false)
	private Long mmrHeaderAttributeMasterUt;
	
	 
	@JsonIgnore
	@ManyToOne
	private MmrTestSheetUt mmrTestSheetUt;
	
	@Column(name="ISMANADATORY")
	private Integer isMandatory;
	
	public MmrTestSheetDetailUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Integer getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Integer isMandatory) {
		this.isMandatory = isMandatory;
	}

	public BigDecimal getBaseAttributeSequenceNo() {
		return this.baseAttributeSequenceNo;
	}

	public void setBaseAttributeSequenceNo(BigDecimal baseAttributeSequenceNo) {
		this.baseAttributeSequenceNo = baseAttributeSequenceNo;
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

	public Long getMmrBaseAttributeMasterUt() {
		return this.mmrBaseAttributeMasterUt;
	}

	public void setMmrBaseAttributeMasterUt(Long mmrBaseAttributeMasterUt) {
		this.mmrBaseAttributeMasterUt = mmrBaseAttributeMasterUt;
	}

	public Long getMmrHeaderAttributeMasterUt() {
		return this.mmrHeaderAttributeMasterUt;
	}

	public void setMmrHeaderAttributeMasterUt(Long mmrHeaderAttributeMasterUt) {
		this.mmrHeaderAttributeMasterUt = mmrHeaderAttributeMasterUt;
	}

	public MmrTestSheetUt getMmrTestSheetUt() {
		return mmrTestSheetUt;
	}

	public void setMmrTestSheetUt(MmrTestSheetUt mmrTestSheetUt) {
		this.mmrTestSheetUt = mmrTestSheetUt;
	}

	public BigDecimal getHeaderAttributeSequenceNo() {
		return headerAttributeSequenceNo;
	}

	public void setHeaderAttributeSequenceNo(BigDecimal headerAttributeSequenceNo) {
		this.headerAttributeSequenceNo = headerAttributeSequenceNo;
	}
	
	
}