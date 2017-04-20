package web;

import java.awt.PageAttributes.MediaType;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import web.UserVO;
 
@Path("/register")
public class RegService
{
@POST
@Path("/doregister")
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

	ArrayList<UserVO> userList = new ArrayList<UserVO>();
	SecurityManager securityManager= new SecurityManager();
	 userList = securityManager.getAllUsersList();
	 for (UserVO userVO : userList){
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