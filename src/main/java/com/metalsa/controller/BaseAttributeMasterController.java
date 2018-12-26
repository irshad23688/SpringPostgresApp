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
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.BaseAttrModel;
import com.metalsa.repository.BaseAttributeRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class BaseAttributeMasterController {
	
    @Autowired
    private BaseAttributeRepository baseAttributeRepository;
    

    @GetMapping("/baseattribute")
    public List<MmrBaseAttributeMasterUt> getAllBaseAttribute() {
    	return baseAttributeRepository.findAll();
    }

    @PostMapping("/baseattribute")
    public List<MmrBaseAttributeMasterUt> createBaseAttribute(@Valid @RequestBody MmrBaseAttributeMasterUt baseAttributeMaster) {
    	baseAttributeRepository.save(baseAttributeMaster);
    	return baseAttributeRepository.findAll();
    }

    @GetMapping("/baseattribute/{id}")
    public MmrBaseAttributeMasterUt getBaseAttributeById(@PathVariable(value = "id") Long id) {
        return baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    }

    @PutMapping("/baseattribute/{id}")
    public List<MmrBaseAttributeMasterUt> updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrBaseAttributeMasterUt baseAttributeMasterDetails) {
    	baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
        baseAttributeRepository.save(baseAttributeMasterDetails);
        return baseAttributeRepository.findAll();
    }
    
    @DeleteMapping("/baseattribute/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long baseAttributeId) {
    	MmrBaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(baseAttributeId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", baseAttributeId));

        baseAttributeRepository.delete(baseAttributeMaster);

        return ResponseEntity.ok().build();
    }

}
