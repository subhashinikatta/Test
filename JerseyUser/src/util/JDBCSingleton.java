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
Connection conn;
 public int addUser( User user ) {
	    	ArrayList<User> userList = new ArrayList<User>();
	    	int status=0;
	        try {
	       
	            String query = "insert into Employee (firstName, lastName, email, username, password, confirmpassword) values(?,?,?,?,?,?)";
	          //conn= JDBCSingleton.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, user.getFirstName() );
	            preparedStatement.setString( 2, user.getLastName() );
	            preparedStatement.setString( 3, user.getEmail() );
	            preparedStatement.setString( 4, user.getusername() );
	            preparedStatement.setString( 5, user.getpassword() );
	            preparedStatement.setString( 6, user.getconfirmpassword() );
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
			
				e.printStackTrace();
			}
			return status;
	    }
	    
	    public int deleteUser( User user) {
	    	ArrayList<User> userList = new ArrayList<User>();
	    	int status=0;
	        try {
	        	//conn= JDBCSingleton.getConnection();
	            String query = "delete from Employee where email=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1,user.getEmail());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
	    }
	    public int updateUser(User user) {
	    	ArrayList<User> userList = new ArrayList<User>();
	    	int status=0;
	        try {
	        	//conn= JDBCSingleton.getConnection();
	            String query = "update Employee set firstName=?,lastName=?, username=?, password=?, confirmpassword=? where  email=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, user.getFirstName() );
	            preparedStatement.setString( 2, user.getLastName() );
	            preparedStatement.setString( 3, user.getusername() );
	            preparedStatement.setString(4, user.getpassword());
	            preparedStatement.setString(5, user.getconfirmpassword());
	            preparedStatement.setString( 6, user.getEmail() );
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return status;
	    }
	    public List<User> getAllUsers() throws Exception {
	        List<User> userList = new ArrayList<User>();
	        try {
	            Statement statement = conn.createStatement();
	            conn= JDBCSingleton.getConnection();
	            ResultSet resultSet = statement.executeQuery( "select * from Employee" );
	            while( resultSet.next() ) {
	                User user = new User();
	                user.setFirstName( resultSet.getString( "firstName" ) );
	                user.setLastName( resultSet.getString( "lastName" ) );
	                user.setEmail( resultSet.getString( "email" ) );
	                user.setusername( resultSet.getString( "username" ) );
	                user.setpassword( resultSet.getString( "password" ) );
	                user.setconfirmpassword( resultSet.getString( "confirmpassword" ) );
	                userList.add(user);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return userList;
	    }
		
}