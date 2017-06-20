package io.swagger.test;


import io.swagger.client.api.UserApi;

public class DeleteUserExample
{
    public static void main(String args[])
    {
        
    	UserApi apiInstance = new UserApi();
        String username = "username_example";  // string | The name that needs to be deleted

        try
        {
            // Delete user
            apiInstance.deleteUser(username);
        }
        catch (Exception e)
        {
            System.out.println("Exception when calling UserApi.DeleteUser: " + e.getMessage() );
        }
    }
}