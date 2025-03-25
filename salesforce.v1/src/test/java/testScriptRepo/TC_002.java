package testScriptRepo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.JavaUtility;
import objectRepo.CampaignsPage;
import objectRepo.CreateCampaignPage;

//@Listeners(genericUtility.ListenersImplementation.class)
public class TC_002 extends BaseClass {
	
	@Test(groups= {"Smoke"}, retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void createCampaign_002() throws Exception
	{
		System.out.println("Test Exceution Started");
		CampaignsPage cPage = new CampaignsPage(driver);
		cPage.clickOnCreateCampaignBtn();
		CreateCampaignPage ccPage = new CreateCampaignPage(driver);
		JavaUtility jUtil = new JavaUtility();
		int randomNumber = jUtil.generateRandomNumber(1000);
		int randomNumber2 = jUtil.generateRandomNumber(100);
		int randomNumber3 = jUtil.generateRandomNumber(10);
		String calanderDetails = jUtil.getCalanderDetails("dd-MM-YYYY", randomNumber3);
		ccPage.createCampaign("Campaign0211"+randomNumber,"This is campaign Status "+randomNumber ,""+randomNumber2,calanderDetails);
		new JavaUtility().waitFromThread(2000);
		String confirmationMsg = ccPage.getCreateCampaignConfirmationMsg().getText();
		Assert.assertTrue(confirmationMsg.contains("Campaign0211"));
		System.out.println("✅ Test Exceution Ended Successfully");
	}
}
