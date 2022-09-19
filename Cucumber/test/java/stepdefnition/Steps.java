package stepdefnition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	ChromeDriver driver;
	Set<String> allWindows,allWindows2;
	List<String> allhandles,allhandles2;
	static  String firstwindowID;
	static  String secondWindowID;
	static String LeadID;
	String leadID;
	WebDriverWait wait;
    @Given("ChromeBrowser is Opened")
	public void openChrombrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	@And ("Load Application URL as {string}")
	public void loadURL(String url)
	{
		driver.get(url);
	}
	@And("Maximize and set timeout for browser")
	public void maximizeTimeout()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	@And("Enter valid username as {string}")
	public void enterUsername(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@And("Enter valid password as {string}")
	public void enterPassword(String pwd)
	{
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	@And("Click on Login button")
	public void clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@And("Click on CRM link")
	public void clickCRMLink()
	{
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
	}
	@And("Click on Leads Tab")
	public void clickLeadsTab()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
	@And("Click on Create Lead link under Shortcuts")
	public void clickCreateLeadLink()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@And("Enter Company Name as {string}")
	public void enterCompanyName(String company)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
	}
	@And("Enter Forename as {string}")
	public void enterForename(String firstname)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
	}
	@And("Enter Surname as {string}")
	public void Surname(String lastname)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
	}
	@When("Create Lead button is clicked")
	public void clickCreateLeadButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View Lead should be displayed")
	public void verifyViewPageDisplay() throws InterruptedException
	{
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.titleContains("View"));
		String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		if(text.contains("View"))
			System.out.println("Lead has been created successfully");
		else
			System.out.println("Lead not created successfully");
		driver.close();
	}
	
	@And("Click on Find Leads under Shortcuts")
	public void clickFindLeads()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@And("Click on Phone tab")
	public void clickPhoneTab()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@And("Enter Phonenumber")
	public void enterPhoneNumber()
	{
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
	}
	@And("Click on Find Leads button")
	public void clickFindLeadsButton()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}
	@And("Click on first lead from search result")
	public void clickFirstLead() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@And("Click on Edit button")
	public void clickEditButton()
	{
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	}
	@And("Update Company Name value {string}")
	public void updateCompanyName(String cmp) throws InterruptedException
	{
	//	Thread.sleep(1000);
		wait.until(ExpectedConditions.titleContains("opentaps"));
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cmp);
	}
	@And("Click on Update button")
	public void updateButton()
	{
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}

	 
	@And("Click on first lead from search result and Note the LeadID")
	public void clickFirstLeadDelete() throws InterruptedException
	{
		Thread.sleep(2000);
leadID=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@And("Click on Delete button")
	public void clickDeleteeButton()
	{
		driver.findElement(By.linkText("Delete")).click();
	}
	@And("Enter deleted LeadID")
	public void enterDeletedLeadID()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	
	@Then("Deleted record should not be displayed")
	public void verifyLeaddeletion() throws InterruptedException
	{
		Thread.sleep(1000);
		String recordMessage = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		if(recordMessage.equals("No records to display"))
		System.out.println("Lead deleted Successfully");
		else
			System.out.println("Lead is not deleted");
		driver.close();
	}

	@And("Click on MergeLeads under Shortcuts")
	public void clickMergeLeads()
	{
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@And("Click on Img across From Lead")
	public void clickFromLeadImg()
	{
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}
	@And("Enter FirstName as {string}")
	public void enterFirstNametoMerge(String name)
	{
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		 firstwindowID = allhandles.get(0);
		 secondWindowID = allhandles.get(1);
		System.out.println("firstwindowID" +firstwindowID);
		System.out.println("secondWindowID "+secondWindowID);
		//driver.switchTo().window(allhandles.get(1));
		driver.switchTo().window(secondWindowID);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(name);
	}
	@And("Click on Find Leads button in the Find Leads window")
	public void clickFindLeadsButtonMerge()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@And("Note down first lead ID from search result in the Find Leads window and click")
	public void retriveFirstLeadIDandClick() throws InterruptedException
	{
		Thread.sleep(1000);
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
	}
	@And("Click on Img across To Lead")
	public void clickToLeadImag()
	{
		//driver.switchTo().window(allhandles.get(0));
		System.out.println("firstwindowID" +firstwindowID);
		System.out.println("secondWindowID "+secondWindowID);
		driver.switchTo().window(firstwindowID);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
	@And("Search for ToLead to be merged whose FirstName as {string}") 
	public void clickFirstToLead(String ToName) throws InterruptedException
	{
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		 firstwindowID = allhandles2.get(0);
		 secondWindowID = allhandles2.get(1);
		//driver.switchTo().window(allhandles.get(1));
		driver.switchTo().window(secondWindowID);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(ToName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@And("Click on Merge button")
	public void clickMerge() throws InterruptedException
	{
			
	//	driver.switchTo().window(allhandles2.get(0));
		driver.switchTo().window(firstwindowID);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}
	@And("Click OK in the Alert")
	public void clickOKAlert()
	{
		driver.switchTo().alert().accept();

	}

	@And("Enter Merged from LeadID")
	public void enterFromLeadID()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}

	@Then("Merged record should not be displayed")
	public void verifyMergeSuccess() throws InterruptedException
	{
		Thread.sleep(1000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Merge Success");
		} else {
			System.out.println("Merge Not successful");
			
		}
		driver.close();
	
	}
	@And("Click on Duplicate button")
	public void clickDuplicateButton()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@When("Click on CreateLead button in Duplicate Lead Page")
	public void clickCreateLeadToDuplicate()
	{
		driver.findElement(By.name("submitButton")).click();
	}
}
