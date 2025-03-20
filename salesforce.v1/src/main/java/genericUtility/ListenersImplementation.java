package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplementation implements ITestListener {


	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" On Test Start Executed",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" On Test Success Executed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String calanderDetails = new JavaUtility().getCalanderDetails("dd_MM_YY_hh_mm_ss");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" On Test Failure Executed",true);
		try {
			new SeleniumUtility().getWebPageScreenshot(BaseClass.sDriver, calanderDetails);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" On Test Skipped Executed",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" On Test Failed With Timeout Executed",true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log(" On Test Start Executed",true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(" On Test Finish Executed",true);
		
	}

	
}
	
