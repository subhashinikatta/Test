package services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import data.Address;
import data.Customer;







@Path("/Customer")
public class CustomerService {
    public static final String DATA_STORE = "CustomerDATA.txt";
    public static final Logger logger = 
            Logger.getLogger(CustomerService.class.getCanonicalName());
   
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response createCustomer(Customer customer) {
        try {
            long customerId = persist(customer);
            return Response.created(URI.create("/" + customerId)).build();
        } catch (Exception e) {
          throw new WebApplicationException(e, 
                  Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
  
    private long persist(Customer customer) throws IOException {

        File dataFile = new File(DATA_STORE);

        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }

        long customerId = customer.getId();
        Address address = customer.getAddress();

        Properties properties = new Properties();
        properties.load(new FileInputStream(dataFile));

        properties.setProperty(String.valueOf(customerId),
                customer.getFirstname() + ","
                + customer.getLastname() + ","
                + address.getNumber() + ","
                + address.getStreet() + ","
                + address.getCity() + ","
                + address.getState() + ","
                + address.getZip() + ","
                + address.getCountry() + ","
                + customer.getEmail() + ","
                + customer.getPhone());

        properties.store(new FileOutputStream(DATA_STORE),null);

        return customerId;
    }
	@GET
	@Path("{id}")
	@Produces({"application/xml", "application/json"})
	public Customer getCustomer(@PathParam("id") String customerId) {
	    Customer customer = null;
	
	    try {
	        customer = findById(customerId);
	    } catch (Exception ex) {
	        logger.log(Level.SEVERE,
	                "Error calling searchCustomer() for customerId {0}. {1}",
	                new Object[]{customerId, ex.getMessage()});
	    }
	    return customer;
	}
	
	private Customer findById(String customerId) throws IOException {
	    Properties properties = new Properties();
	    properties.load(new FileInputStream(DATA_STORE));
	    String rawData = properties.getProperty(customerId);
	
	    if (rawData != null) {
	        final String[] field = rawData.split(",");
	
	        Address address = new Address();
	        Customer customer = new Customer();
	        customer.setId(Integer.parseInt(customerId));
	        customer.setAddress(address);
	
	        customer.setFirstname(field[0]);
	        customer.setLastname(field[1]);
	        address.setNumber(Integer.parseInt(field[2]));
	        address.setStreet(field[3]);
	        address.setCity(field[4]);
	        address.setState(field[5]);
	        address.setZip(field[6]);
	        address.setCountry(field[7]);
	        customer.setEmail(field[8]);
	        customer.setPhone(field[9]);
	
	        return customer;
	    }
	    return null;
	}
}
