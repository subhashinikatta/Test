package head;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Head {
    public static String[] headLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int n = 0;
        String[] lines = new String[n];
        String line;
       
        int Line = 0;
        while((line = reader.readLine()) != null) {
            lines[Line++] = line;
            if(Line >= n) {
                break;
            }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        if(args.length >= 1) {
            System.out.println("Error");
        }
        String[] lines = headLines(args[0]);
        for(String line : lines) {
            if(!line.isEmpty()) {
                System.out.println(line);
            }
        }
    }
}