package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAOImplementation;
import model.User;
 
import util.JDBCSingleton;


 
public class SecurityManager {
 
public ArrayList<User> getAllUsersList()throws Exception {
ArrayList<User> userList = null;
try {
	JDBCSingleton database= new JDBCSingleton();
Connection connection = database.getConnection();
UserDAOImplementation user= new UserDAOImplementation();
userList= (ArrayList<User>) user.getAllUsers();
 
} catch (Exception e) {
throw e;
}
return userList;
}
 
}