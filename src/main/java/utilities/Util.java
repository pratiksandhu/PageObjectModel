package utilities;

import java.io.File;


import java.io.FileInputStream;

import java.io.IOException;


import org.apache.commons.io.FileUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class Util extends BaseClass {
 public static long PageLoadOutTime= 20;
 public static long ImplicitWait= 20;
 String path="C:\\Selenium_WorkSpace\\POMByNaveen\\src\\main\\java\\data\\PomByNaveen.xlsx";
 
 public Object[][] getData(String sheetName) throws InvalidFormatException, IOException{
	 FileInputStream file=new FileInputStream(path);
	 Workbook book= WorkbookFactory.create(file);
	 org.apache.poi.ss.usermodel.Sheet sheet=book.getSheet(sheetName);
	 Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 for(int i=0;i<sheet.getLastRowNum();i++) {
		 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		 }
	 }
	return data;
 }
 
 public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}  
}
