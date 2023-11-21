package constants;

import utils.CommonUtils;

public class FileConstants {

	public static final String LOGIN_TESTDATA_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testData\\Logintestsheet.xlsx";;
	public static final String LOGIN_TESTDATA_FILE_PATH2 = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testData\\LoginTestData.properties";
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\"
			+ CommonUtils.getStringDateandTimeStamp() + "_SFDC.PNG";;
	public static final String USER_MENU_TEST_DATA_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testData\\userMenuTestData.properties";

	public static final String PROFILE_PHOTO_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testData\\photo.png";
	public static final String REPORT_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\"
			+ CommonUtils.getStringDateandTimeStamp() + "_SFDC.html";

}