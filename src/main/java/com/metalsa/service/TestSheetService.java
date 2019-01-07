package com.metalsa.service;

import java.util.List;

import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.model.MmrTestSheetDetailUtViewModel;
import com.metalsa.model.MmrTestSheetUtModel;

public interface TestSheetService {
	
	 List<MmrTestSheetUtModel> getAll();
	 MmrTestSheetUtModel getOne(MmrTestSheetUt mmrTestSheetUt);
	 MmrTestSheetDetailUtViewModel getTestSheetDetail(Long testSheetId);
	 
}
