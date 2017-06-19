package com;

class MyThread1 extends Thread
{  
 
ThreadFileWriter t;  
MyThread1(ThreadFileWriter t)
{  
this.t=t;  
}  


public void run(){  
ThreadFileWriter.fileWrite("subbu.txt","hiiiiii");  
}  
  
} 