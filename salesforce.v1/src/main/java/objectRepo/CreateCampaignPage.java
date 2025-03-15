package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaignPage {
	@FindBy(name="campaignName") private WebElement campaignNameTextField;
	@FindBy(name="campaignStatus") private WebElement campaignStatusTextField;
	@FindBy(name="targetAudience") private WebElement targetAudienceTextField;
	@FindBy(name="description") private WebElement descriptionTextArea;
	@FindBy(name="targetSize") private WebElement targetSizeTextField;
}
