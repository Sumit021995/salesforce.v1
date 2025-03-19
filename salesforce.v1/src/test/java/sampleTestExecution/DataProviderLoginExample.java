package sampleTestExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLoginExample {
	@DataProvider(name="loginData")
	public Object[][] provideData()
	{
		Object[][] arr = {
			{"sumitofficial021995@gmail.com","Infocus4999@"},
			{"infocus4999@gmail.com","Infocus4999@123"}
		};
		return arr;
	}
	@Test(dataProvider = "loginData")
	public void loginToShopperAndLogout(String email , String pwd ) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys(email,Keys.TAB,pwd,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='BaseBadge-root MuiBadge-root css-1rzb3uu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Logout']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
