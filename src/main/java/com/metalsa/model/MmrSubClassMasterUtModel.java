package com.metalsa.model;

/**
 * The persistent class for the MmrSubclassMasterUtModel database table.
 * 
 */

public class MmrSubClassMasterUtModel extends MetalsaAbstractEntityModel{

	private String abbreviation;
	private String description;
	private String name;
	private MmrClassMasterUtModel mmrClassMasterUt;

	public MmrSubClassMasterUtModel() {
		 
	}

	public MmrClassMasterUtModel getMmrClassMasterUt() {
		return mmrClassMasterUt;
	}

	public void setMmrClassMasterUt(MmrClassMasterUtModel mmrClassMasterUt) {
		this.mmrClassMasterUt = mmrClassMasterUt;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	
	 	
}