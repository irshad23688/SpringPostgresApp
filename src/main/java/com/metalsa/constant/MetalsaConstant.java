package com.metalsa.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetalsaConstant {

	public static Map<Object,Object> statusMap = new HashMap<>();
	static {
		statusMap.put(1, "PENDING");
		statusMap.put(2, "APPROVED");
		statusMap.put("PENDING", 1);
		statusMap.put("APPROVED", 2);
		Collections.unmodifiableMap(statusMap);
	}
	
	public interface UOM{
		String PERCENT = "%";
		String PPM = "ppm";
	}
	public interface STATUS{
		String PENDING = "1";
	}


}
