package week5.day2assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class BaseClass {
	public ChromeDriver driver;
	public String excelfilename;
	public Shadow sd;
	@Parameters({"url","uname","pwd"})
	@BeforeMethod
	public void precondition(String url,String username,String pwd) throws Exception
	{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	driver.findElement(By.name("user_name")).sendKeys(username);;
	driver.findElement(By.id("user_password")).sendKeys(pwd);
	driver.findElement(By.id("sysverb_login")).click();
	sd= new Shadow(driver);
	sd.setExplicitWait(8000, 10);
	}
	
	@AfterMethod
	public void postcondition()
	{
		driver.close();
		
	}
	
	@DataProvider
	public String[][] sendData() throws IOException
	{
		String[][] data=ReadExcelServiceNow.getData(excelfilename);
		return data;
	}
	

}
