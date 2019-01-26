package com.metalsa.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metalsa.constant.MetalsaConstant;
import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrDataSheetDetailUt;
import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrEditDataSheetDetailView;
import com.metalsa.domain.MmrNewDataSheetDetailView;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrBaseAttributeMasterUtModel;
import com.metalsa.model.MmrBaseAttributeTableDataTypeUtModel;
import com.metalsa.model.MmrDataSheetDetailUtModel;
import com.metalsa.model.MmrDataSheetHeaderModel;
import com.metalsa.model.MmrDataSheetUtModel;
import com.metalsa.repository.BaseAttributeRepository;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.DataSheetRepository;
import com.metalsa.repository.DataTypeRepository;
import com.metalsa.repository.ManufacturerRepository;
import com.metalsa.repository.MmrEditDataSheetDetailViewRepository;
import com.metalsa.repository.MmrNewDataSheetDetailViewRepository;
import com.metalsa.repository.RegionRepository;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.service.BaseAttributeService;
import com.metalsa.service.DataSheetSevice;

@Service
@PropertySource("classpath:application.properties")
public class DataSheetServiceImpl implements DataSheetSevice {

	@Autowired
	private Environment env; 

	@Autowired
	private DataSheetRepository dataSheetRepository ; 
	
	@Autowired
	private ClassRepository classRepository ; 
	
	@Autowired
	private SubClassRepository subClassRepository ; 
	
	@Autowired
	private RegionRepository regionRepository ; 
	
	@Autowired
	private ManufacturerRepository manufacturerRepository ; 
	
	@Autowired
	private DataTypeRepository dataTypeRepository;
	
	@Autowired
	private BaseAttributeRepository baseAttributeRepository;
	
	@Autowired
	private BaseAttributeService baseAttributeService;
	

	@Autowired
	private MmrEditDataSheetDetailViewRepository editDataSheetDetailViewRepository ; 

	@Autowired
	private MmrNewDataSheetDetailViewRepository newDataSheetDetailViewRepository ; 

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
			BeanUtils.copyProperties(datasheetUt, revisedDataSheet,new String[]{"id"});
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

	@Override
	public MmrDataSheetUtModel getNewDataTestSheetDetailByClassSubClass(Long classId, Long subClassId) {
		return getHeaderWiseBaseAttributeList(newDataSheetDetailViewRepository.findByClassIdAndSubClassId(classId, subClassId));
	}

	private MmrDataSheetUtModel getHeaderWiseBaseAttributeList(List<MmrNewDataSheetDetailView> list) {
		//		MmrDataTestSheetDetailUtViewModel modelView = new MmrDataTestSheetDetailUtViewModel();
		Map<Long,MmrDataSheetHeaderModel> mapHeaderToDetail = new LinkedHashMap<Long,MmrDataSheetHeaderModel>();
		MmrDataSheetUtModel  dataSheetUtModel =null;
		for(MmrNewDataSheetDetailView detailView : list) {
			if(mapHeaderToDetail.containsKey(detailView.getHeaderAttributeId())){
				mapHeaderToDetail.get(detailView.getHeaderAttributeId()).addDataSheetDetails(datasheetDetailMapping(detailView));
			}else {
				if(dataSheetUtModel==null) {
					dataSheetUtModel = new MmrDataSheetUtModel();
					dataSheetUtModel.setClassId(detailView.getClassId());
					dataSheetUtModel.setSubclassId(detailView.getSubClassId());
					dataSheetUtModel.setTestSheetId(detailView.getTestSheetId());
				}
				MmrDataSheetHeaderModel headerModel= new MmrDataSheetHeaderModel();
				headerModel.setHeaderAttributeId(detailView.getHeaderAttributeId());
				headerModel.setHeaderAttributeName(detailView.getHeaderAttributeName());
				headerModel.addDataSheetDetails(datasheetDetailMapping(detailView));
				mapHeaderToDetail.put(headerModel.getHeaderAttributeId(),headerModel);
			}
		}
		List<MmrDataSheetHeaderModel> result=new ArrayList(mapHeaderToDetail.values());
		dataSheetUtModel.setDataSheetHeaderDetails(result);
		return dataSheetUtModel;
	}

	private MmrDataSheetDetailUtModel datasheetDetailMapping(MmrNewDataSheetDetailView detailView) {
		MmrDataSheetDetailUtModel dataSheetDetailUtModel = new MmrDataSheetDetailUtModel(detailView);
		mappingForDataTypeDropdown(dataSheetDetailUtModel);
		mappingForDataTypeRadio(dataSheetDetailUtModel);
		mappingForDataTypeTable(dataSheetDetailUtModel);
		return dataSheetDetailUtModel;
	}

	private void mappingForDataTypeTable(MmrDataSheetDetailUtModel dataSheetDetailUtModel) {
		if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("Table")) {
			MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt = baseAttributeRepository.findById(dataSheetDetailUtModel.getBaseAttributeId())
	    			.orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", dataSheetDetailUtModel.getBaseAttributeId()));
			MmrBaseAttributeMasterUtModel baseAttributeMasterUtModel = baseAttributeService.getOne(mmrBaseAttributeMasterUt);
			for (MmrBaseAttributeTableDataTypeUtModel tableDataType : baseAttributeMasterUtModel.getMmrBaseAttributeTableDataTypeUts()) {
				MmrDataSheetDetailUtModel dataSheetDetailTableType = new MmrDataSheetDetailUtModel(tableDataType);
				dataSheetDetailUtModel.getTableLayoutValue().add(dataSheetDetailTableType);
			}
		}		
	}

	private void mappingForDataTypeRadio(MmrDataSheetDetailUtModel dataSheetDetailUtModel) {
		if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("RadioYesNo")) {
			dataSheetDetailUtModel.setOptions(MetalsaConstant.radioYesNo);
		 }else if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("RadioSOM1SOM2")) {
			 dataSheetDetailUtModel.setOptions(MetalsaConstant.radioSOM1SOM2);
		 }
	}

	private void mappingForDataTypeDropdown(MmrDataSheetDetailUtModel dataSheetDetailUtModel) {
		 if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("Class Dropdown")) {
			dataSheetDetailUtModel.setDropDownValues(classRepository.getClassByStatus(BigDecimal.ONE)); 
		 }else if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("Subclass Dropdown")) {
			 dataSheetDetailUtModel.setDropDownValues(subClassRepository.findSubClassByStatus(BigDecimal.ONE));
		 }else if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("Region Dropdown")) {
			 dataSheetDetailUtModel.setDropDownValues(regionRepository.findByStatus(BigDecimal.ONE));
		 }else if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("Manufacturer Dropdown")) {
			 dataSheetDetailUtModel.setDropDownValues(manufacturerRepository.findByStatus(BigDecimal.ONE));
		 }
	}

	@Override
	public MmrDataSheetUtModel persistDataSheet(MmrDataSheetUtModel model) {
		MmrDataSheetUt dataSheetUt ;
		if(0l!=model.getDataSheetId()) {
			dataSheetUt = dataSheetRepository.findById(model.getDataSheetId()).get();
		}else {
			dataSheetUt = new MmrDataSheetUt();
		}
		dataSheetUt.setClassId(model.getClassId());
		dataSheetUt.setSubclassId(model.getSubclassId());
		
		dataSheetUt.setDataSheetName(model.getDataSheetName());
		dataSheetUt.setCreatedBy(model.getCreatedBy());
		dataSheetUt.setModifiedBy(model.getModifiedBy());
		dataSheetUt.setRevision(model.getRevision());
		dataSheetUt.setStatus(model.getStatus());
		dataSheetUt.setTestSheetId(model.getTestSheetId());
		dataSheetUt.setIssubmitted("1");
		List<MmrDataSheetDetailUt> dataSheetDetailUts = new ArrayList<>();
		for (MmrDataSheetHeaderModel dataSheetHeaderModel : model.getDataSheetHeaderDetails()) {

			for (MmrDataSheetDetailUtModel sheetDetailUtModel : dataSheetHeaderModel.getDataSheetDetails()) {
				
				
				MmrDataSheetDetailUt dataSheetDetailUt = null;
				if(0l!= sheetDetailUtModel.getDataSheetDetailId()) {
					dataSheetDetailUt = getDataSheetDetailById(dataSheetUt.getMmrDataSheetDetailUts(), sheetDetailUtModel.getDataSheetDetailId());
					if (null==dataSheetDetailUt){
						dataSheetDetailUt = new MmrDataSheetDetailUt();
					}
				}else {
					dataSheetDetailUt = new MmrDataSheetDetailUt();
				}
				//BeanUtils.copyProperties(sheetDetailUtModel, dataSheetDetailUt,new String[]{"id"});
				dataSheetDetailUt.setCreatedBy(sheetDetailUtModel.getCreatedBy());
				dataSheetDetailUt.setModifiedBy(sheetDetailUtModel.getModifiedBy());
				dataSheetDetailUt.setStatus(model.getStatus());
				dataSheetDetailUt.setSupplierInformationLhs(sheetDetailUtModel.getSupplierInformationLhs());
				dataSheetDetailUt.setSupplierInformationRhs(sheetDetailUtModel.getSupplierInformationRhs());
				dataSheetDetailUt.setSupplierInformationOperator(sheetDetailUtModel.getSupplierInformationOperator());
				//dataSheetDetailUt.setSupplierInformationTableType(sheetDetailUtModel.getSupplierInformationTableType());
				dataSheetDetailUt.setTestingInformation(sheetDetailUtModel.getTestingInformation());
				//dataSheetDetailUt.setTestingInformationTableType(sheetDetailUtModel.getTestingInformationTableType());
				dataSheetDetailUt.setTestSheetDetailId(sheetDetailUtModel.getTestSheetDetailId());
				dataSheetDetailUt.setUserSelectUom(sheetDetailUtModel.getUserSelectUom());
				//TODO
				dataSheetDetailUt.setUserUom1("");
				dataSheetDetailUt.setUserUom2("");
				
				dataSheetDetailUts.add(dataSheetDetailUt);
			}

		}
		dataSheetUt.setMmrDataSheetDetailUts(dataSheetDetailUts);
		dataSheetRepository.save(dataSheetUt);
		return model;
	}

	private MmrDataSheetDetailUt getDataSheetDetailById(List<MmrDataSheetDetailUt> mmrDataSheetDetailUts, long dataSheetDetailId) {
		for (MmrDataSheetDetailUt mmrDataSheetDetailUt : mmrDataSheetDetailUts) {
			if(dataSheetDetailId==mmrDataSheetDetailUt.getId()) {
				return mmrDataSheetDetailUt;
			}

		}
		return null;
	}

	@Override
	public MmrDataSheetUtModel getDataSheetById(MmrDataSheetUt dataSheetUt) {
		return getEditHeaderWiseBaseAttributeList(dataSheetUt);
	}

	private MmrDataSheetUtModel getEditHeaderWiseBaseAttributeList(MmrDataSheetUt dataSheetUt) {
		Map<Long,MmrDataSheetHeaderModel> mapHeaderToDetail = new LinkedHashMap<Long,MmrDataSheetHeaderModel>();
		MmrDataSheetUtModel  dataSheetUtModel =null;
		for(MmrEditDataSheetDetailView detailView : editDataSheetDetailViewRepository.findByDataSheetUtId(dataSheetUt.getId())) {
			if(mapHeaderToDetail.containsKey(detailView.getHeaderAttributeId())){
				MmrDataSheetDetailUtModel dataSheetDetailUtModel = new MmrDataSheetDetailUtModel(detailView);
				mapHeaderToDetail.get(detailView.getHeaderAttributeId()).addDataSheetDetails(dataSheetDetailUtModel);
			}else {
				if(dataSheetUtModel==null) {
					dataSheetUtModel = new MmrDataSheetUtModel(dataSheetUt);
				}
				MmrDataSheetHeaderModel headerModel= new MmrDataSheetHeaderModel();
				headerModel.setHeaderAttributeId(detailView.getHeaderAttributeId());
				headerModel.setHeaderAttributeName(detailView.getHeaderAttributeName());
				
				MmrDataSheetDetailUtModel dataSheetDetailUtModel = new MmrDataSheetDetailUtModel(detailView);
				headerModel.addDataSheetDetails(dataSheetDetailUtModel);
				mapHeaderToDetail.put(headerModel.getHeaderAttributeId(),headerModel);
			}
		}
		List<MmrDataSheetHeaderModel> result=new ArrayList(mapHeaderToDetail.values());
		dataSheetUtModel.setDataSheetHeaderDetails(result);
		return dataSheetUtModel;
	}


}
