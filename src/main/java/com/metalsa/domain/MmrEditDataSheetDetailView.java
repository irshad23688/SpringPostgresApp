package com.metalsa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MMR_EDIT_DATA_SHEET_DETAIL_VIEW")
public class MmrEditDataSheetDetailView implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private Long id; 

	@Column(name ="BASE_ATTRIBUTE_ID")
	private long baseAttributeId;

	@Column(name ="HEADER_ATTRIBUTE_ID")
	private long headerAttributeId;

	@Column(name ="MMR_TEST_SHEET_UT_ID")
	private long testSheetId;

	@Column(name ="TEST_SHEET_DTL_ID")
	private long testSheetDtlId;
	
	@Column(name ="DATA_SHEET_DETAIL_ID")
	private long datasheetDtlId;

	@Column(name ="HEADER_ATTRIBUTE_NAME")
	private String headerAttributeName;

	@Column(name ="BASE_ATTRIBUTE_NAME")
	private String baseAttributeName;

	@Column(name ="SUPPLIER_INFORMATION_LHS")
	private String supplierInfoLHS;

	@Column(name ="SUPPLIER_INFORMATION_OPERATOR")
	private String supplierInfoOperator;
	
	@Column(name ="SUPPLIER_INFORMATION_RHS")
	private String supplierInfoRHS;
	
	@Column(name ="SUPPLIER_INFORMATION_TABLE_TYPE")
	private String supplierInfoTableType;
	
	@Column(name ="TESTING_INFORMATION_TABLE_TYPE")
	private String testingInfoTableType;
	
	@Column(name ="TESTING_INFORMATION")
	private String testingInfo;
	
	@Column(name ="USER_UOM1")
	private String userUom1;
	
	@Column(name ="USER_UOM2")
	private String userUom2;
	
	@Column(name ="USER_SELECT_UOM")
	private String userSelectUom;
	
	@Column(name ="ISMANADATORY")
	private boolean isMandatory;
	
	@Column(name ="BASE_ATTRIBUTE_SEQUENCE_NO")
	private long baseAttribSequence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getBaseAttributeId() {
		return baseAttributeId;
	}

	public void setBaseAttributeId(long baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}

	public long getHeaderAttributeId() {
		return headerAttributeId;
	}

	public void setHeaderAttributeId(long headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}

	public long getTestSheetId() {
		return testSheetId;
	}

	public void setTestSheetId(long testSheetId) {
		this.testSheetId = testSheetId;
	}

	public long getTestSheetDtlId() {
		return testSheetDtlId;
	}

	public void setTestSheetDtlId(long testSheetDtlId) {
		this.testSheetDtlId = testSheetDtlId;
	}

	public long getDatasheetDtlId() {
		return datasheetDtlId;
	}

	public void setDatasheetDtlId(long datasheetDtlId) {
		this.datasheetDtlId = datasheetDtlId;
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

	public String getSupplierInfoLHS() {
		return supplierInfoLHS;
	}

	public void setSupplierInfoLHS(String supplierInfoLHS) {
		this.supplierInfoLHS = supplierInfoLHS;
	}

	public String getSupplierInfoOperator() {
		return supplierInfoOperator;
	}

	public void setSupplierInfoOperator(String supplierInfoOperator) {
		this.supplierInfoOperator = supplierInfoOperator;
	}

	public String getSupplierInfoRHS() {
		return supplierInfoRHS;
	}

	public void setSupplierInfoRHS(String supplierInfoRHS) {
		this.supplierInfoRHS = supplierInfoRHS;
	}

	public String getSupplierInfoTableType() {
		return supplierInfoTableType;
	}

	public void setSupplierInfoTableType(String supplierInfoTableType) {
		this.supplierInfoTableType = supplierInfoTableType;
	}

	public String getTestingInfoTableType() {
		return testingInfoTableType;
	}

	public void setTestingInfoTableType(String testingInfoTableType) {
		this.testingInfoTableType = testingInfoTableType;
	}

	public String getTestingInfo() {
		return testingInfo;
	}

	public void setTestingInfo(String testingInfo) {
		this.testingInfo = testingInfo;
	}

	public String getUserUom1() {
		return userUom1;
	}

	public void setUserUom1(String userUom1) {
		this.userUom1 = userUom1;
	}

	public String getUserUom2() {
		return userUom2;
	}

	public void setUserUom2(String userUom2) {
		this.userUom2 = userUom2;
	}

	public String getUserSelectUom() {
		return userSelectUom;
	}

	public void setUserSelectUom(String userSelectUom) {
		this.userSelectUom = userSelectUom;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public long getBaseAttribSequence() {
		return baseAttribSequence;
	}

	public void setBaseAttribSequence(long baseAttribSequence) {
		this.baseAttribSequence = baseAttribSequence;
	}

}