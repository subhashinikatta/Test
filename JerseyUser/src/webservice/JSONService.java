package webservice;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.omg.CORBA.portable.ApplicationException;

import dao.UserDAO;
import dao.UserDAOImplementation;
import model.SecurityManager;
import model.User;


@Path("/user")
public class JSONService {
	
	 UserDAO userDao = new UserDAOImplementation();

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logInJSON(User user) throws SQLException {
	
		 {
		 try 

			 {

			 SecurityManager securityManager= new SecurityManager();
			 ArrayList<User> userList = new ArrayList<User>();

			 userList = securityManager.getAllUsersList();

			
			 {

			 System.out.println( "Logged in User");

			 }

			} catch (Exception e)

			 {

			 System.out.println("error");

			 }

			 System.out.println("You are not a Valid User");

			 }
		String result = " Login : " + user;
	
		return Response.status(201).entity(result).build();
		
	}
	 @POST
		@Path("/register")
	 @Consumes(MediaType.APPLICATION_JSON)
		public Response createUserInJSON(User user) {
		   
			
		 userDao.addUser(user);
		
	     ArrayList<User> userList = new ArrayList<User>();
	     userList.add(user);
	     
			String result = "User created : " + user;
			return Response.status(201).entity(result).build();
			
		}

@PUT
@Path("/update")
@Consumes(MediaType.APPLICATION_JSON)
public Response updateInJSON(User user) throws SQLException {
	userDao.updateUser(user);
	ArrayList<User> userList = new ArrayList<User>();
	userList.add(user);
	String result = "Updated User: " + user;
	return Response.status(201).entity(result).build();
	
}

@DELETE
@Path("/delete")
@Consumes(MediaType.APPLICATION_JSON)
public Response DeleteInJSON(User user) throws ApplicationException, SQLException {
	userDao.deleteUser(user);
	ArrayList<User> userList = new ArrayList<User>();
	userList.add(user);
	String result = "Deleted User: " + user;
	return Response.status(201).entity(result).build();
	
}

}
