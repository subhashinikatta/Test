package io.swagger.test;

import io.swagger.client.api.StoreApi;

public class DeleteOrderExample
    {
        public static void main(String args[])
        {
            
        	StoreApi apiInstance = new StoreApi();
            String orderId = "orderId_example";  // string | ID of the order that needs to be deleted

            try
            {
                // Delete purchase order by ID
                apiInstance.deleteOrder(orderId);
            }
            catch (Exception e)
            {
                System.out.println("Exception when calling StoreApi.DeleteOrder: " + e.getMessage() );
            }
        }
    }