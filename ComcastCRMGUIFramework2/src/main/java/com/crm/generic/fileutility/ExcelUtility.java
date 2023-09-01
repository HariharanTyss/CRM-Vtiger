package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcelFile(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis =new FileInputStream("./resourse/testData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		 String data= wbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		 wbook.close();
		 return data;
	}
	public void writeDataFromExcelFile(String sheet,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis =new FileInputStream("./resourse/testData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		Sheet shtt = wbook.getSheet(sheet);
		Row roww = shtt.getRow(row);
		Cell cll = roww.createCell(cell);
		cll.setCellType(CellType.STRING);
		cll.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./resourse/testData.xlsx");
		wbook.write(fos);
		 wbook.close();
		
	}
	

}
