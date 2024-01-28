package DataDriven;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws Exception {
		FileOutputStream file= new FileOutputStream(
				"/home/milind/eclipse-workspace/projects/mobile/MobileAutomation/resource/TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
	/*
		XSSFRow row1 = sheet.createRow(0);
		XSSFRow row2 = sheet.createRow(1);
		XSSFRow row3 = sheet.createRow(2);
		
		row1.createCell(0).setCellValue("sssss");
		row1.createCell(1).setCellValue("ddddddd");
		row1.createCell(2).setCellValue("mmmmm");
		
		row2.createCell(0).setCellValue("AAAA");
		row2.createCell(1).setCellValue("BBBB");
		row2.createCell(2).setCellValue("CCCC");
		
		row3.createCell(0).setCellValue("GGGGG");
		row3.createCell(1).setCellValue("HHHHH");
		row3.createCell(2).setCellValue("LLLLL");  */
		
		Scanner sc = new Scanner(System.in);
		for(int r=0;r<=4;r++){
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<3;c++) {
				//row.createCell(c).setCellValue("MIlind");
				System.out.println("Enter Value :");
				String value = sc.next();
				row.createCell(c).setCellValue(value);
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();	
		System.out.println("Wrting Done");
  }
} 