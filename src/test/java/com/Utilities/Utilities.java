package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.Base.BaseClass;

public class Utilities extends BaseClass{
	public static long implicit_wait=30;
	public static long page_load_timeout=50;
    static Workbook book;
    static org.apache.poi.ss.usermodel.Sheet sheet;
    
    public static String TEST_DATA_SHEET_PATH=prop.getProperty("TestDataLocation");
    
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
    	FileInputStream fis = null;
    	try {
    		fis= new FileInputStream(TEST_DATA_SHEET_PATH);
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	try {
    		book= WorkbookFactory.create(fis);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	sheet= book.getSheet(sheetName);
    	
    	Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	for(int i=0;i<sheet.getLastRowNum();i++) {
    		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
    			data[i][k]= sheet.getRow(i+1).getCell(k).toString();
    		}
    	}
    	return data;
    }
	
	public static void Takescreenshot(String FileName) {
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date= new Date();
		String Timestamp= date.toString().replace(":", "_").replace(" ", "_");
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\jwala\\Documents\\Snapshot//SCR_"+Timestamp+FileName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*public String[][] getExcelData(String fileName, String sheetName) throws IOException {
        String[][] data = null;
        try {
             
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
 
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }*/
}

