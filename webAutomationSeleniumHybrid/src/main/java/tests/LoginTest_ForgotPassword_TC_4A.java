package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.SFDCListeners;
import pages.LoginPage;

@Listeners(SFDCListeners.class)
public class LoginTest_ForgotPassword_TC_4A extends BaseTest {
	
	
	
	@Test
	public void TC4A() throws IOException {
		
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test=BaseTest.threadExtentTest.get();
		LoginPage lp = new LoginPage(driver);
		test.info("Test case 4A Started");
		logger.info("Test case 4A Started");
		test.info("driver congigured");
		logger.info("driver congigured");
		lp.loginToApp_ForgotPassword_A(driver);
	}

}
