package com;


public class TestSynchronization
{  
	static Object Lock1 = new Object();
	   static Object Lock2 = new Object();
public static void main(String args[])
{  
	
ThreadFileWriter obj = new ThreadFileWriter();//only one object  
MyThread1 t1=new MyThread1(obj);  
MyThread2 t2=new MyThread2(obj); 
t1.setName("subbu");
t2.setName("vasu");
t1.start();  
t2.start();
} 
private static class MyThread1 extends Thread {
	private ThreadFileWriter t;

	MyThread1(ThreadFileWriter t)
	{  
	this.t=t;  
	}  

	public void run() {
       synchronized (Lock1) {
    	   ThreadFileWriter.fileWrite("subbu.txt","hiiiiii");  
          System.out.println("Thread 1: Holding lock 1...");
          
          try {
             Thread.sleep(10);
          }catch (InterruptedException e) {}
          System.out.println("Thread 1: Waiting for lock 2...");
          
          synchronized (Lock2) {
             System.out.println("Thread 1: Holding lock 1 & 2...");
          }
       }
    }
 }
private static class MyThread2 extends Thread {
	private ThreadFileWriter t;

	MyThread2(ThreadFileWriter t)
	{  
	this.t=t;  
	}  
    public void run() {
       synchronized (Lock2) {
    	   ThreadFileWriter.fileWrite("subbu1.txt","hiiiiii");  
          System.out.println("Thread 2: Holding lock 1...");
         
          try {
             Thread.sleep(10);
          }catch (InterruptedException e) {}
          System.out.println("Thread 2: Waiting for lock 2...");
          
          synchronized (Lock1) {
             System.out.println("Thread 2: Holding lock 1 & 2...");
          }
       }
    }
 } 
}