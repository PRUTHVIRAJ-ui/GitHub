package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement bankwireMethod;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payByCheckMethod;
	

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		Action.click(driver, bankwireMethod);
		return new OrderSummary();
	}

}
