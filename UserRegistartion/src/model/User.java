package model;
public class User {

private String FirstName;
private String LastName;
private String Email;
private String username;
private String password;
private String confirmpassword;

public User(){
}

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
	this.LastName=LastName;
	
}
public void setEmail(String string) {
	this.Email=Email;
	
}
public void setFirstName(String string) {
	  this.FirstName=FirstName;
	
}
public void setconfirmpassword(String string) {
	 this.confirmpassword = confirmpassword;
}
public String getFirstName() {
	return FirstName;
}
public String getLastName() {
	return LastName;
	
}
public String getEmail() {
	return Email;

}
public String getusername() {
	return username;

}

public String getpassword() {
	return password;
	
}

public String getconfirmpassword() {
	return confirmpassword;

}

 
}