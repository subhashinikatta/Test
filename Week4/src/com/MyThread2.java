package com;

class MyThread2 extends Thread
{  
	ThreadFileWriter t;  
	MyThread2(ThreadFileWriter t)
	{  
	this.t=t;  
	}  

public void run(){  
t.fileWrite();  
}  
}  