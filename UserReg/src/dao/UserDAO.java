package dao;
import java.util.List;
 
import model.User;
 
public interface UserDAO {
    public void addUser( User user );
    public void deleteUser( String FirstName );
    public void updateUser( User user );
    public List<User> getAllUsers();
    public User getUserByFirstName(String FirstName  );
}