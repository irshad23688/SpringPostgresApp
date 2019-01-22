package com.metalsa.service;

import java.math.BigDecimal;

import com.metalsa.model.DashboardModel;

public interface DashboardSevice {
	
	DashboardModel getDashboardData(BigDecimal userId);
}
