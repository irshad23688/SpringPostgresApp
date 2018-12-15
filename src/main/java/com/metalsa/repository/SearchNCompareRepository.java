package com.metalsa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metalsa.model.ParameterConfig;


public interface SearchNCompareRepository {

	List<ParameterConfig> getConfigParameters();
	
	
}
