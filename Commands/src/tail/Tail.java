
import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;

    
    public class Tail {

      public static void main(String[] args) throws IOException {

        if (args.length > 0){

          long n;
		if (args.length > 1)
       n = Long.parseLong(args[1]) ;

          BufferedReader input = new BufferedReader(new FileReader(args[0]));
          String currentLine = null;

          while((currentLine = input.readLine()) != null) {

        {
          System.out.println(currentLine);
          continue;
        }

          }
          input.close();

        } else {
          System.out.println("Missing parameter!\nUsage: java JavaTail fileName [updateTime (Seconds. default to 1 second)]");
        }
      }
    }