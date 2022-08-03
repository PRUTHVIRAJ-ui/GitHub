package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="email")
	WebElement username;
	 
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id="SubmitCreate")
	WebElement createNewAccountbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		return new HomePage();	
	}
	
	public AddressPage login1(String uname, String pswd) throws Throwable {
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		return new AddressPage();	
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccountbtn);
		return new AccountCreationPage();
	}

	
}

