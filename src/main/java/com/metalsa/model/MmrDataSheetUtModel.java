package com.metalsa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the MMR_DATA_SHEET_UT database table.
 * 
 */
public class MmrDataSheetUtModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private long dataSheetId;
	private BigDecimal approvedBy;
	private Long classId;
	private BigDecimal createdBy;
	private String dataSheetName;
	private BigDecimal modifiedBy;
	private Timestamp modifiedOn;
	private BigDecimal revision;
	private BigDecimal status;
	private Long subclassId;
	private Long testSheetId;
	private List<MmrDataSheetHeaderModel> dataSheetHeaderDetails= new ArrayList<>();

	public MmrDataSheetUtModel() {
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

	public BigDecimal getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(BigDecimal approvedBy) {
		this.approvedBy = approvedBy;
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

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
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

 	

}