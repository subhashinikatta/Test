
package clientxml;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import data.Address;
import data.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;

public class CustomerClientXML {
    public static final Logger logger =
            Logger.getLogger(CustomerClientXML.class.getCanonicalName());

    public static void main(String[] args) {

        Client client = Client.create();
        // Define the URL for testing the example application
        WebResource webResource = 
               client.resource("http://localhost:8024/CustomerApplication/rest/customer");

        // Test the POST method
        Customer customer = new Customer();
        Address address = new Address();
        customer.setAddress(address);

        customer.setId(1);
        customer.setFirstname("Duke");
        customer.setLastname("OfJava");
        address.setNumber(1);
        address.setStreet("Duke's Drive");
        address.setCity("JavaTown");
        address.setZip("1234");
        address.setState("JA");
        address.setCountry("USA");
        customer.setEmail("duke@java.net");
        customer.setPhone("12341234");

        ClientResponse response = 
                webResource.type("application/xml").post(ClientResponse.class,
                customer);

        logger.info("POST status: {0}" + response.getStatus());
        if (response.getStatus() == 201) {
            logger.info("POST succeeded");
        } else {
            logger.info("POST failed");
        }

        // Test the GET method using content negotiation
        response = webResource.path("1").accept(MediaType.APPLICATION_XML)
                .get(ClientResponse.class);
        Customer entity = response.getEntity(Customer.class);

        logger.log(Level.INFO, "GET status: {0}", response.getStatus());
        if (response.getStatus() == 200) {
            logger.log(Level.INFO, "GET succeeded, city is {0}",
                    entity.getAddress().getCity());
        } else {
            logger.info("GET failed");
        }

        // Test the DELETE method
        response = webResource.path("1").delete(ClientResponse.class);

        logger.log(Level.INFO, "DELETE status: {0}", response.getStatus());
        if (response.getStatus() == 204) {
            logger.info("DELETE succeeded (no content)");
        } else {
            logger.info("DELETE failed");
        }

        response = webResource.path("1").accept(MediaType.APPLICATION_XML)
                .get(ClientResponse.class);
        logger.log(Level.INFO, "GET status: {0}", response.getStatus());
        if (response.getStatus() == 204) {
            logger.info("After DELETE, the GET request returned no content.");
        } else {
            logger.info("Failed, after DELETE, GET returned a response.");
        }
    }
}