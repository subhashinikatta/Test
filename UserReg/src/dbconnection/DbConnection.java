package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {
 
public static Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:mysql://localhost:3306/userdb";
Connection connection = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "subbu", "subbu123");
return connection;
}
catch (SQLException e)
{
throw e;
}
catch (Exception e)
{
throw e;
}
}
}