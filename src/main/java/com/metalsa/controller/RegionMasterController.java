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

import com.metalsa.domain.MmrRegionMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.RegionRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api/master")
public class RegionMasterController {
	
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/region")
    public List<MmrRegionMasterUt> getAllRegion() {
        return regionRepository.findAll();
    }

    @PostMapping("/region")
    public  List<MmrRegionMasterUt> createRegion(@Valid @RequestBody MmrRegionMasterUt regionMaster) {
    	regionRepository.save(regionMaster);
    	return regionRepository.findAll();
    	/*RegionMasterUt regionMasterUtSaved =  regionRepository.save(regionMaster);
    	Resource<RegionMasterUt> resource = new Resource<RegionMasterUt>(regionMasterUtSaved);
    	ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllRegion());
    	resource.add(linkTo.withRel("region"));
    	return resource;*/
    }

    @GetMapping("/region/{id}")
    public MmrRegionMasterUt getRegionById(@PathVariable(value = "id") Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("RegionMasterUt", "id", id));
    }

    @PutMapping("/region/{id}")
    public List<MmrRegionMasterUt> updateRegion(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrRegionMasterUt mmrRegionMasterUt) {
    	regionRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrRegionMasterUt", "id", id));
        regionRepository.save(mmrRegionMasterUt);
        return regionRepository.findAll();
    }
    
    @DeleteMapping("/region/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable(value = "id") Long regionId) {
    	MmrRegionMasterUt regionMaster = regionRepository.findById(regionId)
                .orElseThrow(() -> new ExceptionHandler("MmrRegionMasterUt", "id", regionId));

        regionRepository.delete(regionMaster);
        return ResponseEntity.ok().build();
    }

}
