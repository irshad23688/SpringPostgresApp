package com.metalsa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrBaseAttributeTableDataTypeUt;
import com.metalsa.domain.MmrHeaderAttributeMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrBaseAttributeMasterUtModel;
import com.metalsa.model.MmrBaseAttributeTableDataTypeUtModel;
import com.metalsa.model.MmrHeaderAttributeMasterUtModel;
import com.metalsa.repository.BaseAttributeRepository;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.service.BaseAttributeService;
import com.metalsa.service.HeaderAttributeService;

@Service
public class BaseAttributeServiceImpl implements BaseAttributeService {

	@Autowired
	private HeaderAttrRepository headerAttributeRepository;

	@Autowired
	private BaseAttributeRepository baseAttributeRepository;
	
	@Autowired
	private HeaderAttributeService headerAttributeService;

	@Override
	public List<MmrBaseAttributeMasterUtModel> getAll() {
		List<MmrBaseAttributeMasterUtModel> list= new ArrayList<>();
		for (MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt : baseAttributeRepository.findAll()) {
			list.add( setBaseAttributeDataForUI(mmrBaseAttributeMasterUt));
		}

		return list;
	}
	
	@Override
	public MmrBaseAttributeMasterUtModel getOne(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt) {
		return  setBaseAttributeDataForUI(mmrBaseAttributeMasterUt);
	}

	private MmrBaseAttributeMasterUtModel setBaseAttributeDataForUI(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt) {
			
			MmrBaseAttributeMasterUtModel model= new MmrBaseAttributeMasterUtModel();
			BeanUtils.copyProperties(mmrBaseAttributeMasterUt, model);
			
			model.setMmrBaseAttributeTableDataTypeUts(new ArrayList<>());
			
			MmrHeaderAttributeMasterUt headerMaster=headerAttributeRepository.findById(mmrBaseAttributeMasterUt.getMmrHeaderAttributeMasterUt())
					.orElseThrow(() -> new ExceptionHandler("HeaderAttributeMasterUt", "id", mmrBaseAttributeMasterUt.getMmrHeaderAttributeMasterUt()));
			MmrHeaderAttributeMasterUtModel modelHeader= new MmrHeaderAttributeMasterUtModel();
			headerMaster.setMmrBaseAttributeMasterUts(new ArrayList<>());
			BeanUtils.copyProperties(headerMaster, modelHeader);
			model.setMmrHeaderAttributeMasterUt(modelHeader);
			for (MmrBaseAttributeTableDataTypeUt typeUt: mmrBaseAttributeMasterUt.getMmrBaseAttributeTableDataTypeUts()) {;
				MmrBaseAttributeTableDataTypeUtModel attributeTableDataTypeUtModel = new MmrBaseAttributeTableDataTypeUtModel();
				BeanUtils.copyProperties(typeUt, attributeTableDataTypeUtModel);
				
				MmrBaseAttributeMasterUt parameterBaseAttributeMaster = baseAttributeRepository.findById(typeUt.getMmrParameterBaseAttributeUt())
		                .orElseThrow(() -> new ExceptionHandler("ParamterBaseAttributeMasterUt", "id", typeUt.getMmrParameterBaseAttributeUt()));
				MmrBaseAttributeMasterUtModel modelParameterBaseAttribute= new MmrBaseAttributeMasterUtModel();
				BeanUtils.copyProperties(parameterBaseAttributeMaster, modelParameterBaseAttribute);
				
				MmrHeaderAttributeMasterUt parameterHeader=headerAttributeRepository.findById(parameterBaseAttributeMaster.getMmrHeaderAttributeMasterUt())
						.orElseThrow(() -> new ExceptionHandler("HeaderAttributeMasterUt", "id", parameterBaseAttributeMaster.getMmrHeaderAttributeMasterUt()));
				parameterHeader.setMmrBaseAttributeMasterUts(new ArrayList<>());
				MmrHeaderAttributeMasterUtModel modelParameterHeader= new MmrHeaderAttributeMasterUtModel();
				BeanUtils.copyProperties(parameterHeader, modelParameterHeader);
				modelParameterBaseAttribute.setMmrHeaderAttributeMasterUt(modelParameterHeader);
				attributeTableDataTypeUtModel.setMmrBaseAttributeMasterUt(typeUt.getMmrParameterBaseAttributeUt());
				/*MmrBaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(typeUt.getMmrBaseAttributeMasterUt().getId())
						.orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", typeUt.getMmrBaseAttributeMasterUt().getId()));
				MmrBaseAttributeMasterUtModel modelBaseAttribute= new MmrBaseAttributeMasterUtModel();
				BeanUtils.copyProperties(baseAttributeMaster, modelBaseAttribute);
				MmrHeaderAttributeMasterUt baseAttributeHeader=headerAttributeRepository.findById(baseAttributeMaster.getMmrHeaderAttributeMasterUt())
						.orElseThrow(() -> new ExceptionHandler("HeaderAttributeMasterUt", "id", baseAttributeMaster.getMmrHeaderAttributeMasterUt()));
				MmrHeaderAttributeMasterUtModel modelBaseAttributeHeader= new MmrHeaderAttributeMasterUtModel();
				BeanUtils.copyProperties(baseAttributeHeader, modelBaseAttributeHeader);
				modelBaseAttribute.setMmrHeaderAttributeMasterUt(modelBaseAttributeHeader);
				attributeTableDataTypeUtModel.setMmrBaseAttributeMasterUt(modelBaseAttribute);*/
				
				attributeTableDataTypeUtModel.setMmrParameterBaseAttributeUt(modelParameterBaseAttribute);
				model.getMmrBaseAttributeTableDataTypeUts().add(attributeTableDataTypeUtModel);
			 
				}
			return model;
	}

	@Override
	public List<MmrBaseAttributeMasterUtModel> getListByIstableheaderFlagAndStatus(BigDecimal istableheaderFlag,
			BigDecimal status) {
		List<MmrBaseAttributeMasterUtModel> list = new ArrayList<MmrBaseAttributeMasterUtModel>();
		List<MmrHeaderAttributeMasterUtModel> findByIstableheaderFlagAndStatus =
				headerAttributeService.findByIstableheaderFlagAndStatus(istableheaderFlag, status);
		for (MmrHeaderAttributeMasterUtModel mmrHeaderAttributeMasterUtModel : findByIstableheaderFlagAndStatus) {
			list.addAll(mmrHeaderAttributeMasterUtModel.getMmrBaseAttributeMasterUts());
		}
		
		return list;
	}

	

	 


}
