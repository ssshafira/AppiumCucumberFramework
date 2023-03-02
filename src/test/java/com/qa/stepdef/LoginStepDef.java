package com.qa.stepdef;

import org.junit.Assert;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.SidePage;

import io.cucumber.java.en.*;

public class LoginStepDef {

	@Given("I'm on the Home page")
	public void iMOnTheHomePage() {
	    new SidePage().pressSideMenu();
	}

	@When("I go to Login page")
	public void iGoToLoginPage() {
	    new SidePage().pressLoginMenu();
	}

	@When("I enter username as {string}")
	public void iEnterUsernameAs(String username) {
	    new LoginPage().enterUsername(username);
	}

	@When("I enter password as {string}")
	public void iEnterPasswordAs(String password) {
	    new LoginPage().enterPassword(password);
	}

	@When("I press Login")
	public void iPressLogin() {
	    new LoginPage().pressLoginBtn();
	}

	@Then("Login should fail with an error {string}")
	public void loginShouldFailWithAnError(String err) {
	    Assert.assertEquals(new LoginPage().getErrTxt(), err); 
	}

	@Then("I should see Products page with title {string}")
	public void iShouldSeeProductsPageWithTitle(String title) throws InterruptedException {
		Thread.sleep(3000);
	    Assert.assertEquals(new ProductsPage().getTitle(), title);
	}
}
