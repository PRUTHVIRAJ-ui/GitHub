package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy(xpath= "//span[contains(text(),'Authentication')]")
	WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validtaeAccountCreatePage() throws Throwable {
		return Action.isDisplayed(driver, formTitle);
	}

}
