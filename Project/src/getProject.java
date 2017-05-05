import java.text.MessageFormat;

public class getProject {
	// Method to get info about the project if uuid is provided.
	public static RestResponse getProject(String uuid) {
	        String subUrl = MessageFormat.format("projects/{0}", uuid);
	         RestApi obj = RestApi.getInstance();
	        return obj.restCall(subUrl, "" , "GET");
	}
}