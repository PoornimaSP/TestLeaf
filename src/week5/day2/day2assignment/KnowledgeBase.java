package week5.day2assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KnowledgeBase extends BaseClass {
	@Test(dataProvider="sendData")
	public void runKnowledgeBase(String knBase,String category1,String category2, String Sdesc,String TextArea) throws InterruptedException
	{
		sd.findElementByXPath("//input[@placeholder='Filter']").sendKeys("Knowledge");
		sd.findElementByXPath("//mark[text()='Knowledge']").click();
		WebElement frame = sd.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[@aria-label='Create Article']")).click();
		driver.findElement(By.xpath("(//span[contains(@class,'icon-search')])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lt= new ArrayList<String>(windowHandles);
		driver.switchTo().window(lt.get(1));
		driver.findElement(By.linkText(knBase)).click();
		driver.switchTo().window(lt.get(0));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("(//span[contains(@class,'icon-search')])[2]")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("(//table[@role='presentation'])[3]//tr[2]/td//div/span[text()='"+category1+"']")).click();
		driver.findElement(By.xpath("(//table[@role='presentation'])[3]//tr[2]/td//div/span[text()='"+category1+"']/ancestor::div[2]/following-sibling::div//span[text()='"+category2+"']")).click();
		driver.findElement(By.id("ok_button")).click();			
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys(Sdesc);
		WebElement kBaseTextArea = sd.findElementByXPath("iframe[@id='kb_knowledge.text_ifr']");
		driver.switchTo().frame(kBaseTextArea);
		driver.findElement(By.id("tinymce")).sendKeys(TextArea);
		driver.switchTo().parentFrame();		
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();	
		
	}
	@BeforeTest
	public void setFileName()
	{
		excelfilename="ServiceNowCreateKnowledgearticle";
	}

}
