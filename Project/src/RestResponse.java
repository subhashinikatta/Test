import java.io.*;
   import java.lang.reflect.*;
   import java.net.MalformedURLException;
   import java.net.SocketTimeoutException;
 import java.net.URL;
    import java.text.MessageFormat;
   import java.util.Base64;
    import java.util.Iterator;
    
   import javax.net.ssl.HostnameVerifier;
 import javax.net.ssl.HttpsURLConnection;
  import javax.net.ssl.SSLSession;
   import javax.net.ssl.SSLContext;
   import javax.net.ssl.TrustManager;
   import javax.net.ssl.X509TrustManager;
   import java.security.cert.X509Certificate;
   import java.security.MessageDigest;
   import java.math.BigInteger;
   import org.json.*;
  
 public class RestResponse {
           private int responseCode; 
         private JSONObject response = null ;
         private String url ;
          private String error ;
          
          public RestResponse (String callingUrl, int code, JSONObject responseContent)
          {
                   url = callingUrl ;
                  responseCode = code ; 
                  response = responseContent ;
          }
           public RestResponse (String callingUrl, int code, String responseContent)
           {
                   url = callingUrl ;
                   responseCode = code ; 
                  error = responseContent ;
           }
           public int getResponseCode() {
                 return responseCode;
           }
          public JSONObject getResponse() {
                   return response;
          }
           public String getUrl() {
                   return url;
           }
           public void errorPrint()
           {
                   System.out.println("RestUrl : "+ url);
                   
                  if ( response == null ) {
                           System.out.println("Code : "+ responseCode);
                           System.out.println("ErrorMessage :" +error);
                  } else {
                           System.out.println("Code : " + response.optString("code"));
                           System.out.println("Reason : "+ Helper.parseResult((Object)response, "message_list", "reason"));
                           System.out.println("Message details : "+ Helper.parseResult((Object)response, "message_list", "details"));
                           System.out.println("Message : "+ Helper.parseResult((Object)response, "message_list", "message"));
                   }
           }
  }
   
   class RestApi {
           private String Ip;
           private String BaseURI = "https://{0}:9440/api/nutanix/v3/{1}";
           private String ContentType = "application/json";
		private String Encoded;
  
           private static volatile RestApi instance = null;
   
           public void setParms(String ipAddr, String username, String password) {
                   this.Ip = ipAddr ;
                  String userPassword = username + ":" + password;
                   try {
                          this.Encoded = Base64.getEncoder().encodeToString(userPassword.getBytes("utf-8"));
                   } catch (Exception e) {
                           this.Encoded = null;
                   }
           }
   
           public static RestApi getInstance() {
                   if (instance == null) {
                          instance = new RestApi();
                  }
                   return instance;
           }
   
           public void setContentType(String contentType) {
                   ContentType = contentType;
           }
           
           /**
           * This method is used to make rest call. 
           * @param subUrl sub URL like "vms/list"
           * @param body JSON content to be sent
           * @param method can be GET,PUT,POST,UPDATE,DELETE
           * @return RestResponse return the object of RestResponse class
           */
          public RestResponse restCall(String subUrl, String body, String method) {
  
                  String result = new String("");
                  int responseCode = 0;
                  String baseUrl = null;
                  JSONObject jSon = null;
  
                 // Create a trust manager that does not validate certificate chains
                  TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                  return null;
                          }
  
                          public void checkClientTrusted(X509Certificate[] certs,
                                          String authType) {
                          }
  
                          public void checkServerTrusted(X509Certificate[] certs,
                                          String authType) {
                         }
                  } };
  
                  try {
 
                          // Install the all-trusting trust manager
                          SSLContext sc = SSLContext.getInstance("SSL");
                          sc.init(null, trustAllCerts, new java.security.SecureRandom());
                         HttpsURLConnection
                                          .setDefaultSSLSocketFactory(sc.getSocketFactory());
  
                  } catch (Exception e) {
  
                          //e.printStackTrace();
                          return new RestResponse(baseUrl, 0 , "SSL config failed");
 
                  }
  
                 // Create all-trusting host name verifier
                  HostnameVerifier allHostsValid = new HostnameVerifier() {
                          public boolean verify(String hostname, SSLSession session) {
                                  return true;
                         }
                  };
 
                 // Install the all-trusting host verifier
                  HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
 
                  try {
                         baseUrl = MessageFormat.format(BaseURI, Ip, subUrl);
                          URL url = new URL(baseUrl);
                          HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                          conn.setReadTimeout(30000);//milisecond
  
                         conn.setRequestMethod(method);
                          conn.setRequestProperty("Accept", ContentType);
                          conn.setRequestProperty("Content-Type", ContentType);
                         conn.setRequestProperty("Authorization", "Basic " + Encoded);
  
                         if (method != "GET") {
                                  conn.setDoOutput(true);
                                  OutputStreamWriter wr = new OutputStreamWriter(
                                                  conn.getOutputStream());
                                  wr.write(body);
                                 wr.flush();
                                 wr.close();
                          }
  
                          responseCode = conn.getResponseCode();
                          BufferedReader br;
                          if (responseCode != 200) {
                                  br = new BufferedReader(new InputStreamReader(
                                                  (conn.getErrorStream())));
                         } else {
                                 br = new BufferedReader(new InputStreamReader(
                                                  (conn.getInputStream())));
                         }

                          String output;
                          while ((output = br.readLine()) != null) {
                                 result += output + "\n";
                          }
 
                          conn.disconnect();
  
                  } catch (MalformedURLException e) {

                          return new RestResponse(baseUrl, 0 , "MalformedURL");
 
                } catch (SocketTimeoutException e) {
  
                          return new RestResponse(baseUrl, 0 , "Timeout");
                          
                  } catch (IOException e) {
  
                          return new RestResponse(baseUrl, 0 , "IOException");
  
                  }
                 
                  try {
  
                          jSon = new JSONObject(result);
  
                 } catch (JSONException e) {
 
                          return new RestResponse(baseUrl, responseCode , result);
  
                  }
  
                  return new RestResponse(baseUrl, responseCode, jSon);
          }
  }