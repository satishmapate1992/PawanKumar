package excel;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class WriteDataInExcel {

	public static void main(String[] args) throws Exception {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Test Data\\file.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data");

		XSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("JAVA");
		row0.createCell(1).setCellValue(9922);
		row0.createCell(2).setCellValue(true);

		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("node js");
		row1.createCell(1).setCellValue(9090);
		row1.createCell(2).setCellValue(false);

		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("File has created...");

	}

}
