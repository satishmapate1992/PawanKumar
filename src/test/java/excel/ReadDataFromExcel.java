package excel;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;


public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Test Data\\Data.xlsx");

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();

		int totalCells = sheet.getRow(1).getLastCellNum();

		System.out.println("Total rows- " + totalRows); // rows couting from 0
		System.out.println("Total cells- " + totalCells); // cells counting from 1

		for (int r = 0; r <= totalRows; r++) {

			XSSFRow currentRow = sheet.getRow(r);

			for (int c = 0; c < totalCells; c++) {

				XSSFCell currentCell = currentRow.getCell(c);

				System.out.print(currentCell.toString() + "\t");
			}

			System.out.println();
		}

		workbook.close();
		file.close();

	}

}
