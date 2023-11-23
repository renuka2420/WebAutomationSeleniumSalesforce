package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//import constants.FileConstants;
import pages.LoginPage;
//import utils.CommonUtils;
//import utils.FileUtils;

public class LoginTest_TC_1 extends BaseTest {

	
	@Test
	public void TC1() throws IOException {
		
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
	lp.loginToAppEmptyPassword(driver);
	String error=lp.errorMessage.getText();
	if(error.equals("Please enter your password.")) {
		
		System.out.println("error message is displayed");
	}
	
	}

}


