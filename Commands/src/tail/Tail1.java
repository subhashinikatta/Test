package tail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tail1{

private static String fileName="";
public static int tailSize;


public static StringBuffer tail(){
String thisLine;
StringBuffer output = new StringBuffer("");
ArrayList<String> List = new ArrayList<String>();
try{
BufferedReader br = new BufferedReader(new FileReader(fileName));
while( ( thisLine = br.readLine() ) != null )
{
List.add( thisLine );
}

} // end try
catch( IOException e )
{
output.append( "Error reading file: " + e );
}
int end= List.size();
int start = List.size() - tailSize;
if(start<0)
{
start =0;
tailSize= end;
}

for(int i=start; i <end; i++)
{
output.append( (String)List.get(i) + "\n" );
}
return output;
}
public static void main(String args[]){
int argsLength = args.length;

if( argsLength == 0 ) System.exit(0);
if( argsLength == 2 )
{

System.out.println(Tail1.tail() );
}
}
}
