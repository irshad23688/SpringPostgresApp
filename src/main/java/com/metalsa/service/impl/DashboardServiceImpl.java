package com.metalsa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.metalsa.domain.MmrHeaderAttributeMasterUt;
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
	
		dashboardModel.setDatasheetPendingList(customRepository.findDatasheetByStatus(new BigDecimal(1)));
		dashboardModel.setDatasheetHistory(customRepository.getDatasheetForDashboard(userId));
		dashboardModel.setPendingListCount(dashboardModel.getDatasheetPendingList().size());
		
		return dashboardModel;
	}
}
