package com;
 import java.io.BufferedReader; 
 import java.io.File; 
 import java.io.FileReader; 
 import java.io.FileWriter; 
 import java.io.IOException;  
 
 
 public class Demo 
 { 
	/* print nth prime number */
 	public static void printnthPrimes(int max) 
 	{ 
 		try{ 
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
 	}catch(Exception e){
 	  	System.out.println("Error");
 	  }
 	} 
 /* print first n numbers */
 	public static void printFirstPrime(int max) 
 	{ try{
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
 	     System.out.println("Value of first n prime: " + num);  
 	    } }catch(Exception e){
 	     	System.out.println("Error");
 	   }
 	  
 		   } 
 /* finding odd even and prime numbers in given array */
 	public static void evenOddPrime(String args[])
 	{ 
         int a[] = new int[20]; 
         try{ 
         for (int i = 0; i < args.length ; i++)  
         { 
             a[i]=Integer.parseInt(args[i]); 
         
             if(a[i] % 2 != 0)
             {
            	 System.out.print("Odd numbers:");   
                 System.out.print(a[i]+" ");
             }else
            	 System.out.print("Even numbers:");   
                 System.out.print(a[i]+" ");
         System.out.print("Prime numbers:");   
          
                      for (int j = 2; j <= a[i] / 2; j++) { 
                          if (a[i] % j == 0) { 
                              break; 
                          } 
                      } 
				System.out.println(a[i] + " "); 
         } } 
         catch(ArrayIndexOutOfBoundsException e){  
               System.out.println("Please enter a number on the command line"); 
         } 
     } 
 
  	
 	private static boolean isInteger(String s) {
	      boolean isValid = true;
	      try
            { 
              Integer.parseInt(s); 
               }
	      catch(NumberFormatException nfe){ 
              isValid = false;
            }
	      return isValid;
	  } 
 	/*Reverse given number or string */
 	public static void reverse(String args[])
 		{  
 		try{
 			int i=0,rem,sum=0;   
 			 if( isInteger(args[0])) {
 			int n = Integer.parseInt(args[i]);
 			while(n>0)  
 			{  
 				rem=n%10;  
 				sum=(sum*10)+rem;  
 				n=n/10;  
 			}  
 			System.out.println("reverse number is"+sum);  
 		} 
 	     else{
	        char[] str= args[i].toCharArray();  
			for (int j=str.length-1;j>=0;j--)  
			System.out.print(str[j]);	
 	}
 		}catch(Exception e){
 			System.out.println("Enter only string or integr");
 		}
 		
 	}
 	/*checking given number/string is palindrome or not */ 
 	public static void palindrome(String args[])
		{ 
 		try{
		int rem,sum=0,temp,i=0;  
		if( isInteger(args[0])) {
 		int n = Integer.parseInt(args[i]);
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
		}else{
			String rev = "";  
		        int n = args[i].length();  
		        for(int j=n-1 ; j>=0 ; j--)  
		        {  
		            rev = rev + args[i].charAt(j);  
		        }  
		        if(args[i].equals(rev)) 
	            System.out.println("Given string is a palindrome");  
	        else  
	           System.out.println("Given string is not a palindrome");	
		}
 		}catch(Exception e){
 			System.out.println("Enter only string or integr");
 		}
	}
 
 /* print Fibonacci frist n value */
 	public static void printFirstFibonacci(int n)
 		{ 
 	    try{    
 		int  a = 0, b = 0, c = 1; 
 	        System.out.print("Fibonacci Series:"); 
 	        for(int i = 1; i <= n; i++) 
 	        { 
 	            a = b; 
 	            b = c; 
 	            c = a + b; 
 	            System.out.print(a+" "); 
 	        } 
 	    }catch(Exception e){
 	    	System.out.println("Error");
 	    }
 	} 
 /* print Fibonacci nth value */
 	public static void printNthFibonacci(int n)
 	{ 
 		 
 	   try{ 
	        int  a = 0, b = 0, c = 1; 
	        System.out.print("Fibonacci Series:"); 
	        for(int i = 1; i <= n; i++) 
	        { 
	            a = b; 
	            b = c; 
	            c = a + b; 
	           
	        } 
	        System.out.print(a+" ");     
 	  }catch(Exception e){
	    	System.out.println("Error");
	    }
 }  
 	/*String With in string*/ 
 public static void contains(String str, String findStr)
 { 
	 try{
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
 }catch(Exception e){
	  	System.out.println("Error");
	  }
 }
/*Quadratic Equation */ 
 public static void quadraticEquation(int a, int b, int c,int x)
 {    try{ 
		double m;
		m=a*(x*x)+b*x+c;
		System.out.println("Equation solving Solution is"+m);
 }catch(Exception e){
  	System.out.println("Error");
  }
 } 
 static void replaceMethod(String original, String toReplace,
	        String replacedWith) {
	 try{
	    for(;;) {
	        int i = original.indexOf(toReplace);
	        if (i == -1) {
	            break;
	        }
	        original = original.substring(0, i) + replacedWith + original.substring(i , toReplace.length());
	    }
	    System.out.println(original);
	 }catch(Exception e){
		  	System.out.println("Error");
		  }
	}
 static void modifyFile(String filename, String oldString, String newString) // replace string fron a file
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
 
 
 

