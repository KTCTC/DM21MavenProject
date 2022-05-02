package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		
		File f = new File(System.getProperty("user.dir")+"\\KTCTC.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh = wb.getSheet("Oct");
		
		XSSFRow row = sh.getRow(0);
		
		XSSFCell cel = row.getCell(0);
		
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		
		System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
		
		System.out.println(sh.getRow(3).getCell(0).getStringCellValue());
		
		System.out.println(cel);
		System.out.println(String.valueOf(cel));
		
		
		
		
		

	}

}
