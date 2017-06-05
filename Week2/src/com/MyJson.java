package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class MyJson {

	
	static String getKeyValue(JSONObject jsonobj , String key){
		try {
			JSONObject jsonObject=jsonobj;
			System.out.println(jsonObject.get(key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;

	}
	static String getPath(JSONObject jsonobj , String key){
		try {
			JSONObject obj = (JSONObject) jsonobj.get(key);
			System.out.println(obj.keySet());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;

	}


	static String getDefinitions(JSONObject jsonobj , String key){
		try {
			JSONObject obj = (JSONObject) jsonobj.get(key);
			System.out.println(obj.keySet());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;

	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonobj=  (JSONObject) parser.parse(new FileReader("C:/Users/kshubhashini/workspace3/Week2/src/com/petstore.json"));
		getKeyValue(jsonobj,"paths");
		getPath(jsonobj,"paths");
		getDefinitions(jsonobj,"definitions");
		
	}
}
