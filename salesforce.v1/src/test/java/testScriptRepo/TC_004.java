package testScriptRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreateProductPage;
import objectRepo.DashboardPage;
import objectRepo.ProductPage;

public class TC_004 extends BaseClass {
	@Test
	public void createProduct()
	{
		new DashboardPage(driver).getProductsLink().click();
		new ProductPage(driver).getCreateProductBtn().click();
		CreateProductPage cpPage = new CreateProductPage(driver);
		cpPage.createProductWithMandatoryFields("Drone","Electronics",2,1500,4);
//		new WebDriverUtility().waitForElementToBeVisible(driver,new ProductPage(driver).getCreateProductConfirmationMsg(), 5);
//		if(new ProductPage(driver).getCreateProductConfirmationMsg().getText().equals(cpPage))
		
	}
}
