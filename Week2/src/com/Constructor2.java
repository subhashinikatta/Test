package com;
public class Constructor2{  
    int id;  
    String name;  
      
    Constructor2(int i,String n){  
    id = i;  
    name = n;  
    }  
    void display()
    {
    	System.out.println(id+" "+name);
    	}  
   
    public static void main(String args[]){  
    	try{
    	Constructor2 s1 = new Constructor2(111,"Subbu");  
    	Constructor2 s2 = new Constructor2(222,"Vasu");  
    s1.display();  
    s2.display();  
   } catch(Exception e) {
		e.printStackTrace();
   }
   }  
}  