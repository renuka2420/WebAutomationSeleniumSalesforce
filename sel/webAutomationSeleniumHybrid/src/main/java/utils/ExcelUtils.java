package utils;
import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FileConstants;

public class ExcelUtils {
	 
	public void readExcelFile(String filepath,int row,int col) {
		
		
		
	}
	public static void main(String [] args) throws InvalidFormatException, IOException {
		
		XSSFWorkbook loginWorkbook= new XSSFWorkbook(new File(FileConstants.LOGIN_TESTDATA_FILE_PATH));
		XSSFSheet logincreds=loginWorkbook.getSheet("UserCredentials");
	XSSFRow second=	logincreds.getRow(1);
	System.out.println(second.getCell(1));
	System.out.println(second.getCell(2));
		
	}

}
