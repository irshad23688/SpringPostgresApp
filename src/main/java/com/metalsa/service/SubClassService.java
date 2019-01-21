package com.metalsa.service;

import java.util.List;

import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.model.MmrSubClassMasterUtModel;

public interface SubClassService {
	
	 List<MmrSubClassMasterUtModel> getAll(boolean active);
	 MmrSubClassMasterUtModel getOne(MmrSubClassMasterUt mmrSubClassMasterUt);

}
