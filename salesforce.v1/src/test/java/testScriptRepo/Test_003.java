package testScriptRepo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import objectRepo.ContactPage;
import objectRepo.CreateContactPage;
import objectRepo.DashboardPage;
//@Listeners(genericUtility.ListenersImplementation.class)

public class Test_003 extends BaseClass{
	
//	@DataProvider(sampleTestExecution.DataProviderLoginExample.class)
	@Test (groups= {"Smoke"}, retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class,dataProvider = "provideCreateContactData")
	public void createContact_001(HashMap<String,String> m) throws Exception
	{
		System.out.println("Test Exceution Started");
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.getContactLink().click();
		new ContactPage(driver).clickOnCreateContactBtn();
		String childUrl = "selectCampaign.html";
		String parentUrl = "create-contact";
		JavaUtility jUtil = new JavaUtility();
		int randomNumber = jUtil.generateRandomNumber(100)+10;
		CreateContactPage ccPage = new CreateContactPage(driver);
		ccPage.createContactWithMandatoryFields(m.get("org"),m.get("title"),m.get("contactName"),m.get("mobile"));
		WebDriverUtility wdUtil = new WebDriverUtility();
		wdUtil.switchToWindow(driver,childUrl);
		wdUtil.select(ccPage.getSearchDropdown(), 1);
		ccPage.getSearchTextField().sendKeys("Campaign_");
		ccPage.getFirstCampaignSelectBtn().click();
		wdUtil.switchToWindow(driver, parentUrl);
		ccPage.getCreateContactBtn().click();
		jUtil.waitFromThread(1000);
		String confirmationMsg = new ContactPage(driver).getCreateContactConfirmationMsg().getText();
//		System.out.println(confirmationMsg);
		Assert.assertTrue(confirmationMsg.contains("Sumit_Saurav_Data"),"Validation Failed ");
		Reporter.log("✅ Test Exceution Ended Successfully",true);
	}
	
	@DataProvider
	public Object[][] provideCreateContactData()
	{
		HashMap<String, String> data1 = new HashMap<String,String>();
		data1.put("org", "QualiMe_YT_Data1");
		data1.put("title", "Title_Data1");
		data1.put("contactName", "Sumit_Saurav_Data1");
		data1.put("mobile", "9818425197_Data1");
		HashMap<String, String> data2 = new HashMap<String,String>();
		data2.put("org", "QualiMe__YT_Data2");
		data2.put("title", "Title_Data2");
		data2.put("contactName", "Sumit_Saurav_Data2");
		data2.put("mobile", "9818425197_Data2");
		
//		Object[][] arr = {
//				{"sumitofficial021995@gmail.com","Infocus4999@"},
//				{"infocus4999@gmail.com","Infocus4999@123"}
//		};
		Object[][] arr = {
				{data1},
				{data2}
		};
		return arr;
	}
	
//	@DataProvider(name="createContactData")
//	public Object[][] provideCreateContactData()
//	{
//		HashMap<String, String> data1 = new HashMap<String,String>();
//		data1.put("org", "QualiMe_YT_Data1");
//		data1.put("title", "Title_Data1");
//		data1.put("contactName", "Sumit_Saurav_Data1");
//		data1.put("mobile", "9818425197_Data1");
//		HashMap<String, String> data2 = new HashMap<String,String>();
//		data2.put("org", "QualiMe__YT_Data2");
//		data2.put("title", "Title_Data2");
//		data2.put("contactName", "Sumit_Saurav_Data2");
//		data2.put("mobile", "9818425197_Data2");
//		
////		Object[][] arr = {
////				{"sumitofficial021995@gmail.com","Infocus4999@"},
////				{"infocus4999@gmail.com","Infocus4999@123"}
////		};
//		Object[][] arr = {
//				{data1},
//				{data2}
//		};
//		return arr;
//	}
}
