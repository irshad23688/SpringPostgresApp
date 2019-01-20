package com.metalsa.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.model.MmrDataSheetUtModel;

public interface DataSheetSevice {
	
	String saveFileOnserver(MultipartFile file, String dataSheetId);
	Resource loadFile(String fileName, String dataSheetId);
	void createRevision(MmrDataSheetUt datasheetUt);
	void updateDataSheet(MmrDataSheetUt datasheetUt);
	MmrDataSheetUtModel getNewDataTestSheetDetailByClassSubClass(Long classId,Long subClassId);
}
