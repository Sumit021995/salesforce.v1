package testScriptRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.JavaUtility;
import objectRepo.ContactPage;
import objectRepo.CreateContactPage;
import objectRepo.DashboardPage;

public class TC_003 extends BaseClass{
	@Test 
	public void createContact() throws Exception
	{
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.getContactLink().click();
		new ContactPage(driver).clickOnCreateContactBtn();
		
		JavaUtility jUtil = new JavaUtility();
		int randomNumber = jUtil.generateRandomNumber(100)+10;
		CreateContactPage ccPage = new CreateContactPage(driver);
		ccPage.createContactWithMandatoryFields(driver,"abc", "title"+randomNumber, "Sumit", "9818425197", "selectCampaign.html", "Campaign0211", "create-contact");
	}
}
