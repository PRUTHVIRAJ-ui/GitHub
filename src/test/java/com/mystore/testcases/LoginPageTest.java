package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTest() throws Throwable {
		indexPage=new IndexPage();
		loginPage=indexPage.ClickOnSignIn();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homepage.getCurrURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
	}

}
