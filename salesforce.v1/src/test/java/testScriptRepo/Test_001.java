package testScriptRepo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.JavaUtility;
import objectRepo.CampaignsPage;
import objectRepo.CreateCampaignPage;


@Listeners(genericUtility.ListenersImplementation.class)
public class Test_001 extends BaseClass {
	
	@Test(groups= {"Smoke","Regression"},retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void createCampaign_001() throws Exception
	{
		System.out.println("Test Exceution Started");
		CampaignsPage cPage = new CampaignsPage(driver);
		cPage.clickOnCreateCampaignBtn();
		CreateCampaignPage ccPage = new CreateCampaignPage(driver);
		JavaUtility jUtil = new JavaUtility();
		String dateFormat = jUtil.getCalanderDetails("dd_MMM_hhmmss");
		Assert.fail();
		ccPage.createCampaign("Campaign_"+dateFormat,"This is campaign Status "+dateFormat ,""+jUtil.generateRandomNumber(100));
		new JavaUtility().waitFromThread(2000);
		String confirmationMsg = ccPage.getCreateCampaignConfirmationMsg().getText();
		Assert.assertTrue(confirmationMsg.contains("Campaign_"+dateFormat));
		
		System.out.println("✅ Test Exceution Ended Successfully");
	}
}
