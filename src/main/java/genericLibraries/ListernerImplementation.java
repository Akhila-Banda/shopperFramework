package genericLibraries;

import java.io.File;

import org.apache.commons.codec.binary.Base16;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListernerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Test Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Fail");
		System.out.println("Failure occured due to :"+result.getThrowable());
		TakesScreenshot ts=(TakesScreenshot)(BaseClass.sdriver);
		JavaUtility jutil=new JavaUtility();
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot"+result.getMethod().getMethodName()+"_"+jutil.getCurrentTime()+"png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped due to :"+result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Started");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Fineshed");

	}

	
	
}
