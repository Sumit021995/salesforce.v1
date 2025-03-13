package objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username") private WebElement unTextField;
	@FindBy(id="inputPassword") private WebElement pwdTextField;
	@FindBy(xpath="//button[@class='btn'") private WebElement loginBtn;
	@FindBy(linkText="Forgot password?") private WebElement forgotPwdLink;
	@FindBy(linkText="Create Account") private WebElement createAccountLink;

	public WebElement getUnTextField() {
		return unTextField;
	}
	public WebElement getPwdTextField() {
		return pwdTextField;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}
	public WebElement getForgotPwdLink() {
		return forgotPwdLink;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void loginToApp(String username ,String password)
	{
		getUnTextField().sendKeys(username,Keys.TAB,password,Keys.ENTER);
	}
	public void forgotPasswordProcess()
	{
		getForgotPwdLink().click();
		// to be continued
		
	}
	public void createNewAccount()
	{
		getCreateAccountLink().click();
		// to be continued
		
	}
	public void loginToApplication(WebDriver driver)
	{
		
	}
	
	
}
