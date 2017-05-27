package threadPool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThreadProcessaArquivo implements Runnable{
	
	private File arquivo;
	private StringBuilder texto = new StringBuilder(); 
	
	public ThreadProcessaArquivo(File arquivo){
		this.arquivo = arquivo;
	}
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Início da execução da "+threadName);
		try(FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr)){
			while(br.ready()){
				texto.append(br.readLine()).append("\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Fim da execução da "+threadName);
//		System.out.println("Texto da thread: "+threadName);
//		System.out.println(texto);
	}
}
