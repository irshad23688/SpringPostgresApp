package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the MMR_DATA_SHEET_DETAIL_UT database table.
 * 
 */
@Entity
@Table(name="MMR_DATA_SHEET_DETAIL_UT")
public class MmrDataSheetDetailUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", insertable=false,updatable=false)
	private Timestamp createdOn;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON",insertable=false,updatable=true)
	private Timestamp modifiedOn;

	@Column(precision=38)
	private BigDecimal status;

	/*@Column(name="STATUS_ID", nullable=false, precision=38)
	private BigDecimal statusId;*/

	@Column(name="SUPPLIER_INFORMATION_LHS",  length=50)
	private String supplierInformationLhs;

	@Column(name="SUPPLIER_INFORMATION_OPERATOR",  length=50)
	private String supplierInformationOperator;

	@Column(name="SUPPLIER_INFORMATION_RHS",  length=50)
	private String supplierInformationRhs;

	@Lob
	@Column(name="SUPPLIER_INFORMATION_TABLE_TYPE")
	private String supplierInformationTableType;

	@Column(name="TEST_SHEET_DETAIL_ID", nullable=false, precision=38)
	private Long testSheetDetailId;

	@Column(name="TESTING_INFORMATION", nullable=false, length=100)
	private String testingInformation;

	@Lob
	@Column(name="TESTING_INFORMATION_TABLE_TYPE")
	private String testingInformationTableType;

	@Column(name="USER_SELECT_UOM",  precision=38)
	private String userSelectUom;

	@Column(name="USER_UOM1", length=50)
	private String userUom1;

	@Column(name="USER_UOM2", length=50)
	private String userUom2;

	@ManyToOne
	private MmrDataSheetUt mmrDataSheetUt;

	public MmrDataSheetDetailUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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


	public String getSupplierInformationLhs() {
		return this.supplierInformationLhs;
	}

	public void setSupplierInformationLhs(String supplierInformationLhs) {
		this.supplierInformationLhs = supplierInformationLhs;
	}

	public String getSupplierInformationOperator() {
		return this.supplierInformationOperator;
	}

	public void setSupplierInformationOperator(String supplierInformationOperator) {
		this.supplierInformationOperator = supplierInformationOperator;
	}

	public String getSupplierInformationRhs() {
		return this.supplierInformationRhs;
	}

	public void setSupplierInformationRhs(String supplierInformationRhs) {
		this.supplierInformationRhs = supplierInformationRhs;
	}

	public String getSupplierInformationTableType() {
		return this.supplierInformationTableType;
	}

	public void setSupplierInformationTableType(String supplierInformationTableType) {
		this.supplierInformationTableType = supplierInformationTableType;
	}

	public String getTestingInformation() {
		return this.testingInformation;
	}

	public void setTestingInformation(String testingInformation) {
		this.testingInformation = testingInformation;
	}

	public String getTestingInformationTableType() {
		return this.testingInformationTableType;
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

	public String getUserUom1() {
		return this.userUom1;
	}

	public void setUserUom1(String userUom1) {
		this.userUom1 = userUom1;
	}

	public String getUserUom2() {
		return this.userUom2;
	}

	public void setUserUom2(String userUom2) {
		this.userUom2 = userUom2;
	}

	public Long getTestSheetDetailId() {
		return testSheetDetailId;
	}

	public void setTestSheetDetailId(Long testSheetDetailId) {
		this.testSheetDetailId = testSheetDetailId;
	}

	public MmrDataSheetUt getMmrDataSheetUt() {
		return mmrDataSheetUt;
	}

	public void setMmrDataSheetUt(MmrDataSheetUt mmrDataSheetUt) {
		this.mmrDataSheetUt = mmrDataSheetUt;
	}
}