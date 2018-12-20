package com.metalsa.service;

import com.metalsa.model.BaseAttrModel;

public interface BaseAttrService {
	
	BaseAttrModel getBaseAttrData();
	
	BaseAttrModel persistBaseAttr(BaseAttrModel baseAttrModel);
}
