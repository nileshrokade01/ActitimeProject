package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.examples.xssf.usermodel.CreateCell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

/**
 * this is a generic library class which contains all the generic methods.
 * @author NILESH
 *
 */
public class FileLibrary {

	/**
	 * This is a generic method which is used to read the data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readingFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * this method is the generic method which is used for the read the data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readTheDataFromExcelSheet(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./testdata/Testdata.xlsx");
	   Workbook wb = WorkbookFactory.create(fis1);
	 String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	  return value;
	}
}
