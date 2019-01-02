package com.metalsa.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.DataSheetRepository;
import com.metalsa.service.DataSheetSevice;


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
    
    @GetMapping("/datasheet")
    public List<MmrDataSheetUt> getAllClass() {
    	return dataSheetRepository.findAll();
    }
    
    @GetMapping("/datasheet/{classId}/{subClassId}")
    public List<MmrDataSheetUt> getDataSheetByClassNSubclass(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
        return customRepository.getDataSheetByClassNSubclass(classId,subClassId);
    }
    
    @GetMapping("/datasheet/new/{classId}/{subClassId}")
    public MmrTestSheetUt createNewDataSheet(@PathVariable(value = "classId") Long classId,
    		@PathVariable(value = "subClassId") Long subClassId) {
    	return customRepository.getTestSheetByClassNSubclass(classId,subClassId);
    }
    
    
    @PostMapping("/datasheet/{type}")
    public MmrDataSheetUt updateDataSheet(@Valid @RequestBody MmrDataSheetUt datasheetUt,
    		@PathVariable(value = "type") String type) {
    	//TODO
    	// Revision inc for create rev
    	// update datasheet
    	dataSheetRepository.save(datasheetUt);
    	return datasheetUt;
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
    

}
