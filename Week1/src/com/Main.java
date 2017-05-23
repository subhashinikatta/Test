package com;

import java.util.Scanner;

public class Main {

	private static Scanner s;
	static void printPrimes(int max) //print prime numbers
	{
	    int counter = 0;
      System.out.println("prime numbers are:");   
	    for (int i = 2; i <= max; i++) {
	     counter = 0;
	        for (int n = 2; n < i; n++) {
	           if (i % n == 0) {
	            counter++;
	          }
	         }
	      if (counter == 0) {
	        System.out.println(i);
	      }
	    } 
	   }
	static void printFirstPrime(int n)// print first n numbers
	{
		   //   int n = 0;
		      int status = 1;
		    int num = 3;
		      System.out.println("First n prime numbers are:");   
		      System.out.println(2);
		      for ( int i = 2 ; i <=n ;  )
		      {
		         for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
		         {
		            if ( num%j == 0 )
		            {
		               status = 0;
		               break;
		            }
		         }
		         if ( status != 0 )
		         {
		            System.out.println(num);
		            i++;
		         }
		         status = 1;
		         num++;
		      }         
		   }
	static void evenOddPrime(int n)// finding odd even and prime numbers in given array
	{
        s = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        n = s.nextInt();
        int[] a = new int[n];
        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) 
        {
            a[i] = s.nextInt();
        }
        System.out.print("Odd numbers:");
        for(int i = 0 ; i < n ; i++)
        {
            if(a[i] % 2 != 0)
            {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println("");
        System.out.print("Even numbers:");
        for(int i = 0 ; i < n ; i++)
        {
            if(a[i] % 2 == 0)
            {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println("");
        System.out.print("Prime numbers:");  
        //loop through the numbers one by one
        for(int i=0; i<a.length; i++){
            boolean isPrime = true;
                 if (a[i] == 1)
                     isPrime = false;
                 else {
                     // check to see if the numbers are prime
                     for (int j = 2; j <= a[i] / 2; j++) {
                         if (a[i] % j == 0) {
                             isPrime = false;
                             break;
                         }
                     }
                 }
            //print the number
            if(isPrime)

                System.out.println(a[i] + " ");
        }
    }
	public static void main(String args[]){
		printPrimes(Integer.parseInt(args[0]));
		printFirstPrime(Integer.parseInt(args[0]));
		evenOddPrime(Integer.parseInt(args[0]));
	}
	
}

