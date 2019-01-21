package com.metalsa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrClassMasterUtModel;
import com.metalsa.model.MmrSubClassMasterUtModel;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.service.SubClassService;

@Service
public class SubClassServiceImpl implements SubClassService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
    private SubClassRepository subClassRepository;

	@Override
	public List<MmrSubClassMasterUtModel> getAll(boolean allSubclass) {
		List<MmrSubClassMasterUt> list= null;
		if(allSubclass) {
			 list=subClassRepository.findAll();
		} else {
			 list=subClassRepository.findSubClassByStatus(BigDecimal.ONE);
		}
    	
    	List<MmrSubClassMasterUtModel> modelList= new ArrayList<>();
    	for (MmrSubClassMasterUt mmrSubclassMasterUt : list) {
    		MmrSubClassMasterUtModel model= new MmrSubClassMasterUtModel();
    		MmrClassMasterUt classMaster = classRepository.findById(mmrSubclassMasterUt.getMmrClassMasterUt().getId())
    				.orElseThrow(() -> new ExceptionHandler("MmrClassMasterUt", "id", mmrSubclassMasterUt.getMmrClassMasterUt().getId()));
    		BeanUtils.copyProperties(mmrSubclassMasterUt,model);
    		MmrClassMasterUtModel modelClass= new MmrClassMasterUtModel();
    		BeanUtils.copyProperties(classMaster,modelClass );
    		model.setMmrClassMasterUt(modelClass);
    		modelList.add(model);
    	}
    	return modelList;
	}

	@Override
	public MmrSubClassMasterUtModel getOne(MmrSubClassMasterUt mmrSubClassMasterUt) {
		MmrSubClassMasterUtModel model= new MmrSubClassMasterUtModel();
		MmrClassMasterUt classMaster = classRepository.findById(mmrSubClassMasterUt.getMmrClassMasterUt().getId())
				.orElseThrow(() -> new ExceptionHandler("MmrClassMasterUt", "id", mmrSubClassMasterUt.getMmrClassMasterUt().getId()));
		BeanUtils.copyProperties(mmrSubClassMasterUt,model);
		MmrClassMasterUtModel modelClass= new MmrClassMasterUtModel();
		BeanUtils.copyProperties(classMaster,modelClass );
		model.setMmrClassMasterUt(modelClass);
		return model;
	}
 	
	 	
	

	

}
