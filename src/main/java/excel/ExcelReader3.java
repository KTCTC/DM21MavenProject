package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.math3.optim.nonlinear.scalar.gradient.NonLinearConjugateGradientOptimizer.Formula;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader3 {

	public static void main(String[] args) throws IOException {

		File f = new File(System.getProperty("user.dir") + "\\KTCTC.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh = wb.getSheet("Oct");

		int rowNum = sh.getLastRowNum();

		System.out.println(rowNum);

		int rowNum2 = sh.getPhysicalNumberOfRows();

		System.out.println(rowNum2);

		System.out.println("---------------------------------------------------------");

		for (int i = 0; i < rowNum2; i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(1);

			CellType celTp = cel.getCellType();

			switch (celTp) {
			case STRING:
				System.out.println(cel.getStringCellValue());
				break;

			case NUMERIC:
				System.out.println(cel.getNumericCellValue());
				break;

			case BOOLEAN:
				System.out.println(cel.getBooleanCellValue());
				break;
			default:
				System.out.println("This is invalid cell type");
				break;
			}

		}

	}

}
