package sampleTestExecution;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleLogin {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
//		WebElement unEle = driver.findElement(By.id("username"));
//		unEle.sendKeys("rmgyantra",Keys.TAB,"rmgy@9999");
//		unEle.submit();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if(currentUrl.contains("dashboard"))
			System.out.println("Evaluated True");
		WebElement element = driver.findElement(By.xpath("//*[name()='svg']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
