package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	TestUtils utils = new TestUtils();
	
	public AppiumDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(AppiumDriver driver2) {
		driver.set(driver2);
	}
	
	public void initializeDriver() throws Exception {
		AppiumDriver driver = null;
		GlobalParams params = new GlobalParams();
		PropertyManager props = new PropertyManager();
		
		if(driver == null) {
			try {
				utils.log().info("Initializing Appium driver");
				driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
				utils.log().info("Driver is initialized");
				this.driver.set(driver);
			} catch (Exception e) {
				e.printStackTrace();
				utils.log().fatal("Driver init fail");
				throw e;
			}
		}
	}
}
