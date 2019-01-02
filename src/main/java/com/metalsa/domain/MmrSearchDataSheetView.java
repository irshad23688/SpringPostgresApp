package com.metalsa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="SEARCH_DATASHEET_VIEW")
//@Immutable
public class MmrSearchDataSheetView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "ID")
    private Long id; 
	
	@Column(name ="DATA_SHEET_ID")
	private long dataSheetId;

	@Column(name ="BASE_ATTRIBUTE_ID")
	private long baseAttributeId;

	@Column(name ="TEST_SHEET_ID")
	private long testSheetId;

	@Column(name ="BASE_ATTRIBUTE_NAME")
	private String baseAttributeName;

	@Column(name ="TESTING_INFORMATION")
	private String testingInformation;

	@Column(name ="REVISION")
	private String revision;

	@Column(name ="SUPPLIER_INFO")
	private String supplierInfo;

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
}
