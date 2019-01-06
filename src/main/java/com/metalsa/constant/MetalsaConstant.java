package com.metalsa.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetalsaConstant {

	public static Map<Object,Object> statusMap = new HashMap<>();
	static {
		statusMap.put(1, "PENDING");
		statusMap.put(2, "SENT FOR APPROVAL");
		statusMap.put(3, "APPROVED");
		statusMap.put(4, "REJECT");
		statusMap.put("PENDING", 1);
		statusMap.put("SENT FOR APPROVAL", 2);
		statusMap.put("APPROVED", 3);
		statusMap.put("REJECT", 4);
		Collections.unmodifiableMap(statusMap);
	}
	
	public interface UOM{
		String PERCENT = "%";
		String PPM = "ppm";
	}
	public interface STATUS{
		String PENDING = "1";
		String SENT_FOR_APPROVAL = "2";
		String APPROVED = "3";
		String REJECT = "4";
		String INACTIVE = "5";
	}

}
