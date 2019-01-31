package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MMR_NEW_DATA_SHEET_DETAIL_VIEW")
public class MmrNewDataSheetDetailView implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private Long id; 
	
	@Column(name ="mmr_data_sheet_ut_id")
	private long dataSheetUtId;

	@Column(name ="class_id")
	private long classId;
	
	@Column(name ="subclass_id")
	private long subClassId;
	
	@Column(name ="data_type_name")
	private String inputDataTypeName;
	
	@Column(name ="front_data_type")
	private String frontDataType;
	
	@Column(name ="front_data_pattern")
	private String frontDataPattern;
	
	@Column(name ="BASE_ATTRIBUTE_ID")
	private long baseAttributeId;

	@Column(name ="HEADER_ATTRIBUTE_ID")
	private long headerAttributeId;

	@Column(name ="MMR_TEST_SHEET_UT_ID")
	private long testSheetId;

	@Column(name ="TEST_SHEET_DTL_ID")
	private long testSheetDtlId;


	@Column(name ="HEADER_ATTRIBUTE_NAME")
	private String headerAttributeName;

	@Column(name ="BASE_ATTRIBUTE_NAME")
	private String baseAttributeName;

	@Column(name ="description")
	private String description;
	
	@Column(name ="place_holder_text")
	private String placeHolderText;
	
	@Column(name ="symbol")
	private String symbol;
	
	@Column(name ="tooltip")
	private String tooltip;
	
	@Column(name ="default_value")
	private String defaultValue;
	
	@Column(name ="ISMANADATORY")
	private Integer isMandatory;

	@Column(name ="BASE_ATTRIBUTE_SEQUENCE_NO")
	private BigDecimal baseAttributeSequenceNo;
	
	
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
	
	@Column(name ="som1_uom")
	private String som1Uom;
	
	@Column(name ="som1_conversion_factor")
	private String som1ConversionFactor;
	
	@Column(name ="som2_uom")
	private String som2Uom;
	
	@Column(name ="som2_conversion_factor")
	private String som2ConversionFactor;
	
	@Column(name ="is_primary")
	private String isPrimary;
	
	@Column(name ="DATA_SHEET_DETAIL_ID")
	private long datasheetDtlId;
	
	
	

	public MmrNewDataSheetDetailView(MmrEditDataSheetDetailView detailView) {
		super();
		this.id = detailView.getId();
		this.classId = detailView.getClassId();
		this.subClassId = detailView.getSubClassId();
		this.inputDataTypeName = detailView.getInputDataTypeName();
		this.frontDataType = detailView.getFrontDataType();
		this.frontDataPattern = detailView.getFrontDataPattern();
		this.baseAttributeId = detailView.getBaseAttributeId();
		this.headerAttributeId = detailView.getHeaderAttributeId();
		this.testSheetId = detailView.getTestSheetId();
		this.testSheetDtlId = detailView.getTestSheetDtlId();
		this.headerAttributeName = detailView.getHeaderAttributeName();
		this.baseAttributeName = detailView.getBaseAttributeName();
		this.description = description;
		this.placeHolderText = placeHolderText;
		this.symbol = symbol;
		this.tooltip = tooltip;
		this.defaultValue = defaultValue;
		this.isMandatory = detailView.getIsMandatory();
		this.baseAttributeSequenceNo = detailView.getBaseAttributeSequenceNo();
	}

	public MmrNewDataSheetDetailView() {
		// TODO Auto-generated constructor stub
	}

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
 
	public Integer getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Integer isMandatory) {
		this.isMandatory = isMandatory;
	}

	public BigDecimal getBaseAttributeSequenceNo() {
		return baseAttributeSequenceNo;
	}

	public void setBaseAttributeSequenceNo(BigDecimal baseAttributeSequenceNo) {
		this.baseAttributeSequenceNo = baseAttributeSequenceNo;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public long getSubClassId() {
		return subClassId;
	}

	public void setSubClassId(long subClassId) {
		this.subClassId = subClassId;
	}

	public String getInputDataTypeName() {
		return inputDataTypeName;
	}

	public void setInputDataTypeName(String inputDataTypeName) {
		this.inputDataTypeName = inputDataTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceHolderText() {
		return placeHolderText;
	}

	public void setPlaceHolderText(String placeHolderText) {
		this.placeHolderText = placeHolderText;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getFrontDataType() {
		return frontDataType;
	}

	public void setFrontDataType(String frontDataType) {
		this.frontDataType = frontDataType;
	}

	public String getFrontDataPattern() {
		return frontDataPattern;
	}

	public void setFrontDataPattern(String frontDataPattern) {
		this.frontDataPattern = frontDataPattern;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
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

	public long getDataSheetUtId() {
		return dataSheetUtId;
	}

	public void setDataSheetUtId(long dataSheetUtId) {
		this.dataSheetUtId = dataSheetUtId;
	}

	public long getDatasheetDtlId() {
		return datasheetDtlId;
	}

	public void setDatasheetDtlId(long datasheetDtlId) {
		this.datasheetDtlId = datasheetDtlId;
	}

	public String getSom1Uom() {
		return som1Uom;
	}

	public void setSom1Uom(String som1Uom) {
		this.som1Uom = som1Uom;
	}

	public String getSom1ConversionFactor() {
		return som1ConversionFactor;
	}

	public void setSom1ConversionFactor(String som1ConversionFactor) {
		this.som1ConversionFactor = som1ConversionFactor;
	}

	public String getSom2Uom() {
		return som2Uom;
	}

	public void setSom2Uom(String som2Uom) {
		this.som2Uom = som2Uom;
	}

	public String getSom2ConversionFactor() {
		return som2ConversionFactor;
	}

	public void setSom2ConversionFactor(String som2ConversionFactor) {
		this.som2ConversionFactor = som2ConversionFactor;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	
	
	
}
