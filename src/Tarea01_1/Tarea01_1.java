package Tarea01_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		String fic = "." + File.separator + "src" + File.separator +"Tarea01_1" + File.separator +"Texto.txt";
		// Realizamos una lectura del texto del fichero
		try (FileReader fr = new FileReader(new File (fic))){
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
			
			while(li.hasPrevious()) {
			  System.out.print(li.previous());
			}
						
		}catch (IOException ex) {
	        ex.printStackTrace();
		}
		
	}

}
