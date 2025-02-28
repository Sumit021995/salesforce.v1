package genericUtility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public List<String> fetchMultipleDataFromExcelFile(String sheetName,int row,int cell) throws Exception
	{
		List<String> excelDataList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		for()
		
		return excelDataList;
		
	}
	
}
