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

import com.metalsa.domain.MmrHeaderAttributeMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.HeaderAttrRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class HeaderAttrMasterController {
	
    @Autowired
    private HeaderAttrRepository headerAttrRepository;

    @GetMapping("/headerattribute")
    public List<MmrHeaderAttributeMasterUt> getAllHeaderAttribute() {
        return headerAttrRepository.findAll();
    }

    @PostMapping("/headerattribute")
    public List<MmrHeaderAttributeMasterUt> createHeaderAttribute(@Valid @RequestBody MmrHeaderAttributeMasterUt headerAttrMaster) {
        headerAttrRepository.save(headerAttrMaster);
        return headerAttrRepository.findAll();
    }

    @GetMapping("/headerattribute/{id}")
    public MmrHeaderAttributeMasterUt getHeaderAttributeById(@PathVariable(value = "id") Long id) {
        return headerAttrRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrHeaderAttributeMasterUt", "id", id));
    }

    @PutMapping("/headerattribute/{id}")
    public List<MmrHeaderAttributeMasterUt> updateHeaderAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrHeaderAttributeMasterUt headerAttrMasterDetails) {
        headerAttrRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrHeaderAttributeMasterUt", "id", id));
        headerAttrRepository.save(headerAttrMasterDetails);
        return headerAttrRepository.findAll();
    }
    
    @DeleteMapping("/headerattribute/{id}")
    public ResponseEntity<?> deleteHeaderAttribute(@PathVariable(value = "id") Long headerAttrMasterId) {
    	 MmrHeaderAttributeMasterUt headerAttrMaster = headerAttrRepository.findById(headerAttrMasterId)
                .orElseThrow(() -> new ExceptionHandler("MmrHeaderAttributeMasterUt", "id", headerAttrMasterId));

        headerAttrRepository.delete(headerAttrMaster);

        return ResponseEntity.ok().build();
    }

}
