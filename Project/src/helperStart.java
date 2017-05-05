import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

class Helper {

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

public static String getValue(JSONArray jObj, String key) {
       for (int i = 0; i < jObj.length(); i++) {
               Object temp = jObj.opt(i);
               if (temp instanceof JSONObject) {
                       return Helper.getValue((JSONObject) temp, key);
               }
       }
       return null;
}

public static String getValue(JSONObject jObj, String key) {
       if (jObj.has(key)) {
                      return jObj.optString(key);
       }
       return null;
}

// Method to get info about the project if uuid is provided.
public static RestResponse getProject(String uuid) {
        String subUrl = MessageFormat.format("projects/{0}", uuid);
         RestApi obj = RestApi.getInstance();
        return obj.restCall(subUrl, "" , "GET");
}

	public static RestResponse listLoggedInUsers() {
	                   RestApi obj = RestApi.getInstance();
	                  return obj.restCall("users/me", null , "GET");
          }
	public static String trackApiStatus(RestResponse response, java.lang.reflect.Method method) {
        int retryCount = 3 ;
        int wait = 5 ;
        RestResponse result = null ;
        JSONObject jObj = response.getResponse();
        JSONObject jObjLocal = null ;
        String apiStatus = null ; 
        
        apiStatus = Helper.parseResult(jObj, "status", "state");
        String uuid = Helper.parseResult(jObj, "metadata", "uuid");
        if (apiStatus.equals("PENDING") || apiStatus.equals("kRunning") || apiStatus.equals("kdeletePending"))
        {
                int count = 0 ;
               while ( count < retryCount )
               {
                        count++;
                        try {
                                Thread.sleep(wait*1000);
                        } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                        }
                        try{
                               result = (RestResponse) method.invoke(Helper.class,new Object[]{uuid});
                               }catch (IllegalAccessException e){
                                        return null ;
                                        }catch (InvocationTargetException e){
                                        return null ;
                                }
                        if ( result.getResponseCode() == 200 ){
                                        jObjLocal = result.getResponse();
                                       apiStatus = Helper.parseResult(jObjLocal, "status", "state");
                                        if (apiStatus.equals("COMPLETE")) { 
                                               break ; 
                                       }
                        }
                }
                if ( result.getResponseCode() != 200 ) {
                        result.errorPrint();
                       return null ;
                } else {
                        if ( apiStatus.equals("COMPLETE") ) {
                                return uuid ;
                        }
                        else if ( apiStatus.equals("ERROR") ) {
                                System.out.println("RestUrl : "+ result.getUrl()+" : kError");
                                System.out.println("Reason : "+ Helper.parseResult(jObjLocal, "message_list", "reason"));
                                System.out.println("Message : "+ Helper.parseResult(jObjLocal, "message_list", "message"));
                                return null ;
                        }
                }
        }
       else if ( apiStatus.equals("ERROR") ) {
               response.errorPrint();
                return null ;
       }
        return uuid ;
}

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
 // Method to list all the projects.
    public static RestResponse getProjects() {
             String body = "{\"kind\":\"project\",\"length\":100,\"offset\":0}";
            RestApi obj = RestApi.getInstance();
            return obj.restCall("projects/list", body, "POST");
   }
 // Method to call Rest API to create Project
    public static RestResponse createProject(String projectname, String roleuuid, String useruuid) {
             String body = "{\"spec\":{\"name\":\""+projectname+"\",\"resources\":{\"role_reference\":{\"kind\":\"role\",\"uuid\":\""+roleuuid+"\"},\"user_reference_list\":[{\"kind\":\"user\",\"uuid\":\""+useruuid+"\"}]}},\"api_version\":\"3.0\",\"metadata\":{\"kind\":\"project\"}}";
            RestApi obj = RestApi.getInstance();
             return obj.restCall("projects", body, "POST");
     }
    // Method to list roles
    public static RestResponse getRoles(String name) {
            String body = "{\"kind\":\"role\",\"length\":100,\"offset\":0,\"filter\":\"name=="+name+"\"}";
            RestApi obj = RestApi.getInstance();
            return obj.restCall("roles/list", body , "POST");
     }
    public static RestResponse getRoles() {
            String body = "{\"kind\":\"role\",\"length\":100,\"offset\":0}";
            RestApi obj = RestApi.getInstance();
            return obj.restCall("roles/list", body , "POST");
    }

	
}