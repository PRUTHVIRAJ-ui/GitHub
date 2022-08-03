package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import com.mystore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig() {
		
		try {
			prop= new Properties();
			System.out.println("Super constuctor invoked");
			FileInputStream ip= new FileInputStream(
					System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver:" + driver);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();	
		}
		
	
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
	

	

}
