package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(linkText="Contacts") private WebElement contactLink; 
	@FindBy(xpath="//span[text()='Create Contact']") private WebElement createContactBtn; 
	@FindBy(name="organizationName") private WebElement organizationTextField; 
	@FindBy(name="department") private WebElement departmentTextField; 
	@FindBy(name="title") private WebElement titleTextField; 
	@FindBy(name="officePhone") private WebElement officePhoneTextField; 
	@FindBy(name="contactName") private WebElement contactNameTextField; 
	@FindBy(name="mobile") private WebElement mobileTextField; 
	@FindBy(name="email") private WebElement emailTextField;
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
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
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createContact()
	{
		
	}
}
