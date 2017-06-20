package client;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientUpdate {

	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8024/JerseyUser/rest/user/update");

			String input = "{\"FirstName\":\"subhashini\",\"LastName\":\"katta\",\"Email\":\"su@hcl.com\",\"username\":\"subha\",\"password\":\"subha\",\"confirmpassword\":\"subha\"}";

			ClientResponse response = webResource.type("application/json")
					.put(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
