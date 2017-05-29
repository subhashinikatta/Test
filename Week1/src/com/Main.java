package com;

public class Main {

	
       public static void main(String args[])
       {
              if( args.length == 0 ) System.exit(0);
              if(args.length == 1){
            
                     Demo.reverse(args);
                      Demo.palindrome(args);
            
            	 
                    Demo.printnthPrimes(Integer.parseInt(args[0]));
                     Demo.printFirstPrime(Integer.parseInt(args[0]));
                     Demo.printFirstFibonacci(Integer.parseInt(args[0]));
                     Demo.printNthFibonacci(Integer.parseInt(args[0]));
                            
              }
              
              if(args.length == 2){
                    
                     Demo.contains(args[0],args[1]);
                     
              }
              if(args.length == 3){
            	  
            	 Demo.modifyFile(args[0],args[1],args[2]);
            	Demo.replaceMethod(args[0],args[1],args[2]);
              }
              
              if(args.length >= 4){
            	  Demo.quadraticEquation(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
            	  Demo.evenOddPrime(args);
              }
}
}
              
             
