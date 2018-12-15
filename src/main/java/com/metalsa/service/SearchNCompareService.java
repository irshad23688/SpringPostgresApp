package com.metalsa.service;

import com.metalsa.model.SearchModel;

public interface SearchNCompareService {
	
	SearchModel getConfigParameters();

	SearchModel getSearchdata(final SearchModel model);

	SearchModel getFilterData(final SearchModel model);

}
