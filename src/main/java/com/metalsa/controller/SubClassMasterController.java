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

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrSubClassMasterUtModel;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.service.SubClassService;


/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class SubClassMasterController {
	
	@Autowired
	private ClassRepository classRepository;
	
    @Autowired
    private SubClassRepository subClassRepository;
    
    @Autowired
    private SubClassService subClassService;

    @GetMapping("/subclass")
    public List<MmrSubClassMasterUtModel> getAllSubClass() {
    	return subClassService.getAll(true);
    }
    @GetMapping("/subclass/active")
    public List<MmrSubClassMasterUtModel> getActiveAllClass() {
    	return subClassService.getAll(false);
    }
    
    @GetMapping("/subclassbyclass/{classId}")
    public List<MmrSubClassMasterUt> getAllSubClass(@PathVariable(value = "classId") Long classId) {
    	MmrClassMasterUt masterUt= classRepository.findById(classId)
        .orElseThrow(() -> new ExceptionHandler("MmrClassMasterUt", "id", classId));
    	return subClassRepository.findByMmrClassMasterUtAndStatus(masterUt, BigDecimal.ONE);
    }
    
    @PostMapping("/subclass")
    public List<MmrSubClassMasterUtModel> createSubClass(@Valid @RequestBody MmrSubClassMasterUt mmrSubclassMasterUt) {
    	 subClassRepository.save(mmrSubclassMasterUt);
    	return subClassService.getAll(true);
    }

    @GetMapping("/subclass/{id}")
    public MmrSubClassMasterUtModel getSubClassById(@PathVariable(value = "id") Long id) {
        return subClassService.getOne(subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id)));
    }
    
    @PutMapping("/subclass/{id}")
    public List<MmrSubClassMasterUtModel> updateSubClass(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrSubClassMasterUt subClassMasterDetails) {
    	subClassRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", id));
    	subClassRepository.save(subClassMasterDetails);
        return subClassService.getAll(true);
    }
    
    @DeleteMapping("/subclass/{id}")
    public ResponseEntity<?> deleteSubClass(@PathVariable(value = "id") Long subClassId) {
    	 MmrSubClassMasterUt subClassMaster = subClassRepository.findById(subClassId)
                .orElseThrow(() -> new ExceptionHandler("SubClassMasterUt", "id", subClassId));

        subClassRepository.delete(subClassMaster);

        return ResponseEntity.ok().build();
    }

}
