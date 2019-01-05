package com.metalsa.service;

import java.util.List;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.model.MmrBaseAttributeMasterUtModel;

public interface BaseAttributeService {
	
	 List<MmrBaseAttributeMasterUtModel> getAll();
	 MmrBaseAttributeMasterUtModel getOne(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt);
}
