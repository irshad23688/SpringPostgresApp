package com.metalsa.controller;

import java.math.BigDecimal;
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
    @GetMapping("/datasheet/{id}")
    public MmrDataSheetUt getDataSheetById(@PathVariable(value = "id") Long id) {
    	return dataSheetRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", id));
    }
    
    @GetMapping("/datasheet/new/{classId}/{subClassId}")
    public MmrDataSheetUtModel createNewDataSheet(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
    	return dataSheetService.getNewDataTestSheetDetailByClassSubClass(classId,subClassId);
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
    
    
    @PostMapping("/datasheet/revision")
    public List<MmrDataSheetUt> createRevision(@Valid @RequestBody MmrDataSheetUt datasheetUt) {
    	dataSheetService.createRevision(datasheetUt);
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
    
    @GetMapping("datasheet/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String fileName,@PathVariable String dataSheetId) {
		 Resource file =  dataSheetService.loadFile(fileName, dataSheetId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

    @GetMapping("/datasheet/status/{status}")
    public List<Object[]> getDataSheetById(@PathVariable(value = "status") BigDecimal status) {
    	return customRepository.findDatasheetByStatus(status);
    }
    
    @GetMapping("/datasheet/user/{user}")
    public List<Object[]> getDataSheetByUserId(@PathVariable(value = "user") BigDecimal user) {
    	return customRepository.getDatasheetForDashboard(user);
    }
    

}
