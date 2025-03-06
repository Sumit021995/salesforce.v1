package sampleTestExecution;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class FetchingDataFromJson {
	public static void main(String[] args) throws Exception {
		FetchingDataFromJson data = new FetchingDataFromJson();
		System.out.println(data.jsonReader("browser"));
	}
	public String jsonReader(String key) throws Exception
	{
		String content = new String(Files.readAllBytes(Paths.get(".\\src\\test\\resources\\TestData\\preCondition.json")));
		JSONObject jsonObj = new JSONObject(content);
		return jsonObj.getString(key);
	}
}
