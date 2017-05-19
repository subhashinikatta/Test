
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
class JavaGrep
{
    public static void main(String args[])
        {
            String searchWord="";
            String fileName="";
            String options="";
            if (args.length==2)
            {
                searchWord=args[0];
                fileName=args[1];
            }
            else
            {
                exit();
            }
             
            try
            {
                grep(options, searchWord, fileName);  // calling grep method to search lines
            }
            catch(IOException io)  { System.out.println("IO Error");  }
        }
// grep method starts
        public static void grep(String options, String exp, String filename) throws IOException
            {
                int count = 0;
                int lineNo=0;
  
                // open the file
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String line;
                if(options.contains("i")) {
				}
                    Pattern pattern=null;
                    // reading  each line
                    while( (line = br.readLine( )) != null)
                    {
                          lineNo++;  
                          try
                           {
                              pattern = Pattern.compile(exp); //flag 2 to mention case insensitive
                           }
                          catch (PatternSyntaxException e)    { System.out.println("Error");   } 
                     
                          Matcher matcher = pattern.matcher(line);
                         if (matcher.find())
                          {
                             count++;    //counting matching lines
                            //printing only matching lines
                            if (!options.contains("v"))
                            {
                                if (options.contains("n")) 
                                    System.out.println(lineNo + " : " + line);  
                                else System.out.println(line);
                            }
                          }
                    }
                       
                        br.close( );
                }
 
        public static void exit()
        {
                System.out.println("Syntax : java JavaGrep [options] regular_expression/word file_name "  );
               
                System.exit(0);
        }
}