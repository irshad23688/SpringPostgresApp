package com.metalsa.service;

import java.math.BigDecimal;
import java.util.List;

import com.metalsa.model.MmrHeaderAttributeMasterUtModel;

public interface HeaderAttributeService {
	
	List<MmrHeaderAttributeMasterUtModel> findByIstableheaderFlagAndStatus(BigDecimal istableheaderFlag,BigDecimal status);
}
