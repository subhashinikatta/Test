<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    padding-top:50px;
}
fieldset {
    border: thin solid #ccc; 
    border-radius: 4px;
    padding: 20px;
    padding-left: 40px;
    background: #fbfbfb;
}
legend {
   color: #678;
}
.form-control {
    width: 20%;
}
label small {
    color: #678 !important;
}
span.req {
    color:maroon;
    font-size: 112%;
}
</style>
</head>
<body >
 <form action="rest/user/register" method="post" >
<center>
<div class="container">
	<div class="row">
        <div class="col-md-6">
            <form action="" method="post" id="fileForm" role="form">
            <fieldset><legend class="text-center"> Registration Page. <span class="req"></span></legend>


            <div class="form-group"> 	 
                <label for="FirstName"><span class="req">* </span> First name: </label>
                    <input class="form-control" type="text" name="FirstName" id = "txt" onkeyup = "Validate(this)" required /> 
                        <div id="errFirst"></div>    
            </div><br>

            <div class="form-group">
                <label for="LastName"><span class="req">* </span> Last name: </label> 
                    <input class="form-control" type="text" name="LastName" id = "txt" onkeyup = "Validate(this)"  required />  
                        <div id="errLast"></div>
            </div><br>

            <div class="form-group">
                <label for="Email"><span class="req">* </span> Email: </label> 
                    <input class="form-control" required type="text" name="Email" id = "email"  onchange="email_validate(this.value);" />   
                        <div class="status" id="status"></div>
            </div><br>

            <div class="form-group">
                <label for="username"><span class="req">* </span> User name:   </label> 
                    <input class="form-control" type="text" name="username" id = "txt" onkeyup = "Validate(this)"  required />  
                        <div id="errLast"></div>
            </div><br>

            <div class="form-group">
                <label for="password"><span class="req">* </span> Password: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16"  id="pass1" /> 
                <br><br>
                <label for="password"><span class="req">* </span> confirmpassword: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                        <span id="confirmMessage" class="confirmMessage"></span>
            </div>
     <br><br><br>
            <div class="form-group" >
                    <button id="submit" name="submit" class="btn btn-success">Register</button>
                    <button id="reset" name="reset" type="reset" class="btn btn-danger">Reset</button><br><br>
                    
                    <span>Already registered!! <a href="NewFile.jsp">Login Here</a></span>
            </div>
          </div>
           
         </fieldset>
            </form><!-- ends register form -->

        </div><!-- ends col-6 -->
  

	</div>
</div>

<script>
function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(pass1.value == pass2.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
} 

// validates text only
function Validate(txt) {
    txt.value = txt.value.replace(/[^a-zA-Z-'\n\r.]+/g, '');
}
// validate email
function email_validate(email)
{
var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

    if(regMail.test(email) == false)
    {
    document.getElementById("status").innerHTML    = "<span class='warning'>Email address is not valid yet.</span>";
    }
    else
    {
    document.getElementById("status").innerHTML	= "<span class='valid'>Thanks, you have entered a valid Email address!</span>";	
    }
}


</script>
</center>
</body>
</html>