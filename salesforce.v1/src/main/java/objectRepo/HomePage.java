package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(linkText="Contacts") private WebElement contactLink; 
	@FindBy(xpath="//span[text()='Create Contact']") private WebElement createContactBtn; 
	@FindBy(name="organizationName") private WebElement organizationTextField; 
}
