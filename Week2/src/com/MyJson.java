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

	/*method which can get the value based on key */
	
	static String getKeyValue(JSONObject jsonobj , String key){
		try {
			JSONObject jsonObject=jsonobj;
			
			JSONObject value = (JSONObject)jsonObject.get(key);
			if (value instanceof JSONObject)// to check type of object
			{
				getKeyValue(value, key);
				System.out.println("key: "+ key );  
				System.out.println(" value: " + value);
				System.out.println("JsonObject: " + jsonObject.get(key));
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return key;

	}
	 
	/*  Method to get the list of all "paths" available in the shared json. */
	
	static String getPath(JSONObject jsonobj , String key){
		try {
			JSONObject obj = (JSONObject) jsonobj.get(key);
			System.out.println(obj.keySet());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;

	}

/* Method to get the list of all "definitions" in the shared json. Create a file for each definitions*/
	
	public static void createFile(JSONObject jsonobj,String keys)
			throws IOException {
		try{
			JSONObject obj = (JSONObject) jsonobj.get(keys);// returns specified key or null
			
			System.out.println(obj.keySet());// print the list of all "definitions" in the petstorejson
			
			Set<String> keyArray  = obj.keySet();//keyset in interface of map it returns a set of key in map
			
			String arry[]= keyArray .toArray(new String[keyArray.size()]);//change the set to String array
			for(int i = 0; i <arry.length; i++) {
				String str=arry[i].toString(); //converting array to String
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
		 JSONObject  info = (JSONObject) jsonobj.get("info");
		getKeyValue(jsonobj,"paths");
		getPath(jsonobj,"paths");
		createFile(jsonobj,"definitions");
	}
}
