package model;

import java.sql.Connection;
import java.util.ArrayList;
 
import model.User;
 
import dbconnection.DbConnection;
import model.UserHandler;;

 
public class SecurityManager {
 
public ArrayList<User> getAllUsersList()throws Exception {
ArrayList<User> userList = null;
try {
DbConnection database= new DbConnection();
Connection connection = database.getConnection();
UserHandler loginHandler= new UserHandler();
userList= loginHandler.getAllUsers(connection);
 
} catch (Exception e) {
throw e;
}
return userList;
}
 
}