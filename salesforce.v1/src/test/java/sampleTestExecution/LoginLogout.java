package sampleTestExecution;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;
import objectRepo.LoginPage;

public class LoginLogout {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		WebDriver driver = new ChromeDriver();
		LoginPage login = new LoginPage(driver);
		PropertiesUtility pUtil = new PropertiesUtility();
		String UN = pUtil.fetchValueFromPropertiesFile("username");
		String PWD = pUtil.fetchValueFromPropertiesFile("password");
		login.loginToApp(UN,PWD);
		
	}
}
