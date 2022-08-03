package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath="//span[contains(text(),'$16.51')]")
	WebElement unitpri;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalpri;
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement prodeedCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitprice=unitpri.getText();
		String unit=unitprice.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalprice=totalpri.getText();
		String total=totalprice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		Action.click(driver, prodeedCheckOut);
		return new LoginPage();
	}
}
