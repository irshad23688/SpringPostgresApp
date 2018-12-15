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

import com.metalsa.domain.ManufacturerMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.ManufacturerRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api")
public class ManufacturerMasterController {
	
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturer")
    public List<ManufacturerMasterUt> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }

    @PostMapping("/manufacturer")
    public Resource<ManufacturerMasterUt> createManufacturer(@Valid @RequestBody ManufacturerMasterUt manufacturerMaster) {
    	//return manufacturerRepository.save(manufacturerMaster);
    	ManufacturerMasterUt manufacturerMasterUtSaved =  manufacturerRepository.save(manufacturerMaster);
    	Resource<ManufacturerMasterUt> resource = new Resource<ManufacturerMasterUt>(manufacturerMasterUtSaved);
    	ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllManufacturer());
    	resource.add(linkTo.withRel("manufacturer"));
    	return resource;
    }

    @GetMapping("/manufacturer/{id}")
    public ManufacturerMasterUt getManufacturerById(@PathVariable(value = "id") Long id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("ManufacturerMasterUt", "id", id));
    }

    @PutMapping("/manufacturer/{id}")
    public ManufacturerMasterUt updateManufacturer(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody ManufacturerMasterUt manufacturerMasterDetails) {
        ManufacturerMasterUt manufacturerMaster = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("ManufacturerMasterUt", "id", id));
        return manufacturerRepository.save(manufacturerMaster);
    }
    
    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable(value = "id") Long manufacturerId) {
    	 ManufacturerMasterUt manufacturerMaster = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ExceptionHandler("ManufacturerMasterUt", "id", manufacturerId));

        manufacturerRepository.delete(manufacturerMaster);

        return ResponseEntity.ok().build();
    }

}
