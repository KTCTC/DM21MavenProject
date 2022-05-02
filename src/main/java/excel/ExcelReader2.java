package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader2 {

	public static void main(String[] args) throws IOException {
		
		File f = new File(System.getProperty("user.dir")+"\\KTCTC.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh = wb.getSheet("Oct");
		
	
		
		int rowNum = sh.getLastRowNum();
		
		System.out.println(rowNum);
		
		int rowNum2 = sh.getPhysicalNumberOfRows();
		
		System.out.println(rowNum2);
		System.out.println("---------------------------------------------------------");
		for (int i=0; i<=rowNum;i++)
		{
			System.out.println(sh.getRow(i).getCell(0).getStringCellValue());
			
		}
		
		System.out.println("---------------------------------------------------------");
		
		for (int i=0;i<rowNum2;i++)
		{
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(1);
			
			//System.out.println(cel.getStringCellValue());
			System.out.println(cel);
			System.out.println(String.valueOf(cel));
			
		}
		
		

	}

}
