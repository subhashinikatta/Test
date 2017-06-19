package com;

import java.io.FileWriter;


public class ThreadFileWriter {  
	public synchronized void fileWrite(){
	 try{    
         FileWriter fw=new FileWriter("C:/java/subbu1.txt");    
         fw.write("Hiii Subhashini");    
         fw.close();    
        }catch(Exception e)
	 {
        	System.out.println(e);
        	}    
        System.out.println("Success...");    
   }    
  
 

}
