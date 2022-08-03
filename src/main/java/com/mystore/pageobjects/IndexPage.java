package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage ClickOnSignIn() throws Throwable {
	
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validationLogo() throws Throwable {
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle=driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
	
	
}
