package com.qa.stepdef;

import org.junit.Assert;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.SidePage;

import io.cucumber.java.en.*;

public class ProductStepDef {

	@Given("I'm logged in")
	public void iMLoggedIn() {
		new SidePage().pressSideMenu();
		new SidePage().pressLoginMenu();
	    new LoginPage().login("bob@example.com", "10203040");
	}

	@Then("The product is listed with title {string} and price {string}")
	public void theProductIsListedWithTitleAndPrice(String title, String price) {
		Assert.assertEquals(new ProductsPage().getSLBTitle(), title); 
		Assert.assertEquals(new ProductsPage().getSLBPrice(), price);
	}

	@When("I click product title {string}")
	public void iClickProductTitle(String title) {
	    new ProductsPage().pressSLBTitle();
	}

	@Then("I should be on product details page with title {string}, price {string}, and description {string}")
	public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String desc) throws Exception {
	    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
	    Thread.sleep(3000);
	    boolean titleCheck = productDetailsPage.getSLBTitle().equalsIgnoreCase(title);
	    boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
	    boolean descCheck = productDetailsPage.getSLBDesc().equalsIgnoreCase(desc);
	    Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck, 
	    		titleCheck & descCheck & priceCheck);
	}
	
}
