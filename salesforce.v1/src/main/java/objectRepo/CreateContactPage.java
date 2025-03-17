package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	@FindBy(name="organizationName") private WebElement organizationTextField; 
	@FindBy(name="department") private WebElement departmentTextField; 
	@FindBy(name="title") private WebElement titleTextField; 
	@FindBy(name="officePhone") private WebElement officePhoneTextField; 
	@FindBy(name="contactName") private WebElement contactNameTextField; 
	@FindBy(name="mobile") private WebElement mobileTextField; 
	@FindBy(name="email") private WebElement emailTextField;
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}
	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}
	public WebElement getTitleTextField() {
		return titleTextField;
	}
	public WebElement getOfficePhoneTextField() {
		return officePhoneTextField;
	}
	public WebElement getContactNameTextField() {
		return contactNameTextField;
	}
	public WebElement getMobileTextField() {
		return mobileTextField;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	} 
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
