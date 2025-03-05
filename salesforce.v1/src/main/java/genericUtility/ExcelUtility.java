package genericUtility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public List<String> fetchMultipleDataFromExcelFile(String sheetName,int startRowNum ) throws Exception
	{
		List<String> excelDataList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		DataFormatter stringFormatExcelData = new DataFormatter();
		for(int i=startRowNum;i<sheet.getLastRowNum();i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String data = stringFormatExcelData.formatCellValue(cell);
				excelDataList.add(data);	
			}
		}
					
		return excelDataList;
	}
	public List<String> fetchMultipleDataFromExcelFileWithFixedRow(String sheetName,int fixedRowIndex ,int startCellNum) throws Exception
	{
		List<String> excelDataList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		
		DataFormatter stringFormatExcelData = new DataFormatter();
		Row row = sheet.getRow(fixedRowIndex);
			for(int j=startCellNum;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String data = stringFormatExcelData.formatCellValue(cell);
				excelDataList.add(data);	
			}
		return excelDataList;
	}
	public List<String> fetchMultipleDataOfColumnFromExcelFile(String sheetName,int fixedCellIndex) throws Exception
	{
		List<String> excelDataList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		DataFormatter stringFormatExcelData = new DataFormatter();
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			    Cell cell = sheet.getRow(i).getCell(fixedCellIndex);
				String data = stringFormatExcelData.formatCellValue(cell);
				excelDataList.add(data);	
		}
		return excelDataList;
	}
	public static void main(String[] args) throws Exception {
		ExcelUtility excelUtility = new ExcelUtility();
		List<String> data = excelUtility.fetchMultipleDataFromExcelFile("Sheet2", 0);
		System.out.println(data);
		List<String> singleColumnData = excelUtility.fetchMultipleDataOfColumnFromExcelFile("Sheet2", 0);
		System.out.println(singleColumnData);
	}
	
}
