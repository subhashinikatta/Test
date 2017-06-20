package io.swagger.test;


import io.swagger.client.api.UserApi;
import io.swagger.client.model.User;

    public class CreateUserExample
    {
        public static void main(String args[])
        {
        	UserApi apiInstance = new UserApi();
            User body = new User(); // User | Created user object

            try
            {
                // Create user
                apiInstance.createUser(body);
               
    			
            }
            catch (Exception e)
            {
                System.out.println("Exception when calling UserApi.CreateUser: " + e.getMessage() );
            }
        }
    }
