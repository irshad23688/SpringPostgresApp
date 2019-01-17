package com.metalsa.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrBaseAttributeMasterUt;
import com.metalsa.domain.MmrCompareDataSheetView;
import com.metalsa.domain.MmrHeaderAttributeMasterUt;
import com.metalsa.domain.MmrSearchDataSheetView;
import com.metalsa.domain.MmrSysConfigUt;
import com.metalsa.model.CompareBaseModel;
import com.metalsa.model.CompareMaterialModel;
import com.metalsa.model.MmrCompareDataSheetModel;
import com.metalsa.model.ResultDataSheetModel;
import com.metalsa.model.SearchModel;
import com.metalsa.repository.CustomRepository;
import com.metalsa.repository.HeaderAttrRepository;
import com.metalsa.repository.SysConfigRepository;
import com.metalsa.service.SearchNCompareService;


@Service
public class SearchNCompareServiceImpl implements SearchNCompareService {

	@Autowired
	private HeaderAttrRepository headerAttrRepository;

	@Autowired
	private CustomRepository customRepository;

	@Autowired
	private SysConfigRepository sysConfigRepository;


	@Override
	public SearchModel getConfigParameters() {
		List textIds= new ArrayList<>();
		MmrSysConfigUt textBasedAtriIds =  sysConfigRepository.findByParamName("TEXT_BASED_BASE_ATTRIBUTE_IDS");
		if(null!= textBasedAtriIds) {
			textIds = Arrays.asList(textBasedAtriIds.getParamValue().split(","));
		}
		List rangeIds= new ArrayList<>();
		MmrSysConfigUt rangeBasedAtriIds =  sysConfigRepository.findByParamName("RANGE_BASED_BASE_ATTRIBUTE_IDS");
		if(null!= rangeBasedAtriIds) {
			rangeIds = Arrays.asList(rangeBasedAtriIds.getParamValue().split(","));
		}
		SearchModel model = new SearchModel();
		List<MmrHeaderAttributeMasterUt> textBasedHeader = new ArrayList<>();
		List<MmrHeaderAttributeMasterUt> rangeBaseHeader = new ArrayList<>();
		for (MmrHeaderAttributeMasterUt header : headerAttrRepository.findAll()) {
			List<MmrBaseAttributeMasterUt> textBaseAttribute = new ArrayList<>();
			List<MmrBaseAttributeMasterUt> rangeBaseAttribute = new ArrayList<>();
			for (MmrBaseAttributeMasterUt baseAttribute : header.getMmrBaseAttributeMasterUts()) {
				if(textIds.contains(baseAttribute.getMmrDataTypeMasterUt().getId()+"")){
					textBaseAttribute.add(baseAttribute);
				}
				if(rangeIds.contains(baseAttribute.getMmrDataTypeMasterUt().getId()+"")){
					rangeBaseAttribute.add(baseAttribute);
				}
			}
			MmrHeaderAttributeMasterUt textBase= new MmrHeaderAttributeMasterUt();
			BeanUtils.copyProperties(header, textBase);

			if(textBaseAttribute.size()>0){
				textBase.setMmrBaseAttributeMasterUts(textBaseAttribute);
			}else{
				textBase.setMmrBaseAttributeMasterUts(new ArrayList<>());
			}
			textBasedHeader.add(textBase);

			MmrHeaderAttributeMasterUt rangeBase=new MmrHeaderAttributeMasterUt();
			BeanUtils.copyProperties(header, rangeBase);
			if(rangeBaseAttribute.size()>0){
				rangeBase.setMmrBaseAttributeMasterUts(rangeBaseAttribute);
			}else {
				rangeBase.setMmrBaseAttributeMasterUts(new ArrayList<>());
			}
			rangeBaseHeader.add(rangeBase);
		}
		model.setRangeBaseHeader(rangeBaseHeader);
		model.setTextBasedHeader(textBasedHeader);
		return model;
	}

	@Override
	public SearchModel getSearchdata(final SearchModel model) {
		List<MmrSearchDataSheetView> results = customRepository.getSearchDataSheetView(model);
		final Map<Long,List<MmrSearchDataSheetView>> materialMap = new LinkedHashMap<>();

		for (MmrSearchDataSheetView viewObj : results) {
			if(0l!=viewObj.getDataSheetId()) {
				List<MmrSearchDataSheetView> lst=null;
				if(materialMap.keySet().contains(viewObj.getDataSheetId())){
					lst = materialMap.get(viewObj.getDataSheetId());
				}else {
					lst = new ArrayList<>();
				}
				lst.add(viewObj);
				materialMap.put(viewObj.getDataSheetId(),lst);
				model.getHeaderSet().add(viewObj.getBaseAttributeName());
			}
		}	
		List<ResultDataSheetModel> resultDataSheet= new ArrayList<>();
		for (Long dataSheetId : materialMap.keySet()) {

			ResultDataSheetModel modelResult = new ResultDataSheetModel();
			modelResult.setDataSheetId(dataSheetId);
			modelResult.setDataSheetIdList(materialMap.get(dataSheetId));
			resultDataSheet.add(modelResult);
		}
		model.setSearchDatamp(resultDataSheet);
		return model;
	}
	/*@Override
	public List<MmrCompareDataSheetModel> compareDataSheetByIds(List<Long> datasheetIds) {
		List<MmrCompareDataSheetView> list = customRepository.compareDataSheetByIds(datasheetIds);
		
		final Map<Long,Map<String, List<MmrCompareDataSheetView>>> mainDataMap = new LinkedHashMap<>();

		for (MmrCompareDataSheetView viewObj : list) {
			if(0l!=viewObj.getDataSheetId()) {
				Map<String, List<MmrCompareDataSheetView>> map = null;
				if(mainDataMap.keySet().contains(viewObj.getDataSheetId())){
					map = mainDataMap.get(viewObj.getDataSheetId());
					List< MmrCompareDataSheetView> lst = null;
					if(map.keySet().contains(viewObj.getHeaderName())) {
						lst = map.get(viewObj.getHeaderName());
					}else {
						lst = new ArrayList<>();
					}
					lst.add(viewObj);
					map.put(viewObj.getHeaderName(), lst);
				}else {
					List <MmrCompareDataSheetView>lst = new ArrayList<>();
					map = new LinkedHashMap<>();
					lst.add(viewObj);
					map .put(viewObj.getHeaderName(), lst);
				}
				mainDataMap.put(viewObj.getDataSheetId(), map);
			}
		}	
		
		List<MmrCompareDataSheetModel> resultDataSheet= new ArrayList<>();
		for (Long dataSheetId : mainDataMap.keySet()) {
			MmrCompareDataSheetModel modelResult = new MmrCompareDataSheetModel();
			modelResult.setDataSheetId(dataSheetId);
			List<CompareModel> compareModels = new ArrayList<>();
			for (String headerName : mainDataMap.get(dataSheetId).keySet()) {
				CompareModel compareModel = new CompareModel();
				compareModel.setHeaderName(headerName);
				compareModel.setCompareDataSheets(mainDataMap.get(dataSheetId).get(headerName));
				compareModels.add(compareModel);
			}
			
			modelResult.setHeaderDetails(compareModels);
			resultDataSheet.add(modelResult);
		}

		return resultDataSheet;
	}*/
	
	public List<MmrCompareDataSheetModel> compareDataSheetByIds(List<Long> datasheetIds) {
		List<MmrCompareDataSheetView> list = customRepository.compareDataSheetByIds(datasheetIds);
		
		Map <Long, String> headerMap = new LinkedHashMap<>(); 
		Map <Long, String> baseMap = new LinkedHashMap<>(); 
		Map<Long, List<String>> testingInfo = new LinkedHashMap<>();
		Map<Long, Set<Long>> headerBaseMap = new LinkedHashMap<>();

		for (MmrCompareDataSheetView viewObj : list) {
			if(0l!=viewObj.getDataSheetId()) {
				headerMap.put(viewObj.getHeaderAttributeId(), viewObj.getHeaderName());
				baseMap.put(viewObj.getBaseAttributeId(), viewObj.getBaseAttributeName());
				List< String> testinfoLst;
				if(testingInfo.keySet().contains(viewObj.getBaseAttributeId())) {
					testinfoLst = testingInfo.get(viewObj.getBaseAttributeId());
					testinfoLst.add(viewObj.getTestingInformation()+"|"+viewObj.getDataSheetId());
				}else {
					testinfoLst = new ArrayList<>();
					testinfoLst.add(viewObj.getTestingInformation()+"|"+viewObj.getDataSheetId());
				}
				testingInfo.put(viewObj.getBaseAttributeId(), testinfoLst);
				
				Set< Long> headerBaselst;
				if(headerBaseMap.keySet().contains(viewObj.getHeaderAttributeId())) {
					headerBaselst = headerBaseMap.get(viewObj.getHeaderAttributeId());
					headerBaselst.add(viewObj.getBaseAttributeId());
				}else {
					headerBaselst = new LinkedHashSet<>();
					headerBaselst.add(viewObj.getBaseAttributeId());
				}
				headerBaseMap.put(viewObj.getHeaderAttributeId(), headerBaselst);
				
			}
		}	
		
		List<MmrCompareDataSheetModel> mainLst = new ArrayList<>();
		
		for (Long headreId : headerBaseMap.keySet()) {
			MmrCompareDataSheetModel compareDataSheetModel = new MmrCompareDataSheetModel();
			compareDataSheetModel.setHeaderAttributeId(headreId);
			compareDataSheetModel.setHeaderAttributeName(headerMap.get(headreId));
			List baseModelLst = new ArrayList<CompareBaseModel>();
			for (Long baseId : headerBaseMap.get(headreId)) {
				CompareBaseModel baseModel = new CompareBaseModel();
				baseModel.setBaseAttributeId(baseId);
				baseModel.setBaseAttributeDefaultDisplayName(baseMap.get(baseId));
				List materialModelLst = new ArrayList<CompareMaterialModel>();
				for (String str : testingInfo.get(baseId)) {
					CompareMaterialModel compareMaterialModel = new CompareMaterialModel();
					List lt = Arrays.asList(str.split("\\|"));
					if(null!=lt.get(0)) {
						compareMaterialModel.setTestingInformation(lt.get(0)+"");
					}
					materialModelLst.add(compareMaterialModel);
				}
				baseModel.setMaterialValue(materialModelLst);
				baseModelLst.add(baseModel);
			}
			compareDataSheetModel.setBaseAttribute(baseModelLst);
			mainLst.add(compareDataSheetModel);
		}
		
		return mainLst;
		
	}
	 

}
