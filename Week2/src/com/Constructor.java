package com;
public class Constructor{  
    int id;  
    String name;  
    public Constructor(){
        System.out.println("default constructor");
    }
      
    Constructor(int i,String n){  
    id = i;  
    name = n;  
    }  
    public Constructor(int i){
        System.out.println("passsing integer");
    }
    public Constructor(String str){
        System.out.println("passing string");
    }
    void display()
    {
    	System.out.println(id+" "+name);
    	}  
   
    public static void main(String args[]){  
    	try{
    		 Constructor s1 = new Constructor();
    	Constructor s2 = new Constructor(111,"Subbu");  
    	Constructor s3 = new Constructor(222,"Vasu");  
    	Constructor s4 = new Constructor(222);  
    	Constructor s5 = new Constructor("latha");  
    s1.display();  
    s2.display();  
    s3.display();
    s4.display();
    s5.display();
   } catch(Exception e) {
		e.printStackTrace();
   }
   }  
}  