package com.metalsa.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.DashboardModel;
import com.metalsa.model.MmrDataSheetUtModel;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.DataSheetRepository;
import com.metalsa.service.DataSheetSevice;
import com.metalsa.service.TestSheetService;


@RestController
@RequestMapping("/api/master")
public class DataSheetController {
	
    @Autowired
    private ClassRepository classRepository;
    
    @Autowired
    private CustomRepository customRepository ;
    
    @Autowired
    private DataSheetRepository dataSheetRepository ;
    
    @Autowired
    private DataSheetSevice dataSheetService;
    
    @Autowired
    private TestSheetService testSheetService;
    
    @GetMapping("/datasheet")
    public List<MmrDataSheetUt> getAllClass() {
    	return dataSheetRepository.findAll();
    }
    
    @GetMapping("/datasheet/{classId}/{subClassId}")
    public List<MmrDataSheetUt> getDataSheetByClassNSubclass(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
        return customRepository.getDataSheetByClassNSubclass(classId,subClassId);
    }
    @GetMapping("/datasheet1/{id}")
    public MmrDataSheetUt getDataSheetById1(@PathVariable(value = "id") Long id) {
    	return dataSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", id));
    }
    @GetMapping("/datasheet/{id}")
    public MmrDataSheetUtModel getDataSheetById(@PathVariable(value = "id") Long id) {
    	MmrDataSheetUt dataSheetUt= dataSheetRepository.findById(id)
        .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", id));
    	return dataSheetService.getDataSheetById(dataSheetUt);
    }
    
    @GetMapping("/datasheet/new/{classId}/{subClassId}")
    public MmrDataSheetUtModel createNewDataSheet(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
    	return dataSheetService.getNewDataTestSheetDetailByClassSubClass(classId,subClassId);
    }
    @GetMapping("/datasheet/revisionnumber/{classId}/{subClassId}/{regionId}")
    public String createNewDataSheet(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId,@PathVariable(value = "classId") Long regionId) {
    	return dataSheetService.getNewRevisonNumber(classId,subClassId,regionId);
    }
    @PostMapping("/datasheet/edit")
    public MmrDataSheetUtModel getDataSheet(@Valid @RequestBody MmrDataSheetUtModel model) {
    	return dataSheetService.getEditDatasheet(model);
    }
    @GetMapping("/datasheet/new1/{classId}/{subClassId}")
    public MmrDataSheetUtModel createNewDataSheet1(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
    	return new MmrDataSheetUtModel();
    }
    
    @PostMapping("/datasheet")
    public MmrDataSheetUtModel persistDataSheetModel(@Valid @RequestBody MmrDataSheetUtModel model) {
    	model = dataSheetService.persistDataSheet(model);
    	return model;
    }
    
    @PostMapping("/datasheetSave")
    public MmrDataSheetUt persistDataSheetModel1(@Valid @RequestBody MmrDataSheetUt model) {
    	
    	return dataSheetRepository.save(model);
    }
    
    /*@PostMapping("/datasheet/revision")
    public List<MmrDataSheetUt> createRevision(@Valid @RequestBody MmrDataSheetUt datasheetUt) {
    	dataSheetService.createRevision(datasheetUt);
    	return dataSheetRepository.findAll();
    }*/
    @PostMapping("/datasheet/revision")
    public List<MmrDataSheetUt> createRevision(@Valid @RequestBody MmrDataSheetUtModel model) {
    	dataSheetService.createRevision(model);
    	return dataSheetRepository.findAll();
    }
   /* @PostMapping("/datasheet")
    public List<MmrDataSheetUt> createDataSheet(@Valid @RequestBody MmrDataSheetUt datasheetUt) {
    	dataSheetRepository.save(datasheetUt);
    	return dataSheetRepository.findAll();
    }*/
    
    @PutMapping("/datasheet/{id}")
    public List<MmrDataSheetUt> updateDataSheet(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody MmrDataSheetUt datasheetUt) {
    	dataSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", id));
    	dataSheetService.updateDataSheet(datasheetUt);
        return dataSheetRepository.findAll();
    }
    
    @PostMapping("/datasheet/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("dataSheetId") String dataShssetId ) {
		String fileName = "";
		try {
			fileName = dataSheetService.saveFileOnserver(file,dataShssetId);
			return ResponseEntity.status(HttpStatus.OK).body(fileName);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to upload");
		}
	}
    
    @GetMapping("datasheet/files/{dataSheetId}/{filename}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable(value = "filename") String fileName,
			@PathVariable(value = "dataSheetId") String dataSheetId) {
		 Resource file =  dataSheetService.loadFile(fileName, dataSheetId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
    
    @PostMapping("/datasheet/updatestatus")
	public List<String> uploadStatus(@Valid @RequestBody DashboardModel model) {
		 
//    	dataSheetRepository.setStatusForDataSheet(status, id);
//    	customRepository.updateDatasheetByStatus(new BigDecimal(status), id);
    	MmrDataSheetUt ut= dataSheetRepository.findById(model.getId())
        .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", model.getId()));
    	ut.setStatus(new BigDecimal(model.getStatus()));
    	ut.setApprovedBy(new BigDecimal(model.getApprovedby()));
    	ut.setApprovedOn(new Timestamp( new Date().getTime()) );
    	ut.setModifiedBy(new BigDecimal(model.getApprovedby()));
    	ut.setModifiedOn(new Timestamp( new Date().getTime()) );
    	
    	dataSheetRepository.save(ut);
    	return new ArrayList<>();
	}

}
