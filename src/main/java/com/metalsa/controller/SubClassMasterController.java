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

import com.metalsa.domain.MmrSubclassMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.SubClassModel;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.service.SubClassService;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class SubClassMasterController {
	
    @Autowired
    private SubClassRepository subClassRepository;
    
    @Autowired
    private SubClassService subClassService;

    @GetMapping("/subclass")
    public List<MmrSubclassMasterUt> getAllSubClass() {
    	return subClassRepository.findAll();
    }

    /*@PostMapping("/subclass")
    public SubClassModel createSubClass(@Valid @RequestBody SubClassModel subClassModel) {
    	return subClassService.persistSubClass(subClassModel);
    }*/
    @PostMapping("/subclass")
    public List<MmrSubclassMasterUt> createSubClass(@Valid @RequestBody MmrSubclassMasterUt mmrSubclassMasterUt) {
    	 subClassRepository.save(mmrSubclassMasterUt);
    	return subClassRepository.findAll();
    }

    @GetMapping("/subclass/{id}")
    public MmrSubclassMasterUt getSubClassById(@PathVariable(value = "id") Long id) {
        return subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
    }

    @PutMapping("/subclass/{id}")
    public SubClassModel updateSubClass(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrSubclassMasterUt subClassMasterDetails) {
        subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
        subClassRepository.save(subClassMasterDetails);
        return subClassService.getSubClassData();
    }
    
    @DeleteMapping("/subclass/{id}")
    public ResponseEntity<?> deleteSubClass(@PathVariable(value = "id") Long subClassId) {
    	 MmrSubclassMasterUt subClassMaster = subClassRepository.findById(subClassId)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", subClassId));

        subClassRepository.delete(subClassMaster);

        return ResponseEntity.ok().build();
    }

}
