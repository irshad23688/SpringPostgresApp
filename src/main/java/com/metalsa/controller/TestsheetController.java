package com.metalsa.controller;

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
import com.metalsa.domain.MmrManufacturerMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrClassMasterUtModel;
import com.metalsa.model.MmrSubClassMasterUtModel;
import com.metalsa.model.MmrTestSheetUtModel;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.repository.TestSheetRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class TestsheetController {
	
    @Autowired
    private TestSheetRepository testSheetRepository;
    
   
    @Autowired
    private ClassRepository classRepository;
    
    @Autowired
    private SubClassRepository subClassRepository;
    
    
   /* @GetMapping("/testsheet")
    public List<MmrTestSheetUt> getAllTestsheet() {
    	return testSheetRepository.findAll();
    }*/
    @GetMapping("/testsheet")
    public List<MmrTestSheetUtModel> getAllTestsheetForUI() {
    	List<MmrTestSheetUtModel> modelList = new ArrayList<>();
    	for(MmrTestSheetUt mmrTestSheetUt: testSheetRepository.findAll()) {
    		MmrTestSheetUtModel modelTestSheet = get(mmrTestSheetUt);
    		modelList.add(modelTestSheet);
    	}
    	return modelList;
    }

	private MmrTestSheetUtModel get(MmrTestSheetUt mmrTestSheetUt) {
		MmrTestSheetUtModel modelTestSheet= new MmrTestSheetUtModel();
		BeanUtils.copyProperties(mmrTestSheetUt, modelTestSheet);
		MmrClassMasterUt classMaster = classRepository.findById(mmrTestSheetUt.getMmrClassMasterUt())
		            .orElseThrow(() -> new ExceptionHandler("MmrClassMasterUt", "id", mmrTestSheetUt.getMmrClassMasterUt()));
		MmrClassMasterUtModel modelClass = new MmrClassMasterUtModel();
		BeanUtils.copyProperties(classMaster, modelClass);
		modelTestSheet.setMmrClassMasterUt(modelClass);
		MmrSubClassMasterUt subClassMaster = subClassRepository.findById(mmrTestSheetUt.getMmrSubclassMasterUt())
				.orElseThrow(() -> new ExceptionHandler("MmrSubclassMasterUt", "id", mmrTestSheetUt.getMmrClassMasterUt()));
		MmrSubClassMasterUtModel modelSubClass = new MmrSubClassMasterUtModel();
		BeanUtils.copyProperties(subClassMaster, modelSubClass);
		modelTestSheet.setMmrSubclassMasterUt(modelSubClass);
		return modelTestSheet;
	}
    
    @PostMapping("/testsheet")
    public List<MmrTestSheetUt> createTestsheet(@Valid @RequestBody MmrTestSheetUt testSheetUt) {
    	 testSheetRepository.save(testSheetUt);
    	return testSheetRepository.findAll();
    }

    @GetMapping("/testsheet/{id}")
    public MmrTestSheetUtModel getBaseAttributeById(@PathVariable(value = "id") Long id) {
    	MmrTestSheetUt mmrTestSheet = testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    	MmrTestSheetUtModel mmrTestSheetModel = get(mmrTestSheet);
    	return mmrTestSheetModel;
    }

    @PutMapping("/testsheet/{id}")
    public List<MmrTestSheetUt> updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrTestSheetUt mmrTestSheetUt) {
    	testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrTestSheetUt", "id", id));
        testSheetRepository.save(mmrTestSheetUt);
        return testSheetRepository.findAll();
    }
    
    @DeleteMapping("/testsheet/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long mmrTestSheetUtId) {
    	MmrTestSheetUt testSheetUt = testSheetRepository.findById(mmrTestSheetUtId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", mmrTestSheetUtId));

        testSheetRepository.delete(testSheetUt);

        return ResponseEntity.ok().build();
    }

}
