package com.mypageobjectmodel.leads.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mypageobjectmodel.base.ProjectMethods;



public class LoginPage extends ProjectMethods{
	
	
	public LoginPage() {
		//constructor
	}
	
	
	public LoginPage enterUsername() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		return this;
	}
	
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
}
