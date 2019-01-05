package com.metalsa.model;

import java.util.List;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;

public class SubClassModel {
	
	private List<MmrClassMasterUt> classUts;
	private List<MmrSubClassMasterUt> subclassUts;
	
	
	public List<MmrClassMasterUt> getClassUts() {
		return classUts;
	}
	public void setClassUts(List<MmrClassMasterUt> classUts) {
		this.classUts = classUts;
	}
	public List<MmrSubClassMasterUt> getSubclassUts() {
		return subclassUts;
	}
	public void setSubclassUts(List<MmrSubClassMasterUt> subclassUts) {
		this.subclassUts = subclassUts;
	}
	
	
	
	

}
