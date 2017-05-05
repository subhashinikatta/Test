

public class getProjects {
	public static RestResponse getProjects() {
        String body = "{\"kind\":\"project\",\"length\":100,\"offset\":0}";
       RestApi obj = RestApi.getInstance();
       return obj.restCall("projects/list", body, "POST");
}
}