package com.qa.utils;

public class GlobalParams {

	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	private static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
	private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
	
	public String getPlatformName() {
		return platformName.get();
	}
	
	public void setPlatformName(String platformName1) {
		platformName.set(platformName1);
	}
	
	public String getUdid() {
		return udid.get();
	}
	
	public void setUdid(String udid1) {
		udid.set(udid1);
	}

	public String getSystemPort() {
		return systemPort.get();
	}
	
	public void setSystemPort(String systemPort1) {
		systemPort.set(systemPort1);
	}
	
	public String getChromeDriverPort() {
		return chromeDriverPort.get();
	}
	
	public void setChromeDriverPort(String chromeDriverPort1) {
		chromeDriverPort.set(chromeDriverPort1);
	}
	
	public void initializeGlobalParams() {
		GlobalParams params = new GlobalParams();
		params.setPlatformName(System.getProperty("platformName", "Android"));
		params.setUdid(System.getProperty("udid", "RR8R105VJLX"));
		params.setSystemPort(System.getProperty("systemPort", "10002"));
		params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
	}
	
}
