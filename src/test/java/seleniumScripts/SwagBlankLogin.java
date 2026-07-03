package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class SwagBlankLogin
{
	WebDriver driver;
	ChromeOptions options;
	
	@BeforeMethod
	public void BrowserLaunch() throws InterruptedException
	{
		options = new ChromeOptions();
		options.addArguments("--headless","disable-gpu");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
	}
	
	@Test
	public void Swag_BlankLogin() throws InterruptedException
	{
		WebElement userName=driver.findElement(By.id("user-name"));
		userName.sendKeys("");
		Thread.sleep(2000);
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("");
		Thread.sleep(2000);
		WebElement loginButton=driver.findElement(By.id("login-button"));
		loginButton.click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void BrowserClose()
	{
		if(driver!=null)
		{
			driver.close();
		}
		System.out.println("Test Completed Successfully");
	}

}
