package excel;

import java.util.HashMap;

public class SampleClass {

	public static void main(String[] args) {

		ExcelHelper exHelp = new ExcelHelper("KTCTC.xlsx", "Oct");
		HashMap<String, String> dd = exHelp.getKayValuePair();

		System.out.println(dd);

	}

}
