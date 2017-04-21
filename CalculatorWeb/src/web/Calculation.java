package web;

public class Calculation {
public static int sum(int a, int b){
	return a+b;
}
public static int subtraction(int a, int b){

	return a-b;
}
public static int multiplication(int a, int b){
int mul = a * b;
	System.out.println("Mul " + mul);
	return a*b;
}
public static int division(int a, int b){
int div = a/b;
	System.out.println("Div " + div);
	return a/b;
}
}
