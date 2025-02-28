package genericUtility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public List<String> fetchMultipleDataFromExcelFile(String sheetName,int stratRowNum ,int startCellNum) throws Exception
	{
		List<String> excelDataList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(stratRowNum);
		Cell cell = row.getCell(startCellNum);
		DataFormatter stringFormatExcelData = new DataFormatter();
		String data = stringFormatExcelData.formatCellValue(cell);
		excelDataList.add(data);
				
			
		
		return excelDataList;
		
	}
	
}
