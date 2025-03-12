package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is an Utility class which contains generic methods for selenium library
 * @author-Sumit
 * @version-01.10.25
 */
public class WebDriverUtility {
	
	
	/**
	 * This is a generic method 
	 * @param driver
	 * @param element
	 * @param second
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element,long second)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.invisibilityOf(element));
	
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param second
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element,long second)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * 
	 * @param driver
	 * @param partialUrl
	 */
	public void switchToWindow(WebDriver driver,String partialUrl)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String window: allWindowIds)
		{
			driver.switchTo().window(window);
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains(partialUrl))
				break;
		}
		
	}
}