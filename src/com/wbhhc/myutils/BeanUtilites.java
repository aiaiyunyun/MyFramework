package com.wbhhc.myutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilites {
	
	public static void populateBean(Object formBean,HttpServletRequest request){
		populateBean(formBean,request.getParameterMap());
	}
	
	public static void populateBean(Object bean,Map propertyMap){
		try {
			BeanUtils.populate(bean,propertyMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}
