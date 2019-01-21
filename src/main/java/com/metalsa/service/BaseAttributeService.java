package com.metalsa.service;

import java.math.BigDecimal;
import java.util.List;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.model.MmrBaseAttributeMasterUtModel;

public interface BaseAttributeService {
	
	 List<MmrBaseAttributeMasterUtModel> getAll(boolean isAll);
	 MmrBaseAttributeMasterUtModel getOne(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt);
	 
	 List<MmrBaseAttributeMasterUtModel> getListByIstableheaderFlagAndStatus(BigDecimal istableheaderFlag,BigDecimal status);
}
