package sampleTestExecution;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	Properties prop=null;
	public void launchBrowser(WebDriver driver)
	{
		String url = prop.getProperty("url");
		if(url.equalsIgnoreCase("chrome")) 
			driver = new ChromeDriver();
		else if(url.equalsIgnoreCase("firefox")) 
			driver = new FirefoxDriver();
		else if(url.equalsIgnoreCase("edge")) 
			driver = new EdgeDriver();
		else  driver = new ChromeDriver();	
	}
}
