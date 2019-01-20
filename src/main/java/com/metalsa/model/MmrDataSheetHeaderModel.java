package com.metalsa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 
public class MmrDataSheetHeaderModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long headerAttributeId;
	private String headerAttributeName;
 
	private List<MmrDataSheetDetailUtModel> dataSheetDetails= new ArrayList<>();
	
	public MmrDataSheetHeaderModel() {
	}

	public String getHeaderAttributeName() {
		return headerAttributeName;
	}

	public void setHeaderAttributeName(String headerAttributeName) {
		this.headerAttributeName = headerAttributeName;
	}

	 
	public List<MmrDataSheetDetailUtModel> getDataSheetDetails() {
		return dataSheetDetails;
	}

	public void setDataSheetDetails(List<MmrDataSheetDetailUtModel> dataSheetDetails) {
		this.dataSheetDetails = dataSheetDetails;
	}

	public void addDataSheetDetails(MmrDataSheetDetailUtModel dataSheetDetail) {
		this.dataSheetDetails.add(dataSheetDetail);
	}

	public Long getHeaderAttributeId() {
		return headerAttributeId;
	}

	public void setHeaderAttributeId(Long headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}
	
	

 }