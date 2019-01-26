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
	
	@Column(name ="ISMANADATORY")
	private Integer isMandatory;

	@Column(name ="BASE_ATTRIBUTE_SEQUENCE_NO")
	private BigDecimal baseAttributeSequenceNo;

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

	
	
	
}
