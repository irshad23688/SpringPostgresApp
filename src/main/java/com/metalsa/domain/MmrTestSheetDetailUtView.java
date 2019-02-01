package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the MMR_TEST_SHEET_DETAIL_UT database table.
 * 
 */
@Entity
@Table(name="MMR_TEST_SHEET_DETAIL_UT_VIEW")
public class MmrTestSheetDetailUtView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private long id;

	@Column(name="TEST_SHEET_DTL_ID")
	private Long testSheetDtlId;
	
	@Column(name="mmr_test_sheet_ut_id")
	private Long mmrTestSheetUtId;
	
	@Column(name="HEADER_ATTRIBUTE_ID")
	private Long headerAttributeId;
	
	@Column(name="HEADER_ATTRIBUTE_NAME")
	private String headerAttributeName;
	
	@Column(name="BASE_ATTRIBUTE_ID" )
	private Long baseAttributeId;
	
	@Column(name="BASE_ATTRIBUTE_NAME" )
	private String baseAttributeName;
	
	@Column(name="HEADER_ATTRIBUTE_SEQUENCE_NO" )
	private BigDecimal headerAttributeSequenceNo;

	@Column(name="BASE_ATTRIBUTE_SEQUENCE_NO" )
	private BigDecimal baseAttributeSequenceNo;
	
	@Column
	private BigDecimal status;

	@Column(name="ISMANADATORY")
	private Integer isMandatory;
	
	public MmrTestSheetDetailUtView() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getTestSheetDtlId() {
		return testSheetDtlId;
	}

	public void setTestSheetDtlId(Long testSheetDtlId) {
		this.testSheetDtlId = testSheetDtlId;
	}

	public Long getMmrTestSheetUtId() {
		return mmrTestSheetUtId;
	}

	public void setMmrTestSheetUtId(Long mmrTestSheetUtId) {
		this.mmrTestSheetUtId = mmrTestSheetUtId;
	}

	public Long getHeaderAttributeId() {
		return headerAttributeId;
	}

	public void setHeaderAttributeId(Long headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}


	public Long getBaseAttributeId() {
		return baseAttributeId;
	}

	public void setBaseAttributeId(Long baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}


	public String getHeaderAttributeName() {
		return headerAttributeName;
	}

	public void setHeaderAttributeName(String headerAttributeName) {
		this.headerAttributeName = headerAttributeName;
	}

	public String getBaseAttributeName() {
		return baseAttributeName;
	}

	public void setBaseAttributeName(String baseAttributeName) {
		this.baseAttributeName = baseAttributeName;
	}

	public BigDecimal getBaseAttributeSequenceNo() {
		return baseAttributeSequenceNo;
	}

	public void setBaseAttributeSequenceNo(BigDecimal baseAttributeSequenceNo) {
		this.baseAttributeSequenceNo = baseAttributeSequenceNo;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public Integer getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Integer isMandatory) {
		this.isMandatory = isMandatory;
	}

	public BigDecimal getHeaderAttributeSequenceNo() {
		return headerAttributeSequenceNo;
	}

	public void setHeaderAttributeSequenceNo(BigDecimal headerAttributeSequenceNo) {
		this.headerAttributeSequenceNo = headerAttributeSequenceNo;
	}

	
	 
}