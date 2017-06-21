package grep;
import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
class JavaGrep
{
    public static void main(String args[])
        {
            String searchWord="";
            String fileName="";
            String[] options=new String[4];
            if (args.length==2)
            {
                searchWord=args[0];
                fileName=args[1];
            }
            if (args.length==3)
            {
            	for(int i=0;i<1;i++){
            		options[i]=args[i];//stores option in an array
            	}
                searchWord=args[1];
                fileName=args[2];
            }
            else if (args.length>3)
              {
            	for(int i=0;i<2;i++){//options may contain  vnicew. 
                      options[i]=args[i];
                
            	}
                searchWord=args[2];
                fileName=args[3];
            }
            else
            {
                exit();
            }
             
            
             
            try
           {
                grep(options, searchWord, fileName);  // calling grep method to search lines
            }
           catch(IOException io){  }
        }
// grep method starts
        public static void grep(String options[], String exp, String filename) throws IOException
            {
                int count = 0;
                int flag=0;
                int lineNo=0;
                int countNM=0;
                for(int i=0;i<options.length;i++){
                String str=options[i].toString();// convert array to string
                // open the file
                BufferedReader brdr = new BufferedReader(new FileReader(filename));
                String line;
                if(str.contains("-i"))  flag=2;// for case insensitive
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
                            if (!str.contains("-v"))
                            {
                                if (str.contains("-n")) 
                                    System.out.println(lineNo + " : " + line);  
                                else System.out.println(line);
                            }
                          }
                         else
                            {
                             countNM++;  // counting not matching lines
                             //printing not matching lines
                            if (str.contains("-v"))   
                            {
                                if (str.contains("-n"))  
                                    System.out.println(lineNo + " : " + line);  
                                else
                                    System.out.println(line); 
                            }
                            }
                         if(str.contains("-w"))//match only whole words 
                         {
        						if (matcher.find())
        						{
        							if(line.equals(exp)){

        								System.out.println(line);
        							}
        						}
                            }
                         if(str.contains("-e"))//use regex PATTERN for matching
                         {
 							if (matcher.lookingAt()) {
 								if (filename != null) {

 								}
 								System.out.println(line);
 							}
 						}
                    }
                        //Lines count for both matching  &  not matching 
                        if (str.contains("-c"))  
                        {
                            System.out.println("\n Word / Exp : " + exp );
                            System.out.println(count + " line(s) matched.");
                            System.out.println(countNM + " line(s) not matched.");
                        }
                       
                 
                        brdr.close( );
                }
            }
 
        public static void exit()
        {
                System.out.println("Syntax : java JavaGrep [options] regular_expression/word file_name "  );
                System.out.println("Options Allowed : -i or -n or -c or -v or -e or -w  or any combinations "  );
                System.exit(0);
        }
}