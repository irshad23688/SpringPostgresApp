package com.metalsa.model;

import java.math.BigDecimal;


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