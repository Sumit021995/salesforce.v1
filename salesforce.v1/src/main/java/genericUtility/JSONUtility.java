package genericUtility;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("data.json")));
        JSONObject json = new JSONObject(content);
        System.out.println("Name: " + json.getString("name"));
    }
    public void jsonParser() throws IOException, ParseException
    {
    	JSONParser jParser = new JSONParser();
    	FileReader file = new FileReader("Absolute path");
    	Object obj = jParser.parse(file);
    	//convet to JSON Object
    	JSONObject jObj = new JSONObject(obj);
    }
}