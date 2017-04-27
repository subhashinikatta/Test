package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAOImplementation;
import model.User;
 
import util.DbConnection;


 
public class SecurityManager {
 
public ArrayList<User> getAllUsersList()throws Exception {
ArrayList<User> userList = null;
try {
DbConnection database= new DbConnection();
Connection connection = database.getConnection();
UserDAOImplementation user= new UserDAOImplementation();
userList= (ArrayList<User>) user.getAllUsers();
 
} catch (Exception e) {
throw e;
}
return userList;
}
 
}