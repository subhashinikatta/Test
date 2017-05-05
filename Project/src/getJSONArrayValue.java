import org.json.JSONArray;
import org.json.JSONObject;

public class getJSONArrayValue {
	// Method to update project.
	    
	    public static JSONArray getJSONArrayValue(JSONObject jObj, String key) {
	        if (jObj.has(key)) {
	               if (jObj.optJSONArray(key) != null) {
	                      return jObj.optJSONArray(key);
	               }
	              System.out.println("Given key is not JSONArray :" + key);
	      } else {
	               System.out.println("Key not exists in JSONObject : " + key);
	      }
	       return null;
	}
}