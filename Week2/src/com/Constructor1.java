package com;
public class Constructor1{  
int id;  
String name;  
  
void display()
{
	System.out.println(id+" "+name);
	}  
  
public static void main(String args[])
{  
	try{
	Constructor1 c1=new Constructor1();  
	Constructor1 c2=new Constructor1();  
c1.display();  
c2.display();  
} catch(Exception e) {
	e.printStackTrace();
}
}
}