package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(linkText="Contacts") private WebElement contactLink; 
	@FindBy(xpath="//span[text()='Create Contact']") private WebElement createContactBtn; 
	@FindBy(name="organizationName") private WebElement organizationTextField; 
	@FindBy(name="department") private WebElement departmentTextField; 
	@FindBy(name="title") private WebElement titleTextField; 
	@FindBy(name="officePhone") private WebElement officePhoneTextField; 
	@FindBy(name="contactName") private WebElement contactNameTextField; 
	@FindBy(name="mobile") private WebElement mobileTextField; 
	@FindBy(name="email") private WebElement mobileTextField; 
}
