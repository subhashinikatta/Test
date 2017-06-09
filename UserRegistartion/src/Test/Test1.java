package Test;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Test1 {

 public static void main(String[] args) throws ClientProtocolException, IOException {

  ClientConfig config = new DefaultClientConfig();

  Client client = Client.create(config);

  WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8024/UserRegistartion/").build());

  // getting XML data

 //System.out.println(service. path("/rest").path("/user").accept(MediaType.APPLICATION_JSON).get(String.class));

  // getting JSON data

  System.out.println(service. path("/rest").path("/user/login").accept(MediaType.APPLICATION_XML).get(String.class));

 }

}
