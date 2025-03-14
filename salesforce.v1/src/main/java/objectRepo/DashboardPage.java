package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	@FindBy(linkText="Campaigns") private WebElement campaignsLink;
	@FindBy(linkText="Contacts") private WebElement contactLink;
	@FindBy(linkText="Leads") private WebElement leadsLink;
	@FindBy(linkText="Opportunities") private WebElement opportunitiesLink;
	@FindBy(linkText="Products") private WebElement productsLink;
	@FindBy(xpath="//*[name()='svg']") private WebElement profileIcon;
	@FindBy(xpath="//div[text()='Logout ']") private WebElement logoutIcon;
}
