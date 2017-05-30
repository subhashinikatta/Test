package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyJson {
	public static Map<String,String> getKeyValue(JSONObject json , Map<String,String> out) throws JSONException{
	    Iterator<String> keys = json.keys();
	    while(keys.hasNext()){
	        String key = keys.next();
	        String val = null;
	        try{
	             JSONObject value = json.getJSONObject(key);
	             getKeyValue(value,out);
	        }catch(Exception e){
	            val = json.getString(key);
	        }
	
	        if(val != null){
	            out.put(key,val);
	        }
	    }
	    return out;
	}
	
	 public static void main(String[] args) throws JSONException, IOException, ParseException {
	
		 JSONParser parser = new JSONParser();

		 FileReader fileReader = new FileReader("C:/java/Week1/petstore.json"); 
		 JSONObject json = (JSONObject) parser.parse(fileReader);

		
		
	    Map<String,String> out = new HashMap<String, String>();
	  
	    JSONObject jsonObject = new JSONObject           (json);
	    JSONObject info     = jsonObject.getJSONObject ("info");
	    JSONObject paths   = info.getJSONObject     ("paths");
	    String post = paths.getString("post");
	    JSONObject definitions   = info.getJSONObject     ("definitions");
	    System.out.println("paths : " + paths );
	    System.out.println("post : " + post );
	    getKeyValue(paths,out);
	   
	
	}
}





