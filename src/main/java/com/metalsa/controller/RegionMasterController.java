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

import com.metalsa.domain.RegionMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.RegionRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api")
public class RegionMasterController {
	
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/region")
    public List<RegionMasterUt> getAllRegion() {
        return regionRepository.findAll();
    }

    @PostMapping("/region")
    public Resource<RegionMasterUt> createRegion(@Valid @RequestBody RegionMasterUt regionMaster) {
    	//return regionRepository.save(regionMaster);
    	RegionMasterUt regionMasterUtSaved =  regionRepository.save(regionMaster);
    	Resource<RegionMasterUt> resource = new Resource<RegionMasterUt>(regionMasterUtSaved);
    	ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllRegion());
    	resource.add(linkTo.withRel("region"));
    	return resource;
    }

    @GetMapping("/region/{id}")
    public RegionMasterUt getRegionById(@PathVariable(value = "id") Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("RegionMasterUt", "id", id));
    }

    @PutMapping("/region/{id}")
    public RegionMasterUt updateRegion(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody RegionMasterUt regionMasterDetails) {
        RegionMasterUt regionMaster = regionRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("RegionMasterUt", "id", id));
        return regionRepository.save(regionMaster);
    }
    
    @DeleteMapping("/region/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable(value = "id") Long regionId) {
    	 RegionMasterUt regionMaster = regionRepository.findById(regionId)
                .orElseThrow(() -> new ExceptionHandler("Note", "id", regionId));

        regionRepository.delete(regionMaster);

        return ResponseEntity.ok().build();
    }

}
