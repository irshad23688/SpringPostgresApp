package com.metalsa.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.metalsa.model.DashboardModel;
import com.metalsa.model.DataSheetDashboardModel;
import com.metalsa.repository.CustomRepository;
import com.metalsa.service.DashboardSevice;

@Service
@PropertySource("classpath:application.properties")
public class DashboardServiceImpl implements DashboardSevice {

	@Autowired
    private CustomRepository customRepository ;
	
    
	@Override
	public DashboardModel getDashboardData(BigDecimal userId) {
		
		DashboardModel dashboardModel = new DashboardModel();
	
		dashboardModel.setUserData(customRepository.findUserDetailsByUserId(userId.longValue()));
		dashboardModel.setDatasheetPendingList(customRepository.findDatasheetByStatus(new BigDecimal(2)));
		List<DataSheetDashboardModel> datasheetHistoryList = customRepository.getDatasheetForDashboard(userId);
		dashboardModel.setDatasheetHistory(datasheetHistoryList);
		dashboardModel.setPendingListCount(dashboardModel.getDatasheetPendingList().size());
		if(datasheetHistoryList.size()>0) {
			dashboardModel.setLastDesignation(datasheetHistoryList.get(0).getDatasheetName());
			dashboardModel.setLastUpdatedOn(datasheetHistoryList.get(0).getApprovedOn());
			
		}
		
		
		return dashboardModel;
	}
}
