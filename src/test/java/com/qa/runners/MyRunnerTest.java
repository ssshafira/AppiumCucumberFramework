package com.qa.runners;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "summary", "html:target/cucumber/cucumber.html"},
		features = {"src/test/resources"},
		glue = {"com.qa.stepdef"},
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		monochrome = true
		, tags = "@login"
)
public class MyRunnerTest {
	@BeforeClass
	public static void initialize() throws Exception {
		GlobalParams params = new GlobalParams();
		params.initializeGlobalParams();
		
		ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getUdid());
	
		new ServerManager().startServer();
		new DriverManager().initializeDriver();
	}
	
	@AfterClass
	public static void quit() {
		DriverManager driverManager = new DriverManager();
		if(driverManager.getDriver() != null) {
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		ServerManager serverManager = new ServerManager();
		if(serverManager.getServer() != null) {
			serverManager.getServer().stop();
		}
	}
}
