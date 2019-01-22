package com.metalsa.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.model.DashboardModel;
import com.metalsa.service.DashboardSevice;


@RestController
@RequestMapping("/api/master")
public class DashboardController {
	
    @Autowired
    private DashboardSevice dashboardSevice ;
    
    @GetMapping("/dashboard/dashboardData/{user}")
    public DashboardModel getDashboardData(@PathVariable(value = "user") BigDecimal userId) {
    	return dashboardSevice.getDashboardData(userId);
    }
    
}
