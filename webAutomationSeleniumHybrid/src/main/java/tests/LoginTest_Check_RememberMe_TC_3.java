package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.SFDCListeners;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;

@Listeners(SFDCListeners.class)
public class LoginTest_Check_RememberMe_TC_3  extends BaseTest{
	
	
	@Test
	public void TC3() throws IOException {
		
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test=BaseTest.threadExtentTest.get();
		LoginPage lp = new LoginPage(driver);
		test.info("Test case 3 Start");
		logger.info("Test case 3 Start");
		test.info("driver congigured");
		logger.info("driver congigured");
	
		lp.loginToApp_RememberMe(driver);
		test.info("user able to click on remember me check box and able to login");
		logger.info("user able to click on remember me check box and able to login");
		UserMenuPage ump=new UserMenuPage(driver);
		
		//ump.clickOnUserMenu();
		ump.userMenu.click();
		test.info("user able to click on usermenu dropdown");
		logger.info("user able to click on usermenu dropdown");
		Assert.assertTrue(ump.logOut(driver), "logout is not selected");
		
		//ump.logOut(driver);
		
		//ump.Logout.click();
		test.info("user able to click on logout from Usermenu dropdown");
		logger.info("user able to click on logout from Usermenu dropdown");
		String title=driver.getTitle();
		System.out.println(title);
		test.info("user navigated to login salesforce page");
		logger.info("user navigated to login salesforce page");
		
		CommonUtils.waitForElement(driver, lp.savedUsername);
	boolean userNameDisplayed=	lp.savedUsername.isDisplayed();
	Assert.assertTrue(userNameDisplayed,"UserName not populated");
	test.info("username is populated after logout");
	logger.info("username is populated after logout");
	boolean rememberMeSelected=lp.rememberMe.isSelected();
	Assert.assertTrue(rememberMeSelected,"not selected");
	test.info("remember me check box is enabled");
	logger.info("remember me check box is enabled");
	test.info("LoginTest_Check_RememberMe_TC_3-passed ");
	logger.info("LoginTest_Check_RememberMe_TC_3-passed ");
	
		
		
		
		
		
	}

}
