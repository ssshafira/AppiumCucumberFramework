package com.qa.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsPage extends SidePage {
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
	private WebElement SLBTitle;
	
	@AndroidFindBy(accessibility = "product description")
	private WebElement SLBDesc;
	
	@AndroidFindBy(accessibility = "product price")
	private WebElement price;
	
	public String getSLBTitle() {
		return getText(SLBTitle);
	}
	
	public String getSLBDesc() {
		return getText(SLBDesc);
	}
	
	public String getPrice() {
		return getText(price);
	}
	
	public ProductsPage backToProductsPage() {
		pressSideMenu();
		return pressCatalogMenu();
	}
	  
}
