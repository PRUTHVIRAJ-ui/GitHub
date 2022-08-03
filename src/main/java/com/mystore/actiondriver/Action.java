package com.mystore.actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.mystore.base.BaseClass;
import com.mystore.actiondriver.Action;
public class Action extends BaseClass{
	
	public static void scrollByVisiblityOfElement(WebDriver driver, WebElement ele)throws Throwable {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript("argument[0].scrollIntoView;", ele);
	}
	
	public static void click(WebDriver ldriver,WebElement locatorName)throws Throwable{
		
		Actions act=new Actions(ldriver);
		act.moveToElement(locatorName).click().perform();
		
	}
	
	public static boolean findElement(WebDriver driver,WebElement ele)throws Throwable {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag=true;
		}catch(Exception e) {
			flag=false;
		}finally {
			if(flag) {
			System.out.println("Successfully found element at");
			}else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	
	}
	
	public static boolean isDisplayed(WebDriver ldriver,WebElement ele)throws Throwable {
		boolean flag= false;
		flag= findElement(ldriver, ele);
		if(flag) {
			flag=ele.isDisplayed();
			if(flag) {
				System.out.println("The element is Displayed");
				}else {
					System.out.println("The element is not Displayed");
				}
			}else {
				System.out.println("Not Displayed");
			}
		return flag;
	}
	
	public static boolean isSelected(WebDriver ldriver,WebElement ele) throws Throwable {
		boolean flag= false;
		flag= findElement(ldriver, ele);
		if(flag) {
			flag=ele.isSelected();
			if(flag) {
				System.out.println("The element is Selected");
				}else {
					System.out.println("The element is not Selected");
				}
			}else {
				System.out.println("Not Selected");
			}
		return flag;
	}
	 
	public static boolean isEnabled(WebDriver ldriver,WebElement ele) throws Throwable {
		boolean flag= false;
		flag= findElement(ldriver, ele);
		if(flag) {
			flag=ele.isEnabled();
			if(flag) {
				System.out.println("The element is Enabled");
				}else {
					System.out.println("The element is not Enabled");
				}
			}else {
				System.out.println("Not Enabled");
			}
		return flag;
	}
	
	public static boolean type(WebElement ele, String text)throws Throwable {
		boolean flag = false;
		try {
			flag=ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag=true;
		}catch(Exception e) {
			System.out.println("Location Not found");
			flag=false;
		}finally {
			if(flag) {
			System.out.println("Successfully entered value");
			}else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	
	public static boolean SelectBySendkeys(WebElement ele, String value)throws Throwable {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag=true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
			System.out.println("Select value from the DropDown");
			}else {
				System.out.println("Not Select value from the DropDown");
			}
		}
		
	}
	
	public static boolean SelectByIndex(WebElement ele, int index)throws Throwable {
		boolean flag = false;
		try {
			Select s=new Select(ele);
			s.selectByIndex(index);
			flag=true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
			System.out.println("Option selected by Index");
			}else {
				System.out.println("Option not selected by Index");
			}
		}
		
	}
	
	public static boolean SelectByValue(WebElement ele, String value) throws Throwable{
		boolean flag = false;
		try {
			Select s=new Select(ele);
			s.deselectByValue(value);
			flag=true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
			System.out.println("Option selected by Value");
			}else {
				System.out.println("Option not selected by Value");
			}
		}
		
	}
	
	public static boolean SelectByVisibleText(WebElement ele, String Visibletext)throws Throwable {
		boolean flag = false;
		try {
			Select s=new Select(ele);
			s.deselectByValue(Visibletext);
			flag=true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
			System.out.println("Option selected by Visibletext");
			}else {
				System.out.println("Option not selected by Visibletext");
			}
		}
		
	}
	
	public static boolean JsClick(WebDriver driver,WebElement ele)throws Throwable{
		boolean flag = false;
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeAsyncScript("argument[0].scrollIntoView;", ele);
			flag=true;
			
		}catch(Exception e) {
			throw e;
		}finally {
			if(flag) {
			System.out.println("Click Action performed");
			}else if(!flag){
				System.out.println("Click Action Not performed");
			}
		}
		return flag;
	}
	
	public static boolean switchToFrameByIndex(int index) {
		boolean flag = false;
		try {
		    //new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(null));
		    driver.switchTo().frame(index);
			flag=true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
			System.out.println("Frame with index \"" +index+ "\" is Selected");
			}else {
				System.out.println("Frame with index \"" +index+ "\"  is not Selected ");
			}
		}
	
	}
	
	public static boolean switchToFrameById(int idValue)throws Throwable {
		boolean flag = false;
		try {
		   
		    driver.switchTo().frame(idValue);
			flag=true;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
			System.out.println("Frame with index \"" +idValue+ "\" is Selected");
			}else {
				System.out.println("Frame with index \"" +idValue+ "\" is  not Selected");
			}
		}
	}
	
	public static boolean switchToFrameByName(int nameValue)throws Throwable {
		boolean flag = false;
		try {
		   
		    driver.switchTo().frame(nameValue);
			flag=true;
			return true;
		}catch(Exception e) {
			
			return false;
		}finally {
			if(flag) {
			System.out.println("Frame with index \"" +nameValue+ "\" is Selected");
			}else {
				System.out.println("Frame with index \"" +nameValue+ "\" is  not Selected ");
			}
		}
		
	}
	
	public static boolean switchToDefaultFrame()throws Throwable {
		boolean flag = false;
		try {
		   
		    driver.switchTo().defaultContent();
			flag=true;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
		
			}else if(!flag) {
				
			}
		}
		
	}
	
	public static boolean mouseOverElement(WebElement element)throws Throwable {
		boolean flag = false;
		try {
		   
		    new Actions(driver).moveToElement(element).perform();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
				System.out.println("MouseOver Action is performed");
			}else  {
				System.out.println("MouseOver Action is not performed");
			}
		}
		return flag;
		
	}
	
	public static boolean mouseHoverByJavaScript(WebElement locator)throws Throwable {
		boolean flag = false;
		try {
		    WebElement mouse=locator;
			String strJavaScript = 
		            "var mouseEventObj = document.createEvent('MouseEvents');"
		            + "mouseEventObj.initEvent( 'mouseover', true, true );"
		            + "element.dispatchEvent(mouseEventObj);";
			JavascriptExecutor js =  (JavascriptExecutor) driver;
		     js.executeScript(strJavaScript, mouse);
			
		     flag=true;
		     return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		
		}finally {
			if(flag) {
				System.out.println("MouseOver Action is performed");
			}else  {
			System.out.println("MouseOver Action is not performed");
			}
		}
			
	}

	
	
	
}
