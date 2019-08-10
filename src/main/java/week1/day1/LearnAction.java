package week1.day1;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LearnAction extends ProjectSpecificMethods{
	
	
	
	/*
	 * public void invokeBrowser() { System.setProperty("webdriver.chrome.driver",
	 * "./drivers/Chromedriver/chromedriver.exe");
	 * 
	 * driver = new ChromeDriver(); driver.manage().timeouts().implicitlyWait(30,
	 * TimeUnit.SECONDS); driver.manage().deleteAllCookies();
	 * driver.manage().window().maximize();
	 * 
	 * driver.get("https://www.automationPUB.com"); }
	 */
	@Test
	public void fillText() {
		Actions actions = new Actions(driver);
		WebElement search = driver.findElement(By.id("tags"));
		//actions.moveToElement(search).click().build().perform();
		actions.keyDown(search, Keys.SHIFT).sendKeys("hai").keyUp(Keys.SHIFT).build().perform();
	}
	
	public void learnDisplayed() {
		driver.findElement(By.xpath("//button[@id='heateor_ss_browser_msg_close']/img")).click();
		WebElement wb = driver.findElement(By.xpath("//*[contains(text(),'001 Selenium – webdriver')]"));
		
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'What is Selenium WebDriver?')]")).isDisplayed());
		System.out.println("----first check----");
		if (wb.isDisplayed() == true) {
			wb.click();
		}
		
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'What is Selenium WebDriver?')]")).isDisplayed());
		System.out.println("----second check----");
		
	}

//	public void learnSelected() {
//		driver.findElement(By.xpath("//legend[contains(text(),'Select a Location: ')]/"))
//	}
	public static void main(String[] args) {
		LearnAction la = new LearnAction();
		la.login();
		//la.invokeBrowser();
		la.fillText();
		
		//la.learnDisplayed();
	}

}
