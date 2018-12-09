package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the data_sheet_detail_ut database table.
 * 
 */
@Entity
@Table(name="data_sheet_detail_ut")
@NamedQuery(name="DataSheetDetailUt.findAll", query="SELECT d FROM DataSheetDetailUt d")
public class DataSheetDetailUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="data_sheet_id")
	private Integer dataSheetId;

	@Column(name="supplier_information_lhs")
	private String supplierInformationLhs;

	@Column(name="supplier_information_operator")
	private String supplierInformationOperator;

	@Column(name="supplier_information_rhs")
	private String supplierInformationRhs;

	@Column(name="supplier_information_table_type")
	private String supplierInformationTableType;

	@Column(name="test_sheet_detail_id")
	private Integer testSheetDetailId;

	@Column(name="testing_information")
	private String testingInformation;

	@Column(name="testing_information_table_type")
	private String testingInformationTableType;

	public DataSheetDetailUt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDataSheetId() {
		return this.dataSheetId;
	}

	public void setDataSheetId(Integer dataSheetId) {
		this.dataSheetId = dataSheetId;
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

	public Integer getTestSheetDetailId() {
		return this.testSheetDetailId;
	}

	public void setTestSheetDetailId(Integer testSheetDetailId) {
		this.testSheetDetailId = testSheetDetailId;
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

}