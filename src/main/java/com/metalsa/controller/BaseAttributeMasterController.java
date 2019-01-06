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

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrBaseAttributeMasterUtModel;
import com.metalsa.repository.BaseAttributeRepository;
import com.metalsa.service.BaseAttributeService;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class BaseAttributeMasterController {
	
    @Autowired
    private BaseAttributeRepository baseAttributeRepository;
    
    @Autowired
    private BaseAttributeService baseAttributeService;
    
    
    @GetMapping("/baseattribute")
    public List<MmrBaseAttributeMasterUtModel> getAllBaseAttribute() {
    	return baseAttributeService.getAll();
    }

    @GetMapping("/baseattribute/{istableheaderFlag}/{status}")
    public List<MmrBaseAttributeMasterUtModel> getAllHeaderAttributeForUI(
    		@PathVariable(value = "istableheaderFlag") Long istableheaderFlag,@PathVariable(value = "status") Long status) {
    	return baseAttributeService.getListByIstableheaderFlagAndStatus(new BigDecimal(istableheaderFlag),new BigDecimal(status));
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
    @GetMapping("/baseattribute/ui/{id}")
    public MmrBaseAttributeMasterUtModel getBaseAttributeByIdForUI(@PathVariable(value = "id") Long id) {
    	MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt = baseAttributeRepository.findById(id)
    			.orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    	return baseAttributeService.getOne(mmrBaseAttributeMasterUt);
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
