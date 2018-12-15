package com.metalsa.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metalsa.model.ParameterConfig;
import com.metalsa.repository.SearchNCompareRepository;

@Repository
public class SearchNCompareRepositoryImpl implements SearchNCompareRepository {

	@Override
	public List<ParameterConfig> getConfigParameters() {
		return new ArrayList<>();
	}

}
