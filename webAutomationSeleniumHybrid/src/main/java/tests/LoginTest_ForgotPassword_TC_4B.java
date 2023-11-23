package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.LoginPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class LoginTest_ForgotPassword_TC_4B extends BaseTest {

	@Test
	public void TC4B() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = BaseTest.threadExtentTest.get();
		LoginPage lp = new LoginPage(driver);
		test.info("Test case 4B Started");
		logger.info("Test case 4B Started");
		test.info("driver congigured");
		logger.info("driver congigured");

		lp.loginToApp_B(driver);
		
		String errorMessage=lp.errorMessage.getText();
		
		
		Assert.assertEquals(errorMessage,
				FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "expctedErrorMessage"));
		
		

	}

}
