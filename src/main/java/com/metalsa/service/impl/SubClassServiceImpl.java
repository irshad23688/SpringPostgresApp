package com.metalsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.model.SubClassModel;
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
	public SubClassModel getSubClassData() {
		return getSubClassModel();
	}

	@Override
	public SubClassModel persistSubClass(SubClassModel subClassModel) {
		
		MmrSubClassMasterUt mmrSubclassMasterUt = subClassModel.getSubclassUts().get(0);
		mmrSubclassMasterUt.setMmrClassMasterUt(subClassModel.getClassUts().get(0));
		subClassRepository.save(mmrSubclassMasterUt);
		
		return getSubClassModel();
	}
	
	private SubClassModel getSubClassModel() {
		SubClassModel subClassModel = new SubClassModel();
		subClassModel.setClassUts(classRepository.findAll(new Sort(Sort.Direction.ASC,"name")));
		subClassModel.setSubclassUts(subClassRepository.findAll(new Sort(Sort.Direction.DESC,"createdOn")));
		return subClassModel;
	}

	
	

	

}
