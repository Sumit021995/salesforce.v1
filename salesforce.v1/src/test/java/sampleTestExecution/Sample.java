package sampleTestExecution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;
import objectRepo.LoginPage;

public class Sample {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		PropertiesUtility pUtility = new PropertiesUtility();
		String UN = pUtility.fetchValueFromPropertiesFile("username");
		String PWD = pUtility.fetchValueFromPropertiesFile("password");
		String URL = pUtility.fetchValueFromPropertiesFile("url");
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(UN, PWD);
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("dashboard"))
			System.out.println("Evaluated True");
	}
}
