package week5.day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class CreateNewProposal extends BaseClass{
	
	@BeforeTest
	public void setFileName()
	{
		excelfilename="ServiceNowcreateProposal";
	}
	@Test(dataProvider="sendData")
	public void runcreateProposal(String proposalDesc) throws InterruptedException {

		sd.findElementByXPath("//input[@placeholder='Filter']").sendKeys("Proposal");
		sd.findElementByXPath("//mark[text()='Proposal']").click();		
		WebElement frame = sd.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[@type='submit']")).click();	  
		driver.findElement(By.xpath("//button[@id='lookup.std_change_proposal.category']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lt= new ArrayList<String>(windowHandles);		
		driver.switchTo().window(lt.get(1));
		driver.findElement(By.linkText("Standard Changes")).click();
		driver.switchTo().window(lt.get(0));	
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys(proposalDesc);
		driver.findElement(By.xpath("//span[@class='navbar_ui_actions']/button[1]")).click();
		List<WebElement> proposalCount = driver.findElements(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr"));
		proposalCount.size();
		String proposalDescription = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr["+proposalCount.size()+"]/td[4]")).getText();
		if(proposalDescription.equals(proposalDesc))
		{
		String proposalNumber = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr["+proposalCount.size()+"]/td[3]/a")).getText();
		System.out.println(proposalNumber+ " Proposal has been created successfully");
		}
		else
			System.out.println("Record creation Failed");
		
}
	

}
