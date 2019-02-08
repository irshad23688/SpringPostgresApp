package com.metalsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsa.model.MmrCompareDataSheetModel;
import com.metalsa.model.SearchModel;
import com.metalsa.service.SearchNCompareService;

@RestController
@RequestMapping("/api/search")
public class SearchNCompareController {

	@Autowired
    private SearchNCompareService service;
	
    @GetMapping("/getConfig")
    public SearchModel getConfigParameters() {
        return service.getConfigParameters();
    }
    @PostMapping("/searchData")
    public SearchModel getSearchData(@RequestBody SearchModel model) {
    	return service.getSearchdata(model);
    }
    
    @PostMapping("/compareDatasheets")
    public List<MmrCompareDataSheetModel> compareDatasheetByIds(@RequestBody SearchModel model) {
    	return service.compareDataSheetByIds(model.getDatasheetIds());
    }
   
/*    @GetMapping("/showfilterdata")
    public SearchModel getSearch(@RequestBody SearchModel model) {
    	// logic search and populate it in 
    	return service.getSearchdata(model);
    }
*/   
}
