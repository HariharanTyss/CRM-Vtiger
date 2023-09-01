package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledataTest {

	public static void main(String[] args) throws Throwable, IOException 
	{
		FileInputStream fis =new FileInputStream("./src/test/resources/TestData/testData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		int rowcount = wb.getSheet("org").getPhysicalNumberOfRows();
		System.out.println("Row Count is "+rowcount);
		System.out.println("===============");
		
		for (int i = 1; i <rowcount; i++) 
		{
			String data = wb.getSheet("org").getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}
		wb.close();
		
	}

}
