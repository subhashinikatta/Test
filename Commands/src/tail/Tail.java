package tail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tail{

private String fileName="";
public int tailSize;

ArrayList<String> List = new ArrayList<String>();
public Tail(int tailSize , String fileName)
{
this.fileName=fileName;
this.tailSize= tailSize;
}
public StringBuffer  run(){
String thisLine;
StringBuffer output = new StringBuffer("");
try{
FileReader fr = new FileReader( fileName );
BufferedReader br = new BufferedReader( fr );
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
Tail tail = new Tail( new Integer( args[1] ).intValue(), args[0]);
System.out.println( tail.run().toString() );
}
}
}