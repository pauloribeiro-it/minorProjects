package threadPool;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolProcessor {
	
	public static void main(String[] args) throws Exception{
		PoolThread pool = new PoolThread();
		Thread thread = new Thread(pool);
//		thread.setDaemon(false);
		thread.start();
		thread.join();
	}
	
}

class PoolThread implements Runnable {
	public void run() {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.execute(new ThreadProcessaArquivo(new File("F:\\Workspaces\\Office\\threadPool\\file1.txt")));
		executor.execute(new ThreadProcessaArquivo(new File("F:\\Workspaces\\Office\\threadPool\\file2.txt")));
		executor.execute(new ThreadProcessaArquivo(new File("F:\\Workspaces\\Office\\threadPool\\file3.txt")));
		executor.execute(new ThreadProcessaArquivo(new File("F:\\Workspaces\\Office\\threadPool\\file4.txt")));
		executor.shutdown();
	}
}