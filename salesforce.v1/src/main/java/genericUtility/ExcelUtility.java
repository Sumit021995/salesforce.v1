package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class ExcelUtility {
	public String fetchDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream file = new FileInputStream(IPathUtility.propertyFilePath);
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
}
