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
public class Test_002 extends BaseClass {
	
	@Test(groups= {"Smoke"}, retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void createCampaign_002() throws Exception
	{
		System.out.println("Test Exceution Started");
		CampaignsPage cPage = new CampaignsPage(driver);
		cPage.clickOnCreateCampaignBtn();
		CreateCampaignPage ccPage = new CreateCampaignPage(driver);
		JavaUtility jUtil = new JavaUtility();
		String dateFormat = jUtil.getCalanderDetails("dd_MMM_hhmmss");
		int randomTarget = 10+jUtil.generateRandomNumber(100);
		String dateFormat2 = jUtil.getCalanderDetails("dd-MM-YYYY",10);
		ccPage.createCampaign("Campaign_"+dateFormat,"campaign Status:"+dateFormat ,""+randomTarget,dateFormat2);
		new JavaUtility().waitFromThread(2000);
		String confirmationMsg = ccPage.getCreateCampaignConfirmationMsg().getText();
		Assert.assertTrue(confirmationMsg.contains("Campaign_"+dateFormat));
		System.out.println("✅ Test Exceution Ended Successfully");
	}
}
