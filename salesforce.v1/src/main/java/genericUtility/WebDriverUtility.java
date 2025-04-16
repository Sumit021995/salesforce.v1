package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	/**
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver , int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * 
	 * @param driver
	 * @param frameEle
	 */
	public void switchToFrame(WebDriver driver , WebElement frameEle)
	{
		driver.switchTo().frame(frameEle);
	}
	/**
	 * 
	 * @param driver
	 * @param nameId
	 */
	public void switchToFrame(WebDriver driver , String nameId)
	{
		driver.switchTo().frame(nameId);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void select(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void select(String visibleText , WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void deselect(WebElement element,int index)
	{
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	public void deselect(WebElement element,String value)
	{
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	public void deselect(String visibleText , WebElement element)
	{
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}
	public void moveToElement(WebDriver driver)
	{
		Actions act = new Actions(driver);
	}
}