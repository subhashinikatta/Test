
import java.io.*;
import java.util.Vector;
class Head
{
private String _fileName = "";
private int _headSize = 25; // default tailsize

Vector _theList = new Vector(5000,500);
public Head( String fileName ) { _fileName = fileName; }
public Head( String fileName, int headSize )
{
_fileName = fileName; _headSize = headSize;
}
public StringBuffer run()
{
StringBuffer output = new StringBuffer("");
String thisLine;

try
{
FileReader fr = new FileReader( _fileName );
BufferedReader myInput = new BufferedReader( fr );

while( ( thisLine = myInput.readLine() ) != null )
{
_theList.add( thisLine );
}

} // end try
catch( IOException e )
{
output.append( "Error reading file: " + e );
}

_theList.trimToSize();

int end = _theList.size();
int start = _theList.size() - _headSize;
if( start < 0 ) { start = 0; _headSize = end; }
output.append( "========== Tail [" + _fileName + "]\n" );
output.append( "========== Showing last [" + _headSize + "] lines\n" );

for( int i = start; i < end; i++ )
{
output.append( (String)_theList.get(i) + "\n" );
}
output.append( "========== END\n" );

return output;
}

public static void main( String args[] )
{
int argsLength = args.length;

if( argsLength == 0 ) System.exit(0);
if( argsLength == 1 )
{
Tail tail = new Tail( args[0] );
System.out.println( tail.run().toString() );
}
if( argsLength == 2 )
{
Head head = new Head( args[0], new Integer( args[1] ).intValue() );
System.out.println( head.run().toString() );
}
}
}