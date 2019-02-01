package com.metalsa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.metalsa.constant.MetalsaConstant;
import com.metalsa.domain.MmrEditDataSheetDetailView;
import com.metalsa.domain.MmrNewDataSheetDetailView;

 
public class MmrDataSheetDetailUtModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long dataSheetDetailId;
	private BigDecimal createdBy;
	private BigDecimal modifiedBy;
	private long headerAttributeId;
	private String headerAttributeName;
	private long baseAttributeId;
	private String baseAttributeName;
	private String description;
	private String placeHolderText;
	private String symbol;
	private String tooltip;
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
	private String mmrDataTypeMasterUt;
	private String frontDataType;
	private String frontDataPattern;
	private List dropDownValues = new ArrayList<>();
	private List options = new ArrayList<>();
	private List<MmrDataSheetDetailUtModel> tableLayoutValue = new ArrayList<>();
	private List<String> headings = new ArrayList<>();
	private List<MmrDataSheetDetailListViewUtModel> listviewData = new ArrayList<>();
     


	public MmrDataSheetDetailUtModel() {
	}

	
	public MmrDataSheetDetailUtModel(MmrNewDataSheetDetailView detailView) {
		this.headerAttributeId = detailView.getHeaderAttributeId();
		this.headerAttributeName = detailView.getHeaderAttributeName();
		this.baseAttributeId = detailView.getBaseAttributeId();
		this.baseAttributeName = detailView.getBaseAttributeName();
		this.baseAttributeSequenceNo = detailView.getBaseAttributeSequenceNo();
		this.isMandatory = detailView.getIsMandatory();
		this.testSheetDetailId = detailView.getTestSheetDtlId();
		this.mmrDataTypeMasterUt=detailView.getInputDataTypeName();
		this.description=detailView.getDescription();
		this.placeHolderText=detailView.getPlaceHolderText();
		this.symbol=detailView.getSymbol();
		this.tooltip=detailView.getTooltip();
		this.frontDataType=detailView.getFrontDataType();
		this.frontDataPattern=detailView.getFrontDataPattern();
		this.testingInformation=detailView.getDefaultValue();
	}


	public MmrDataSheetDetailUtModel(MmrEditDataSheetDetailView detailView) {
		this.headerAttributeId = detailView.getHeaderAttributeId();
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
		this.mmrDataTypeMasterUt=detailView.getInputDataTypeName();
		this.frontDataType=detailView.getFrontDataType();
		this.frontDataPattern=detailView.getFrontDataPattern();

	}
 

	public MmrDataSheetDetailUtModel(MmrBaseAttributeTableDataTypeUtModel tableDataType) {
//		this.headerAttributeName = tableDataType.getMmrParameterBaseAttributeUt().get;
		this.baseAttributeId = tableDataType.getMmrParameterBaseAttributeUt().getId();
		this.baseAttributeName = tableDataType.getMmrParameterBaseAttributeUt().getName();
//		this.baseAttributeSequenceNo = tableDataType.getMmrParameterBaseAttributeUt().getBaseAttributeSequenceNo();
//		this.isMandatory = tableDataType.getMmrParameterBaseAttributeUt().getIsMandatory();
//		this.testSheetDetailId = tableDataType.getMmrParameterBaseAttributeUt().getTestSheetDtlId();
		this.mmrDataTypeMasterUt=tableDataType.getMmrParameterBaseAttributeUt().getMmrDataTypeMasterUt().getName();
		this.description=tableDataType.getMmrParameterBaseAttributeUt().getDescription();
		this.placeHolderText=tableDataType.getMmrParameterBaseAttributeUt().getPlaceHolderText();
		this.symbol=tableDataType.getMmrParameterBaseAttributeUt().getSymbol();
		this.tooltip=tableDataType.getMmrParameterBaseAttributeUt().getTooltip();
		this.frontDataType=MetalsaConstant.FRONTEND_DATA_TYPE_TEXT;
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
 


	public String getMmrDataTypeMasterUt() {
		return mmrDataTypeMasterUt;
	}


	public void setMmrDataTypeMasterUt(String mmrDataTypeMasterUt) {
		this.mmrDataTypeMasterUt = mmrDataTypeMasterUt;
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
	public List getDropDownValues() {
		return dropDownValues;
	}

	public void setDropDownValues(List dropDownValues) {
		this.dropDownValues = dropDownValues;
	}


	public List<MmrDataSheetDetailUtModel> getTableLayoutValue() {
		return tableLayoutValue;
	}


	public void setTableLayoutValue(List<MmrDataSheetDetailUtModel> tableLayoutValue) {
		this.tableLayoutValue = tableLayoutValue;
	}


	public long getBaseAttributeId() {
		return baseAttributeId;
	}


	public void setBaseAttributeId(long baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}


	public String getFrontDataType() {
		return frontDataType;
	}


	public void setFrontDataType(String frontDataType) {
		this.frontDataType = frontDataType;
	}


	public List getOptions() {
		return options;
	}


	public void setOptions(List options) {
		this.options = options;
	}


	public String getFrontDataPattern() {
		return frontDataPattern;
	}


	public void setFrontDataPattern(String frontDataPattern) {
		this.frontDataPattern = frontDataPattern;
	}


	public List<String> getHeadings() {
		return headings;
	}


	public void setHeadings(List<String> headings) {
		this.headings = headings;
	}


	public List<MmrDataSheetDetailListViewUtModel> getListviewData() {
		return listviewData;
	}


	public void setListviewData(List<MmrDataSheetDetailListViewUtModel> listviewData) {
		this.listviewData = listviewData;
	}


	public long getHeaderAttributeId() {
		return headerAttributeId;
	}


	public void setHeaderAttributeId(long headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}

	
	
}