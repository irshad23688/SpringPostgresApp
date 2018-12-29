package com.metalsa.repository;

import java.util.List;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.model.SearchModel;

public interface CustomRepository {

	List<MmrDataSheetUt> getDataSheetByClassNSubclass(Long classId, Long subClassId);
	MmrTestSheetUt getTestSheetByClassNSubclass(Long classId, Long subClassId);
	List<MmrSearchDataSheetView> getSearchDataSheetView(SearchModel model);

}
