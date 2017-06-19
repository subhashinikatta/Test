package com;


public class TestSynchronization
{  
public static void main(String args[])
{  
ThreadFileWriter obj = new ThreadFileWriter();//only one object  
MyThread1 t1=new MyThread1(obj);  
MyThread2 t2=new MyThread2(obj); 
t1.start();  
t2.start();
} 
}