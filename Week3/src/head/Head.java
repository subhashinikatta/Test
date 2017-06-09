package head;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Head {
    public static String[] headLines(String options,int n, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] lines = new String[n];
        String line;
        int nLine = 0;
        if(options.contains("-n")) {
        while((line = reader.readLine()) != null) {
            lines[nLine++] = line;
            if(nLine >= n) {
                break;
            }
        }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
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