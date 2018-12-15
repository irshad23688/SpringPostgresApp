package com.metalsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.model.SearchModel;
import com.metalsa.service.SearchNCompareService;
import com.metalsa.util.JsonCreator;

@RestController
@RequestMapping("/api/search")
public class SearchNCompareController {

	@Autowired
    private SearchNCompareService service;

    @GetMapping("/getconfig")
    public SearchModel getConfigParameters() {
        return service.getConfigParameters();
    }
    @PostMapping("/searchData")
    public SearchModel getSearchData(@RequestBody SearchModel model) {
    	// logic search an dpoplate it in 
    	return service.getSearchdata(model);
    }
    @GetMapping("/showfilterdata")
    public SearchModel getSearch(@RequestBody SearchModel model) {
    	// logic search an dpoplate it in 
    	return service.getFilterData(model);
    }

    
}
