package com.qa.stepdef;

import org.openqa.selenium.OutputType;

import com.qa.pages.BasePage;
import com.qa.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	BasePage bp = new BasePage();

	@Before
	public void initialize() throws Exception {
		
	}
	
	@After
	public void quit(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		bp.closeApp();
		bp.launchApp();
	}
	
}
