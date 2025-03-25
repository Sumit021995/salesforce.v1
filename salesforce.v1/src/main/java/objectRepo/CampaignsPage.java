package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	@FindBy(id="username") private WebElement unTextField;
	@FindBy(id="inputPassword") private WebElement pwdTextField;
	@FindBy(xpath="//select[@class='form-control']") private WebElement searchDropDown;
	@FindBy(xpath="//input[@class='form-control']") private WebElement searchTextField;
	@FindBy(xpath="//span[text()='Create Campaign']") private WebElement createCampaignBtn;
	public WebElement getUnTextField() {
		return unTextField;
	}
	public WebElement getPwdTextField() {
		return pwdTextField;
	}
	public WebElement getSearchDropDown() {
		return searchDropDown;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateCampaignBtn()
	{
		getCreateCampaignBtn().click();
	}
	
}
