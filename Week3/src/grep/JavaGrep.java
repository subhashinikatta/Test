package grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaGrep {

		public static void main(String args[])
		{ 
			String matchWord="";
			String fileName="";
			String options="";
			String optionsAllowed="-i –e –v –w –c -n";//grep options
			if (args.length==2)
			{
				matchWord=args[0];
				fileName=args[1];
			}
			else if (args.length==3)
			{
				options=args[0];    //options may contain  -i –e –v –w –c -n.
				matchWord=args[1];
				fileName=args[2];
			}
			else
			{
				exit();
			}


			if(options.length()>2)  // option is more than two allowed
			{
				exit();
			}

			char array[]=options.toCharArray(); 

			for (int i=0 ; i<array.length;i++)
				if( optionsAllowed.indexOf(array[i])==-1)  //if options contains other than -i –e –v –w –c -n, it exits
				{
					System.out.println("Invalid options");
					exit();
				}
			try
			{
				grep(options, matchWord, fileName);  // calling grep method to search lines
			}
			catch(IOException io)  { System.out.println("IOerror");  }
		}


		// grep method starts
		public static void grep(String options, String exp, String fileName) throws IOException
		{

			int count = 0;
			int lineNo=0;
			int countNM=0;
			int flag=0;
			String Line = null;
			Pattern pattern=null;
			try {
				FileReader filereader = new FileReader( fileName );
				BufferedReader brdr = new BufferedReader( filereader );
				while( true ) {// open the file
					switch (options) {
					case "-i":// for case insensitive
                       flag=2;// for case insensitive(default)
						while( (Line = brdr.readLine( )) != null) // reading  each line
						{
							pattern=Pattern.compile(exp,flag);// to mention case insensitive
							Matcher matcher = pattern.matcher(Line);
							if (matcher.find())
							{
								count++;    //counting and printing matching lines
								
								System.out.println(Line);

							}
						}
						break;
					case "-v":// select non-matching lines
						while( (Line = brdr.readLine( )) != null)
						{

							pattern=Pattern.compile(exp);
							Matcher matcher = pattern.matcher(Line);
							if (matcher.find()){}
							else{
								System.out.println(Line);
							}
						}

						break;

					case "-n":// print line number with output lines
						while( (Line = brdr.readLine( )) != null)
						{
							lineNo++;
							pattern=Pattern.compile(exp);

							Matcher matcher = pattern.matcher(Line);
							if (matcher.find())
							{

								System.out.println(lineNo + " : " + Line);
							}

						}
						break;
					case "-c":// print NUM lines of output context

						while( (Line = brdr.readLine( )) != null)
						{
							pattern = Pattern.compile(exp); 
							Matcher matcher = pattern.matcher(Line);
							if (matcher.find())
							{
								count++;    //counting and printing matching lines
								
							}else 
							{
								countNM++;  // counting and printing not matching lines
								
							}
						}
						System.out.println("\n Word / Exp : " + exp );
						System.out.println(count + " line(s) matched.");
						System.out.println(countNM + " line(s) not matched.");
						break;
						
					case "-e"://use regex PATTERN for matching
						
						while( ( Line = brdr.readLine() ) != null ) {
							pattern = Pattern.compile(exp); 
							Matcher matcher = pattern.matcher(Line);
							if (matcher.lookingAt()) {
								if (fileName != null) {

								}
								System.out.println(Line);
							}
						}
						break;
						
					case "-w"://match only whole words 
						
						while( (Line = brdr.readLine( )) != null) // reading  each line
						{
							pattern=Pattern.compile(exp);
							Matcher matcher = pattern.matcher(Line);


							if (matcher.find())
							{
								if(Line.equals(exp)){

									System.out.println(Line);
								}
							}
						}
						break;
						
					default:
						exit();
					}

					brdr.close();
				}
		} catch (Exception e) { System.out.println(""); }
		}
		
		public static void exit()
		{
			System.out.println("Syntax : java JavaGrep [options] regular_expression/word file_name "  );
			System.out.println("Options Allowed : -i –e –v –w –c -n "  );
			System.exit(0);
		}
	}  

