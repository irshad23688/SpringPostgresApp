package com.metalsa.model;

public class TestsheetDetailModel {
	
	
	private Long headerId, baseId, testSheetDtlId, testSheetDtlBaseId, ismandatory, testSheetDtlSeqno;
	private String headerName,baseName;
	
	public Long getHeaderId() {
		return headerId;
	}
	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}
	public Long getBaseId() {
		return baseId;
	}
	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}
	public Long getTestSheetDtlId() {
		return testSheetDtlId;
	}
	public void setTestSheetDtlId(Long testSheetDtlId) {
		this.testSheetDtlId = testSheetDtlId;
	}
	public Long getTestSheetDtlBaseId() {
		return testSheetDtlBaseId;
	}
	public void setTestSheetDtlBaseId(Long testSheetDtlBaseId) {
		this.testSheetDtlBaseId = testSheetDtlBaseId;
	}
	public Long getIsmandatory() {
		return ismandatory;
	}
	public void setIsmandatory(Long ismandatory) {
		this.ismandatory = ismandatory;
	}
	public Long getTestSheetDtlSeqno() {
		return testSheetDtlSeqno;
	}
	public void setTestSheetDtlSeqno(Long testSheetDtlSeqno) {
		this.testSheetDtlSeqno = testSheetDtlSeqno;
	}
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
}
