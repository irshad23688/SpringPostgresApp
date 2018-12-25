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
    public List<MmrTestSheetUt> getAllTestsheet() {
    	return testSheetRepository.findAll();
    }
    
    @PostMapping("/testsheet")
    public List<MmrTestSheetUt> createTestsheet(@Valid @RequestBody MmrTestSheetUt testSheetUt) {
    	 testSheetRepository.save(testSheetUt);
    	return testSheetRepository.findAll();
    }

    @GetMapping("/testsheet/{id}")
    public MmrTestSheetUt getBaseAttributeById(@PathVariable(value = "id") Long id) {
        return testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    }

    @PutMapping("/testsheet/{id}")
    public BaseAttrModel updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrTestSheetUt baseAttributeMasterDetails) {
    	MmrTestSheetUt testSheetUt = testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
        testSheetRepository.save(testSheetUt);
        return baseAttrService.getBaseAttrData();
    }
    
    @DeleteMapping("/testsheet/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long baseAttributeId) {
    	MmrTestSheetUt testSheetUt = testSheetRepository.findById(baseAttributeId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", baseAttributeId));

        testSheetRepository.delete(testSheetUt);

        return ResponseEntity.ok().build();
    }

}
