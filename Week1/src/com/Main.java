package com;


public class Main {

	
	public static void main(String args[])
	{
		Demo.printPrimes(Integer.parseInt(args[0]));
		Demo.printnthPrimes(Integer.parseInt(args[0]));
		Demo.printFirstPrime(Integer.parseInt(args[0]));
		Demo.evenOddPrime(args);
		Demo.swapwithoutTemp(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		Demo.swapwithTemp(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		Demo.reverseNumber(Integer.parseInt(args[0]));
		Demo.reverseString(args[0]);
		Demo.palindromeNumber(Integer.parseInt(args[0]));
		Demo.palindromeString(args[0]);
		Demo.printFirstfibonacci(Integer.parseInt(args[0]));
	
	}
	
}

