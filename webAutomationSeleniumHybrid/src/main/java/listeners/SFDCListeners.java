package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDCListeners extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult res) {
		BaseTest.test=extent.createTest(res.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//BaseTest.test.pass(result.getName()+"Test case 6: passed");
		BaseTest.threadExtentTest.get().pass(MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//BaseTest.test.fail(result.getName()+"Test case 6: failed");
		BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
		try {
			BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
