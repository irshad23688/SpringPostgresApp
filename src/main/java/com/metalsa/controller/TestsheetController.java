package com.metalsa.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.BaseAttrModel;
import com.metalsa.repository.TestSheetRepository;
import com.metalsa.service.BaseAttrService;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class TestsheetController {
	
    @Autowired
    private TestSheetRepository testSheetRepository;
    
    @Autowired
    private BaseAttrService baseAttrService;

    @GetMapping("/testsheet")
    public List<MmrTestSheetUt> getAllBaseAttribute() {
    	return testSheetRepository.findAll();
    }

   /* @PostMapping("/testsheet")
    public BaseAttrModel createBaseAttribute(@Valid @RequestBody BaseAttrModel baseAttrModel) {
        //return baseAttributeRepository.save(baseAttributeMaster);
    	return baseAttrService.persistBaseAttr(baseAttrModel);
    }*/
    @PostMapping("/testsheet")
    public List<MmrTestSheetUt> createBaseAttribute(@Valid @RequestBody MmrTestSheetUt baseAttributeMaster) {
    	 testSheetRepository.save(baseAttributeMaster);
    	return testSheetRepository.findAll();
//    	return baseAttrService.persistBaseAttr(baseAttrModel);
    }

    @GetMapping("/testsheet/{id}")
    public MmrTestSheetUt getBaseAttributeById(@PathVariable(value = "id") Long id) {
        return testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    }

    @PutMapping("/testsheet/{id}")
    public BaseAttrModel updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrTestSheetUt baseAttributeMasterDetails) {
    	MmrTestSheetUt baseAttributeMaster = testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
        testSheetRepository.save(baseAttributeMaster);
        return baseAttrService.getBaseAttrData();
    }
    
    @DeleteMapping("/testsheet/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long baseAttributeId) {
    	MmrTestSheetUt baseAttributeMaster = testSheetRepository.findById(baseAttributeId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", baseAttributeId));

        testSheetRepository.delete(baseAttributeMaster);

        return ResponseEntity.ok().build();
    }

}