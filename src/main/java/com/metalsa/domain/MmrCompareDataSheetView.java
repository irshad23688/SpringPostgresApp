package com.metalsa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MMR_COMPARE_DATA_SHEET_VIEW")
public class MmrCompareDataSheetView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "ID")
    private Long id; 
	
	@Column(name ="TEST_SHEET_ID")
	private long testSheetId;
	
	@Column(name ="DATA_SHEET_ID")
	private long dataSheetId;

	@Column(name ="BASE_ATTRIBUTE_ID")
	private long baseAttributeId;
	
	@Column(name ="HEADER_ATTRIBUTE_ID")
	private long headerAttributeId;


	@Column(name ="HEADERNAME")
	private String headerName;
	
	@Column(name ="BASE_ATTRIBUTE_NAME")
	private String baseAttributeName;

	@Column(name ="TESTING_INFORMATION")
	private String testingInformation;

	@Column(name ="REVISION")
	private String revision;

	@Column(name ="SUPPLIER_INFO")
	private String supplierInfo;
	
	@Column(name ="SOM1_UOM")
	private String som1Uom;
	
	@Column(name ="USER_UOM1")
	private String userUom1;
	
	@Column(name ="SOM2_UOM")
	private String som2Uom;
	
	@Column(name ="USER_UOM2")
	private String userUom2;
	
	@Column(name ="STATUS")
	private long status;

	public long getDataSheetId() {
		return dataSheetId;
	}

	public void setDataSheetId(long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}

	public long getBaseAttributeId() {
		return baseAttributeId;
	}

	public void setBaseAttributeId(long baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}

	public long getTestSheetId() {
		return testSheetId;
	}

	public void setTestSheetId(long testSheetId) {
		this.testSheetId = testSheetId;
	}

	public String getBaseAttributeName() {
		return baseAttributeName;
	}

	public void setBaseAttributeName(String baseAttributeName) {
		this.baseAttributeName = baseAttributeName;
	}

	public String getTestingInformation() {
		return testingInformation;
	}

	public void setTestingInformation(String testingInformation) {
		this.testingInformation = testingInformation;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(String supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSom1Uom() {
		return som1Uom;
	}

	public void setSom1Uom(String som1Uom) {
		this.som1Uom = som1Uom;
	}

	public String getUserUom1() {
		return userUom1;
	}

	public void setUserUom1(String userUom1) {
		this.userUom1 = userUom1;
	}

	public String getSom2Uom() {
		return som2Uom;
	}

	public void setSom2Uom(String som2Uom) {
		this.som2Uom = som2Uom;
	}

	public String getUserUom2() {
		return userUom2;
	}

	public void setUserUom2(String userUom2) {
		this.userUom2 = userUom2;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getHeaderAttributeId() {
		return headerAttributeId;
	}

	public void setHeaderAttributeId(long headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	
	
}
