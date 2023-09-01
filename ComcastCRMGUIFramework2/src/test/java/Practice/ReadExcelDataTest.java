package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelDataTest 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/TestData/testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String login = wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		
		String password = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
		
		wb.close();
		System.out.println(login);
		System.out.println(password);
	}

}
