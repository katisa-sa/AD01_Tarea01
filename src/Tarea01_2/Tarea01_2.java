package Tarea01_2;
/*Katerin Sanz AD01 Tarea 2
 * Realiza un programa en Java que lea un fichero de texto y cree un nuevo fichero con las
palabras palíndromas que encuentre. Es decir, si el fichero original contiene la frase “ana y
lola son amigas”, el fichero resultante contendrá las palabras “ana” e “y”. Una palabra
palíndroma es aquella que se lee igual de izquierda a derecha que de derecha a izquierda. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tarea01_2 {

	public static void main(String[] args) {
		//Creamos String con las direcciones de los ficheros
		String dir = "." + File.separator + "src" + File.separator +"Tarea01_2" + File.separator +"Texto.txt";
		String dir2 = "." + File.separator + "src" + File.separator +"Tarea01_2" + File.separator +"palindromos.txt";
				
				try {
					//Creamos los flujos de entrada y salida
					BufferedReader br = new BufferedReader (new FileReader(new File (dir)));
					BufferedWriter bw = new BufferedWriter (new FileWriter(dir2));
					// Realizamos una lectura del texto del fichero
					String lineaLeida = br.readLine();
					//Dividimos la frase en palabras
					String[] lineas =  lineaLeida.split(" ");
					//Cerramos flujo de entrada
					br.close();
					//Recorremos las palabras una por una
					for (String linea : lineas) {
						// Convertimos a minúscula y quitamos espacios " " y puntos "." 
						
						linea = linea.toLowerCase().replace(".", "");
						// Invertimos la cadena, y si es igual que la original entonces son palíndromos
						String invertida = new StringBuilder(linea).reverse().toString();
						
						if (invertida.equals(linea)) {
							//Escribimos en el nuevo fichero si es palindromo
								System.out.print("Es palindromo: " );
								System.out.println(linea);
								bw.write(linea + ", ");
							}
						}bw.close();
				//capturamos posibles excepciones
				}catch (IOException ex) {
			        ex.printStackTrace();
				}
				
			}

	
	}


