package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignsPage {
	@FindBy(id="username") private WebElement unTextField;
	@FindBy(id="inputPassword") private WebElement pwdTextField;
	@FindBy(xpath="//select[@class='form-control']") private WebElement searchDropDown;
	@FindBy(xpath="//input[@class='form-control']") private WebElement searchTextField;
	@FindBy(xpath="//span[text()='Create Campaign']") private WebElement createCampaignBtn;
}
