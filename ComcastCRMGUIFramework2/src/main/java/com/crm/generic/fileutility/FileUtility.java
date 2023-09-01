package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility 
{
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis =new FileInputStream("./configAppData/commondata.properties");
		Properties properties=new Properties();
		properties.load(fis);
		
		String data = properties.getProperty(key);
		 return data;
	}

	public String getDataFromJsonFile(String key) throws Throwable 
	{
		JSONParser parse=new JSONParser();
		Object object = parse.parse(new FileReader("./configAppData/commondata.json"));
		JSONObject jsonmap=(JSONObject) object;
		String data = jsonmap.get(key).toString();
		return data;
	}
	

}
