package head;


	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;


	public class Head1 {
		 public static void main(String[] args) throws IOException {

	    try{
	        BufferedReader br = new BufferedReader(new FileReader("C:/java/subbu.txt"));
	        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/java/subbu2.txt"));
	         
	        String line = br.readLine();
	         
	        int n = 0;
			for( int i = 1; i <= n && line != null; i++)
	        {
	            bw.write(line);
	            bw.write("\n");
	            line = br.readLine();
	        }
	         
	        System.out.println("Lines are Successfully copied!");
	         
	        br.close();
	        bw.close();
	    }
	    catch(Exception e){
	        System.out.println("Exception caught : " + e);
	    }
	}
	}

