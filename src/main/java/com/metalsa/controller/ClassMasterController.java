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

import com.metalsa.domain.ClassMasterUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.repository.ClassRepository;

/**
 * Created by jayesh on 9/12/18.
 */
@RestController
@RequestMapping("/api")
public class ClassMasterController {
	
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/class")
    public List<ClassMasterUt> getAllClass() {
        return classRepository.findAll();
    }

    @PostMapping("/class")
    public Resource<ClassMasterUt> createClass(@Valid @RequestBody ClassMasterUt classMaster) {
    	//return classRepository.save(classMaster);
    	ClassMasterUt classMasterUtSaved =  classRepository.save(classMaster);
    	Resource<ClassMasterUt> resource = new Resource<ClassMasterUt>(classMasterUtSaved);
    	ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllClass());
    	resource.add(linkTo.withRel("class"));
    	return resource;
    }

    @GetMapping("/class/{id}")
    public ClassMasterUt getClassById(@PathVariable(value = "id") Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("ClassMasterUt", "id", id));
    }

    @PutMapping("/class/{id}")
    public ClassMasterUt updateClass(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody ClassMasterUt classMasterDetails) {
        ClassMasterUt classMaster = classRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("ClassMasterUt", "id", id));
        return classRepository.save(classMaster);
    }
    
    @DeleteMapping("/class/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable(value = "id") Long classId) {
    	 ClassMasterUt classMaster = classRepository.findById(classId)
                .orElseThrow(() -> new ExceptionHandler("Note", "id", classId));

        classRepository.delete(classMaster);

        return ResponseEntity.ok().build();
    }

}
