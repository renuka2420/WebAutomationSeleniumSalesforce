package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.SFDCListeners;
//import constants.FileConstants;
import pages.LoginPage;
//import utils.CommonUtils;
//import utils.FileUtils;
@Listeners(SFDCListeners.class)
public class LoginTest_TC_1 extends BaseTest {

	
	@Test
	public void TC1() throws IOException {
		
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=BaseTest.threadExtentTest.get();
		LoginPage lp=new LoginPage(driver);
		test.info("driver congigured");
	lp.loginToAppEmptyPassword(driver);
	String error=lp.errorMessage.getText();
	if(error.equals("Please enter your password.")) {
		
		System.out.println("error message is displayed");
		test.info("error message is verified");
		logger.info("LoginTest_TC_1 :passed");
	}
	
	}

}


