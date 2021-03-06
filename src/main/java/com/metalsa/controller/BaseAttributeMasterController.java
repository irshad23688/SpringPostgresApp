package com.metalsa.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.metalsa.domain.MmrBaseAttributeUomDetailsUt;
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
    	return baseAttributeService.getAll(true);
    }
    @GetMapping("/baseattribute/active")
    public List<MmrBaseAttributeMasterUtModel> getAllActiveBaseAttribute() {
    	return baseAttributeService.getAll(false);
    }

    @GetMapping("/baseattribute/{istableheaderFlag}/{status}")
    public List<MmrBaseAttributeMasterUtModel> getAllHeaderAttributeForUI(
    		@PathVariable(value = "istableheaderFlag") Long istableheaderFlag,@PathVariable(value = "status") Long status) {
    	return baseAttributeService.getListByIstableheaderFlagAndStatus(new BigDecimal(istableheaderFlag),new BigDecimal(status));
    }
    @PostMapping("/baseattribute")
    public List<MmrBaseAttributeMasterUtModel> createBaseAttribute(@Valid @RequestBody MmrBaseAttributeMasterUt baseAttributeMaster) {
    	List<MmrBaseAttributeUomDetailsUt> lst= new ArrayList<>();
    	if(baseAttributeMaster.getMmrBaseAttributeUomDetailsUts()!=null) {
    		for (MmrBaseAttributeUomDetailsUt mmrBaseAttributeUomDetailsUt : baseAttributeMaster.getMmrBaseAttributeUomDetailsUts()) {
    			if( mmrBaseAttributeUomDetailsUt.getSom1Uom()!=null && mmrBaseAttributeUomDetailsUt.getSom1Uom()!="" ) {
    				lst.add(mmrBaseAttributeUomDetailsUt);
    			}
				
			}
    	}
    	baseAttributeMaster.setMmrBaseAttributeUomDetailsUts(new ArrayList<>());
    	baseAttributeMaster.setMmrBaseAttributeUomDetailsUts(lst);
    	baseAttributeRepository.save(baseAttributeMaster);
    	return baseAttributeService.getAll(true);
    }

   /* @GetMapping("/baseattribute/{id}")
    public MmrBaseAttributeMasterUt getBaseAttributeById(@PathVariable(value = "id") Long id) {
        return baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    }*/
    
    @GetMapping("/baseattribute/{id}")
    public MmrBaseAttributeMasterUtModel getBaseAttributeByIdForUI(@PathVariable(value = "id") Long id) {
    	MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt = baseAttributeRepository.findById(id)
    			.orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    	return baseAttributeService.getOne(mmrBaseAttributeMasterUt);
    }
    
    @GetMapping("/baseattribute1/{id}")
    public MmrBaseAttributeMasterUt getBaseAttributeByIdForUI1(@PathVariable(value = "id") Long id) {
    	MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt = baseAttributeRepository.findById(id)
    			.orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
    	return mmrBaseAttributeMasterUt;
    }

    @PutMapping("/baseattribute/{id}")
    public List<MmrBaseAttributeMasterUtModel> updateBaseAttribute(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrBaseAttributeMasterUt baseAttributeMasterDetails) {
    	baseAttributeRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", id));
        baseAttributeRepository.save(baseAttributeMasterDetails);
        return baseAttributeService.getAll(true);
    }
    
    @DeleteMapping("/baseattribute/{id}")
    public ResponseEntity<?> deleteBaseAttribute(@PathVariable(value = "id") Long baseAttributeId) {
    	MmrBaseAttributeMasterUt baseAttributeMaster = baseAttributeRepository.findById(baseAttributeId)
                .orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", baseAttributeId));

        baseAttributeRepository.delete(baseAttributeMaster);

        return ResponseEntity.ok().build();
    }

}
