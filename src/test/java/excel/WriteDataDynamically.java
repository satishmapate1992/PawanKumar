package excel;

import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;

public class WriteDataDynamically {

	public static void main(String[] args) throws Exception {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Test Data\\file.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of Rows ?");
		int noOfRows = sc.nextInt();
		System.out.println("Enter number of columns ?");
		int noOfCells = sc.nextInt();

		for (int r = 0; r < noOfRows; r++) {

			XSSFRow currentRow = sheet.createRow(r);

			for (int c = 0; c < noOfCells; c++) {

				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next());

			}

		}

		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("File has created...");

	}

}
