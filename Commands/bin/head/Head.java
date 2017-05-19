
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Head{

private static String fileName="";
public static int headSize;

public static void main(String args[]){
int argsLength = args.length;

if( argsLength == 0 ) System.exit(0);
if( argsLength == 2 )
{
System.out.println(Head.head(new Integer( args[0] ).intValue(),args[1] ) );
}
}
public static StringBuffer head(int headSize,String fileName){
String thisLine;
StringBuffer output = new StringBuffer("");
ArrayList<String> List = new ArrayList<String>();
try{
FileReader fr = new FileReader( fileName );
BufferedReader br = new BufferedReader( fr );
while( ( thisLine = br.readLine() ) != null )
{
List.add( thisLine );
}
br.close();
} // end try
catch( IOException e )
{
output.append( "Error reading file: " + e );
}
int end= headSize;

int start = 0;
for(int i=start; i <end; i++)
{
output.append( (String)List.get(i) + "\n" );
}
return output;
}

}