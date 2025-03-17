package objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateContactPage {
	WebDriver driver;
	@FindBy(name="organizationName") private WebElement organizationTextField; 
	@FindBy(name="department") private WebElement departmentTextField; 
	@FindBy(name="title") private WebElement titleTextField; 
	@FindBy(name="officePhone") private WebElement officePhoneTextField; 
	@FindBy(name="contactName") private WebElement contactNameTextField; 
	@FindBy(name="mobile") private WebElement mobileTextField; 
	@FindBy(name="email") private WebElement emailTextField;
	@FindBy(xpath="//button[text()='Create Contact']") private WebElement createContactBtn; 
	@FindBy(xpath="//*[name()='svg' and @data-icon='plus']") private WebElement createContactPlusIcon; 
	
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}
	public WebElement getCreateContactPlusIcon() {
		return createContactPlusIcon;
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
	public void createContactWithMandatoryFields(String org,String title,String contactName ,String mobile)
	{
		getOrganizationTextField().sendKeys(org,Keys.TAB,title);
		getContactNameTextField().sendKeys(contactName,Keys.TAB,mobile);
		WebDriverUtility wdUtil = new WebDriverUtility();
		wdUtil.switchToWindow(driver, );
	}
}
