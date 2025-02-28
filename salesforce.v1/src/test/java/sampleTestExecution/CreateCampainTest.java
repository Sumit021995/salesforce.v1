package sampleTestExecution;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampainTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss");
		String uniqueStringValue = sdf.format(new Date());
		SimpleDateFormat dateSdf = new SimpleDateFormat("dd-MM-YYYY");
		String currentDate = dateSdf.format(Calendar.getInstance().getTime());
		
//
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
