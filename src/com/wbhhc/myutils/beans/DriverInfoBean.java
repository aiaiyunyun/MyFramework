package com.wbhhc.myutils.beans;

public class DriverInfoBean {
	private String vendor;
	private String description;
	private String driverClass;
	private String url;
	
	public DriverInfoBean(){
		
	}
	
	public DriverInfoBean(String vendor,String description,String driverClass,String url) {
		// TODO Auto-generated constructor stub
		this.vendor=vendor;
		this.description=description;
		this.driverClass=driverClass;
		this.url=url;
	}
	
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
