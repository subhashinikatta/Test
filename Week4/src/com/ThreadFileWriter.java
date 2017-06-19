package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class ThreadFileWriter {  
	public static synchronized void fileWrite(String FileName,String Content){
		System.out.println("My file name is "+FileName+" Creator Name is "+Thread.currentThread().getName());
	 try{    
		 File oFile = new File(FileName);
         if (!oFile.exists()) {
             oFile.createNewFile();
         }
         if (oFile.canWrite()) {
             BufferedWriter bw = new BufferedWriter(new FileWriter(FileName, true));
             bw.write (Content);
             bw.close();
         }   
        }catch(Exception e)
	 {
        	System.out.println(e);
        	}    
        System.out.println("Success...");    
   }    
  
 

}
