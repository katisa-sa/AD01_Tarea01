package Tarea01_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* Katerin Sanz
 * Tarea 01 Ejercicio 1. 
 * Realiza un programa en Java que lea un fichero y lo invierta. Es decir, si el fichero de
entrada contiene “Hola mundo”, el fichero de salida contendrá “odnum aloH”.
 */
public class Tarea01_1 {

	public static void main(String[] args) {
		//Creamos un String con la direccion del fichero
		String dir = "." + File.separator + "src" + File.separator +"Tarea01_1" + File.separator +"Texto.txt";
		String dir2 = "." + File.separator + "src" + File.separator +"Tarea01_1" + File.separator +"Texto2.txt";
		// Realizamos una lectura del texto del fichero
		try (FileReader fr = new FileReader(new File (dir))){
			File fic2 = new File (dir2);
			FileWriter fw = new FileWriter(fic2);
			fic2.createNewFile();
			int i = 1;
			char letra = 0;
			List<Character> listaChar = new ArrayList<Character>();
			//Leemos cada caracter del fichero y lo añadimos a una lista de caracteres
			while ((i = fr.read())!=-1) {
				letra = (char)i;
				listaChar.add(letra);
			}	
			//Iteramos la lista del reves
			ListIterator li = listaChar.listIterator(listaChar.size());
			
			PrintWriter writer = new PrintWriter(fw);
			//Escribimos en el nuevo fichero
			while(li.hasPrevious()) {
				writer.print(li.previous());
			  
			} 
			 
			writer.close();
			fr.close();
			fw.close();
			
						
		}catch (IOException ex) {
	        ex.printStackTrace();
		}
		
	}

}
