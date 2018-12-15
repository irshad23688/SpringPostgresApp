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

import com.metalsa.domain.SubclassMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.SubClassRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/admin")
public class SubClassMasterController {
	
    @Autowired
    private SubClassRepository subClassRepository;

    @GetMapping("/subclass")
    public List<SubclassMasterUt> getAllSubClass() {
        return subClassRepository.findAll();
    }

    @PostMapping("/subclass")
    public SubclassMasterUt createSubClass(@Valid @RequestBody SubclassMasterUt subClassMaster) {
        return subClassRepository.save(subClassMaster);
    }

    @GetMapping("/subclass/{id}")
    public SubclassMasterUt getSubClassById(@PathVariable(value = "id") Long id) {
        return subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
    }

    @PutMapping("/subclass/{id}")
    public SubclassMasterUt updateSubClass(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody SubclassMasterUt subClassMasterDetails) {
        SubclassMasterUt subClassMaster = subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
        return subClassRepository.save(subClassMaster);
    }
    
    @DeleteMapping("/subclass/{id}")
    public ResponseEntity<?> deleteSubClass(@PathVariable(value = "id") Long subClassId) {
    	 SubclassMasterUt subClassMaster = subClassRepository.findById(subClassId)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", subClassId));

        subClassRepository.delete(subClassMaster);

        return ResponseEntity.ok().build();
    }

}
