package filegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
	final static int QTD_ARQUIVOS = 4;
	final static int QTD_LINHAS_ARQUIVO = 5_000_000;
//	final static int QTD_LINHAS_ARQUIVO = 10;

	public static void main(String[] args) {
		escreveArquivos();
	}
	
	private static void escreveArquivos(){
		for(int i = 0;i<QTD_ARQUIVOS; i++){
			File file  = new File("file"+(i+1)+".txt");
			try(FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw)){
				
				for(int linha = 0;linha < QTD_LINHAS_ARQUIVO;linha++){
					bw.write("linha "+linha+"\n");
//					bw.newLine();
				}
				bw.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
			System.out.println(file + " criado.");
		}
	}
}
