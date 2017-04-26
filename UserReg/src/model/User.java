package model;

public class User {

private String FirstName;
private String LastName;
private String Email;
private String username;
private String password;
private String confirmpassword;

public User(String FirstName,String LastName,String Email,String username,String password,String confirmpassword) {
    this.username = username; 
    this.password = password;
    this.confirmpassword = confirmpassword;
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.Email=Email;
    }

public void setusername(String username) {
this.username = username;
}

public void setpassword(String password) {
this.password = password;
}
public void setLastName(String string) {
	// TODO Auto-generated method stub
	
}
public void setEmail(String string) {
	// TODO Auto-generated method stub
	
}
public void setFirstName(String string) {
	// TODO Auto-generated method stub
	
}
public void setconfirmpassword(String string) {
	// TODO Auto-generated method stub
	
}
public String getFirstName() {
	// TODO Auto-generated method stub
	return null;
}
public String getLastName() {
	// TODO Auto-generated method stub
	return null;
}
public String getEmail() {
	// TODO Auto-generated method stub
	return null;
}
public String getusername() {
	// TODO Auto-generated method stub
	return null;
}

public String getpassword() {
	// TODO Auto-generated method stub
	return null;
}

public String getconfirmpassword() {
	// TODO Auto-generated method stub
	return null;
}

 
}