package model;

import java.sql.Connection;
import java.util.ArrayList;
 
import pojo.User;
 
import dbconnection.DbConnection;
import dbconnection.UserHandler;;

 
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