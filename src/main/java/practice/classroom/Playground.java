package practice.classroom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Playground {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void learnSwitchWindow() throws InterruptedException {
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("p:nth-child(6)>button")).wait(6);
		//driver.findElement(By.name("New Message Window")).click();
	    //driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		System.out.println(handles);
	}
	
	public void learnAlert() {
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("12334");
		driver.findElement(By.name("submit")).click();
		Alert pop = driver.switchTo().alert();
		System.out.println(pop.getText());;
		pop.accept();
		pop.accept();
		driver.close();
	}
	
	public void learnWindow() {
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> arrayList = new ArrayList<String>(handles);
		
		System.out.println(arrayList);
		driver.switchTo().window(arrayList.get(1));
		System.out.println(driver.findElement(By.cssSelector("div.example>h3")).getText());
		driver.close();
		
	}
	
	public void learnMultiFrame() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/guru99home/");
		int num_of_frames = driver.findElements(By.tagName("iframe")).size();
		/*
		 * for (int i = 0; i <= num_of_frames; i++) { driver.switchTo().frame(i); int
		 * find_index =
		 * driver.findElements(By.cssSelector("a[href*='selenium-project.html']>img")).
		 * size(); System.out.println(find_index); driver.switchTo().defaultContent(); }
		 */
		driver.switchTo().frame(2);
		
		//System.out.println(driver.findElement(By.cssSelector("body")).getText());
		//driver.findElement(By.cssSelector("a[href*='selenium-project.html']>img")).click();
		//driver.switchTo().parentFrame();
	}
	
	public void learnDropDown() throws InterruptedException {
		driver.get("http://toolsqa.com/automation-practice-form/");
		Select dd = new Select(driver.findElement(By.id("selenium_commands")));
		if(dd.isMultiple()) 
			dd.selectByIndex(0);
		Thread.sleep(3000);
		dd.deselectByIndex(0);
	} 
	
	public static void main(String[] args) throws InterruptedException {
		Playground pg = new Playground();
		pg.invokeBrowser();
		//pg.learnSwitchWindow();
		//pg.learnAlert();
		//pg.learnWindow();
		//pg.learnMultiFrame();
		pg.learnDropDown();

	
	}

}
