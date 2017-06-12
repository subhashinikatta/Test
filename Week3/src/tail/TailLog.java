package tail;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 
public class TailLog implements Runnable {
 
	private boolean debug = false;
 
	private int RunEveryNSeconds = 2000;
	private long lastKnownPosition = 0;
	private boolean shouldIRun = true;
	private File File = null;
	private static int TailCounter = 0;
 
	public TailLog(String options, int myInterval,String myFile) {
		File = new File(myFile);
		this.RunEveryNSeconds = myInterval;
	}
 
	private void printLine(String message) {
		System.out.println(message);
	}
 
	public void stopRunning() {
		shouldIRun = false;
	}
 
	public void run() {
		try {
			while (shouldIRun) {
				Thread.sleep(RunEveryNSeconds);
				long fileLength = File.length();
				if (fileLength > lastKnownPosition) {
 
					// Reading and writing file
					RandomAccessFile readWriteFileAccess = new RandomAccessFile(File, "rw");
					readWriteFileAccess.seek(lastKnownPosition);
					String Line = null;
				
					while ((Line = readWriteFileAccess.readLine()) != null) {
						this.printLine(Line);
						TailCounter++;
					}
					 
					lastKnownPosition = readWriteFileAccess.getFilePointer();
					readWriteFileAccess.close();
				} else {
					if (debug)
						this.printLine("Hmm.. Couldn't found new line after line # " + TailCounter);
				}
			}
		} catch (Exception e) {
			stopRunning();
		}
		if (debug)
			this.printLine("Exit the program...");
	}
 
	public static void main(String args[]) {
 
		ExecutorService Executor = Executors.newFixedThreadPool(6);
 
		TailLog tailF = new TailLog(args[0],Integer.parseInt( args[1] ),args[2]);
 
		// Start running log file tailer on subbu.log file
		Executor.execute(tailF);

 
	}
 
	
 
}