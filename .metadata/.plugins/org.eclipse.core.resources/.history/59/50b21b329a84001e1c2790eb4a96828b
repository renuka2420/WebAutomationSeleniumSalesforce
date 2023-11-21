package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserMenuPage;

public class UserMenuPage_MyProfile_TC_6 extends BaseTest {
	@BeforeMethod
	public void navigateToHome() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	@Test
	public void userMenuDropdown_MyProfile_TC_6() throws IOException, InterruptedException {

		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(), "");
		Assert.assertTrue(ump.selectMyprofile(driver), "");
		Assert.assertTrue(ump.isProfilePageVisible(), "");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyEditContactPopUp(driver), "");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "abc"), "");

	}
}