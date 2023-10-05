package Tarea01_2;
/*Katerin Sanz AD01 Tarea 2
 * Realiza un programa en Java que lea un fichero de texto y cree un nuevo fichero con las
palabras palíndromas que encuentre. Es decir, si el fichero original contiene la frase “ana y
lola son amigas”, el fichero resultante contendrá las palabras “ana” e “y”. Una palabra
palíndroma es aquella que se lee igual de izquierda a derecha que de derecha a izquierda. 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Tarea01_2 {

	public static void main(String[] args) {
		//Creamos un String con la direccion del fichero
				String fic = "." + File.separator + "src" + File.separator +"Tarea01_2" + File.separator +"Texto.txt";
				// Realizamos una lectura del texto del fichero
				try (BufferedReader br = new BufferedReader (new FileReader(new File (fic)))){
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


	}

}
