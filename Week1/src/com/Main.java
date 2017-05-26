package com;

public class Main {

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
       public static void main(String args[])
       {
              if( args.length == 0 ) System.exit(0);
              if(args.length == 1){
            	 if( isInteger(args[0]))
            	 {

                     Demo.reverseNumber(args[0]);
                      Demo.palindromeNumber(args[0]);
            	 }
            	 
                    Demo.printnthPrimes(Integer.parseInt(args[0]));
                     Demo.printFirstPrime(Integer.parseInt(args[0]));
                     Demo.reverseString(args[0]);
                     Demo.printFirstfibonacci(Integer.parseInt(args[0]));
                     System.out.println("th value in fibonacci series is : "+Demo.fibrec(Integer.parseInt(args[0])));
                     Demo.palindromeString(args[0]);
                            
              }
              
              if(args.length == 2){
                     Demo.swapwithoutTemp(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
                     Demo.swapwithTemp(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
                     Demo.contains(args[0],args[1]);
                     
              }
              if(args.length == 3){
            	  Demo.quadraticEquation(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
            	 Demo.modifyFile(args[0],args[1],args[2]);
            	Demo.replaceString(args[0],args[1],args[2]);
              }
              
              if(args.length >= 4){
            	  Demo.evenOddPrime(args);
              }
}
}
              
             
