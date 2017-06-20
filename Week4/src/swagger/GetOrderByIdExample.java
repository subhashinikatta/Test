package io.swagger.test;

import io.swagger.client.api.StoreApi;
import io.swagger.client.model.Order;

public class GetOrderByIdExample
    {
        public static void main(String args[])
        {
            
        	StoreApi apiInstance = new StoreApi();
            String orderId = "789";  // long? | ID of pet that needs to be fetched

            try
            {
                // Find purchase order by ID
                Order result = apiInstance.getOrderById(orderId);
                System.out.println(result);
            }
            catch (Exception e)
            {
            	System.out.println("Exception when calling StoreApi.GetOrderById: " + e.getMessage() );
            }
        }
    }