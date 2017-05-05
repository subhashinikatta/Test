import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class parseResult {
	public static String parseResult(Object Obj, String parent, String child) {
	        JSONObject jObj = (JSONObject) Obj ; 
	        if (jObj.has(parent))
	        {
	                Object temp = jObj.opt(parent);
	                if (temp instanceof JSONArray ) {
	                return Helper.getValue((JSONArray)temp, child);
	        } else if (temp instanceof JSONObject) {
	               return Helper.getValue((JSONObject)temp, child);
	       }
	       } else {
	               Iterator<?> keys = jObj.keys();
	               while ( keys.hasNext() ) {
	                       String key = (String)keys.next();
	                      Object temp = jObj.opt(key);
	                      if (temp instanceof JSONObject && ((JSONObject) temp).length() > 0) {
	                               String value = Helper.parseResult(temp, parent, child);
	                               if (value != null){
	                                       return value;
	                               }
	                       }
	               }
	       }
	       return null ;
	}
	
}