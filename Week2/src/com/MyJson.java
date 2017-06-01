package com;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyJson {
	public static Map<String,String> getKeyValue(JSONObject json , Map<String,String> out) throws JSONException{
		json = new JSONObject();
		 Set keys = json.keySet();
		    Iterator a = keys.iterator();
		    while(a.hasNext()) {
		    	String key = (String)a.next();
		        JSONObject value = (JSONObject)json.get(key);
		        getKeyValue(value,out);
		    }
		  
		    return out;
	}
	 public static void main(String[] args) throws JSONException, IOException, ParseException {
	
		 JSONParser parser = new JSONParser();

		 FileReader fileReader = new FileReader("C:/java/Week1/petstore.json"); 
		 JSONObject json = (JSONObject) parser.parse(fileReader);

	    Map<String,String> out = new HashMap<String, String>();
	  
	    JSONObject jsonObject = new JSONObject           (json);
	    JSONObject info     = (JSONObject) jsonObject.get ("info");
	    JSONObject paths   = (JSONObject) info.get("paths");
	    System.out.println("paths: " + jsonObject.get("paths"));
	    System.out.println("definitions: " + jsonObject.get("definitions"));
	    JSONObject definitions   = (JSONObject) info.get ("definitions");
	    getKeyValue(jsonObject,out);
	}
}





