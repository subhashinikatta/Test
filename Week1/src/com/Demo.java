package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo {
	private static Scanner s;
	public static void printPrimes(int max) //print prime numbers
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
	public static void printFirstPrime(int n)// print first n numbers
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
	public static void evenOddPrime(int n)// finding odd even and prime numbers in given array
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
	public static void swapwithoutTemp(int n)//Swapping without using Temp
	{
	int a,b;
	System.out.println(" ");
	System.out.println("Swapping without use Temp");
	System.out.println("enter A number");
	a=s.nextInt();
	

	System.out.println("enter B number");
	b=s.nextInt();
	
	System.out.println("before swapping is" +a+" "+b);
	a=a+b;
	b=a-b;
	a=a-b;
	System.out.println("after swapping is" +a+" "+b);

	}
	public static void swapwithTemp(int n)//Swapping With using Temp
	{
		int a,b,temp;
		System.out.println(" ");
		System.out.println("Swapping with using Temp");
		System.out.println("enter A number");
		a=s.nextInt();
		

		System.out.println("enter B number");
		b=s.nextInt();
		
		System.out.println("before swapping is"+a+" "+b);
		temp=a;
		a=b;
		b=temp;
		System.out.println("after swapping is"+a+" "+b);
	}
	public static void reverseNumber(int n)//Reverse given number
	{
		int rem,sum=0;
		System.out.println("enter a number to reverse");
		n=s.nextInt();
		
		while(n>0)
		{
			rem=n%10;
			sum=(sum*10)+rem;
			n=n/10;
		}
		System.out.println("reverse number is"+sum);
	}
	public static void reverseString(String s)//reverse given string
	{
		String input="";
        System.out.println("Enter the input string");
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
            char[] try1= input.toCharArray();
            for (int i=try1.length-1;i>=0;i--)
            System.out.print(try1[i]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }	
	}
	public static void palindromeNumber(int n)//checking given number is palindrome or not
	{
	int rem,sum=0,temp;
	System.out.println("");
	System.out.println("enter a number for palindrome");
	n=s.nextInt();
	temp=n;
	while(n>0)
	{
		rem=n%10;
		sum=(sum*10)+rem;
		n=n/10;
	}
	
	if(temp==sum)
	{
		System.out.println("palindrome");
	}
	else
	{
		System.out.println("not palindrome");
	}
	}
	public static void palindromeString(String s) //checking given string is palindrome or not
	{
		try
        {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter a String : ");
        String str = br.readLine();
        String rev = "";
        int n = str.length();
        for(int i=n-1 ; i>=0 ; i--)
        {
            rev = rev + str.charAt(i);
        }
        if(str.equals(rev))
            System.out.println("\nGiven string is a palindrome");
        else
            System.out.println("\nGiven string is not a palindrome");
        }
        catch (IOException e) {
            e.printStackTrace();
        }		       
  }
	public static void printFirstfibonacci(int n)
		{
	        int  a = 0, b = 0, c = 1;
	        System.out.print("Enter value of n:");
	        n = s.nextInt();
	        System.out.print("Fibonacci Series:");
	        for(int i = 1; i <= n; i++)
	        {
	            a = b;
	            b = c;
	            c = a + b;
	            System.out.print(a+" ");
	        }
	}
}
