package com.qa.utils;

import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesManager {
	TestUtils utils = new TestUtils();
	
	public DesiredCapabilities getCaps() throws Exception {
		GlobalParams params = new GlobalParams();
		Properties props = new PropertyManager().getProps();
		
		try {
			utils.log().info("Getting Capabilities");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			caps.setCapability(MobileCapabilityType.UDID, params.getUdid());
			
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
			caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
			caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
			caps.setCapability("systemPort", params.getSystemPort());
			caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
		
			return caps;
		} catch (Exception e) {
			e.printStackTrace();
			utils.log().fatal("Failed to load Capabilities" + e.toString());
			throw e;
		}
	}
}
