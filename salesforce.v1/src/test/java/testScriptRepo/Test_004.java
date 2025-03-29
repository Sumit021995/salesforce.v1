package testScriptRepo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.JavaUtility;
import objectRepo.CreateProductPage;
import objectRepo.DashboardPage;
import objectRepo.ProductPage;

//@Listeners(genericUtility.ListenersImplementation.class)
public class Test_004 extends BaseClass {
	@Test(groups= {"Regression"}, retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void createProduct() throws Exception
	{
		int randomNumber = new JavaUtility().generateRandomNumber(1000)+10;
		new DashboardPage(driver).getProductsLink().click();
		new ProductPage(driver).getCreateProductBtn().click();
		CreateProductPage cpPage = new CreateProductPage(driver);
		cpPage.createProductWithMandatoryFields("Drone"+randomNumber,"Electronics",2,1500,4);
		new JavaUtility().waitFromThread(2000);
//		Assert.fail();
		String confirmationMsg = new ProductPage(driver).getCreateProductConfirmationMsg().getText();
		System.out.println(confirmationMsg);
		Assert.assertEquals(confirmationMsg.contains("Drone"+randomNumber),true);
		
	}
	
	@Test(dataProvider = "provideCreateContactData",dataProviderClass = testScriptRepo.Test_003.class)
	public void getDataPrint(HashMap<String,String> m)
	{
		System.out.println(m.get("org"));
		System.out.println(m.get("title"));
		System.out.println(m.get("contactName"));
		System.out.println(m.get("mobile"));
	}
}
