package sampleDataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class DataProviderClass {
	ExcelUtility eUtil = new ExcelUtility();
	int a=1;
	@Test(dataProvider = "hrData")
	public void getExcelDataFromDataProvider(String s1,String s2,String s3)
	{
		System.out.println(a+" "+s1+"  "+s2+" "+s3);
		a++;
		
	}
	
	@DataProvider
	public Object[][] hrData() throws EncryptedDocumentException, IOException
	{
		int rowCount = eUtil.getRowCount("Sheet2");
		int colCount = eUtil.getColumnCount("Sheet2",rowCount);
		Object [][] objArr=new Object[rowCount][colCount];
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0]=eUtil.featchDataFromExcelFile("Sheet2", i+1, 0);
			objArr[i][1]=eUtil.featchDataFromExcelFile("Sheet2", i+1, 1);
			objArr[i][2]=eUtil.featchDataFromExcelFile("Sheet2", i+1, 2);
		}
		return objArr;
		
	}
	
			
}
