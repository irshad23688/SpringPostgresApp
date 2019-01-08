package com.metalsa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;
import com.metalsa.domain.MmrTestSheetDetailUtView;
import com.metalsa.domain.MmrTestSheetUt;
import com.metalsa.exception.ExceptionHandler;
import com.metalsa.model.MmrClassMasterUtModel;
import com.metalsa.model.MmrHeaderAttributeMasterUtModel;
import com.metalsa.model.MmrSubClassMasterUtModel;
import com.metalsa.model.MmrTestSheetDetailUtViewModel;
import com.metalsa.model.MmrTestSheetUtModel;
import com.metalsa.repository.ClassRepository;
import com.metalsa.repository.SubClassRepository;
import com.metalsa.repository.TestSheetDetailUtViewRepository;
import com.metalsa.repository.TestSheetRepository;
import com.metalsa.service.TestSheetService;

@Service
public class TestSheetServiceImpl implements TestSheetService {

	@Autowired
	private TestSheetRepository testSheetRepository;

	@Autowired
    private ClassRepository classRepository;
    
    @Autowired
    private SubClassRepository subClassRepository;
    
    @Autowired
    private TestSheetDetailUtViewRepository detailUtViewRepository;
    
	@Override
	public List<MmrTestSheetUtModel> getAll() {
		List<MmrTestSheetUtModel> modelList = new ArrayList<>();
    	for(MmrTestSheetUt mmrTestSheetUt: testSheetRepository.findAll()) {
    		MmrTestSheetUtModel modelTestSheet = getOne(mmrTestSheetUt);
    		modelList.add(modelTestSheet);
    	}
		return modelList;
	}
	
	@Override
	public MmrTestSheetUtModel getOne(MmrTestSheetUt mmrTestSheetUt) {
		return  setBaseAttributeDataForUI(mmrTestSheetUt);
	}

	private MmrTestSheetUtModel setBaseAttributeDataForUI(MmrTestSheetUt mmrTestSheetUt) {
		MmrTestSheetUtModel modelTestSheet= new MmrTestSheetUtModel();
		BeanUtils.copyProperties(mmrTestSheetUt, modelTestSheet);
		MmrClassMasterUt classMaster = classRepository.findById(mmrTestSheetUt.getMmrClassMasterUt())
		            .orElseThrow(() -> new ExceptionHandler("MmrClassMasterUt", "id", mmrTestSheetUt.getMmrClassMasterUt()));
		MmrClassMasterUtModel modelClass = new MmrClassMasterUtModel();
		BeanUtils.copyProperties(classMaster, modelClass);
		modelTestSheet.setMmrClassMasterUt(modelClass);
		MmrSubClassMasterUt subClassMaster = subClassRepository.findById(mmrTestSheetUt.getMmrSubclassMasterUt())
				.orElseThrow(() -> new ExceptionHandler("MmrSubclassMasterUt", "id", mmrTestSheetUt.getMmrClassMasterUt()));
		MmrSubClassMasterUtModel modelSubClass = new MmrSubClassMasterUtModel();
		BeanUtils.copyProperties(subClassMaster, modelSubClass);
		modelTestSheet.setMmrSubclassMasterUt(modelSubClass);
		return modelTestSheet;
	}

	@Override
	public MmrTestSheetDetailUtViewModel getTestSheetDetail(Long testSheetId) {
		MmrTestSheetDetailUtViewModel modelView = new MmrTestSheetDetailUtViewModel();
		Map<Long,MmrHeaderAttributeMasterUtModel> mapHeaderToDetail = new HashMap<Long,MmrHeaderAttributeMasterUtModel>();
		for(MmrTestSheetDetailUtView detailView : detailUtViewRepository.findByTestSheetDetail(testSheetId)) {
			if(mapHeaderToDetail.containsKey(detailView.getHeaderAttributeId())){
				mapHeaderToDetail.get(detailView.getHeaderAttributeId()).addTestSheetDetailUtView(detailView);
			}else {
				MmrHeaderAttributeMasterUtModel headerModel= new MmrHeaderAttributeMasterUtModel();
				headerModel.setId(detailView.getHeaderAttributeId());
				headerModel.setName(detailView.getHeaderAttributeName());
				headerModel.addTestSheetDetailUtView(detailView);
				mapHeaderToDetail.put(detailView.getHeaderAttributeId(),headerModel);
			}
		}
		List<MmrHeaderAttributeMasterUtModel> result=new ArrayList(mapHeaderToDetail.values());
		modelView.setHeaderAttributeDetail(result);
		return modelView;
	}

	 
	

	 


}
