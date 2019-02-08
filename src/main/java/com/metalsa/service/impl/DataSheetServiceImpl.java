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
import java.util.Random;

import javax.validation.Valid;

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
import com.metalsa.model.MmrDataSheetDetailListViewUtModel;
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
			File direct = new File(rootLocation+File.separator+dataSheetId);
			if(!direct.isDirectory()) {
				direct.mkdirs();
			}
			path = Paths.get(rootLocation+File.separator+dataSheetId);
			try {
				Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));

			} catch(Exception e) {
				throw new RuntimeException(e.getMessage());
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
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void createRevision(MmrDataSheetUtModel model) {
		MmrDataSheetUt datasheetUt=mappingDataSheet(model);
		if(MetalsaConstant.STATUS.APPROVED.equals(datasheetUt.getStatus()+"")){
			MmrDataSheetUt revisedDataSheet = new MmrDataSheetUt();
			BeanUtils.copyProperties(datasheetUt, revisedDataSheet,new String[]{"id"});
			revisedDataSheet.setStatus(new BigDecimal(MetalsaConstant.STATUS.PENDING));
			revisedDataSheet.setRevision(datasheetUt.getRevision().add(BigDecimal.ONE));
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
		long min =newDataSheetDetailViewRepository.getMinHeaderCount(classId, subClassId);
		MmrDataSheetUtModel model= getHeaderWiseBaseAttributeList(newDataSheetDetailViewRepository.
				findByClassIdAndSubClassIdAndHeaderAttributeSequenceNo(classId, subClassId, min));
		model.setRevision(BigDecimal.ONE);
		model.setStatus(BigDecimal.ONE);
		return model;
	}

	private MmrDataSheetUtModel getHeaderWiseBaseAttributeList(List<MmrNewDataSheetDetailView> list) {
		//		MmrDataTestSheetDetailUtViewModel modelView = new MmrDataTestSheetDetailUtViewModel();
		Map<Long,MmrDataSheetHeaderModel> mapHeaderToDetail = new LinkedHashMap<Long,MmrDataSheetHeaderModel>();
		Map<Long,MmrDataSheetDetailUtModel> mapListViewDetail = new LinkedHashMap<Long,MmrDataSheetDetailUtModel>();
		MmrDataSheetUtModel  dataSheetUtModel =null;
		for(MmrNewDataSheetDetailView detailView : list) {
			if(mapHeaderToDetail.containsKey(detailView.getHeaderAttributeId())){
				MmrDataSheetDetailUtModel dataSheetDetailUtModel =datasheetDetailMapping(detailView,mapListViewDetail);
				if(dataSheetDetailUtModel!=null) {
					mapHeaderToDetail.get(detailView.getHeaderAttributeId()).addDataSheetDetails(datasheetDetailMapping(detailView,mapListViewDetail));
				}
			}else {
				if(dataSheetUtModel==null) {
					dataSheetUtModel = new MmrDataSheetUtModel();
					dataSheetUtModel.setDataSheetId(detailView.getDataSheetUtId());
					dataSheetUtModel.setClassId(detailView.getClassId());
					dataSheetUtModel.setSubclassId(detailView.getSubClassId());
					dataSheetUtModel.setTestSheetId(detailView.getTestSheetId());
					long max =newDataSheetDetailViewRepository.getMaxHeaderCount(detailView.getClassId(), detailView.getSubClassId());
					long min =newDataSheetDetailViewRepository.getMinHeaderCount(detailView.getClassId(), detailView.getSubClassId());
					long nextHeader=min+1;
					if(nextHeader>max) {
						nextHeader=min;
					}
					dataSheetUtModel.setCurrentSequenceNo(min);
					dataSheetUtModel.setHeaderAttributeSequenceNo(nextHeader);
					dataSheetUtModel.setMinHeaders(min);
					dataSheetUtModel.setMaxHeaders(max);
				}
				MmrDataSheetHeaderModel headerModel= new MmrDataSheetHeaderModel();
				headerModel.setHeaderAttributeId(detailView.getHeaderAttributeId());
				headerModel.setHeaderAttributeName(detailView.getHeaderAttributeName());
				MmrDataSheetDetailUtModel dataSheetDetailUtModel =datasheetDetailMapping(detailView,mapListViewDetail);
				if(dataSheetDetailUtModel!=null) {
					headerModel.addDataSheetDetails(datasheetDetailMapping(detailView,mapListViewDetail));
				}
				mapHeaderToDetail.put(headerModel.getHeaderAttributeId(),headerModel);
			}
		}
		for (MmrDataSheetDetailUtModel listViewModel : mapListViewDetail.values()) {
			mapHeaderToDetail.get(listViewModel.getHeaderAttributeId()).addDataSheetDetails(listViewModel);
		}
		List<MmrDataSheetHeaderModel> result=new ArrayList(mapHeaderToDetail.values());
		dataSheetUtModel.setDataSheetHeaderDetails(result);
		return dataSheetUtModel;
	}

	private MmrDataSheetDetailUtModel datasheetDetailMapping(MmrNewDataSheetDetailView detailView,
			Map<Long, MmrDataSheetDetailUtModel> mapListViewDetail) {
		MmrDataSheetDetailUtModel dataSheetDetailUtModel =new MmrDataSheetDetailUtModel(detailView);
		if(detailView.getInputDataTypeName().equalsIgnoreCase("Table")) {
			mappingForDataTypeTable(dataSheetDetailUtModel,mapListViewDetail);
			dataSheetDetailUtModel=null;
		}else if(detailView.getInputDataTypeName().equalsIgnoreCase("Integer Number") || 
				detailView.getInputDataTypeName().equalsIgnoreCase("Decimal Number")) {
			mappingForDataSOMListView(dataSheetDetailUtModel,mapListViewDetail);
			dataSheetDetailUtModel=null;
		}else {
			mappingForDataTypeDropdown(dataSheetDetailUtModel);
			mappingForDataTypeRadio(dataSheetDetailUtModel);
		}
		return dataSheetDetailUtModel;
	}

	private void mappingForDataSOMListView(MmrDataSheetDetailUtModel dataSheetDetailUtModel, 
			Map<Long, MmrDataSheetDetailUtModel> mapListViewDetail) {
		 
		
			MmrDataSheetDetailListViewUtModel viewModel= new MmrDataSheetDetailListViewUtModel();
			viewModel.setBaseAttribute(dataSheetDetailUtModel);
			
			MmrDataSheetDetailUtModel supplierLhs = new MmrDataSheetDetailUtModel();
			Random ran = new Random();
			int x = ran.nextInt(1000) + 5;
			supplierLhs.setBaseAttributeId(x);
			supplierLhs.setMmrDataTypeMasterUt(MetalsaConstant.DATA_TYPE_TEXT);
			supplierLhs.setFrontDataType(MetalsaConstant.FRONTEND_DATA_TYPE_TEXT);
			supplierLhs.setTestingInformation(dataSheetDetailUtModel.getSupplierInformationLhs());
			
			MmrDataSheetDetailUtModel supplierOperator = new MmrDataSheetDetailUtModel();
			int y = ran.nextInt(1000) + 5;
			supplierOperator.setBaseAttributeId(y);
			supplierOperator.setMmrDataTypeMasterUt(MetalsaConstant.DATA_TYPE_DROPDOWN);
			supplierOperator.setFrontDataType(MetalsaConstant.FRONTEND_DATA_TYPE_DROPDOWN);
			supplierOperator.setDropDownValues(MetalsaConstant.SUPPLIER_DROPDOWN);
			supplierOperator.setTestingInformation(dataSheetDetailUtModel.getSupplierInformationOperator());
			
			MmrDataSheetDetailUtModel supplierRhs = new MmrDataSheetDetailUtModel();
			int z = ran.nextInt(1000) + 5;
			supplierRhs.setBaseAttributeId(z);
			supplierRhs.setMmrDataTypeMasterUt(MetalsaConstant.DATA_TYPE_TEXT);
			supplierRhs.setFrontDataType(MetalsaConstant.FRONTEND_DATA_TYPE_TEXT);
			supplierRhs.setTestingInformation(dataSheetDetailUtModel.getSupplierInformationRhs());
			
			viewModel.getSupplierInfo().add(supplierLhs); 
			viewModel.getSupplierInfo().add(supplierOperator); 
			viewModel.getSupplierInfo().add(supplierRhs); 
			MmrDataSheetDetailUtModel parentModel =null;
			if(mapListViewDetail.containsKey(dataSheetDetailUtModel.getHeaderAttributeId())) {
				mapListViewDetail.get(dataSheetDetailUtModel.getHeaderAttributeId()).getListviewData().add(viewModel);
			}else {
				parentModel = new MmrDataSheetDetailUtModel();
				parentModel.setHeaderAttributeId(dataSheetDetailUtModel.getHeaderAttributeId());
				parentModel.setHeadings(MetalsaConstant.LISTVIEW_HEADER_DATA);
				parentModel.setMmrDataTypeMasterUt(MetalsaConstant.DATA_TYPE_LISTVIEW);
				parentModel.setFrontDataType(MetalsaConstant.DATA_TYPE_LISTVIEW);
				parentModel.getListviewData().add(viewModel);
				mapListViewDetail.put(dataSheetDetailUtModel.getHeaderAttributeId(), parentModel);
			}
		
	}

	private void mappingForDataTypeTable(MmrDataSheetDetailUtModel dataSheetDetailUtModel, Map<Long, MmrDataSheetDetailUtModel> mapListViewDetail) {
		if(dataSheetDetailUtModel.getMmrDataTypeMasterUt().equalsIgnoreCase("Table")) {
			MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt = baseAttributeRepository.findById(dataSheetDetailUtModel.getBaseAttributeId())
	    			.orElseThrow(() -> new ExceptionHandler("BaseAttributeMasterUt", "id", dataSheetDetailUtModel.getBaseAttributeId()));
			MmrBaseAttributeMasterUtModel baseAttributeMasterUtModel = baseAttributeService.getOne(mmrBaseAttributeMasterUt);
			for (MmrBaseAttributeTableDataTypeUtModel tableDataType : baseAttributeMasterUtModel.getMmrBaseAttributeTableDataTypeUts()) {
				MmrDataSheetDetailUtModel dataSheetDetailTableType = new MmrDataSheetDetailUtModel(tableDataType);
				dataSheetDetailUtModel.getTableLayoutValue().add(dataSheetDetailTableType);
			}
			MmrDataSheetDetailListViewUtModel viewModel= new MmrDataSheetDetailListViewUtModel();
			viewModel.setBaseAttribute(dataSheetDetailUtModel);
			
			MmrDataSheetDetailUtModel supplierInfo = new MmrDataSheetDetailUtModel();
			Random ran = new Random();
			int x = ran.nextInt(1000) + 5;
			supplierInfo.setBaseAttributeId(x);
			supplierInfo.setMmrDataTypeMasterUt(dataSheetDetailUtModel.getMmrDataTypeMasterUt());
			supplierInfo.setFrontDataType(dataSheetDetailUtModel.getFrontDataType());
			supplierInfo.setTableLayoutValue(dataSheetDetailUtModel.getTableLayoutValue());
			viewModel.getSupplierInfo().add(supplierInfo);
			MmrDataSheetDetailUtModel parentModel =null;
			if(mapListViewDetail.containsKey(dataSheetDetailUtModel.getHeaderAttributeId())) {
				mapListViewDetail.get(dataSheetDetailUtModel.getHeaderAttributeId()).getListviewData().add(viewModel);
			}else {
				parentModel = new MmrDataSheetDetailUtModel();
				parentModel.setHeaderAttributeId(dataSheetDetailUtModel.getHeaderAttributeId());
				parentModel.setHeadings(MetalsaConstant.LISTVIEW_HEADER_DATA);
				parentModel.setMmrDataTypeMasterUt(MetalsaConstant.DATA_TYPE_LISTVIEW);
				parentModel.setFrontDataType(MetalsaConstant.DATA_TYPE_LISTVIEW);
				parentModel.getListviewData().add(viewModel);
				mapListViewDetail.put(dataSheetDetailUtModel.getHeaderAttributeId(), parentModel);
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
		MmrDataSheetUtModel	mmrDataSheetUtModel = new MmrDataSheetUtModel();
		mmrDataSheetUtModel.setMaxHeaders(model.getMaxHeaders());
		mmrDataSheetUtModel.setMinHeaders(model.getMinHeaders());
		if(model.getTraverseFlag()==null) {
			throw new ExceptionHandler("Traverse Flag", "is", "null"); 
		}
		if(model.getAction()==null) {
			throw new ExceptionHandler("Action ", "is", "either SAVE or VIEW or Update"); 
		}
		if(model.getTraverseFlag().equalsIgnoreCase("N")) {
			MmrDataSheetUt dataSheetUt = mappingDataSheet(model);
			if(!model.getAction().equalsIgnoreCase("View")){
				dataSheetRepository.save(dataSheetUt);
			}
			BeanUtils.copyProperties(dataSheetUt,mmrDataSheetUtModel);
			mmrDataSheetUtModel.setDataSheetId(dataSheetUt.getId());
			long nextHeader=0;
			if(model.getMaxHeaders()==(model.getCurrentSequenceNo())) {
				nextHeader=model.getCurrentSequenceNo();
			}else {
				nextHeader=model.getCurrentSequenceNo()+1;
			}
			/*if(nextHeader>=model.getMaxHeaders()) {
				nextHeader=model.getMaxHeaders();
				throw new ExceptionHandler("Max Header", "is", "Reached");
			}*/
			mmrDataSheetUtModel.setCurrentSequenceNo(nextHeader);
			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(nextHeader);
			MmrDataSheetUtModel	nextModel=null;
			if(model.getAction().equalsIgnoreCase("View")|| model.getDataSheetId()!=0) {
				List<MmrNewDataSheetDetailView> listNew = convertEditListtoNewList(mmrDataSheetUtModel, dataSheetUt);
				if(null!=listNew && listNew.isEmpty()) {
					nextModel= getHeaderWiseBaseAttributeList(
							newDataSheetDetailViewRepository.findByClassIdAndSubClassIdAndHeaderAttributeSequenceNo(
									model.getClassId(), model.getSubclassId(), nextHeader));
				}else {
					nextModel= getHeaderWiseBaseAttributeList(listNew);
				}
			}else {
				nextModel= getHeaderWiseBaseAttributeList(
						newDataSheetDetailViewRepository.findByClassIdAndSubClassIdAndHeaderAttributeSequenceNo(
								model.getClassId(), model.getSubclassId(), nextHeader));
				
			}
			mmrDataSheetUtModel.getDataSheetHeaderDetails().addAll(nextModel.getDataSheetHeaderDetails());
		}else {
			
			MmrDataSheetUt dataSheetUt= dataSheetRepository.findById(model.getDataSheetId())
			        .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", model.getDataSheetId()));
//			MmrDataSheetUtModel	mmrDataSheetUtModel = new MmrDataSheetUtModel();
			BeanUtils.copyProperties(dataSheetUt,mmrDataSheetUtModel);
			mmrDataSheetUtModel.setDataSheetId(dataSheetUt.getId());
			long prevHeader=0;
			if(model.getMinHeaders()==(model.getCurrentSequenceNo())) {
				prevHeader=model.getCurrentSequenceNo();
			}else {
				prevHeader=model.getCurrentSequenceNo()-1;
			}

			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(prevHeader+1);
			mmrDataSheetUtModel.setCurrentSequenceNo(prevHeader);
			List<MmrNewDataSheetDetailView> listNew = convertEditListtoNewList(mmrDataSheetUtModel, dataSheetUt);
			MmrDataSheetUtModel	nextModel= getHeaderWiseBaseAttributeList(listNew);
			mmrDataSheetUtModel.getDataSheetHeaderDetails().addAll(nextModel.getDataSheetHeaderDetails());
		}
		
		return mmrDataSheetUtModel;
	}

	private List<MmrNewDataSheetDetailView> convertEditListtoNewList(MmrDataSheetUtModel model,
			MmrDataSheetUt dataSheetUt) {
		List<MmrNewDataSheetDetailView> listNew = new ArrayList<>();
		List<MmrEditDataSheetDetailView> listEdit = editDataSheetDetailViewRepository.
				findByDataSheetUtIdAndHeaderAttributeSequenceNo(dataSheetUt.getId(), model.getCurrentSequenceNo());

		for (MmrEditDataSheetDetailView mmrEditDataSheetDetailView : listEdit) {
			MmrNewDataSheetDetailView newView= new MmrNewDataSheetDetailView();
			BeanUtils.copyProperties(mmrEditDataSheetDetailView, newView);
			listNew.add(newView);
		}
		return listNew;
	}

	 

	private MmrDataSheetUt mappingDataSheet(MmrDataSheetUtModel model) {
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
		if(model.getStatus().equals(new BigDecimal(2))) {
		dataSheetUt.setIssubmitted("Yes");
		}else{
			dataSheetUt.setIssubmitted("No");
		}
		List<MmrDataSheetDetailUt> dataSheetDetailUts = new ArrayList<>();
		for (MmrDataSheetHeaderModel dataSheetHeaderModel : model.getDataSheetHeaderDetails()) {

			for (MmrDataSheetDetailUtModel sheetDetailUtModel : dataSheetHeaderModel.getDataSheetDetails()) {
				
				
				if(sheetDetailUtModel.getListviewData().size()==0) {
					MmrDataSheetDetailUt dataSheetDetailUt = mappingDataSheetDetailForSave(model, dataSheetUt,
							sheetDetailUtModel);
					dataSheetDetailUts.add(dataSheetDetailUt);
				}else {
					
					for (MmrDataSheetDetailListViewUtModel mmrDataSheetDetailUt : sheetDetailUtModel.getListviewData()) {
						
						MmrDataSheetDetailUt dataSheetDetailUt = mappingDataSheetDetailForListView(model, dataSheetUt,
								mmrDataSheetDetailUt);
						dataSheetDetailUts.add(dataSheetDetailUt);
					}
				}
				
			}

		}
		dataSheetUt.setMmrDataSheetDetailUts(dataSheetDetailUts);
		return dataSheetUt;
	}

	private MmrDataSheetDetailUt mappingDataSheetDetailForSave(MmrDataSheetUtModel model, MmrDataSheetUt dataSheetUt,
			MmrDataSheetDetailUtModel sheetDetailUtModel) {
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
		if(sheetDetailUtModel.getBaseAttributeName().equalsIgnoreCase(MetalsaConstant.METALSA_DESIGNATION)) {
			dataSheetUt.setDataSheetName(sheetDetailUtModel.getTestingInformation());
		}
		dataSheetDetailUt.setCreatedBy(model.getCreatedBy());
		dataSheetDetailUt.setModifiedBy(sheetDetailUtModel.getModifiedBy());
		dataSheetDetailUt.setStatus(model.getStatus());
		dataSheetDetailUt.setSupplierInformationLhs(sheetDetailUtModel.getSupplierInformationLhs());
		dataSheetDetailUt.setSupplierInformationRhs(sheetDetailUtModel.getSupplierInformationRhs());
		dataSheetDetailUt.setSupplierInformationOperator(sheetDetailUtModel.getSupplierInformationOperator());
		dataSheetDetailUt.setSupplierInformationTableType(sheetDetailUtModel.getSupplierInformationTableType());
		if(sheetDetailUtModel.getTestingInformation()!=null) {
			dataSheetDetailUt.setTestingInformation(sheetDetailUtModel.getTestingInformation());
		}else {
			dataSheetDetailUt.setTestingInformation("NA");
		}
		dataSheetDetailUt.setTestingInformationTableType(sheetDetailUtModel.getTestingInformationTableType());
		dataSheetDetailUt.setTestSheetDetailId(sheetDetailUtModel.getTestSheetDetailId());
		dataSheetDetailUt.setUserSelectUom(sheetDetailUtModel.getUserSelectUom());
		//TODO
		dataSheetDetailUt.setUserUom1("");
		dataSheetDetailUt.setUserUom2("");
		return dataSheetDetailUt;
	}
	private MmrDataSheetDetailUt mappingDataSheetDetailForListView(MmrDataSheetUtModel model, MmrDataSheetUt dataSheetUt,
			MmrDataSheetDetailListViewUtModel mmrDataSheetDetailUt) {
		MmrDataSheetDetailUt dataSheetDetailUt = null;
		if(0l!= mmrDataSheetDetailUt.getBaseAttribute().getDataSheetDetailId()) {
			dataSheetDetailUt = getDataSheetDetailById(dataSheetUt.getMmrDataSheetDetailUts(),
					mmrDataSheetDetailUt.getBaseAttribute().getDataSheetDetailId());
			if (null==dataSheetDetailUt){
				dataSheetDetailUt = new MmrDataSheetDetailUt();
			}
		}else {
			dataSheetDetailUt = new MmrDataSheetDetailUt();
		}
		//BeanUtils.copyProperties(sheetDetailUtModel, dataSheetDetailUt,new String[]{"id"});
		dataSheetDetailUt.setCreatedBy(model.getCreatedBy());
		dataSheetDetailUt.setModifiedBy(mmrDataSheetDetailUt.getBaseAttribute().getModifiedBy());
		dataSheetDetailUt.setStatus(model.getStatus());
		dataSheetDetailUt.setSupplierInformationLhs(mmrDataSheetDetailUt.getSupplierInfo().get(0).getTestingInformation());
		dataSheetDetailUt.setSupplierInformationOperator(mmrDataSheetDetailUt.getSupplierInfo().get(1).getTestingInformation());
		dataSheetDetailUt.setSupplierInformationRhs(mmrDataSheetDetailUt.getSupplierInfo().get(2).getTestingInformation());
		dataSheetDetailUt.setSupplierInformationTableType(mmrDataSheetDetailUt.getSupplierInfo().get(0).getTestingInformationTableType());
		dataSheetDetailUt.setTestingInformationTableType(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformationTableType());
		dataSheetDetailUt.setTestSheetDetailId(mmrDataSheetDetailUt.getBaseAttribute().getTestSheetDetailId());
		dataSheetDetailUt.setUserSelectUom(mmrDataSheetDetailUt.getBaseAttribute().getIsPrimary());
		if(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation()!=null) {
			dataSheetDetailUt.setTestingInformation(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation());
			calculateConversion(mmrDataSheetDetailUt, dataSheetDetailUt);
		}else {
			dataSheetDetailUt.setTestingInformation("NA");
		}
		//TODO
//		dataSheetDetailUt.setUserUom1("");
//		dataSheetDetailUt.setUserUom2("");
		return dataSheetDetailUt;
	}

	private void calculateConversion(MmrDataSheetDetailListViewUtModel mmrDataSheetDetailUt,
			MmrDataSheetDetailUt dataSheetDetailUt) {
		if(MetalsaConstant.SOM1.equals(dataSheetDetailUt.getUserSelectUom()) && 
				MetalsaConstant.SOM1.equals(mmrDataSheetDetailUt.getBaseAttribute().getIsPrimary())) {
			dataSheetDetailUt.setTestingInformation(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation());
			dataSheetDetailUt.setUserUom1(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation());
			if(mmrDataSheetDetailUt.getBaseAttribute().getSom1ConversionFactor()!=null && mmrDataSheetDetailUt.getBaseAttribute().getSom1ConversionFactor().contains("/") ) {
				BigDecimal cal=new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation()).
						divide(new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getSom1ConversionFactor().split("/")[1]));
				dataSheetDetailUt.setUserUom2(cal+"");
			}
			if(mmrDataSheetDetailUt.getBaseAttribute().getSom1ConversionFactor()!=null &&
					mmrDataSheetDetailUt.getBaseAttribute().getSom1ConversionFactor().contains("*") ) {
				BigDecimal cal=new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation()).
						multiply(new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getSom1ConversionFactor().split("*")[1]));
				dataSheetDetailUt.setUserUom2(cal+"");
			}
		}else {
			dataSheetDetailUt.setTestingInformation(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation());
			dataSheetDetailUt.setUserUom2(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation());
			if(mmrDataSheetDetailUt.getBaseAttribute().getSom2ConversionFactor()!=null 
					&& mmrDataSheetDetailUt.getBaseAttribute().getSom2ConversionFactor().contains("/") ) {
				BigDecimal cal=new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation()).
						divide(new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getSom2ConversionFactor().split("/")[1]));
				dataSheetDetailUt.setUserUom1(cal+"");
			}
			if(mmrDataSheetDetailUt.getBaseAttribute().getSom2ConversionFactor()!=null &&
					mmrDataSheetDetailUt.getBaseAttribute().getSom2ConversionFactor().contains("*") ) {
				BigDecimal cal=new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getTestingInformation()).
						multiply(new BigDecimal(mmrDataSheetDetailUt.getBaseAttribute().getSom2ConversionFactor().split("*")[1]));
				dataSheetDetailUt.setUserUom1(cal+"");
			}
		}
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
		
//		return getEditHeaderWiseBaseAttributeList(editDataSheetDetailViewRepository.findByDataSheetUtId(dataSheetUt.getId()));
		List<MmrNewDataSheetDetailView> listNew = new ArrayList<>();
		List<MmrEditDataSheetDetailView> listEdit = editDataSheetDetailViewRepository.findByDataSheetUtId(dataSheetUt.getId());

		for (MmrEditDataSheetDetailView mmrEditDataSheetDetailView : listEdit) {
			MmrNewDataSheetDetailView newView= new MmrNewDataSheetDetailView();
			BeanUtils.copyProperties(mmrEditDataSheetDetailView, newView);
			listNew.add(newView);
		}
		return getHeaderWiseBaseAttributeList(listNew);
	}

	private MmrDataSheetUtModel getEditHeaderWiseBaseAttributeList(List<MmrEditDataSheetDetailView> list) {
		//		MmrDataTestSheetDetailUtViewModel modelView = new MmrDataTestSheetDetailUtViewModel();
		MmrDataSheetUtModel  dataSheetUtModel =null;
/*		Map<Long,MmrDataSheetHeaderModel> mapHeaderToDetail = new LinkedHashMap<Long,MmrDataSheetHeaderModel>();
		Map<Long,MmrDataSheetDetailUtModel> mapListViewDetail = new LinkedHashMap<Long,MmrDataSheetDetailUtModel>();
		for(MmrEditDataSheetDetailView detailView : list) {
			if(mapHeaderToDetail.containsKey(detailView.getHeaderAttributeId())){
				MmrNewDataSheetDetailView newDatasheetView = new MmrNewDataSheetDetailView();
				BeanUtils.copyProperties(detailView,newDatasheetView);
				MmrDataSheetDetailUtModel dataSheetDetailUtModel =datasheetDetailMapping(detailView,mapListViewDetail);
				if(dataSheetDetailUtModel!=null) {
					mapHeaderToDetail.get(detailView.getHeaderAttributeId()).addDataSheetDetails(datasheetDetailMapping(detailView,mapListViewDetail));
				}
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
				MmrDataSheetDetailUtModel dataSheetDetailUtModel =datasheetDetailMapping(detailView,mapListViewDetail);
				if(dataSheetDetailUtModel!=null) {
					headerModel.addDataSheetDetails(datasheetDetailMapping(detailView,mapListViewDetail));
				}
				mapHeaderToDetail.put(headerModel.getHeaderAttributeId(),headerModel);
			}
		}
		for (MmrDataSheetDetailUtModel listViewModel : mapListViewDetail.values()) {
			mapHeaderToDetail.get(listViewModel.getHeaderAttributeId()).addDataSheetDetails(listViewModel);
		}
		List<MmrDataSheetHeaderModel> result=new ArrayList(mapHeaderToDetail.values());
		dataSheetUtModel.setDataSheetHeaderDetails(result);
*/		return dataSheetUtModel;
	}

	@Override
	public MmrDataSheetUtModel getEditDatasheet(@Valid MmrDataSheetUtModel model) {
		
		MmrDataSheetUtModel mmrDataSheetUtModel = model;
		MmrDataSheetUtModel	nextModel=null;
		if(model.getMaxHeaders()==null){
			long max =editDataSheetDetailViewRepository.getMaxHeaderCount(model.getDataSheetId());
			mmrDataSheetUtModel.setMaxHeaders(max);
		}
		if(model.getMinHeaders()==null){
			long min =editDataSheetDetailViewRepository.getMinHeaderCount(model.getDataSheetId());
			mmrDataSheetUtModel.setMinHeaders(min);
		}
		if(model.getCurrentSequenceNo()==null){
			mmrDataSheetUtModel.setCurrentSequenceNo(0l);
		}
		if(model.getTraverseFlag()==null) {
			throw new ExceptionHandler("Traverse Flag", "is", "null"); 
		}
		MmrDataSheetUt dataSheetUt= dataSheetRepository.findById(model.getDataSheetId())
		        .orElseThrow(() -> new ExceptionHandler("MmrDataSheetUt", "id", model.getDataSheetId()));
//		MmrDataSheetUtModel	mmrDataSheetUtModel = new MmrDataSheetUtModel();
		if(model.getTraverseFlag().equals("N")) {
			long nextHeader=0;
			if(model.getMaxHeaders()==(model.getCurrentSequenceNo())) {
				nextHeader=model.getCurrentSequenceNo();
			}else {
				nextHeader=model.getCurrentSequenceNo()+1;
			}
			mmrDataSheetUtModel.setCurrentSequenceNo(nextHeader);
			List<MmrNewDataSheetDetailView> listNew = new ArrayList<>();
			List<MmrEditDataSheetDetailView> listEdit = editDataSheetDetailViewRepository.
					findByDataSheetUtIdAndHeaderAttributeSequenceNo(model.getDataSheetId(), nextHeader);

			for (MmrEditDataSheetDetailView mmrEditDataSheetDetailView : listEdit) {
				MmrNewDataSheetDetailView newView= new MmrNewDataSheetDetailView();
				BeanUtils.copyProperties(mmrEditDataSheetDetailView, newView);
				listNew.add(newView);
			}
//			model.setHeaderAttributeSequenceNo(nextHeader);
			nextModel= getHeaderWiseBaseAttributeList(listNew);
			BeanUtils.copyProperties(dataSheetUt,mmrDataSheetUtModel);
			mmrDataSheetUtModel.setDataSheetId(dataSheetUt.getId());
//			mmrDataSheetUtModel.setCurrentSequenceNo(mmrDataSheetUtModel.getHeaderAttributeSequenceNo());
//			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(nextHeader);
//			mmrDataSheetUtModel.setMaxHeaders(model.getMaxHeaders());
//			mmrDataSheetUtModel.setMinHeaders(model.getMinHeaders());
			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(nextHeader);
			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(mmrDataSheetUtModel.getHeaderAttributeSequenceNo());
			mmrDataSheetUtModel.getDataSheetHeaderDetails().clear();
			mmrDataSheetUtModel.getDataSheetHeaderDetails().addAll(nextModel.getDataSheetHeaderDetails());
		}else {
			
			long prevHeader=0;
			if(model.getMinHeaders()==(model.getCurrentSequenceNo())) {
				prevHeader=model.getCurrentSequenceNo();
			}else {
				prevHeader=model.getCurrentSequenceNo()-1;
			}

			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(prevHeader+1);
			mmrDataSheetUtModel.setCurrentSequenceNo(prevHeader);
//			long prevHeader;
//			if(mmrDataSheetUtModel.getMinHeaders()==(mmrDataSheetUtModel.getHeaderAttributeSequenceNo())) {
//				prevHeader=mmrDataSheetUtModel.getHeaderAttributeSequenceNo();
//			}else {
//				prevHeader=mmrDataSheetUtModel.getHeaderAttributeSequenceNo()-1;
//			}
//			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(prevHeader);
			List<MmrNewDataSheetDetailView> listNew = new ArrayList<>();
			List<MmrEditDataSheetDetailView> listEdit = editDataSheetDetailViewRepository.
					findByDataSheetUtIdAndHeaderAttributeSequenceNo(model.getDataSheetId(), prevHeader);

			for (MmrEditDataSheetDetailView mmrEditDataSheetDetailView : listEdit) {
				MmrNewDataSheetDetailView newView= new MmrNewDataSheetDetailView();
				BeanUtils.copyProperties(mmrEditDataSheetDetailView, newView);
				listNew.add(newView);
			}
			nextModel= getHeaderWiseBaseAttributeList(listNew);
			BeanUtils.copyProperties(dataSheetUt,mmrDataSheetUtModel);
			mmrDataSheetUtModel.setDataSheetId(dataSheetUt.getId());
			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(prevHeader);
//			mmrDataSheetUtModel.setMaxHeaders(model.getMaxHeaders());
//			mmrDataSheetUtModel.setMinHeaders(model.getMinHeaders());
			mmrDataSheetUtModel.setHeaderAttributeSequenceNo(prevHeader);
			mmrDataSheetUtModel.getDataSheetHeaderDetails().clear();
			mmrDataSheetUtModel.getDataSheetHeaderDetails().addAll(nextModel.getDataSheetHeaderDetails());
		}
		 
		return mmrDataSheetUtModel;
	}

	@Override
	public String getNewRevisonNumber(Long classId, Long subClassId, Long regionId) {
		
		return null;
	}


}
