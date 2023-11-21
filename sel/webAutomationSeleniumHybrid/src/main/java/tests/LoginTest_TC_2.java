package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.LoginPage;
import utils.FileUtils;

public class LoginTest_TC_2 extends BaseTest{
	
	@Test
	public void TC2() throws IOException {
		
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get("https://login.salesforce.com/");
		lp.username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		lp.password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		lp.loginButton.click();
	}

}
