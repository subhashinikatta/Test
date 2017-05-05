

public class getRoles {
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