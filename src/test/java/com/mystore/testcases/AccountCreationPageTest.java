package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;

	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyCreateAccountTest() throws Throwable {
		indexPage=new IndexPage();
		loginPage=indexPage.ClickOnSignIn();
		accountCreationPage=loginPage.createNewAccount("pruthvi@gmail.com");
		boolean result=accountCreationPage.validtaeAccountCreatePage();
		Assert.assertTrue(result);
		
	}
}
