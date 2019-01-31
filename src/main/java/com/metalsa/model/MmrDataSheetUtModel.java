package com.metalsa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.metalsa.domain.MmrDataSheetUt;


/**
 * The persistent class for the MMR_DATA_SHEET_UT database table.
 * 
 */
public class MmrDataSheetUtModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private long dataSheetId;
	private Long classId;
	private BigDecimal createdBy;
	private String dataSheetName;
	private BigDecimal modifiedBy;
	private BigDecimal revision;
	private BigDecimal status;
	private Long subclassId;
	private Long testSheetId;
	private Long headerAttributeSequenceNo;
	private Long maxHeaders;
	private Long minHeaders;
	private String traverseFlag;
	private String action;
	private List<MmrDataSheetHeaderModel> dataSheetHeaderDetails= new ArrayList<>();

	public MmrDataSheetUtModel() {
	}
	
	public MmrDataSheetUtModel(MmrDataSheetUt mmrDataSheetUt) {
		this.dataSheetId = mmrDataSheetUt.getId();
		this.classId = mmrDataSheetUt.getClassId();
		this.createdBy = mmrDataSheetUt.getCreatedBy();
		this.dataSheetName = mmrDataSheetUt.getDataSheetName();
		this.modifiedBy = mmrDataSheetUt.getModifiedBy();
		this.revision = mmrDataSheetUt.getRevision();
		this.status = mmrDataSheetUt.getStatus();
		this.subclassId = mmrDataSheetUt.getSubclassId();
		this.testSheetId = mmrDataSheetUt.getTestSheetId();
	}

	public List<MmrDataSheetHeaderModel> getDataSheetHeaderDetails() {
		return dataSheetHeaderDetails;
	}

	public void setDataSheetHeaderDetails(List<MmrDataSheetHeaderModel> dataSheetHeaderDetails) {
		this.dataSheetHeaderDetails = dataSheetHeaderDetails;
	}
	public void addDataSheetHeaderDetails(MmrDataSheetHeaderModel dataSheetHeaderDetail) {
		this.dataSheetHeaderDetails.add(dataSheetHeaderDetail);
	}


	public long getDataSheetId() {
		return dataSheetId;
	}

	public void setDataSheetId(long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public String getDataSheetName() {
		return dataSheetName;
	}

	public void setDataSheetName(String dataSheetName) {
		this.dataSheetName = dataSheetName;
	}

	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public BigDecimal getRevision() {
		return revision;
	}

	public void setRevision(BigDecimal revision) {
		this.revision = revision;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public Long getSubclassId() {
		return subclassId;
	}

	public void setSubclassId(Long subclassId) {
		this.subclassId = subclassId;
	}

	public Long getTestSheetId() {
		return testSheetId;
	}

	public void setTestSheetId(Long testSheetId) {
		this.testSheetId = testSheetId;
	}

	public Long getHeaderAttributeSequenceNo() {
		return headerAttributeSequenceNo;
	}

	public void setHeaderAttributeSequenceNo(Long headerAttributeSequenceNo) {
		this.headerAttributeSequenceNo = headerAttributeSequenceNo;
	}

	public Long getMaxHeaders() {
		return maxHeaders;
	}

	public void setMaxHeaders(Long maxHeaders) {
		this.maxHeaders = maxHeaders;
	}

	public Long getMinHeaders() {
		return minHeaders;
	}

	public void setMinHeaders(Long minHeaders) {
		this.minHeaders = minHeaders;
	}

	public String getTraverseFlag() {
		return traverseFlag;
	}

	public void setTraverseFlag(String traverseFlag) {
		this.traverseFlag = traverseFlag;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
 

	 
 	

}