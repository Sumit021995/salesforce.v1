package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	ExtentTest test;
	ExtentReports  report;

	String dateTimeStamp = new JavaUtility().getCalanderDetails("YYYYMMdd_hhmmss");

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("✅ "+ methodName+" Test Started Successfully ",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("✅ "+ methodName+" Test Executed Successfully ",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("❌ "+ methodName+" Test Executecution Failed... ",true);
		Reporter.log("⚠️ in process to take Screenshot...",true);
		try {
			String path = new SeleniumUtility().getWebPageScreenshot(BaseClass.sDriver, dateTimeStamp);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Test Skipped...",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("❌ "+methodName+" On Test Failed With Timeout..",true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("Test Start Executed",true);
		// Configuration of Extent Report 
		ExtentSparkReporter reporter = new ExtentSparkReporter(".//ExtentReport//report"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("NinzaCrm_Report");
		reporter.config().setReportName("NinzaCrm_ExtentsReport");
		reporter.config().setTheme(Theme.DARK);
		
		// Create an empty report with configuration 
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Base OS", "Windows 10");
		report.setSystemInfo("Base URL", "http://49.249.28.218:8098/");
		report.setSystemInfo("Base OS", "Windows 10");
		report.setSystemInfo("Reporter", "Sumit");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(" On Test Finish Executed",true);
		
	}

	
}
	
