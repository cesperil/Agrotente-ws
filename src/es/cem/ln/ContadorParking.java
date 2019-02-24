package es.cem.ln;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContadorParking {

	
	public int leerContador(){
		int contador = 0;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		PrintWriter writer = null;
		
		File f = new File("ContadorParking");
		
		try {
			if(!f.exists()){
				f.createNewFile();
				writer = new PrintWriter(new FileWriter(f));
				writer.println(0);
			}
			if(writer != null){
				writer.close();
			}
		
			fileReader = new FileReader(f);
			bufferedReader = new BufferedReader(fileReader);
			String valorLeido = bufferedReader.readLine();
			contador = Integer.parseInt(valorLeido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(writer != null){
				writer.close();
			}
		}
		
		if(bufferedReader != null){
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return contador;
	}
	
	public void guardarContador(int contador) throws Exception{
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		fileWriter = new FileWriter("ContadorParking");
		printWriter = new PrintWriter(fileWriter);
		printWriter.println(contador);
		if(printWriter != null){
			printWriter.close();
		}
	}
}
