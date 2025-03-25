package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class DashboardPage {
	WebDriver driver;
	@FindBy(linkText="Campaigns") private WebElement campaignsLink;
	@FindBy(linkText="Contacts") private WebElement contactLink;
	@FindBy(linkText="Leads") private WebElement leadsLink;
	@FindBy(linkText="Opportunities") private WebElement opportunitiesLink;
	@FindBy(linkText="Products") private WebElement productsLink;
	@FindBy(xpath="//*[name()='svg']") private WebElement profileIcon;
	@FindBy(xpath="//div[text()='Logout ']") private WebElement logoutIcon;
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	public WebElement getLogoutIcon() {
		return logoutIcon;
	}
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void logoutFromApplication(WebDriver driver)
	{
		WebDriverUtility wdUtil = new WebDriverUtility();
		wdUtil.waitForElementToBeVisible(driver, getLogoutIcon(), 10);
		Actions act = new Actions(driver);
		act.moveToElement(getProfileIcon()).perform();
		getLogoutIcon().click();
	}
}
