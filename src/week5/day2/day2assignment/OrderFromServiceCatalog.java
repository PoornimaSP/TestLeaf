package week5.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderFromServiceCatalog extends BaseClass{
	@Test(dataProvider="sendData")
	public void runOrderFromServiceCatalog(String filterText,String phoneType,String phoneColor) throws InterruptedException {
		sd.findElementByXPath("//input[@placeholder='Filter']").sendKeys(filterText);
		sd.findElementByXPath("//mark[text()='Service Catalog']").click();
		WebElement frame = sd.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);												
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//strong[text()='"+phoneType+"']")).click();
		WebElement colorDropDown = driver.findElement(By.xpath("(//select[contains(@class,'cat_item_option')])[2]"));
		colorDropDown.click();
		Select select= new Select(colorDropDown);
		select.selectByVisibleText(phoneColor);
		WebElement storageDropDown = driver.findElement(By.xpath("(//select[contains(@class,'cat_item_option')])[3]"));
		storageDropDown.click();
		Select select1= new Select(colorDropDown);
		select1.selectByIndex(3);
		driver.findElement(By.id("oi_order_now_button")).click();
		String orderMessage = driver.findElement(By.xpath("//span[contains(text(),'Thank you')]")).getText();
		if(orderMessage.contains("Thank you"))
{ 
			WebElement requestID = driver.findElement(By.xpath("//a[@id='requesturl']"));
	System.out.println(requestID.getText()+"order has been created successfully");
}
		else
			System.out.println("Order unsuccessful");

	}
	
	@BeforeTest
	public void setFileName()
	{
	excelfilename="ServiceNowOrderMobile";
	}


}
