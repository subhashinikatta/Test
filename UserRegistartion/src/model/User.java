package model;
public class User {

private String firstName;
private String lastName;
private String email;
private String username;
private String password;
private String confirmpassword;

public User(){
}

public User(String firstName,String lastName,String email,String username,String password,String confirmpassword) {
    this.username = username; 
    this.password = password;
    this.confirmpassword = confirmpassword;
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    }

public void setusername(String username) {
this.username = username;
}

public void setpassword(String password) {
this.password = password;
}
public void setLastName(String string) {
	this.lastName=lastName;
	
}
public void setEmail(String string) {
	this.email=email;
	
}
public void setFirstName(String string) {
	  this.firstName=firstName;
	
}
public void setconfirmpassword(String string) {
	 this.confirmpassword = confirmpassword;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
	
}
public String getEmail() {
	return email;

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