package sampleTestExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectCreation {
	
	@FindBy(linkText="Products") private WebElement productLink;
	@FindBy(xpath="//span[text()='Add Product']") private WebElement createProductLink;
	@FindBy(xpath="//button[text()='Add']") private WebElement addProductBtn;
	@FindBy(name="productName") private WebElement productNameTextField;
	@FindBy(name="productCategory") private WebElement productCategoryDropDown;
	@FindBy(name="vendorId") private WebElement vendorCategoryDropDown;
	@FindBy(name="quantity") private WebElement quantityTextField;
	@FindBy(name="price") private WebElement priceTextField;
	
	public ProjectCreation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getCreateProductLink() {
		return createProductLink;
	}
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
	public void createProduct()
	{
//		getProductLin
	}
	public static void main(String[] args) {
		
	}
	
}
