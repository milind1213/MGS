package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(
				"/home/milind/eclipse-workspace/projects/mobile/MobileAutomation/resource/TestData/AutoTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("testData");
		int totalrows = sheet.getLastRowNum();
		int totalcells = sheet.getRow(1).getLastCellNum();
		System.out.println("Number of Rows :" + totalrows);
		System.out.println("Number of Colls :" + totalcells);

		for (int r = 0; r <= totalrows; r++) {
			XSSFRow curretrow = sheet.getRow(r);
			for (int c = 0; c < totalcells; c++) {
				XSSFCell cell = curretrow.getCell(c);
			    String value = cell.toString();
			    System.out.print(value + "      ");
			}
			System.out.println();
		}
		workbook.close();
	}
}
