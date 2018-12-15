package com.metalsa.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreator {
	
	public static void createJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("Json object : "+mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
