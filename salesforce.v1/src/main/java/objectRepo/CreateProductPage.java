package objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.JavaUtility;
import net.bytebuddy.utility.RandomString;

public class CreateProductPage {
	@FindBy(xpath="//button[text()='Add']") private WebElement addProductBtn;
	@FindBy(name="productName") private WebElement productNameTextField;
	@FindBy(name="productCategory") private WebElement productCategoryDropDown;
	@FindBy(name="vendorId") private WebElement vendorCategoryDropDown;
	@FindBy(name="quantity") private WebElement quantityTextField;
	@FindBy(name="price") private WebElement priceTextField;
	
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}
	public WebElement getProductCategoryDropDown() {
		return productCategoryDropDown;
	}
	public WebElement getVendorCategoryDropDown() {
		return vendorCategoryDropDown;
	}
	public WebElement getQuantityTextField() {
		return quantityTextField;
	}
	public WebElement getPriceTextField() {
		return priceTextField;
	}
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createProductWithMandatoryFields(WebDriver driver)
	{
		int randomNumber = new JavaUtility().generateRandomNumber(9);
		
		new DashboardPage(driver).getProductsLink().click();
		new ProductPage(driver).getCreateProductBtn().click();
		getProductNameTextField().sendKeys("Product"+randomNumber,Keys.TAB,Keys.TAB,""+randomNumber,Keys.TAB,""+1000*randomNumber);
		
	}
}
