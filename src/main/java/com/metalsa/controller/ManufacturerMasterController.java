package com.metalsa.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.domain.MmrManufacturerMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.ManufacturerRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class ManufacturerMasterController {
	
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturer")
    public List<MmrManufacturerMasterUt> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }

    @PostMapping("/manufacturer")
    public List<MmrManufacturerMasterUt> createManufacturer(@Valid @RequestBody MmrManufacturerMasterUt manufacturerMaster) {
    	manufacturerRepository.save(manufacturerMaster);
    	return manufacturerRepository.findAll();
    	/*ManufacturerMasterUt manufacturerMasterUtSaved =  manufacturerRepository.save(manufacturerMaster);
    	Resource<ManufacturerMasterUt> resource = new Resource<ManufacturerMasterUt>(manufacturerMasterUtSaved);
    	ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllManufacturer());
    	resource.add(linkTo.withRel("manufacturer"));
    	return resource;*/
    }

    @GetMapping("/manufacturer/{id}")
    public MmrManufacturerMasterUt getManufacturerById(@PathVariable(value = "id") Long id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("ManufacturerMasterUt", "id", id));
    }

    @PutMapping("/manufacturer/{id}")
    public List<MmrManufacturerMasterUt> updateManufacturer(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrManufacturerMasterUt manufacturerMasterDetails) {
    	MmrManufacturerMasterUt manufacturerMaster = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("ManufacturerMasterUt", "id", id));
        manufacturerRepository.save(manufacturerMaster);
        return manufacturerRepository.findAll();
    }
    
    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable(value = "id") Long manufacturerId) {
    	MmrManufacturerMasterUt manufacturerMaster = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ExceptionHandler("ManufacturerMasterUt", "id", manufacturerId));

        manufacturerRepository.delete(manufacturerMaster);

        return ResponseEntity.ok().build();
    }

}
