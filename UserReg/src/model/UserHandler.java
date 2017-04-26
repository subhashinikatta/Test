package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import model.User;
 
public class UserHandler {
 
public ArrayList<User> getAllUsers(Connection connection) throws Exception {
ArrayList<User> userList = new ArrayList<User>();
try {
// String uname = request.getParameter("uname");
PreparedStatement ps = connection
.prepareStatement("SELECT * FROM Employee");
// ps.setString(1,uname);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
User uservo = new User();
uservo.setusername(rs.getString("username"));
uservo.setpassword(rs.getString("password"));
userList.add(uservo);
}
return userList;
} catch (Exception e) {
throw e;
}
}
 
public ArrayList<User> getAllUsers1(Connection connection) throws SQLException
{
ArrayList<User> userList = new ArrayList<User> ();

PreparedStatement stmt = connection.prepareStatement("insert into Employee(FirstName,LastName,Emali,username,password,confirmpassword) values(?,?,?,?,?.?)");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
User uservo = new User();
uservo.setFirstName(rs.getString("FirstName"));
uservo.setLastName(rs.getString("LastName"));
uservo.setEmail(rs.getString("Emali"));
uservo.setusername(rs.getString("username"));
uservo.setpassword(rs.getString("password"));
uservo.setconfirmpassword(rs.getString("confirmpassword"));
userList.add(uservo);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return userList;
 
}
}