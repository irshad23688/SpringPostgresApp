package com.metalsa.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metalsa.model.RadioModel;

public class MetalsaConstant {

	public static Map<Object,Object> statusMap = new HashMap<>();
	public static List<RadioModel> radioYesNo = new ArrayList<>();
	public static List<RadioModel> radioSOM1SOM2 = new ArrayList<>();
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
		radioYesNo.add(new RadioModel("Yes","Yes"));
		radioYesNo.add(new RadioModel("No","No"));
		radioSOM1SOM2.add(new RadioModel("SOM1","SOM1"));
		radioSOM1SOM2.add(new RadioModel("SOM2","SOM2"));
	}
	
	public interface UOM{
		String PERCENT = "%";
		String PPM = "ppm";
	}
	public interface STATUS{
		String INACTIVE = "0";
		String PENDING = "1";
		String SENT_FOR_APPROVAL = "2";
		String APPROVED = "3";
		String REJECT = "4";
	}
	
	public static final String YES="Yes";
	public static final String NO="No";
	public static final String SOM1="SOM1";
	public static final String SOM2="SOM2";
	public static final String DATA_TYPE_DROPDOWN="dropdown";
	public static final String FRONTEND_DATA_TYPE_DROPDOWN="select";
	public static final String DATA_TYPE_TEXT="Text";
	public static final String FRONTEND_DATA_TYPE_TEXT="text";
	public static final List<String> SUPPLIER_DROPDOWN=Arrays.asList("SELECT","-",">","<","<=",">=");
	public static final List<String> LISTVIEW_HEADER_DATA=Arrays.asList("SN","Base Attribute Name","Testing Information","UOM","Supplier Information","UOM");
	public static final String DATA_TYPE_LISTVIEW = "ListView";
	

}
