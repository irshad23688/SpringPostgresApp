package com.metalsa.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MMR_TEST_SHEET_DETAIL_UT database table.
 * 
 */
public class MmrTestSheetDetailUtModel extends MetalsaAbstractEntityModel {

	private long id;
	private BigDecimal baseAttributeSequenceNo;
	private Long mmrBaseAttributeMasterUt;
	private Long mmrHeaderAttributeMasterUt;
	private Integer isMandatory;
	
	public MmrTestSheetDetailUtModel() {
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

}