package tail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tail{
    public static String[] headLines(String options,int n, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
       String[] lines = new String[n];//array of size n, filled with nulls.
       int count = 0;
    String line = null;
    if(options.contains("-n")) {
   while ((line = reader .readLine()) != null) {
    lines[count % lines.length] = line;
    count++;
   }
    }
   
	return lines;
    }
    
    public static void main(String[] args) throws IOException {
        if(args.length != 3) {
            throw new IllegalArgumentException();
        }
        String[] lines = headLines(args[0],Integer.parseInt( args[1] ),args[2] );
        for(String line : lines) {
            if(!line.isEmpty()) {
                System.out.println(line);
            }
        }
    }
}