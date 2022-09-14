package week5.day1;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public 	RemoteWebDriver driver;
	@Parameters({"browser","url"})
	@BeforeMethod
	public void preCondition(String browser,String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
	WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();		
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
	WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
		public void postCondition()
		{
			driver.quit();
		}
	
	

}
