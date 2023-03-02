package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.utils.TestUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(accessibility = "Username input field")
	private WebElement usernameTxtFld;
	
	@AndroidFindBy(accessibility = "Password input field")
	private WebElement passwordTxtFld;
	
	@AndroidFindBy(accessibility = "Login button")
	private WebElement loginBtn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView")
	private WebElement errTxt;
	
	public LoginPage() {
		
	}
	
	public LoginPage enterUsername(String username) {
		sendKeys(usernameTxtFld, username, "Login with " + username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		sendKeys(passwordTxtFld, password, "Password is " + password);
		return this;
	}
	
	public ProductsPage pressLoginBtn() {
		click(loginBtn, "Click login button");
		return new ProductsPage();
	}
	
	public ProductsPage login(String username, String password) {
		utils.log().info("Do login");
		enterUsername(username);
		enterPassword(password);
		return pressLoginBtn();
	}
	
	public String getErrTxt() {
		String err = getText(errTxt, "Error message : ");
		return err;
	}
	  
}
