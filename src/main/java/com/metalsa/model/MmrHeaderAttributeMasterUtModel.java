package com.metalsa.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.metalsa.domain.MmrDataSheetDetailUtView;
import com.metalsa.domain.MmrTestSheetDetailUtView;


/**
 * The persistent class for the MMR_HEADER_ATTRIBUTE_MASTER_UT database table.
 * 
 */
public class MmrHeaderAttributeMasterUtModel extends MetalsaAbstractEntityModel {

	private String description;
	private BigDecimal istableheaderFlag;
	private String name;
	
	private List<MmrBaseAttributeMasterUtModel> mmrBaseAttributeMasterUts;
	
	private List<MmrTestSheetDetailUtView> testSheetDetailUtView;

	public MmrHeaderAttributeMasterUtModel() {
	}

	 

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getIstableheaderFlag() {
		return istableheaderFlag;
	}

	public void setIstableheaderFlag(BigDecimal istableheaderFlag) {
		this.istableheaderFlag = istableheaderFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MmrBaseAttributeMasterUtModel> getMmrBaseAttributeMasterUts() {
		return mmrBaseAttributeMasterUts;
	}

	public void setMmrBaseAttributeMasterUts(List<MmrBaseAttributeMasterUtModel> mmrBaseAttributeMasterUts) {
		this.mmrBaseAttributeMasterUts = mmrBaseAttributeMasterUts;
	}

	public List<MmrTestSheetDetailUtView> getTestSheetDetailUtView() {
		return testSheetDetailUtView;
	}

	public void setTestSheetDetailUtView(List<MmrTestSheetDetailUtView> testSheetDetailUtView) {
		this.testSheetDetailUtView = testSheetDetailUtView;
	}
	public void addTestSheetDetailUtView(MmrTestSheetDetailUtView testSheetDetailUtView) {
		if(getTestSheetDetailUtView()==null) {
			this.testSheetDetailUtView= new ArrayList<MmrTestSheetDetailUtView>();
		}
		getTestSheetDetailUtView().add(testSheetDetailUtView);
	}

}