
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Head2 {
    public static String[] headLines(int n, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] lines = new String[n];
        String line;
        int nLine = 0;
        while((line = reader.readLine()) != null) {
            lines[nLine++] = line;
            if(nLine >= n) {
                break;
            }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            throw new IllegalArgumentException();
        }
        String[] lines = headLines(new Integer( args[0] ).intValue(),args[1] );
        for(String line : lines) {
            if(!line.isEmpty()) {
                System.out.println(line);
            }
        }
    }
}