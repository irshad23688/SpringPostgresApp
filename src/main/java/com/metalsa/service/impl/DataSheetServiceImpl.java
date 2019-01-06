package com.metalsa.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metalsa.constant.MetalsaConstant;
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.DataSheetRepository;
import com.metalsa.service.DataSheetSevice;

@Service
@PropertySource("classpath:application.properties")
public class DataSheetServiceImpl implements DataSheetSevice {

	@Autowired
	private Environment env; 
	
    @Autowired
    private DataSheetRepository dataSheetRepository ; 

	@Override
	public String saveFileOnserver(MultipartFile file, String dataSheetId) {
		String rootLocation = env.getProperty("datasheet.server.filepath");
		Path path = null;
		if(null!=rootLocation && !rootLocation.isEmpty()) {
			path = Paths.get(rootLocation+File.separator+dataSheetId);
			try {
				Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
				
			} catch(Exception e) {
				return null;
			}
		}
		return file.getOriginalFilename();	
	}

	@Override
	public Resource loadFile(String fileName, String dataSheetId) {
		String rootLocation = env.getProperty("datasheet.server.filepath");
		Path path = Paths.get(rootLocation+File.separator+dataSheetId);
		try {
			Path file = path.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException();
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void createRevision(MmrDataSheetUt datasheetUt) {
		if(MetalsaConstant.STATUS.APPROVED.equals(datasheetUt.getStatus().toString())){
			MmrDataSheetUt revisedDataSheet = new MmrDataSheetUt();
			BeanUtils.copyProperties(datasheetUt, revisedDataSheet);
			revisedDataSheet.setStatus(new BigDecimal(MetalsaConstant.STATUS.PENDING));
			revisedDataSheet.setRevParentId(datasheetUt.getId());
			dataSheetRepository.save(revisedDataSheet);
		}
	}

	@Override
	public void updateDataSheet(MmrDataSheetUt datasheetUt) {
		if(MetalsaConstant.STATUS.APPROVED.equals(datasheetUt.getStatus().toString())){
			if(null!=datasheetUt.getRevParentId()) {
				MmrDataSheetUt parentDataSheet = dataSheetRepository.findById(datasheetUt.getRevParentId()).get();
				BigDecimal rev = parentDataSheet.getRevision();
				parentDataSheet.setRevision(rev.add(BigDecimal.ONE));
				parentDataSheet.setStatus(new BigDecimal(MetalsaConstant.STATUS.INACTIVE));
				dataSheetRepository.save(parentDataSheet);	
			}
		}
		dataSheetRepository.save(datasheetUt);	
	}

}
