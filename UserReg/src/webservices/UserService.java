package webservices;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.UserDAOImplementation;
import model.SecurityManager;
import model.User;
 
@Path("/user")
public class UserService {
 
@POST
 @Path("/login")
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public String login(@FormParam("username") String username,
 @FormParam("password") String password) {
 
	return getAllUsersList(username, password);
	 
	}
	 
	public String getAllUsersList(String username,String password)
	 {
	 String userListData = null;
	 try 
	 {
	 ArrayList<User> userList = null;
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 for (User user : userList) {
	 if(user.getusername().equals(username))
	 {
	 if(user.getpassword().equals(password))
	 {
	 return "Logged in User:"+username;
	 }
	 }
	 }
	 
	} catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 return "You are not a Valid User";
	 }
@POST
@Path("/register")
public String register(@FormParam("FirstName") String FirstName,@FormParam("LastName") String LastName,@FormParam("Email") String Email,
        @FormParam("username") String username, @FormParam("password") String password, @FormParam("confirmpassword") String confirmpassword){
	
	 User user = new User(FirstName,LastName,Email,username,password,confirmpassword);
     int result = UserDAOImplementation.addUser(user);
     String users=null;
     try
 {
	 
	 ArrayList<User> userList = null;
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 Gson gson =new Gson();
	 users =gson.toJson(userList);
	 for (User user1 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user1.getEmail() == null || user1.getEmail().trim().equals("")&& !pattern.matcher(Email).matches()&& user1.getusername() == null || user1.getusername().trim().equals("")&& user1.getFirstName() == null || user1.getFirstName().trim().equals("")&& user1.getLastName() == null || user1.getLastName().trim().equals(""))
{
					  
						  System.out.println("please enter valid details");
					  }
else{
	userList.add(user1);
}
	 }
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
     return users;
}
@PUT
@Path("/update")
public String update(@FormParam("FirstName") String FirstName,@FormParam("LastName") String LastName,@FormParam("Email") String Email,
        @FormParam("username") String username, @FormParam("password") String password, @FormParam("confirmpassword") String confirmpassword){
	 User user = new User(FirstName,LastName,Email,username,password,confirmpassword);
     int result = UserDAOImplementation.updateUser(user);
	 try 
	 {
	 ArrayList<User> userList = null;
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 for (User user2 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user2.getEmail() == null || user2.getEmail().trim().equals("")&& !pattern.matcher(Email).matches())
{
	System.out.println("please enter valid email");
		 
}
else{
	if(user.getEmail().equals(Email))	{			  
		userList.add(user2);
	  }
	

}
	 }
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
     if(result == 1){
        return "SUCCESSFULLY UPDATED";
     }
     return "YOUR EMAIL IS NOT REGISTERED";
}
@DELETE
@Path("/delete")
public String deleet(@FormParam("FirstName") String FirstName,@FormParam("LastName") String LastName,@FormParam("Email") String Email,
        @FormParam("username") String username, @FormParam("password") String password, @FormParam("confirmpassword") String confirmpassword){
	User user = new User(FirstName,LastName,Email,username,password,confirmpassword);
    int result = UserDAOImplementation.deleetUser(user);
	 try 
	 {
	 ArrayList<User> userList = null;
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 for (User user3 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user3.getEmail() == null || user3.getEmail().trim().equals("")&& !pattern.matcher(Email).matches())
{
	System.out.println("please enter valid email");
		 
}
else{
	if(user.getEmail().equals(Email))	{			  
		userList.add(user3);
	  }
	

}
	 }
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
     if(result == 1){
        return "SUCCESSFULLY DELETED";
     }
     return "YOUR EMAIL IS NOT REGISTERED";
}
}