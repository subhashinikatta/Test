package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import web.UserVO;
 
public class RegHandler
{
public ArrayList<UserVO> getAllUsers(Connection connection) throws SQLException
{
ArrayList<UserVO> userList = new ArrayList<UserVO> ();
PreparedStatement stmt = connection.prepareStatement("insert into Employee(FirstName,LastName,Emali,username,password,confirmpassword) values(?,?,?,?,?.?)");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
UserVO uservo = new UserVO();
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