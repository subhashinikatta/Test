package io.swagger.test;

import io.swagger.client.api.UserApi;

public class LogoutUserExample
    {
        public static void main(String args[])
        {
            
        	UserApi apiInstance = new UserApi();

            try
            {
                // Logs out current logged in user session
                apiInstance.logoutUser();
            }
            catch (Exception e)
            {
               System.out.println("Exception when calling UserApi.LogoutUser: " + e.getMessage() );
            }
        }
    }