package io.swagger.test;

import io.swagger.client.api.UserApi;

public class LoginUserExample
    {
        public static void main(String args[])
        {
            
        	UserApi apiInstance = new UserApi();
            String username = "username_example";  // string | The user name for login
            String  password = "password_example";  // string | The password for login in clear text

            try
            {
                // Logs user into the system
                String result = apiInstance.loginUser(username, password);
                System.out.println(result);
            }
            catch (Exception e)
            {
            	 System.out.println("Exception when calling UserApi.LoginUser: " + e.getMessage() );
            }
        }
    }