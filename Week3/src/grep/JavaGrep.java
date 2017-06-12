package grep;
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
            String optionsAllowed="vnicwe";//Options allowed in the input
            if (args.length==2)
            {
                searchWord=args[0];
                fileName=args[1];
            }
            else if (args.length==3)
              {
                options=args[0];    //options may contain  vnicew.   
                searchWord=args[1];
                fileName=args[2];
            }
            else
            {
                exit();
            }
             
             
            if(options.length()>6 )   // length  of options may not be more than 6 chars. 
                {
                    exit();   
                }
             
                char OA[]=options.toCharArray(); //Options converted to char array
                 
            for (int i=0 ; i<OA.length;i++)     
                if( optionsAllowed.indexOf(OA[i])==-1)  //if options contains other than vnci, it exits
                { 
                    System.out.println("Invalid options");
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
                int flag=0;
                int lineNo=0;
                int countNM=0;
                // open the file
                BufferedReader brdr = new BufferedReader(new FileReader(filename));
                String line;
                if(options.contains("i"))  flag=2;// for case insensitive
                    Pattern pattern=null;
                    // reading  each line
                    while( (line = brdr.readLine( )) != null)
                    {
                          lineNo++;  
                          try
                           {
                              pattern = Pattern.compile(exp, flag); //flag 2 to mention case insensitive
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
                         else
                            {
                             countNM++;  // counting not matching lines
                             //printing not matching lines
                            if (options.contains("v"))   
                            {
                                if (options.contains("n"))  
                                    System.out.println(lineNo + " : " + line);  
                                else
                                    System.out.println(line); 
                            }
                            }
                         if(options.contains("w"))//match only whole words 
                         {
        						if (matcher.find())
        						{
        							if(line.equals(exp)){

        								System.out.println(line);
        							}
        						}
                            }
                         if(options.contains("e"))//use regex PATTERN for matching
                         {
 							if (matcher.lookingAt()) {
 								if (filename != null) {

 								}
 								System.out.println(line);
 							}
 						}
                    }
                        //Lines count for both matching  &  not matching 
                        if (options.contains("c"))  
                        {
                            System.out.println("\n Word / Exp : " + exp );
                            System.out.println(count + " line(s) matched.");
                            System.out.println(countNM + " line(s) not matched.");
                        }
                       
                          
                        brdr.close( );
                }
 
        public static void exit()
        {
                System.out.println("Syntax : java JavaGrep [options] regular_expression/word file_name "  );
                System.out.println("Options Allowed : i or n or c or v or e or w  or any combinations "  );
                System.exit(0);
        }
}