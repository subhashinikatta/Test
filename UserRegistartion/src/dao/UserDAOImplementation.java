package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
import util.DbConnection;
 
public class UserDAOImplementation implements UserDAO {
 
	 private static Connection conn;
	 
	    public UserDAOImplementation(){
	        
	    	
	    }
	    public int addUser( User user ) {
	    	ArrayList<User> userList = new ArrayList<User>();
	    	int status=0;
	        try {
	        	conn= DbConnection.getConnection();
	            String query = "insert into Employee (FirstName, LastName, Email, username, password, confirmpassword) values(?,?,?,?,?,?)";
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
	        	conn= DbConnection.getConnection();
	            String query = "delete from Employee where Email=?";
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
	        	conn= DbConnection.getConnection();
	            String query = "update Employee set FirstName=?,LastName=?, username=?, password=?, confirmpassword=? where  Email=?";
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
	    public List<User> getAllUsers() {
	        List<User> userList = new ArrayList<User>();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery( "select * from Employee" );
	            while( resultSet.next() ) {
	                User user = new User();
	                user.setFirstName( resultSet.getString( "FirstName" ) );
	                user.setLastName( resultSet.getString( "LastName" ) );
	                user.setEmail( resultSet.getString( "Email" ) );
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