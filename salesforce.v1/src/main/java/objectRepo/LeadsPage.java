package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath="//span[text()='Create Lead']") private WebElement createLeadBtn;
	@FindBy(xpath="//select[@class='form-control']") private WebElement searchByLeadIdDropdown;
	@FindBy(xpath="//input[@class='form-control' and @placeholder='Search by Lead Id']") private WebElement searchByLeadIdTestField;
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
	public WebElement getSearchByLeadIdDropdown() {
		return searchByLeadIdDropdown;
	}
	public WebElement getSearchByLeadIdTestField() {
		return searchByLeadIdTestField;
	}
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
