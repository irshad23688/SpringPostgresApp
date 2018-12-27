package com.metalsa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.CustomRepository;


@RestController
@RequestMapping("/api/master")
public class DataSheetController {
	
    @Autowired
    private ClassRepository classRepository;
    
    @Autowired
    private CustomRepository customRepository ;
    
    @GetMapping("/datasheet")
    public List<MmrClassMasterUt> getAllClass() {
    	return classRepository.findAll(new Sort(Sort.Direction.DESC,"modifiedOn"));
    }
    
    @GetMapping("/datasheet/{classId}/{subClassId}")
    public List<MmrDataSheetUt> getDataSheetByClassNSubclass(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
        return customRepository.getDataSheetByClassNSubclass(classId,subClassId);
    }
    
    @GetMapping("/datasheet/new/{classId}/{subClassId}")
    public MmrTestSheetUt createNewDataSheet(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
    	return customRepository.getTestSheetByClassNSubclass(classId,subClassId);
    }
    
    @PostMapping("/datasheet")
    public MmrDataSheetUt createdatasheet(@Valid @RequestBody MmrDataSheetUt datasheetUt) {
    	customRepository.saveOrUpdate(datasheetUt);
    	return datasheetUt;
    }
    
    @PostMapping("/datasheet/savelater")
    public void saveDataSheet(@Valid @RequestBody MmrDataSheetUt datasheetUt) {
    	customRepository.saveOrUpdate(datasheetUt);
    }

}
