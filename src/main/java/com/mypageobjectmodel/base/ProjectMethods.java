package com.mypageobjectmodel.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectMethods {
	public WebDriver driver;
	
	@BeforeSuite
	public void browserProperty() {
		System.setProperty("window.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	@BeforeMethod
	public void invokeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
