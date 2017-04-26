package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
import dbconnection.DbConnection;
 
public class UserDAOImplementation implements UserDAO {
 
    private static Connection conn;
 
    public UserDAOImplementation() throws Exception {
        conn = DbConnection.getConnection();
    }
    @Override
    public static void addUser( User user ) {
        try {
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
        }
    }
    @Override
    public void deleteUser( String FirstName) {
        try {
            String query = "delete from Employee where FirstName=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, FirstName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateUser( User user ) {
        try {
            String query = "update Employee set FirstName=?, LastName=?, Email=?, username=?, password=?, confirmpassword=? where FirstName=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getFirstName() );
            preparedStatement.setString( 2, user.getLastName() );
            preparedStatement.setString( 3, user.getEmail() );
            preparedStatement.setString( 4, user.getusername() );
            preparedStatement.setString(5, user.getpassword());
            preparedStatement.setString(5, user.getconfirmpassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
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
                users.add(user);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public User getUserByFirstName(String FirstName) {
        User user = new User();
        try {
            String query = "select * from Employee where FirstName=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, FirstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                user.setFirstName( resultSet.getString( "FristName" ) );
                user.setLastName( resultSet.getString( "LastName" ) );
                user.setEmail( resultSet.getString( "Email" ) );
                user.setusername( resultSet.getString( "username" ) );
                user.setpassword( resultSet.getString( "password" ) );
                user.setconfirmpassword( resultSet.getString( "confirmpassword" ) );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
 
}