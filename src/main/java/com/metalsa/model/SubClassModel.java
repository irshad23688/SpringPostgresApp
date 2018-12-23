package com.metalsa.model;

import java.util.List;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubclassMasterUt;

public class SubClassModel {
	
	private List<MmrClassMasterUt> classUts;
	private List<MmrSubclassMasterUt> subclassUts;
	
	
	public List<MmrClassMasterUt> getClassUts() {
		return classUts;
	}
	public void setClassUts(List<MmrClassMasterUt> classUts) {
		this.classUts = classUts;
	}
	public List<MmrSubclassMasterUt> getSubclassUts() {
		return subclassUts;
	}
	public void setSubclassUts(List<MmrSubclassMasterUt> subclassUts) {
		this.subclassUts = subclassUts;
	}
	
	
	
	

}
