package com;


public class Main {

	
	public static void main(String args[])
	{
		if( args.length == 0 ) System.exit(0);
		if(args.length == 1){
			Demo.printPrimes(Integer.parseInt(args[0]));
			Demo.printnthPrimes(Integer.parseInt(args[0]));
			Demo.printFirstPrime(Integer.parseInt(args[0]));
			Demo.evenOddPrime(args);
			Demo.reverseNumber(Integer.parseInt(args[0]));
			Demo.palindromeNumber(Integer.parseInt(args[0]));
			Demo.printFirstfibonacci(Integer.parseInt(args[0]));
			  System.out.println("th value in fibonacci series is : "+Demo.fibrec(Integer.parseInt(args[0])));
			  Demo.replacewithFilename(args[0]);

				Demo.reverseString(args[0]);
				
				Demo.palindromeString(args[0]);
				
		}
		if(args.length == 2){
			Demo.swapwithoutTemp(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			Demo.swapwithTemp(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			 Demo.contains(args[0],args[1]);
		}
		
		
		
		
	      
		if(args.length == 3){
	        Demo.quadraticEquation(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		} 
		
	}
	
}

