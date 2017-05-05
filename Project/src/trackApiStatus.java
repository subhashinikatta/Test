import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.json.JSONObject;




public class trackApiStatus {
	public static String trackApiStatus(RestResponse response, Method callFunction) {
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
	                                          result = (RestResponse) callFunction.invoke(Helper.class,new Object[]{uuid});
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
}