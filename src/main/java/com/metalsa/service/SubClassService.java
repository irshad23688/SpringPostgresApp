package com.metalsa.service;

import com.metalsa.model.SubClassModel;

public interface SubClassService {
	
	SubClassModel getSubClassData();
	
	SubClassModel persistSubClass(SubClassModel subClassModel);
}
