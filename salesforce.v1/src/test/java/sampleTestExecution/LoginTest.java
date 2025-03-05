package sampleTestExecution;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.PropertiesUtility;
import objectRepo.LoginPage;

public class LoginTest {
	
	
	PropertiesUtility pUtility = new PropertiesUtility();
	WebDriver driver;
	public void launchBrowser() throws FileNotFoundException, IOException
	{
		String browser = pUtility.fetchValueFromPropertiesFile("browser");
		if(browser.equalsIgnoreCase("chrome")) 
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox")) 
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge")) 
			driver = new EdgeDriver();
		else  driver = new ChromeDriver();	
	}
	public void loginToApplication() throws FileNotFoundException, IOException
	{
		String url = pUtility.fetchValueFromPropertiesFile("url");
		String username = pUtility.fetchValueFromPropertiesFile("username");
		String password = pUtility.fetchValueFromPropertiesFile("password");
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(username, password);
	}
	public void logoutFromApplication() 
	{
		WebElement logoutEle = driver.findElement(By.xpath("//*[name()='svg']"));
		Actions act = new Actions(driver);
		act.moveToElement(logoutEle).perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LoginTest loginText = new LoginTest();
		loginText.launchBrowser();
		loginText.loginToApplication();
	}
	
}
