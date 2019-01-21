package com.metalsa.repository;

import java.math.BigDecimal;
import java.util.List;

import com.metalsa.domain.MmrCompareDataSheetView;
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.model.SearchModel;

public interface CustomRepository {

	List<MmrDataSheetUt> getDataSheetByClassNSubclass(Long classId, Long subClassId);
	MmrTestSheetUt getTestSheetByClassNSubclass(Long classId, Long subClassId);
	List<MmrSearchDataSheetView> getSearchDataSheetView(SearchModel model);
	List<MmrCompareDataSheetView> compareDataSheetByIds(List<Long> datasheetIds);
	List<Object[]> getDatasheetForDashboard(BigDecimal user);
	List<Object[]> findDatasheetByStatus(BigDecimal status);
	void saveDataSheet(MmrDataSheetUt mmrDataSheetUt);

}
