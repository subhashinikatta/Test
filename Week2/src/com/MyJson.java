package com;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

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
	public static void createFile(JSONObject jsonobj,String keys)
			throws IOException {
		try{
			JSONObject obj = (JSONObject) jsonobj.get(keys);
			Set<String> keyArray  = obj.keySet();
			String arry[]= keyArray .toArray(new String[keyArray.size()]);
			for(int i = 0; i <arry.length; i++) {
				String str=arry[i].toString();
				FileWriter outputFile = new FileWriter("C:/Users/kshubhashini/workspace3/Week2/src/com/json/"+str+".json");
				PrintWriter out = new PrintWriter(outputFile);
				JSONObject value = (JSONObject) obj.get(str);
				out.println(value);
				out.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonobj=  (JSONObject) parser.parse(new FileReader("C:/Users/kshubhashini/workspace3/Week2/src/com/petstore.json"));
		getKeyValue(jsonobj,"paths");
		getPath(jsonobj,"paths");
		getDefinitions(jsonobj,"definitions");
		createFile(jsonobj,"definitions");
	}
}
