package com.metalsa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrHeaderAttributeMasterUt;
import com.metalsa.model.MmrHeaderAttributeMasterUtModel;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.service.HeaderAttributeService;


@Service
public class HeaderAttributeServiceImpl implements HeaderAttributeService {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HeaderAttrRepository  headerAttrRepository; 

	@Override
	public List<MmrHeaderAttributeMasterUtModel> findByIstableheaderFlagAndStatus(BigDecimal istableheaderFlag,
			BigDecimal status) {
		List<MmrHeaderAttributeMasterUtModel> modelHeaderList = new ArrayList<>();
		for (MmrHeaderAttributeMasterUt mmrHeaderAttributeMasterUt : headerAttrRepository.findByIstableheaderFlagAndStatus(istableheaderFlag, status)) {
			
			/* Filter out active base attributes */
			List<MmrBaseAttributeMasterUt>  activeAttributeList;
			activeAttributeList = (List<MmrBaseAttributeMasterUt>) mmrHeaderAttributeMasterUt.getMmrBaseAttributeMasterUts()
				.stream().filter(e -> e.getStatus().equals(BigDecimal.ONE)).collect(Collectors.toList());
			mmrHeaderAttributeMasterUt.setMmrBaseAttributeMasterUts(activeAttributeList);
			
			MmrHeaderAttributeMasterUtModel modelHeader= new MmrHeaderAttributeMasterUtModel();
		
			BeanUtils.copyProperties(mmrHeaderAttributeMasterUt, modelHeader);
			modelHeaderList.add(modelHeader);
		}
		return modelHeaderList;
	}

	 
}
