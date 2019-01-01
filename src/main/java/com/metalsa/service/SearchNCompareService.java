package com.metalsa.service;

import java.util.List;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.model.SearchModel;

public interface SearchNCompareService {
	
	SearchModel getConfigParameters();
	SearchModel getSearchdata(final SearchModel model);
	List<MmrDataSheetUt> getDataSheetByIds(List<Long> datasheetIds);

}
