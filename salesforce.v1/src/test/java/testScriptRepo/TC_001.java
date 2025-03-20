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
public class TC_001 extends BaseClass {
	
	@Test(groups= {"Smoke","Regression"})
	public void createCampaign_001() throws Exception
	{
		System.out.println("Test Exceution Started");
		CampaignsPage cPage = new CampaignsPage(driver);
		cPage.clickOnCreateCampaignBtn();
		CreateCampaignPage ccPage = new CreateCampaignPage(driver);
		JavaUtility jUtil = new JavaUtility();
		int randomNumber = jUtil.generateRandomNumber(1000);
		int randomNumber2 = jUtil.generateRandomNumber(100);
		ccPage.createCampaign("Campaign0211"+randomNumber,"This is campaign Status "+randomNumber ,""+randomNumber2);
		Assert.assertEquals((ccPage.getCreateCampaignConfirmationMsg().getText()).contains("Campaign0211"+randomNumber), true);
		Reporter.log("Validated True",true);
		Assert.fail();
	}
}
