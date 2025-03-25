package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	

	@FindBy(xpath="//span[text()='Add Product']") private WebElement createProductBtn;
	@FindBy(xpath="//div[@class='Toastify__toast-body']") private WebElement createProductConfirmationMsg;
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}

	public WebElement getCreateProductConfirmationMsg() {
		return createProductConfirmationMsg;
	}
	
	
}

