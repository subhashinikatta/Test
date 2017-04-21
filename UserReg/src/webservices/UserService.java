package webservices;

import java.sql.DriverManager;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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
 for (User userVO : userList) {
 if(userVO.getUsername().equals(username))
 {
 if(userVO.getPassword().equals(password))
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
	
	try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "subbu", "subbu123");

		PreparedStatement ps = (PreparedStatement) connection
                .prepareStatement("insert into Employee values(?,?,?,?,?,?)");

        ps.setString(1, FirstName);
        ps.setString(2, LastName );
        ps.setString(3, Email);
        ps.setString(4, username);
        ps.setString(5, password);
        ps.setString(6, confirmpassword);
        int i = ps.executeUpdate();

	ArrayList<User> userList = new ArrayList<User>();
	SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 for (User userVO : userList){
if(FirstName.equals(null)||FirstName==""||LastName.equals(null)||LastName==""||Email.equals(null)||Email==""||username.equals(null)||username==""||password.equals(null)||password==""||confirmpassword.equals(null)||confirmpassword=="")
 {
			
			return "Successfully added user details";
 }
	 }
} catch (Exception e)
{
e.printStackTrace();
}
return "Successfully added user details";

}
}