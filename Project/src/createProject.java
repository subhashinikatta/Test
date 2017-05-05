

public class createProject {
	 public static RestResponse createProject(String projectname, String roleuuid, String useruuid) {
	             String body = "{\"spec\":{\"name\":\""+projectname+"\",\"resources\":{\"role_reference\":{\"kind\":\"role\",\"uuid\":\""+roleuuid+"\"},\"user_reference_list\":[{\"kind\":\"user\",\"uuid\":\""+useruuid+"\"}]}},\"api_version\":\"3.0\",\"metadata\":{\"kind\":\"project\"}}";
	            RestApi obj = RestApi.getInstance();
	             return obj.restCall("projects", body, "POST");
	     }
}