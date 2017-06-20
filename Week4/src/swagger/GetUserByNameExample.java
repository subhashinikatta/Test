package io.swagger.test;

import io.swagger.client.api.UserApi;
import io.swagger.client.model.User;

public class GetUserByNameExample
    {
        public static void main(String args[])
        {
            
        	UserApi apiInstance = new UserApi();
        String username = "username_example";  // string | The name that needs to be fetched. Use user1 for testing. 

            try
            {
                // Get user by user name
                User result = apiInstance.getUserByName(username);
                System.out.println(result);
            }
            catch (Exception e)
            {
            	 System.out.println("Exception when calling UserApi.GetUserByName: " + e.getMessage() );
            }
        }
    }