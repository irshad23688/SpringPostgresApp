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

import com.metalsa.domain.HeaderAttributeMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.HeaderAttrRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api")
public class HeaderAttrMasterController {
	
    @Autowired
    private HeaderAttrRepository headerAttrRepository;

    @GetMapping("/headerAttribute")
    public List<HeaderAttributeMasterUt> getAllHeaderAttribute() {
        return headerAttrRepository.findAll();
    }

    @PostMapping("/headerAttribute")
    public HeaderAttributeMasterUt createHeaderAttribute(@Valid @RequestBody HeaderAttributeMasterUt headerAttrMaster) {
        return headerAttrRepository.save(headerAttrMaster);
    }

    @GetMapping("/headerAttribute/{id}")
    public HeaderAttributeMasterUt getHeaderAttributeById(@PathVariable(value = "id") Long id) {
        return headerAttrRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("HeaderAttributeMasterUt", "id", id));
    }

    @PutMapping("/headerAttribute/{id}")
    public HeaderAttributeMasterUt updateHeaderAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody HeaderAttributeMasterUt headerAttrMasterDetails) {
        HeaderAttributeMasterUt headerAttrMaster = headerAttrRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("HeaderAttributeMasterUt", "id", id));
        return headerAttrRepository.save(headerAttrMaster);
    }
    
    @DeleteMapping("/headerAttribute/{id}")
    public ResponseEntity<?> deleteHeaderAttribute(@PathVariable(value = "id") Long headerAttrMasterId) {
    	 HeaderAttributeMasterUt headerAttrMaster = headerAttrRepository.findById(headerAttrMasterId)
                .orElseThrow(() -> new ExceptionHandler("HeaderAttributeMasterUt", "id", headerAttrMasterId));

        headerAttrRepository.delete(headerAttrMaster);

        return ResponseEntity.ok().build();
    }

}
