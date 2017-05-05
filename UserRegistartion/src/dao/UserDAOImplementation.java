package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
import util.JDBCSingleton;
 
public class UserDAOImplementation implements UserDAO {
 
	//JDBCSingleton jdbc= JDBCSingleton.getInstance();  
	// private static DbConnection database= new DbConnection();
	 private static Connection conn;
	 
	    public UserDAOImplementation(){
	        
	    	
	    }
	    public int addUser( User user ) {
	    	ArrayList<User> userList = new ArrayList<User>();
	    	int status=0;
	        try {
	        
	        	conn= JDBCSingleton.getConnection();
	            String query = "insert into Employee (firstName, lastName, email, username, password, confirmpassword) values(?,?,?,?,?,?)";
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
	           // conn= JDBCSingleton.getConnection();
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