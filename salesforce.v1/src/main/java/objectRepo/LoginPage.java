package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.IPathUtility;

public class LoginPage {
	@FindBy(id="username") private WebElement unTextField;
	@FindBy(id="inputPassword") private WebElement pwdTextField;
	
	public WebElement getUnTextField() {
		return unTextField;
	}
	public WebElement getPwdTextField() {
		return pwdTextField;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void loginToApp(WebDriver driver)
	{
		getUnTextField().sendKeys();
	}
	
}
