package genericUtility;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener ,ISuiteListener{
	

	ExtentTest test;
	ExtentReports  report;
	String dateTimeStamp = new JavaUtility().getCalanderDetails("YYYYMMdd_hhmmss");
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Suite Level Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suite Level Report BackUp");
	}

	@Override
	public void onTestStart(ITestResult result) {
//		String className = result.getMethod().getQualifiedName();
		String methodName = result.getMethod().getQualifiedName();
		Reporter.log("✅ "+ methodName+" Test Started Successfully ",true);
		
		// Adding test method to ExtentReports
		test = report.createTest(methodName);
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("✅ "+ methodName+" Test Executed Successfully ",true);
		
		// Success status logging
//		test.log(Status.PASS, "✅ "+methodName+" is Passed");
		extentTest.get().log(Status.PASS, "✅ "+methodName+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("❌ "+ methodName+" Test Executecution Failed... ",true);
		Reporter.log("⚠️ in process to take Screenshot...",true);
		// Fail status logging
//		test.log(Status.FAIL, "❌  "+methodName+" is Failed");
		extentTest.get().log(Status.FAIL, "✅ "+methodName+" is Failed");
		extentTest.get().log(Status.INFO, result.getThrowable());
		// Info logging
//		test.log(Status.INFO, result.getThrowable());
		
		try {
//			String path = new SeleniumUtility().getWebPageScreenshot(BaseClass.sDriver, dateTimeStamp);
//			test.addScreenCaptureFromPath(path);
			String path = new SeleniumUtility().getWebPageScreenshotFromBase64(BaseClass.getDriver());
			test.addScreenCaptureFromBase64String(path);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Test Skipped...",true);
		// Skip Status logging
//		test.log(Status.SKIP, "⚠️ "+methodName+" Test Skipped");
		extentTest.get().log(Status.SKIP, "⚠️ "+methodName+" Test Skipped");
		
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
		
		Reporter.log("onStart method Execution Started",true);
		// Configuration of Extent Report 
		ExtentSparkReporter reporter = new ExtentSparkReporter(".//ExtentReport//report"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("NinzaCrm_Report"+dateTimeStamp);
		reporter.config().setReportName("NinzaCrm_ExtentsReport");
		reporter.config().setTheme(Theme.DARK);
		
		// Create an empty report with configuration 
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Base OS", "Windows 10");
		report.setSystemInfo("Base URL", "http://49.249.28.218:8098/");
		report.setSystemInfo("Default Browser", "Chrome");
		report.setSystemInfo("Reporter", "Sumit");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(" On Test Finish Executed",true);
		report.flush();
		
	}

	
}
	
