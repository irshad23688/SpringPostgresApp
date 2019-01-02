package com.metalsa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.model.SearchModel;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.service.SearchNCompareService;

@RestController
@RequestMapping("/api/search")
public class SearchNCompareController {

	@Autowired
    private SearchNCompareService service;
	
	@Autowired
    private HeaderAttrRepository headerAttrRepository;
	
    @GetMapping("/getconfig")
    public SearchModel getConfigParameters() {
    	headerAttrRepository.findAll();
        return service.getConfigParameters();
    }
    @PostMapping("/searchData")
    public SearchModel getSearchData(@RequestBody SearchModel model) {
    	// logic search and populate it in 
    	return service.getSearchdata(model);
    }
    @GetMapping("/showfilterdata")
    public SearchModel getSearch() {
    	// logic search and populate it in 
    	return service.getSearchdata(new SearchModel());
    }
    
    @GetMapping("/getdatasheets")
    public List<MmrDataSheetUt> getDataSheetByIds(@Valid List<Long> datasheetIds) {
    	return service.getDataSheetByIds(datasheetIds);
    }
/*    @GetMapping("/showfilterdata")
    public SearchModel getSearch(@RequestBody SearchModel model) {
    	// logic search and populate it in 
    	return service.getSearchdata(model);
    }
*/   
}
