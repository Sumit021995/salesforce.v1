package sampleTestExecution;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.WebDriverUtility;

public class CreateContactSample {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverUtility wUtility = new WebDriverUtility();
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss");
		String uniqueStringValue = sdf.format(new Date());
		SimpleDateFormat dateSdf = new SimpleDateFormat("dd-MM-YYYY");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		String currentDate = dateSdf.format(calendar.getTime());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("SumitCampaign"+uniqueStringValue,Keys.TAB,Keys.TAB,"5");
		driver.findElement(By.name("expectedCloseDate")).sendKeys(currentDate);
		Thread.sleep(2000);
		driver.findElement(By.name("targetAudience")).sendKeys("Target"+uniqueStringValue,Keys.TAB,"Description",Keys.TAB,Keys.ENTER);
//		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		String expectedAlertText = "Campaign SumitCampaign"+uniqueStringValue+" Successfully Added";
		WebElement alertEle = driver.findElement(By.xpath("//div[@role='alert']"));
		if(alertEle.getText().equals(expectedAlertText))
			System.out.println("Validated true");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("organizationName")).sendKeys("SumitOrganization",Keys.TAB,"Title");
		driver.findElement(By.name("contactName")).sendKeys("SumitSaurav",Keys.TAB,"9818425197",Keys.TAB,"sumitsaurav0602@gmail.com");
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		Thread.sleep(2000);
		String parentID = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		for(String s:allIds)
		{
			if(!s.equals(parentID)) {
				
				driver.switchTo().window(s);	
			}
		}
		WebElement dropdown = driver.findElement(By.id("search-criteria"));
		Select s = new Select(dropdown);
		s.selectByIndex(1);
		driver.findElement(By.id("search-input")).sendKeys("SumitCampaign"+uniqueStringValue);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='SumitCampaign"+uniqueStringValue+"']")));
		driver.findElement(By.xpath("//td[text()='SumitCampaign"+uniqueStringValue+"']/../td/button")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentID);	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		Thread.sleep(2000);
		WebElement logoutEle = driver.findElement(By.xpath("//*[name()='svg']"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(logoutEle).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		Thread.sleep(2000);
		driver.quit();

		
	}
}
