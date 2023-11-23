package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.SFDCListeners;
//import constants.FileConstants;
import pages.LoginPage;
//import utils.FileUtils;
@Listeners(SFDCListeners.class)
public class LoginTest_TC_2 extends BaseTest{
	
	@Test
	public void TC2() throws IOException {
		
		/*WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get("https://login.salesforce.com/");
		lp.username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		lp.password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		lp.loginButton.click();*/
		
		
		

			WebDriver driver = BaseTest.getDriver();
			ExtentTest test=BaseTest.threadExtentTest.get();
			LoginPage lp = new LoginPage(driver);
			test.info("driver congigured");
			lp.loginToApp(driver);
			test.info("LoginTest_TC_2:Test case 2 passed");
			logger.info("LoginTest_TC_2 :passed");
		}
	}


