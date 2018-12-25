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
import com.metalsa.service.BaseAttrService;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class BaseAttributeMasterController {
	
    @Autowired
    private BaseAttributeRepository baseAttributeRepository;
    
    @Autowired
    private BaseAttrService baseAttrService;

    @GetMapping("/baseattribute")
    public BaseAttrModel getAllBaseAttribute() {
    	return baseAttrService.getBaseAttrData();
    }

   /* @PostMapping("/baseattribute")
    public BaseAttrModel createBaseAttribute(@Valid @RequestBody BaseAttrModel baseAttrModel) {
        //return baseAttributeRepository.save(baseAttributeMaster);
    	return baseAttrService.persistBaseAttr(baseAttrModel);
    }*/
    @PostMapping("/baseattribute")
    public List<MmrBaseAttributeMasterUt> createBaseAttribute(@Valid @RequestBody MmrBaseAttributeMasterUt baseAttributeMaster) {
    	 baseAttributeRepository.save(baseAttributeMaster);
    	return baseAttributeRepository.findAll();
//    	return baseAttrService.persistBaseAttr(baseAttrModel);
    }

    @GetMapping("/baseattribute/{id}")
    public MmrBaseAttributeMasterUt getBaseAttributeById(@PathVariable(value = "id") Long id) {
        return baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    }

    @PutMapping("/baseattribute/{id}")
    public BaseAttrModel updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrBaseAttributeMasterUt baseAttributeMasterDetails) {
    	MmrBaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
        baseAttributeRepository.save(baseAttributeMaster);
        return baseAttrService.getBaseAttrData();
    }
    
    @DeleteMapping("/baseattribute/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long baseAttributeId) {
    	MmrBaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(baseAttributeId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", baseAttributeId));

        baseAttributeRepository.delete(baseAttributeMaster);

        return ResponseEntity.ok().build();
    }

}
