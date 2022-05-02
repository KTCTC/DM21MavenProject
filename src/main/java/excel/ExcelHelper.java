package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private XSSFSheet sh;
	public ExcelHelper(String fileName, String sheetName) {
		try {
			File f = new File(System.getProperty("user.dir") + "\\"+fileName);

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			 sh = wb.getSheet(sheetName);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<String> getKeysList()
	{
		ArrayList<String> keys = new ArrayList<>();
		for (int i = 1; i <=sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(0);
			String ss1 = printCellValueAccordingToCellType(cel);
			keys.add(ss1);

		}
		return keys;
		
	}
	
	public ArrayList<String> getValuesList()
	{
		ArrayList<String> values = new ArrayList<>();
		for (int i = 1; i <=sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(1);
			String ss1 = printCellValueAccordingToCellType(cel);
			values.add(ss1);

		}
		return values;
		
	}
	
	public HashMap<String,String> getKayValuePair()
	{
		HashMap<String, String> data = new HashMap<>();
		
		for (int i = 1; i <=sh.getLastRowNum(); i++)
		{
			XSSFRow row = sh.getRow(i);			
			XSSFCell keyCel = row.getCell(0);
			XSSFCell ValCel = row.getCell(1);
			String key = printCellValueAccordingToCellType(keyCel);
			String val = printCellValueAccordingToCellType(ValCel);
			data.put(key, val);
			
		}
		return data;
		
	}
	public HashMap<String,String> getKayValuePair2()
	{
		HashMap<String, String> data = new HashMap<>();
		
		for (int i = 1; i <=sh.getLastRowNum(); i++)
		{
			XSSFRow row = sh.getRow(i);					
			data.put(printCellValueAccordingToCellType(row.getCell(0)), printCellValueAccordingToCellType(row.getCell(1)));
			
		}
		return data;
		
	}
	
	public HashMap<String,String> getKayValuePair3()
	{
		HashMap<String, String> data = new HashMap<>();
		ArrayList<String> keys = getKeysList();
		ArrayList<String> values = getValuesList();
		
		for (int i = 0; i <=keys.size(); i++)
		{
			data.put(keys.get(i), values.get(i));
			
		}
		return data;
		
	}
	
	
	
	private static String printCellValueAccordingToCellType(XSSFCell cel) {
		CellType celTp = cel.getCellType();
	Object dd = "";
		switch (celTp) {
		case STRING:
			dd = cel.getStringCellValue();
			break;

		case NUMERIC:
			dd = cel.getNumericCellValue();
			break;

		case BOOLEAN:
			dd = cel.getBooleanCellValue();
			break;
		default:
			System.out.println("This is invalid cell type");
			break;
	}
		
		return dd.toString();
		
		
	}

}
