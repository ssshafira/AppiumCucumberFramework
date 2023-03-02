package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.DriverManager;
import com.qa.utils.PropertyManager;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

	private AppiumDriver driver;
	TestUtils utils = new TestUtils();
	PropertyManager props = new PropertyManager();
	
	public BasePage() {
		this.driver = new DriverManager().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void clear(WebElement e) {
		waitForVisibility(e);
		e.clear();
	}
	
	public void click(WebElement e) {
		waitForVisibility(e);
		e.click();
	}
	
	public void click(WebElement e, String msg) {
		waitForVisibility(e);
		utils.log().info(msg);
		e.click();
	}
	  
	public void sendKeys(WebElement e, String txt) {
		clear(e);
		e.sendKeys(txt);
	}
	
	public void sendKeys(WebElement e, String txt, String msg) {
		clear(e);
		utils.log().info(msg);
		e.sendKeys(txt);
	}
	  
	public String getText(WebElement e) {
		waitForVisibility(e);
		return e.getAttribute("text");
	}
	
	public String getText(WebElement e, String msg) {
		String txt;
		txt = getText(e);
		utils.log().info(msg + txt);
		return txt;
	}
	
	public void closeApp() throws Exception {
		((InteractsWithApps) driver).terminateApp(props.getProps().getProperty("androidAppPackage"));
	}
	  
	public void launchApp() throws Exception {
		((InteractsWithApps) driver).activateApp(props.getProps().getProperty("androidAppPackage"));
	}
}
