package io.swagger.test;

import io.swagger.client.api.StoreApi;
import io.swagger.client.model.Order;

public class PlaceOrderExample
    {
        public static void main(String args[])
        {
            
        	StoreApi apiInstance = new StoreApi();
            Order body = new Order(); // Order | order placed for purchasing the pet

            try
            {
                // Place an order for a pet
                Order result = apiInstance.placeOrder(body);
                System.out.println(result);
            }
            catch (Exception e)
            {
            	 System.out.println("Exception when calling StoreApi.PlaceOrder: " + e.getMessage() );
            }
        }
    }