package com.metalsa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.domain.MmrDataTypeMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.DataTypeRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class DataTypeMasterController {
	
    @Autowired
    private DataTypeRepository dataTypeRepository;

    @GetMapping("/datatype")
    public List<MmrDataTypeMasterUt> getAllDataType() {
        return dataTypeRepository.findAll(new Sort(Sort.Direction.DESC,"modifiedOn"));
    }

    @PostMapping("/datatype")
    public List<MmrDataTypeMasterUt> createClass(@Valid @RequestBody MmrDataTypeMasterUt dataTypeMaster) {
    	dataTypeRepository.save(dataTypeMaster);
    	return dataTypeRepository.findAll(new Sort(Sort.Direction.DESC,"modifiedOn"));
    }

    @GetMapping("/datatype/{id}")
    public MmrDataTypeMasterUt getClassById(@PathVariable(value = "id") Long id) {
        return dataTypeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrDataTypeMasterUt", "id", id));
    }

    @PutMapping("/datatype/{id}")
    public List<MmrDataTypeMasterUt> updateDataType(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrDataTypeMasterUt dataTypeMasterDetails) {
        dataTypeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrDataTypeMasterUt", "id", id));
        dataTypeRepository.save(dataTypeMasterDetails);
        return dataTypeRepository.findAll(new Sort(Sort.Direction.DESC,"modifiedOn"));
    }
    
    @DeleteMapping("/datatype/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable(value = "id") Long classId) {
    	 MmrDataTypeMasterUt classMaster = dataTypeRepository.findById(classId)
                .orElseThrow(() -> new ExceptionHandler("MmrDataTypeMasterUt", "id", classId));

        dataTypeRepository.delete(classMaster);

        return ResponseEntity.ok().build();
    }

}
