
package excel;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
	//	String filePath = System.getProperty("user.dir") + "\\Test Data\\" + xlfile;
	//	fis= new FileInputStream(filePath);
		fis= new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(xlsheet);
		int totalRow=sheet.getLastRowNum();
		workbook.close();
		fis.close();		
		return totalRow;
	}
	
	public static int getColumnCount(String xlfile, String xlsheet, int rownum) throws IOException {
	//	String filePath = System.getProperty("user.dir") + "\\Test Data\\" + xlfile;
	//	fis= new FileInputStream(filePath);
		fis= new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(xlsheet);
		int totalColumn=sheet.getRow(rownum).getLastCellNum();		
		workbook.close();
		fis.close();		
		return totalColumn;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int columnnum) throws IOException {
	//	String filePath = System.getProperty("user.dir") + "\\Test Data\\" + xlfile;
	//	fis= new FileInputStream(filePath);
		fis= new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(columnnum);
		
		String data;
		try {
			DataFormatter format= new DataFormatter();
			data=format.formatCellValue(cell);
						
		}catch(Exception e) {
			data="";
		}		
		workbook.close();
		fis.close();		
		
		return data;
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int columnnum, String data) throws IOException{
	//	String filePath = System.getProperty("user.dir") + "\\Test Data\\" + xlfile;
	//	fis= new FileInputStream(filePath);
		fis= new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(columnnum);
		cell.setCellValue(data);
	//	fos= new FileOutputStream(filePath);
		fos= new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();		
	}
	
	public static void setGreenColor(String xlfile, String xlSheetName, int rowNum, int colNum) throws Exception {
	//	String filePath = System.getProperty("user.dir") + "\\Test Data\\" + xlFileName;
		try {
			
			//	fis = new FileInputStream(filePath);
				fis= new FileInputStream(xlfile);
				workbook= new XSSFWorkbook(fis);
				sheet = workbook.getSheet(xlSheetName);
				
				if (sheet == null) {
				//	sheet=workbook.createSheet();
					System.out.println("Sheet not found!");
					return;
				}
	
				row = sheet.getRow(rowNum);
				if (row == null) {
					row = sheet.createRow(rowNum);
				}
	
				cell = row.getCell(colNum);
				if (cell == null) {
					cell = row.createCell(colNum);
				}
	
				// Create a CellStyle with green background
				style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
				cell.setCellStyle(style);
	
				// Write the changes back to the file
				try (FileOutputStream fos = new FileOutputStream(xlfile)) {
					workbook.write(fos);
					System.out.println("Cell color set to green successfully.");
					fos.close();
				}

		   } catch (IOException e) {
			System.out.println("Error processing the Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		
		fis.close();
		workbook.close();
		
	}
	
	public static void setRedColor(String xlfile, String xlSheetName, int rowNum, int colNum) throws Exception {
	//	String filePath = System.getProperty("user.dir") + "\\Test Data\\" + xlFileName;
		try {
			
			//	fis = new FileInputStream(filePath);
				fis= new FileInputStream(xlfile);
				workbook= new XSSFWorkbook(fis);
				sheet = workbook.getSheet(xlSheetName);
				
				if (sheet == null) {
				//	sheet=workbook.createSheet();
					System.out.println("Sheet not found!");
					return;
				}
	
				row = sheet.getRow(rowNum);
				if (row == null) {
					row = sheet.createRow(rowNum);
				}
	
				cell = row.getCell(colNum);
				if (cell == null) {
					cell = row.createCell(colNum);
				}
	
				// Create a CellStyle with green background
				style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
				cell.setCellStyle(style);
	
				// Write the changes back to the file
				try (FileOutputStream fos = new FileOutputStream(xlfile)) {
					workbook.write(fos);
					System.out.println("Cell color set to red successfully.");
					fos.close();
				}

		   } catch (IOException e) {
			System.out.println("Error processing the Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		
		fis.close();
		workbook.close();
		
	}

	// For testing
	public static void main(String[] args) throws Exception {
	
	/*	
		System.out.println("Total Rows= "+getRowCount("file2.xlsx", "Data"));
		System.out.println("Total Columns= "+getColumnCount("file2.xlsx", "Data",1));
		System.out.println(getCellData("file2.xlsx", "Data",1,2));
		setCellData("file2.xlsx", "Data",1,4,"pass");
		setGreenColor("file2.xlsx", "Data",1,4);
		setRedColor("file2.xlsx", "Data",2,4);
	*/	
	}
}
