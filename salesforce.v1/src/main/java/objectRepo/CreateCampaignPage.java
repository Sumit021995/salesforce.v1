package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtility;

public class CreateCampaignPage {
	
	@FindBy(name="campaignName") private WebElement campaignNameTextField;
	@FindBy(name="campaignStatus") private WebElement campaignStatusTextField;
	@FindBy(name="targetAudience") private WebElement targetAudienceTextField;
	@FindBy(name="description") private WebElement descriptionTextArea;
	@FindBy(name="targetSize") private WebElement targetSizeTextField;
	@FindBy(xpath="//button[text()='Create Campaign']") private WebElement createCampaignBtn;
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}
	public WebElement getCampaignStatusTextField() {
		return campaignStatusTextField;
	}
	public WebElement getTargetAudienceTextField() {
		return targetAudienceTextField;
	}
	public WebElement getDescriptionTextArea() {
		return descriptionTextArea;
	}
	public WebElement getTargetSizeTextField() {
		return targetSizeTextField;
	}
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void createCampaign(String campaignName , String targetSize)
	{
		
		getCampaignNameTextField().sendKeys();
	}
}
