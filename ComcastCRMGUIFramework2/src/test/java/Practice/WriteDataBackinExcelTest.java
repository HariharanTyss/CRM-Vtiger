package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackinExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis =new FileInputStream("./src/test/resources/TestData/testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet("org").getRow(0).createCell(4).setCellValue("Organisation Created");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData/testData.xlsx");
		
		wb.write(fos);
		
		wb.close();
	}
}
