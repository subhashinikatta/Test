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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.UserDAO;
import dao.UserDAOImplementation;
import model.SecurityManager;
import model.User;
import util.JDBCSingleton;


@Path("/user")
public class UserService {
	
	  UserDAO userDao = new UserDAOImplementation();
		
@POST
 @Path("/login")
/*@Produces(MediaType.APPLICATION_JSON) */
/* @Consumes(MediaType.APPLICATION_FORM_URLENCODED) */
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
	 return "Logged in User:"+username;
	 }
@POST
@Path("/register")
@Produces(MediaType.APPLICATION_JSON) 

public String register(@FormParam("FirstName") String FirstName,
		@FormParam("LastName") String LastName,
		@FormParam("Email") String Email,
        @FormParam("username") String username,
        @FormParam("password") String password,
        @FormParam("confirmpassword") String confirmpassword){
	
	 User user = new User(FirstName,LastName,Email,username,password,confirmpassword);
    /* int result = UserDAOImplementation.addUser(user);*/
	
	 userDao.addUser(user);
	
     String users=null;
     ArrayList<User> userList = new ArrayList<User>();
     try
 {
	 
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	
	// for (User user1 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user.getEmail() == null || user.getEmail().trim().equals("")&& !pattern.matcher(Email).matches()&& user.getusername() == null || user.getusername().trim().equals("")&& user.getFirstName() == null || user.getFirstName().trim().equals("")&& user.getLastName() == null || user.getLastName().trim().equals(""))
{
					  
						  //System.out.println("please enter valid details");
					  }
/*if(FirstName.isEmpty()||LastName.isEmpty()||Email.isEmpty()||username.isEmpty()||password.isEmpty()||confirmpassword.isEmpty())
	{
			 System.out.println("Please fill all the fields");
 	}
	String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 Pattern pattern = Pattern.compile(emailRegex);
	   
		 if( FirstName == "" )
		   {
			 System.out.println("Please enter the first names");
		     return FirstName;
		   }
		 if( LastName == "" )
		   {
		     
			 System.out.println("enter the last name");
		     return LastName;
		   }
		    
		   if (Email == "" )
		 {
			   System.out.println( "enter the email");
		  return Email;
		  }else if(!emailRegex.test(Email)){
		  
			  System.out.println( "enter the valid email");
		  return false;
		  }
		   
			 if(username == "")
			  {
			  
				 System.out.println( "enter the username");
			   return username;
			  } 
		  
		   
		 if(password == "")
		  {
		  
			 System.out.println( "enter the password");
		   return password;
		  }
		  
		 if(confirmpassword == "")
		  {
		  
			 System.out.println( "enter the confirmpassword");
		   return confirmpassword;
		  }else if(!emailRegex.test(confirmpassword)){
			  System.out.println("Re-enter the valid password");
			  return confirmpassword;
			  }
			
		  
		 
		  if(FirstName != "" && LastName != "" && Email != "" && username != "" && password != "" && confirmpassword != "" ){
			  System.out.println( "form submitted successfully");
		   }
		     */
	

else{
	userList.add(user);
	Gson gson=new Gson();
	users =gson.toJson(user);
}
	 }
	 
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
    /* if(result != 1){ 
       return "Invalid Details"; 
    	 } */
    	      return "successfully Registered values"+users ; 
    	     
 } 
@PUT
@Path("/update")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String update(@FormParam("FirstName") String FirstName,
		@FormParam("LastName") String LastName,
		@FormParam("Email") String Email,
        @FormParam("username") String username,
       @FormParam("password") String password,
       @FormParam("confirmpassword") String confirmpassword){
	
	User user = new User(FirstName,LastName,Email,username,password,confirmpassword);
	 userDao.updateUser(user);
	 
     String users=null;
	 try 
	 {
	 ArrayList<User> userList = null;
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	// for (User user2 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user.getEmail() == null || user.getEmail().trim().equals("")&& !pattern.matcher(Email).matches())
{
	//System.out.println("please enter valid email");
		 
}
else{
	if(user.getEmail().equals(Email))	{			  
		userList.add(user);
		
		Gson gson =new Gson(); 
	  users =gson.toJson(user); 
	  } 

}
	 
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
	 /*if(result != 1){ 
		        return "Invalid"; 
	     } */
		    return "successfully updated values"+users; 
		} 
@DELETE
@Path("/delete")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String deleet(@FormParam("FirstName") String FirstName,
		@FormParam("LastName") String LastName,
		@FormParam("Email") String Email,
        @FormParam("username") String username,
        @FormParam("password") String password,
        @FormParam("confirmpassword") String confirmpassword){
	
	User user = new User(FirstName,LastName,Email,username,password,confirmpassword);
	
	 userDao.deleteUser(user);
	
    String users = null;
	 try 
	 {
	 ArrayList<User> userList = null;
	 SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	//for (User user3 : userList) {
		 String EMAIL_PATTERN = 
				 "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				 + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
if( user.getEmail() == null || user.getEmail().trim().equals("")&& !pattern.matcher(Email).matches())
{
	//System.out.println("please enter valid email");
		 
}
else{
	if(user.getEmail().equals(Email))	{			  
		userList.add(user);
		Gson gson =new Gson(); 
	 		 users =gson.toJson(user); 
			  }

}
	 
	 }
	 catch (Exception e)
	 {
	 System.out.println("error");
	 }
	 
	/* if(result != 1){ 
		         return "Invalid email"; 
		     } */
		      return "Successfully Deleted "+users; 
		 } 
		 } 