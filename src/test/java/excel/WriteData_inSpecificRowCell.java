package excel;

import java.io.*;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.*;


public class WriteData_inSpecificRowCell {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir") + "\\Test Data\\file2.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Data");
		
		XSSFRow row=sheet.createRow(3);	
		XSSFCell cell=row.createCell(4);
		
		cell.setCellValue("Soldier");
		
		workbook.write(file);	
		workbook.close();
		file.close();
		
		System.out.println("File has created...");

	}

}
