
package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Demo {
	public static void printnthPrimes(int max)// print nth prime number
	{
		
	    int num, count, i;
	    num=1;
	    count=0;
	 
	    while (count < max){
	      num=num+1;
	      for (i = 2; i <= num; i++){
	        if (num % i == 0) {
	          break;
	        }
	      }
	      if ( i == num){
	        count = count+1;
	      }
	    }
	    System.out.println("Value of nth prime: " + num);
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
	public static void evenOddPrime(String args[])// finding odd even and prime numbers in given array
	{
        int a[] = new int[20];
        try{
        for (int i = 0; i < args.length ; i++) 
        {
            a[i]=Integer.parseInt(args[i]);
        }
        System.out.print("Odd numbers:");
        for(int i = 0 ; i < args.length ; i++)
        {
            if(a[i] % 2 != 0)
            {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println("");
        System.out.print("Even numbers:");
        for(int i = 0 ; i < args.length ; i++)
        {
            if(a[i] % 2 == 0)
            {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println("");
        System.out.print("Prime numbers:");  
        //loop through the numbers one by one
        for(int i=0; i<args.length; i++){
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
        catch(ArrayIndexOutOfBoundsException e){ 
              System.out.println("Please enter a number on the command line");
        }
    }

	public static void swapwithoutTemp(int a, int b)//Swapping without using Temp
	{
	System.out.println("Swapping without use Temp");
	
	System.out.println("before swapping is" +a+" "+b);
	a=a+b;
	b=a-b;
	a=a-b;
	System.out.println("after swapping is" +a+" "+b);

	}
	public static void swapwithTemp(int a, int b)//Swapping With using Temp
	{
		int temp;
		System.out.println("Swapping with using Temp");
		
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
		
		while(n>0)
		{
			rem=n%10;
			sum=(sum*10)+rem;
			n=n/10;
		}
		System.out.println("reverse number is"+sum);
	}
	public static void reverseString(String input)//reverse given string
	{
        char[] try1= input.toCharArray();
		for (int i=try1.length-1;i>=0;i--)
		System.out.print(try1[i]);	
	}
	public static void palindromeNumber(int n)//checking given number is palindrome or not
	{
	int rem,sum=0,temp;
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
	public static void palindromeString(String str) //checking given string is palindrome or not
	{
		String rev = "";
        int n = str.length();
        for(int i=n-1 ; i>=0 ; i--)
        {
            rev = rev + str.charAt(i);
        }
        if(str.equals(rev))
            System.out.println("Given string is a palindrome");
        else
            System.out.println("Given string is not a palindrome");		       
      }
	public static void printFirstfibonacci(int n)// print Fibonacci frist n value
		{
	        int  a = 0, b = 0, c = 1;
	        System.out.print("Fibonacci Series:");
	        for(int i = 1; i <= n; i++)
	        {
	            a = b;
	            b = c;
	            c = a + b;
	            System.out.print(a+" ");
	        }
	}
	public static int fibrec(int n)// print Fibonacci nth value
	{
		
		 if(n==1)
	        {   
	            return 0;
	        }
	        if(n==2)
	        {
	            return 1;
	        }
	        return fibrec(n-1)+fibrec(n-2);
	        
	
}


public static void contains(String str, String findStr)//String With in string
{
	int lastIndex = 0;
	int count = 0;

	while(lastIndex != -1){

	    lastIndex = str.indexOf(findStr,lastIndex);

	    if(lastIndex != -1){
	        count ++;
	        lastIndex += findStr.length();
	    }
	}
	System.out.println(count);
}
public static void quadraticEquation(int a, int b, int c)//Quadratic Equation 
{
  double root1, root2, d;
  
  System.out.println("Given quadratic equation:"+a+"x^2 + "+b+"x + "+c);
  d = b * b - 4 * a * c;
  if(d > 0)
  {
      System.out.println("Roots are real and unequal");
      root1 = ( - b + Math.sqrt(d))/(2*a);
      root2 = (-b - Math.sqrt(d))/(2*a);
      System.out.println("First root is:"+root1);
      System.out.println("Second root is:"+root2);
  }
  else if(d == 0)
  {
      System.out.println("Roots are real and equal");
      root1 = (-b+Math.sqrt(d))/(2*a);
      System.out.println("Root:"+root1);
  }
  else
  {
      System.out.println("Roots are imaginary");
  }
}
static String replaceString(String original, String toReplace,
        String replacedWith) {
    for(;;) {
        int i = original.indexOf(toReplace);
        if (i == -1) {
            break;
        }
        original = original.substring(0, i) + replacedWith + original.substring(i + toReplace.length());
    }
    return original;
}
static void modifyFile(String filename, String oldString, String newString)
{
    File fileToBeModified = new File(filename);
     
    String oldContent = "";
     
    BufferedReader reader = null;
     
    FileWriter writer = null;
     
    try
    {
        reader = new BufferedReader(new FileReader(fileToBeModified));
         
        //Reading all the lines of input text file into oldContent
         
        String line = reader.readLine();
         
        while (line != null) 
        {
            oldContent = oldContent + line + System.lineSeparator();
             
            line = reader.readLine();
        }
         
        //Replacing oldString with newString in the oldContent
         
        String newContent = oldContent.replaceAll(oldString, newString);
         
        //Rewriting the input text file with newContent
         
        writer = new FileWriter(fileToBeModified);
         
        writer.write(newContent);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        try
        {
            //Closing the resources
             
            reader.close();
             
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
}

