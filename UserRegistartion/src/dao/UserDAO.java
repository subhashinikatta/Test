package dao;
import java.util.List;
 
import model.User;
 
public interface UserDAO {
    public int addUser( User user );
    public int deleteUser( User user );
    public int updateUser( User user );
    public List<User> getAllUsers();
   
}