package web;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("/customers")
public class RestService {
    
    @POST
    @Path("/addCustomer")
    @Produces("text/html")
    public Response getResultByPassingValue(
                    @FormParam("nameKey") String name,
                    @FormParam("countryKey") String country) {
        
        String output = "<font face='verdana' size='2'>" +
                "Web Service has added your Customer information with Name - <u>"+name+"</u>, Country - <u>"+country+"</u></font>";
        return Response.status(200).entity(output).build();
 
    }
    @POST
    @Path("/addNumber")
    @Produces("text/html")
    public Response getResultByPassingValue(
                    @FormParam("nameKey") int a,
                    @FormParam("countryKey") int b) {
        int result = Calculation.sum(a, b);
        System.out.println("Result "+result);
        String output = "<font face='verdana' size='2'>" +
                "Web Service has added your Customer information with Name "+result+"</u></font>";
        /*String output = "{\"name\":\"Test\","
        		+ "\"name\":\"Test\"}";*/
        return Response.status(200).entity(output).build();
 
    }
   @POST
    @Path("/subNumber")
    @Produces("text/html")
    public Response getResultByPassingValue1(
                    @FormParam("nameKey") int a,
                    @FormParam("countryKey") int b) {
        int result = Calculation.sub(a, b);
        System.out.println("Result "+result);
        String output = "<font face='verdana' size='2'>" +
                "Web Service has added your Customer information with Name "+result+"</u></font>";
        /*String output = "{\"name\":\"Test\","
        		+ "\"name\":\"Test\"}";*/
        return Response.status(200).entity(output).build();
 
   }
   @POST
   @Path("/mulNumber")
   @Produces("text/html")
   public Response getResultByPassingValue2(
                   @FormParam("nameKey") int a,
                   @FormParam("countryKey") int b) {
       int result = Calculation.mul(a, b);
       System.out.println("Result "+result);
       String output = "<font face='verdana' size='2'>" +
               "Web Service has added your Customer information with Name "+result+"</u></font>";
       /*String output = "{\"name\":\"Test\","
       		+ "\"name\":\"Test\"}";*/
       return Response.status(200).entity(output).build();

  }
   @POST
   @Path("/divNumber")
   @Produces("text/html")
   public Response getResultByPassingValue3(
                   @FormParam("nameKey") int a,
                   @FormParam("countryKey") int b) {
       int result = Calculation.div(a, b);
       System.out.println("Result "+result);
       String output = "<font face='verdana' size='2'>" +
               "Web Service has added your Customer information with Name "+result+"</u></font>";
       /*String output = "{\"name\":\"Test\","
       		+ "\"name\":\"Test\"}";*/
       return Response.status(200).entity(output).build();

  }
   
    
}