package com.metalsa.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MMR_TEST_SHEET_UT database table.
 * 
 */
public class MmrTestSheetUtModel extends MetalsaAbstractEntityModel {


	private BigDecimal approvedBy;
	private Timestamp approvedOn;
	private String description;
	private String name;
	private List<MmrTestSheetDetailUtModel> mmrTestSheetDetailUts;
	private MmrClassMasterUtModel mmrClassMasterUt;
	private MmrSubClassMasterUtModel mmrSubclassMasterUt;

	public MmrTestSheetUtModel() {
	}

	 

	public BigDecimal getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(BigDecimal approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Timestamp approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MmrTestSheetDetailUtModel> getMmrTestSheetDetailUts() {
		return mmrTestSheetDetailUts;
	}

	public void setMmrTestSheetDetailUts(List<MmrTestSheetDetailUtModel> mmrTestSheetDetailUts) {
		this.mmrTestSheetDetailUts = mmrTestSheetDetailUts;
	}

	public MmrClassMasterUtModel getMmrClassMasterUt() {
		return mmrClassMasterUt;
	}

	public void setMmrClassMasterUt(MmrClassMasterUtModel mmrClassMasterUt) {
		this.mmrClassMasterUt = mmrClassMasterUt;
	}

	public MmrSubClassMasterUtModel getMmrSubclassMasterUt() {
		return mmrSubclassMasterUt;
	}

	public void setMmrSubclassMasterUt(MmrSubClassMasterUtModel mmrSubclassMasterUt) {
		this.mmrSubclassMasterUt = mmrSubclassMasterUt;
	}

 

}