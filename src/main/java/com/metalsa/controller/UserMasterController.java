package com.metalsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.model.UserMasterModel;
import com.metalsa.repository.CustomRepository;

@RestController
@RequestMapping("/api/master")
public class UserMasterController {
	
    @Autowired
    private CustomRepository customRepository;


    @GetMapping("/user/{userId}")
    public UserMasterModel getUserById(@PathVariable(value = "userId") Long userId) {
        return customRepository.findUserDetailsByUserId(userId);
    }


}
