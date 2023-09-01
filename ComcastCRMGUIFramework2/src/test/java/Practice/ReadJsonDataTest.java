package Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonDataTest 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		//step1:Parse the Json Physical file into java Object Using Json Parse
		JSONParser jsonparser=new JSONParser();

		Object object = jsonparser.parse(new FileReader("./src/test/resources/TestData/jsondata.json"));
		
		//Step2:Transfer Object to Json Object
		JSONObject map = (JSONObject)object;
		
		//step3: Get the Value form Json File by passing Key 
		String url = map.get("url").toString();
		String browser = map.get("browser").toString();
		String unm = map.get("unm").toString();
		String pwd = map.get("pwd").toString();
		String email = map.get("email").toString();
		
		//Print on Console
		System.out.println(url);
		System.out.println(browser);
		System.out.println(unm);
		System.out.println(pwd);
		System.out.println(email);
		
		
		
	}

}
