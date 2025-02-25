package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public String fetchValueFromPropertiesFile(String key) throws FileNotFoundException , IOException
	{
		FileInputStream file = new FileInputStream(IPathUtility.propertyFilePath);
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
}
