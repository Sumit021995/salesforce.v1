package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath="//span[text()='Create Contact']") private WebElement createContactPlusBtn; 
	
	
	public WebElement getCreateContactPlusBtn() {
		return createContactPlusBtn;
	}
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateContactBtn()
	{
		getCreateContactPlusBtn().click();
	}

}
