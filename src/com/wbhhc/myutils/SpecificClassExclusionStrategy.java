package com.wbhhc.myutils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class SpecificClassExclusionStrategy implements ExclusionStrategy {
//	   private final Class<?> excludedThisClass;
	   private final String[] excludedThisProperty;

	   public SpecificClassExclusionStrategy(String[] excludedThisProperty) {
//	     this.excludedThisClass = excludedThisClass;
	     this.excludedThisProperty=excludedThisProperty;
	   }

	   public boolean shouldSkipClass(Class<?> clazz) {
		   return false;
	   }

	   public boolean shouldSkipField(FieldAttributes f) {
		   boolean flag=false;
//		   if (excludedThisClass.equals(f.getDeclaredClass())) {
//			   flag=true;
//		   }
		   for (String ele : excludedThisProperty) {
			   if (ele.equals(f.getName())) {
					flag=true;
					break;
			   }
		   }
		   return flag;
	   }
	 }