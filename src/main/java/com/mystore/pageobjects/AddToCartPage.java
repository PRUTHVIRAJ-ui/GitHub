package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath="button[name='Submit']")
	WebElement addcart;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement proccedToCheckbtn;
	
	@FindBy(xpath="//h2[contains(text(),'Product successfully added to your shopping cart')]")
	WebElement addToCartMessag;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, "2");
	}
	
	public void selectSize(String size1) throws Throwable {
		Action.SelectByVisibleText(size, "M");
	}
	
	public void clickOnAddCart() throws Throwable {
		Action.JsClick(driver, addcart);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		
		
		return Action.isDisplayed(driver, addToCartMessag);	
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
	
		Action.JsClick(driver, proccedToCheckbtn);
		return new OrderPage();
		
	}

}
