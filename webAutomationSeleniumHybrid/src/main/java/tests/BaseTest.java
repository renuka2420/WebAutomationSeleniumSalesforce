package tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class BaseTest {
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> threadExtentTest =new ThreadLocal<>();
	
	public static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	
	
	public static Logger logger=LogManager.getLogger("BaseTest");
	
	
	@BeforeMethod
	public void setUp(Method name) {
		BaseTest.test=extent.createTest(name.getName());
		logger.info("BaseTest:setUp:"+name.getName()+"Test object for reporting created");
	}
	
@AfterMethod
public void tearDown() {
	
}
@Parameters({"browserName","isHeadless"})
	@BeforeTest
	public static void setDriver(String browserName,boolean isHeadless) {
//chrome should be parameterized
		spark=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		
		WebDriver driver = BaseTest.getBrowserType(browserName, isHeadless);
		threadLocalDriver.set(driver);
	}




	public static WebDriver getDriver() {
		return threadLocalDriver.get();

	}

	@AfterTest
	public static void removeDriver() {
		getDriver().close();
		threadLocalDriver.remove();
		extent.flush();
	}

	public static WebDriver getBrowserType(String browserName,boolean headless) {

		WebDriver driver ;

		String browserType = browserName.toLowerCase();

		switch (browserType) {
		case "chrome":
			
			if(headless) {
			ChromeOptions co=new ChromeOptions();
			logger.info("BaseTest:getBrowserType:"+"Headless chrome onfigured");
			co.addArguments("--headless");
			driver = new ChromeDriver(co);
			}
			else
			{
			driver = new ChromeDriver();
			logger.info("BaseTest:getBrowserType:"+"chrome onfigured");
			}
			
			break;

		case "firefox":
			driver = new FirefoxDriver();
			logger.info("BaseTest:getBrowserType:"+"firefox  onfigured");
			break;
		case "safari":
			driver = new SafariDriver();
			logger.info("BaseTest:getBrowserType:"+"safari onfigured");
			break;
		case "edge":
			driver = new EdgeDriver();
			logger.info("BaseTest:getBrowserType:"+"Edge onfigured");
			break;

		default:
			driver = null;
			logger.fatal("BaseTest:getBrowserType:"+"Incorrect browser name supplied");
			break;

		}
		
		return driver;

	}

}
