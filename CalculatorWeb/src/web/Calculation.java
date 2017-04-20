package web;

public class Calculation {
public static int sum(int a, int b){
	int sum = a +  b;
	System.out.println("Sum " + sum);
	return a+b;
}
public static int sub(int a, int b){
int sub = a - b;
	System.out.println("Sub " + sub);
	return a-b;
}
public static int mul(int a, int b){
int mul = a * b;
	System.out.println("Mul " + mul);
	return a*b;
}
public static int div(int a, int b){
int div = a/b;
	System.out.println("Div " + div);
	return a/b;
}
}
