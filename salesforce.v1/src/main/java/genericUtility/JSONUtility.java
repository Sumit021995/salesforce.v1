package genericUtility;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JSONUtility {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("data.json")));
        JSONObject json = new JSONObject(content);
        System.out.println("Name: " + json.getString("name"));
    }
}