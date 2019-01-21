package com.metalsa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrEditDataSheetDetailView;
import com.metalsa.domain.MmrNewDataSheetDetailView;

 
public class MmrDataSheetDetailUtModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long dataSheetDetailId;
	private BigDecimal createdBy;
	private BigDecimal modifiedBy;
	private String headerAttributeName;
	private String baseAttributeName;
	private BigDecimal baseAttributeSequenceNo;
	private Integer isMandatory;
	private String supplierInformationLhs;
	private String supplierInformationOperator;
	private String supplierInformationRhs;
	private String supplierInformationTableType;
	private Long testSheetDetailId;
	private String testingInformation;
	private String testingInformationTableType;
	private String userSelectUom;
     


	public MmrDataSheetDetailUtModel() {
	}

	
	public MmrDataSheetDetailUtModel(MmrNewDataSheetDetailView detailView) {
		this.headerAttributeName = detailView.getHeaderAttributeName();
		this.baseAttributeName = detailView.getBaseAttributeName();
		this.baseAttributeSequenceNo = detailView.getBaseAttributeSequenceNo();
		this.isMandatory = detailView.getIsMandatory();
		this.testSheetDetailId = detailView.getTestSheetDtlId();
	}


	public MmrDataSheetDetailUtModel(MmrEditDataSheetDetailView detailView) {
		this.dataSheetDetailId = detailView.getDatasheetDtlId();
		this.headerAttributeName = detailView.getHeaderAttributeName();
		this.baseAttributeName = detailView.getBaseAttributeName();
		this.baseAttributeSequenceNo = detailView.getBaseAttributeSequenceNo();
		this.isMandatory = detailView.getIsMandatory();
		this.supplierInformationLhs = detailView.getSupplierInfoLHS();
		this.supplierInformationOperator = detailView.getSupplierInfoOperator();
		this.supplierInformationRhs = detailView.getSupplierInfoRHS();
		this.supplierInformationTableType = detailView.getSupplierInfoTableType();
		this.testSheetDetailId = detailView.getTestSheetDtlId();
		this.testingInformation = detailView.getTestingInfo();
		this.testingInformationTableType = detailView.getTestingInfoTableType();
		this.userSelectUom = detailView.getUserSelectUom();

	}
 

	public long getDataSheetDetailId() {
		return dataSheetDetailId;
	}

	public void setDataSheetDetailId(long dataSheetDetailId) {
		this.dataSheetDetailId = dataSheetDetailId;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public Integer getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Integer isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getSupplierInformationLhs() {
		return supplierInformationLhs;
	}

	public void setSupplierInformationLhs(String supplierInformationLhs) {
		this.supplierInformationLhs = supplierInformationLhs;
	}

	public String getSupplierInformationOperator() {
		return supplierInformationOperator;
	}

	public void setSupplierInformationOperator(String supplierInformationOperator) {
		this.supplierInformationOperator = supplierInformationOperator;
	}

	public String getSupplierInformationRhs() {
		return supplierInformationRhs;
	}

	public void setSupplierInformationRhs(String supplierInformationRhs) {
		this.supplierInformationRhs = supplierInformationRhs;
	}

	public String getSupplierInformationTableType() {
		return supplierInformationTableType;
	}

	public void setSupplierInformationTableType(String supplierInformationTableType) {
		this.supplierInformationTableType = supplierInformationTableType;
	}

	public Long getTestSheetDetailId() {
		return testSheetDetailId;
	}

	public void setTestSheetDetailId(Long testSheetDetailId) {
		this.testSheetDetailId = testSheetDetailId;
	}

	public String getTestingInformation() {
		return testingInformation;
	}

	public void setTestingInformation(String testingInformation) {
		this.testingInformation = testingInformation;
	}

	public String getTestingInformationTableType() {
		return testingInformationTableType;
	}

	public void setTestingInformationTableType(String testingInformationTableType) {
		this.testingInformationTableType = testingInformationTableType;
	}

	public String getUserSelectUom() {
		return userSelectUom;
	}

	public void setUserSelectUom(String userSelectUom) {
		this.userSelectUom = userSelectUom;
	}
	
 
}