package com.ui.testware.utility;

import java.io.FileInputStream;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadSheetReader {

	FileInputStream fis = null;
	XSSFWorkbook workBook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;

	public SpreadSheetReader() {
		String path = Constants.DATA_XLS_PATH;
		try {
			fis = new FileInputStream(path);
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object[][] getData(String testCaseName) {

		String sheetName = Constants.TESTDATA_SHEET_UI;

		int testStartRowNum = 1;
		while (!getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)) {
			testStartRowNum++;
		}
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		int rows = 0;
		while (!getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}

		int cols = 0;
		while (!getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		Object[][] data = new Object[rows][1];

		int dataRow = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = getCellData(sheetName, cNum, colStartRowNum);
				String value = getCellData(sheetName, cNum, rNum); // data
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workBook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue().trim();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				cellText = cellText.substring(0, cellText.length() - 2);
				return cellText;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel Sheet";
		}
	}
}
