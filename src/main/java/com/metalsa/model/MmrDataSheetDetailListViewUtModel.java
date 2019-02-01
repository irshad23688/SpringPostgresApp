package com.metalsa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MmrDataSheetDetailListViewUtModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MmrDataSheetDetailUtModel baseAttribute;
	private List<MmrDataSheetDetailUtModel> supplierInfo = new ArrayList<>();




	public MmrDataSheetDetailListViewUtModel() {
	}




	public MmrDataSheetDetailUtModel getBaseAttribute() {
		return baseAttribute;
	}




	public void setBaseAttribute(MmrDataSheetDetailUtModel baseAttribute) {
		this.baseAttribute = baseAttribute;
	}




	public List<MmrDataSheetDetailUtModel> getSupplierInfo() {
		return supplierInfo;
	}




	public void setSupplierInfo(List<MmrDataSheetDetailUtModel> supplierInfo) {
		this.supplierInfo = supplierInfo;
	}


}