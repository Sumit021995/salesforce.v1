package genericUtility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import objectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;		//only for listeners
	public SeleniumUtility sUtil=new SeleniumUtility();
	public PropertiesUtility pUtil=new PropertiesUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public DatabaseUtility dbUtil=new DatabaseUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void dbConnection() throws Exception
	{
		String dbURL=pUtil.fetchValueFromPropertiesFile("DBURL");
		String dbUN=pUtil.fetchValueFromPropertiesFile("DBUN");
		String dbPWD=pUtil.fetchValueFromPropertiesFile("DBPWD");
		dbUtil.connectToDatabase(dbURL, dbUN, dbPWD);
		System.out.println("DB connection created");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Exception
	{
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sDriver=driver;		//this sDriver is initialized and will be used in Listeners
		sUtil.implicitWait(driver, 15);
		sUtil.maximizeWindow(driver);
		String URL=pUtil.fetchValueFromPropertiesFile("url");
		sUtil.accesToApplication(driver, URL);
		System.out.println("Browser launched successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginOperation() throws Exception
	{
//		String UN=pUtil.getDataFromPropertiesFile("username");
//		String PWD=pUtil.getDataFromPropertiesFile("password");
		String UN=dbUtil.fetchDataFromTable("User1", "username");
		String PWD=dbUtil.fetchDataFromTable("User1", "password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		System.out.println("Login done successfully");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutOperation()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOperation(driver);
		System.out.println("Sign out done successfully");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser closed successfully");
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDBConnection() throws Exception
	{
		dbUtil.closeDBConnection();
		System.out.println("DB connection closed");
	}
}