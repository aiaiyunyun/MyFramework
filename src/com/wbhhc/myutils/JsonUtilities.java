package com.wbhhc.myutils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wbhhc.myutils.SpecificClassExclusionStrategy;

public class JsonUtilities {
	
	public static String toJson(Object obj,String[] excludedPropertys){
		ExclusionStrategy excludeStrings=new SpecificClassExclusionStrategy(excludedPropertys);
		Gson gson = new GsonBuilder()
	     .setExclusionStrategies(excludeStrings)
	     .serializeNulls()
	     .create();
		return gson.toJson(obj);
	}
	
	public static String toJson(Object obj){
		Gson gson = new GsonBuilder()
	     .serializeNulls()
	     .create();
		return gson.toJson(obj);
	}
}
