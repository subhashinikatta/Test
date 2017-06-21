package com;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class FileWriter{ 
public  static void main(String args[]){
	byte[] bytes={'s','u','b','u'};
	FileWriter(bytes);
}


		// Thread safe version.
synchronized static void FileWriter(byte[] bytes) {
try{
FileOutputStream file = new FileOutputStream("C:/java/subbu.txt");
	 OutputStreamWriter os = new OutputStreamWriter(file); 
			  try {
			    boolean written = false;
			    do {
			      try {
			        // Lock it!
			        FileLock lock = file.getChannel().lock();
			        try {
			          // Write the bytes.
			          file.write(bytes);
			          written = true;
			        } finally {
			          // Release the lock.
			          lock.release();
			        }
			      } catch ( OverlappingFileLockException ofle ) {
			        try {
			          // Wait a bit
			          Thread.sleep(1000);
			        } catch (InterruptedException ex) {
			          throw new InterruptedIOException ("Interrupted waiting for a file lock.");
			        }
			      }
			    } while (!written);
			  } catch (IOException ex) {
			   // log.warn("Failed to lock " + file, ex);
				  System.out.println("Failed to lock " +ex);
			  }
			}catch(Exception e){
				System.out.println(e);
			}
			}
}

