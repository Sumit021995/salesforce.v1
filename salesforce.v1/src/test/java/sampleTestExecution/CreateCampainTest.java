package sampleTestExecution;

import java.time.Duration;

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
		
			System.out.println("Evaluated True");
		WebElement logoutEle = driver.findElement(By.xpath("//*[name()='svg']"));
		Actions act = new Actions(driver);
		act.moveToElement(logoutEle).perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
}
