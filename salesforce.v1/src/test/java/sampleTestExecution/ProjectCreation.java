package sampleTestExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProjectCreation {
	@FindBy(linkText="Products") private WebDriver productLink;
	@FindBy(xpath="//span[text()='Add Product']") private WebDriver createProductLink;
	@FindBy(xpath="//button[text()='Add']") private WebDriver addProductBtn;
	@FindBy(name="productName") private WebDriver productNameTextField;
	@FindBy(name="productCategory") private WebDriver productCategoryDropDown;
	@FindBy(name="vendorId") private WebDriver vendorCategoryDropDown;
	@FindBy(name="quantity") private WebDriver quantityTextField;
	@FindBy(name="price") private WebDriver priceTextField;
	public static void main(String[] args) {
		
	}
	
}
