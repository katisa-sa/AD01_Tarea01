package Tarea01_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*Katerin Sanz AD01 Tarea 4b
 *
 *Desde la editorial quieren tener controlado el peso de sus personajes, ya que
últimamente han hecho algún exceso que otro. Realiza un programa en java que te permita
modificar los datos de un personaje. El programa recibe desde la línea de comandos el dni
y el peso del último mes. Si el personaje no existe devolverá un mensaje de error, sino
mostrará en la consola el nombre del personaje y cuantos kilos ha engordado, adelgazado
o si se mantiene en su peso. (1,5 puntos) 
 */
public class Tarea01_4b {
	public static void main(String[] args) throws IOException {
		final int longitud = 110;// Longitud en Bytes de cada objeto
			
			try {
				//Declaramos fichero 
				String dir = "." + File.separator + "src" + File.separator + "Tarea01_4" + File.separator + "Marvel.dat";
				File fich = new File ( dir);
				//Declcara fichero de acceso aleatorio
				RandomAccessFile raf = new RandomAccessFile (fich, "rw");
				
				//declaramos variables
				int pesoConsola, pesoFich;
				String dniConsola, dniFich, nombreFich;
				boolean existeDni = false;
			
				// Pedimos DNI y peso por consola
				System.out.println("Introduzca el DNI del personaje:");
				dniConsola = Consola.readString();	
				System.out.println("Introduzca el peso del personaje del último mes:");
				pesoConsola = Consola.readInt();
				
				//Recorremos los datos para comparar Dni
				for (int p = 0; p < fich.length(); p+=longitud) {
					//Nos situamos para leer dni
					raf.seek(p);
					raf.skipBytes(4);
					
					//Paso el DNI a un array de char y lo combierto a String para poder compararlo
					char[] auxDni=new char[9];
					for (int i =0; i<9;i++) {
						auxDni [i] = raf.readChar();
						}
					dniFich = new String (auxDni);
					
					//Realizamos los mismos pasos con el nombre
					char[] auxNom =new char[10];
					for (int i =0; i<10;i++){
						auxNom [i] = raf.readChar();
						}
					nombreFich = new String (auxNom);
					
					// Buscamos peso anterior en fichero
					raf.skipBytes(60);
					pesoFich = raf.readInt();
					
					//Comparamos DNI
					if (dniFich.equalsIgnoreCase(dniConsola)) {
						
						//Si coinciden DNI comprobamos que existan
						existeDni = true;
						
						//Comparamos peso introducido con el que tenemos en fichero
						if ( pesoConsola < pesoFich ) {
							int pesoDif = pesoFich - pesoConsola;
							System.out.println( nombreFich +" ha adelgazado "+pesoDif+" kilos.");
							} else if ( pesoConsola > pesoFich ) {
								int pesoDif = pesoConsola - pesoFich;
								System.out.println( nombreFich +" ha engordado "+pesoDif+" kilos.");
								} else {
									System.out.println( nombreFich +" tiene el mismo peso.");
									} 
						
					if (!existeDni) {
						//Si no existe personaje manda mensaje
						System.out.println("El personaje no existe.");
						} 
					}
				}
					raf.close();
				
				} catch (FileNotFoundException e){}
				
			
		}
	}
		

