package objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username") private WebElement unTextField;

	public WebElement getUnTextField() {
		return unTextField;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void loginToApp(String username ,String password)
	{
		getUnTextField().sendKeys(username,Keys.TAB,password,Keys.ENTER);
	}
	
	
}
