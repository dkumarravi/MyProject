package steps;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	ChromeDriver driver;

	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
	    driver = new ChromeDriver();
	}

	@Given("Maximise the browser")
	public void maximise_the_browser() {
	    driver.manage().window().maximize();
	}

	@Given("Set the Timeouts")
	public void set_the_Timeouts() {
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Load the URL")
	public void load_the_URL() {
	    driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@Given("Enter the Username as (.*)")
	public void enter_the_Username_as_DemoSalesManager(String data) {
	    driver.findElement(By.id("username")).sendKeys(data);
	}

	@Given("Enter the Password as (.*)")
	public void enter_the_Password_as_srmsfa(String data) {
		driver.findElement(By.id("password")).sendKeys(data);
	}

	@When("User click on the Login Button")
	public void user_click_on_the_Login_Button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Verify login is success")
	public void verify_login_is_success() {
	    System.out.println("login success");
	}

}
