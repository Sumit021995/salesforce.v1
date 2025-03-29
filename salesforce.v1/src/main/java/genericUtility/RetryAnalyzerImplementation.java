package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	int count=0,maxCount=2; // manual Execution
	@Override
	public boolean retry(ITestResult result) {
		Reporter.log("⚠️ Retry Analyser Started",true);
		while(count<=maxCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
