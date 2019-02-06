package com.metalsa.controller;

import java.math.BigDecimal;
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
import com.metalsa.model.MmrTestSheetDetailUtViewModel;
import com.metalsa.model.MmrTestSheetUtModel;
import com.metalsa.repository.TestSheetRepository;
import com.metalsa.service.TestSheetService;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class TestsheetController {
	
    @Autowired
    private TestSheetRepository testSheetRepository;
    
   
    @Autowired
    private TestSheetService testSheetService;
    
   /* @GetMapping("/testsheet")
    public List<MmrTestSheetUt> getAllTestsheet() {
    	return testSheetRepository.findAll();
    }*/
    @GetMapping("/testsheet")
    public List<MmrTestSheetUtModel> getAllTestsheet() {
    	return testSheetService.getAll();
    }
    
    @PostMapping("/testsheet")
    public List<MmrTestSheetUtModel> createTestsheet(@Valid @RequestBody MmrTestSheetUt testSheetUt) {
    	
    	List<MmrTestSheetUt> oldTestSheetList=testSheetRepository.
    			findByMmrClassMasterUtAndMmrSubclassMasterUt(testSheetUt.getMmrClassMasterUt(), testSheetUt.getMmrSubclassMasterUt());
    	for (MmrTestSheetUt mmrTestSheetUt : oldTestSheetList) {
    		mmrTestSheetUt.setStatus(BigDecimal.ZERO);
    		testSheetRepository.save(mmrTestSheetUt);
		}
    	testSheetRepository.save(testSheetUt);
    	return testSheetService.getAll();
    }

    @GetMapping("/testsheetdetail/{id}")
    public MmrTestSheetDetailUtViewModel getTestSheetById(@PathVariable(value = "id") Long id) {
    	/*MmrTestSheetUt mmrTestSheet = testSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("TestSheetServiceUt", "id", id));*/
    	return testSheetService.getTestSheetDetail(id);
    }
    @GetMapping("/testsheet/{id}")
    public MmrTestSheetUtModel getTestSheetDetail(@PathVariable(value = "id") Long id) {
    	MmrTestSheetUt mmrTestSheet = testSheetRepository.findById(id)
    			.orElseThrow(() -> new ExceptionHandler("TestSheetServiceUt", "id", id));
    	MmrTestSheetUtModel mmrTestSheetModel = testSheetService.getOne(mmrTestSheet);
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
