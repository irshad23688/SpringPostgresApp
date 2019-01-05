package com.metalsa.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrClassMasterUtModel;
import com.metalsa.model.MmrSubClassMasterUtModel;
import com.metalsa.model.SubClassModel;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.service.SubClassService;


/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class SubClassMasterController {
	
	@Autowired
	private ClassRepository classRepository;
	
    @Autowired
    private SubClassRepository subClassRepository;
    
    @Autowired
    private SubClassService subClassService;

    @GetMapping("/subclass")
    public List<MmrSubClassMasterUtModel> getAllSubClass() {
    	List<MmrSubClassMasterUtModel> modelList= new ArrayList<>();
    	List<MmrSubClassMasterUt> list=subClassRepository.findAll();
    	
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

    /*@PostMapping("/subclass")
    public SubClassModel createSubClass(@Valid @RequestBody SubClassModel subClassModel) {
    	return subClassService.persistSubClass(subClassModel);
    }*/
    @PostMapping("/subclass")
    public List<MmrSubClassMasterUt> createSubClass(@Valid @RequestBody MmrSubClassMasterUt mmrSubclassMasterUt) {
    	 subClassRepository.save(mmrSubclassMasterUt);
    	return subClassRepository.findAll();
    }

    @GetMapping("/subclass/{id}")
    public MmrSubClassMasterUt getSubClassById(@PathVariable(value = "id") Long id) {
        return subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
    }

    @PutMapping("/subclass/{id}")
    public SubClassModel updateSubClass(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrSubClassMasterUt subClassMasterDetails) {
        subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
        subClassRepository.save(subClassMasterDetails);
        return subClassService.getSubClassData();
    }
    
    @DeleteMapping("/subclass/{id}")
    public ResponseEntity<?> deleteSubClass(@PathVariable(value = "id") Long subClassId) {
    	 MmrSubClassMasterUt subClassMaster = subClassRepository.findById(subClassId)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", subClassId));

        subClassRepository.delete(subClassMaster);

        return ResponseEntity.ok().build();
    }

}
