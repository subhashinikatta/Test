package util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCSingleton {  
     //Step 1  
     // create a JDBCSingleton class.  
  //static member holds only one instance of the JDBCSingleton class.  
           
       private static JDBCSingleton jdbc;  
           
    //JDBCSingleton prevents the instantiation from any other class.  
      public JDBCSingleton() {  }  
        
    //Now we are providing gloabal point of access.  
        public static JDBCSingleton getInstance() {    
                                     if (jdbc==null)  
                                  {  
                                            jdbc=new  JDBCSingleton();  
                                  }  
                         return jdbc;  
            }

 
public static Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:mysql://localhost:3306/userdb?autoReconnect=true&useSSL=false";
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