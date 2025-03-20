package testScriptRepo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.WebDriverUtility;
import objectRepo.CreateProductPage;
import objectRepo.DashboardPage;
import objectRepo.ProductPage;

public class TC_004 extends BaseClass {
	@Test(groups= {"Regression"})
	public void createProduct() throws Exception
	{
		new DashboardPage(driver).getProductsLink().click();
		new ProductPage(driver).getCreateProductBtn().click();
		CreateProductPage cpPage = new CreateProductPage(driver);
		cpPage.createProductWithMandatoryFields("Drone","Electronics",2,1500,4);
		new WebDriverUtility().waitForElementToBeVisible(driver,new ProductPage(driver).getCreateProductConfirmationMsg(), 5);
		Assert.assertTrue(new ProductPage(driver).getCreateProductConfirmationMsg().getText().contains("Drone"));
		Reporter.log("Validated True",true);
		
	}
}
