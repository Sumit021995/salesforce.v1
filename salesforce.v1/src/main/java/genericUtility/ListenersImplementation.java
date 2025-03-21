package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplementation implements ITestListener {

	String calanderDetails = new JavaUtility().getCalanderDetails("YYYYMMdd_hhmmss");

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
			new SeleniumUtility().getWebPageScreenshot(BaseClass.sDriver, calanderDetails);
			
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
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(" On Test Finish Executed",true);
		
	}

	
}
	
