package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForElementVisibility(WebDriver driver,WebElement element,int second)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
}