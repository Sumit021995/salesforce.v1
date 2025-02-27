package sampleTestExecution;

import java.text.SimpleDateFormat;
import java.time.Duration;
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Campaign1",Keys.TAB,"CampaignSatus");
		driver.findElement(By.name("targetSize")).sendKeys("10");
		Date d=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		driver.findElement(By.name("expectedCloseDate")).sendKeys();
		driver.findElement(By.name("targetAudience")).sendKeys("Audience1",Keys.TAB,"Description1",Keys.ENTER);
		WebElement logoutEle = driver.findElement(By.xpath("//*[name()='svg']"));
		Actions act = new Actions(driver);
		act.moveToElement(logoutEle).perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
}
