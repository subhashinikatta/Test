import java.io.*;

public class Tail {

  public Tail(File f) throws java.io.IOException, java.lang.InterruptedException{

    int pos = 0;
    RandomAccessFile file = new RandomAccessFile(f, "r");
    pos = (int)file.length() - (int)Math.min(400, file.length());
    file.seek(pos);
    for  (;true; Thread.currentThread().sleep(2000)){
      int l = (int)(file.length()-pos);
      if (l <= 0) continue;
      byte[] buf = new byte[l];
      int read = file.read(buf,0, l);
      String out = new String(buf, 0,l);
      System.out.print(out);
      pos = pos+l;

    }
  }

  public static void main(String[] args) {
    try{
      Tail tail1 = new Tail(new File(args[0]));
    }
    catch (ArrayIndexOutOfBoundsException a){
      System.out.println("Usage : Tail <file>");
      System.exit(1);
    }
    catch (java.io.IOException io){
      System.err.println(io.getMessage());
      System.exit(1);
    }
    catch (Exception xe){
      xe.printStackTrace();
      System.exit(1);
    }
  }
}
