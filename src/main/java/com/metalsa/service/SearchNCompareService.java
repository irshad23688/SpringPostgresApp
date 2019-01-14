package com.metalsa.service;

import java.util.List;

import com.metalsa.model.MmrCompareDataSheetModel;
import com.metalsa.model.SearchModel;

public interface SearchNCompareService {
	
	SearchModel getConfigParameters();
	SearchModel getSearchdata(final SearchModel model);
	List<MmrCompareDataSheetModel> compareDataSheetByIds(List<Long> datasheetIds);

}
