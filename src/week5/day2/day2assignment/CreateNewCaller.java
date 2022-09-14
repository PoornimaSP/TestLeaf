package week5.day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewCaller extends BaseClass{
	@Test(dataProvider="sendData")
	public void runCreateNewCaller(String fname,String lname,String title,String phonenum) throws InterruptedException
	{   
		sd.findElementByXPath("//input[@placeholder='Filter']").sendKeys("callers");
		sd.findElementByXPath("//mark[text()='Callers']").click();
		WebElement frame = sd.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(fname);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(lname);
		driver.findElement(By.xpath("//span[contains(@class,'icon-lightbulb')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lt= new ArrayList<String>(windowHandles);
		driver.switchTo().window(lt.get(1));
		driver.findElement(By.linkText(title)).click();
		driver.switchTo().window(lt.get(0));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(phonenum);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		String callerLastName = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]/a")).getText();
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(lname,Keys.ENTER);
		String searchCallerByFname = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[4]")).getText();
		if(searchCallerByFname.equals(fname))
		{
			System.out.println("Created user profile is appearing in search result");
			
		}
		else
			System.out.println("Created user profile is not appearing in search result");
	}
	@BeforeTest
	public void setFileName()
	{
		excelfilename="ServiceNowCreateNewCaller";
	}

}
