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

import com.metalsa.domain.BaseAttributeMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.BaseAttributeRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api")
public class BaseAttributeMasterController {
	
    @Autowired
    private BaseAttributeRepository baseAttributeRepository;

    @GetMapping("/baseattribute")
    public List<BaseAttributeMasterUt> getAllBaseAttribute() {
        return baseAttributeRepository.findAll(new Sort(Sort.Direction.DESC,"createdOn"));
    }

    @PostMapping("/baseattribute")
    public BaseAttributeMasterUt createBaseAttribute(@Valid @RequestBody BaseAttributeMasterUt baseAttributeMaster) {
        return baseAttributeRepository.save(baseAttributeMaster);
    }

    @GetMapping("/baseattribute/{id}")
    public BaseAttributeMasterUt getBaseAttributeById(@PathVariable(value = "id") Long id) {
        return baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    }

    @PutMapping("/baseattribute/{id}")
    public BaseAttributeMasterUt updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody BaseAttributeMasterUt baseAttributeMasterDetails) {
        BaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
        return baseAttributeRepository.save(baseAttributeMaster);
    }
    
    @DeleteMapping("/baseattribute/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long baseAttributeId) {
    	 BaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(baseAttributeId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", baseAttributeId));

        baseAttributeRepository.delete(baseAttributeMaster);

        return ResponseEntity.ok().build();
    }

}
