package com.metalsa.model;

/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_TABLE_DATA_TYPE_UT database table.
 * 
 */
public class MmrBaseAttributeTableDataTypeUtModel extends MetalsaAbstractEntityModel {

	private MmrBaseAttributeMasterUtModel mmrParameterBaseAttributeUt;
	private MmrBaseAttributeMasterUtModel mmrBaseAttributeMasterUt;
 
	public MmrBaseAttributeTableDataTypeUtModel() {
	}

	 
	public MmrBaseAttributeMasterUtModel getMmrParameterBaseAttributeUt() {
		return mmrParameterBaseAttributeUt;
	}


	public void setMmrParameterBaseAttributeUt(MmrBaseAttributeMasterUtModel mmrParameterBaseAttributeUt) {
		this.mmrParameterBaseAttributeUt = mmrParameterBaseAttributeUt;
	}


	public MmrBaseAttributeMasterUtModel getMmrBaseAttributeMasterUt() {
		return mmrBaseAttributeMasterUt;
	}

	public void setMmrBaseAttributeMasterUt(MmrBaseAttributeMasterUtModel mmrBaseAttributeMasterUt) {
		this.mmrBaseAttributeMasterUt = mmrBaseAttributeMasterUt;
	}

 	

}