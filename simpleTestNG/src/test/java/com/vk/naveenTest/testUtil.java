package com.vk.naveenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class testUtil {
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Asus\\eclipse-workspace\\simpleTestNG\\src\\test\\java\\com\\vk\\naveenTest\\ExcelData.xlsx";
	
	public static Object[][] getTestData(String sheetName) throws Exception {
		
		FileInputStream file = null;
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
		
	}

}
