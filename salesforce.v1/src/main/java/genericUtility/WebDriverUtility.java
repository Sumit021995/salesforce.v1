package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This is a generic method to 
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
	public void waitForElementToBeClicable(WebDriver driver,WebElement element,long second)
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