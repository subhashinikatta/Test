package tail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tail{
    public static String[] headLines(int n, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
       String[] lines = new String[n];
       int count = 0;
    String line = null;
   while ((line = reader .readLine()) != null) {
    lines[count % lines.length] = line;
    count++;
   }
   return lines;
    }
    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            throw new IllegalArgumentException();
        }
        String[] lines = headLines(Integer.parseInt( args[0] ),args[1] );
        for(String line : lines) {
            if(!line.isEmpty()) {
                System.out.println(line);
            }
        }
    }
}