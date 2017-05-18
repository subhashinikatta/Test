package tail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Tail {
	
//tail method starts
     public static  StringBuffer tail(String options, String filename) throws IOException
         {
    	
    	 ArrayList<String> List = new ArrayList<String>();
    	 StringBuffer output = new StringBuffer("");
    	 String thisLine;
    	 int tailSize = 0;
    	 try
    	 {
    	 FileReader fr = new FileReader( filename );
    	 BufferedReader myInput = new BufferedReader( fr );

    	 while( ( thisLine = myInput.readLine() ) != null )
    	 {
    	 List.add( thisLine );
    	 }

    	 } // end try
    	 catch( IOException e )
    	 {
    	 output.append( "Error reading file: " + e );
    	 }

    	 List.trimToSize();

    	 int end = List.size();
    	
		int start = List.size() - tailSize;
    	 if( start < 0 )
    	 { start = 0;
    	 tailSize = end; 
    	 }
    	 output.append( "========== Tail [" + filename + "]\n" );
    	 output.append( "========== Showing last [" + tailSize + "] lines\n" );

    	 for( int i = start; i < end; i++ )
    	 {
    	 output.append( (String)List.get(i) + "\n" );
    	 }
    	 output.append( "========== END\n" );

    	 return output;
    	 }
     public static void main(String args[])
     {
       
         String filename="";
         String options= "";// default size
         if (args.length==2)
         {
        	 options=args[0];
        	 filename=args[1];
         }
         else
         {
             exit();
         }
          
         try
         {
        
			System.out.println(tail(options, filename));  // calling tail method to search lines
         }
         catch(IOException io)  { 
        	 System.out.println("IO Error"); 
        	 }
     }

     public static void exit()
     {
             System.out.println("Syntax : java tail [options] file_name "  );
            
             System.exit(0);
     }
}
