package com.metalsa.service;

import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.model.MmrDataSheetUtModel;

public interface DataSheetSevice {
	
	String saveFileOnserver(MultipartFile file, String dataSheetId);
	Resource loadFile(String fileName, String dataSheetId);
	void createRevision(MmrDataSheetUtModel model);
	void updateDataSheet(MmrDataSheetUt datasheetUt);
	MmrDataSheetUtModel getNewDataTestSheetDetailByClassSubClass(Long classId,Long subClassId);
	MmrDataSheetUtModel persistDataSheet(MmrDataSheetUtModel model);
	MmrDataSheetUtModel getDataSheetById(MmrDataSheetUt dataSheetUt);
	MmrDataSheetUtModel getEditDatasheet(@Valid MmrDataSheetUtModel model);
	String getNewRevisonNumber(Long classId, Long subClassId, Long regionId);
}
