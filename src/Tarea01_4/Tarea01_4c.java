package Tarea01_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*Katerin Sanz AD01 Tarea 04c
 * Realiza un programa en Java que te permita visualizar los personajes de un tipo
	concreto (héroe o villano). El programa recibe desde la línea de comandos el tipo de
	personaje y visualiza cuantos personajes hay de dicho tipo y todos los datos de dichos
	personajes. Verifica que exista dicho tipo en el fichero, si no existe saca un mensaje de
	error por pantalla. (1,5 puntos)
	Nota: Hay que pensar que el fichero puede crecer en un futuro y aparecer nuevos tipos
 */
public class Tarea01_4c {
	public static void main(String[] args) throws IOException {
		final int longitud = 110; //Longitud del registro 
		try	{
			
			String dir = "." + File.separator + "src" + File.separator + "Tarea01_4" + File.separator + "Marvel.dat";
			File fich = new File ( dir);
			
			//Declaramos fichero de acceso aleatorio
			RandomAccessFile raf = new RandomAccessFile(fich, "r");
			
			//Definimos variables
			String dni, nom, ident, tipoConsola, tipoFich;
			int peso, altura, contador = 0;
			Boolean existeTipo = false;
			
			//Pedimos el tipo de personaje por consola
			System.out.println("Introduce un tipo de personaje: ");
			tipoConsola = Consola.readString();
			
			//Recorremos el fichero
			for (int p = 0; p < fich.length(); p+=longitud) {
				//Nos posicionamos en el dato que queremos en este caso el tipo.
				raf.seek(p);
				raf.skipBytes(82);
				//Creamos un array de caracteres que recorreremos y pasaremos a String para poder comparar			
				char[] auxTipo=new char[10];
				for(int i=0;i<10;i++)
				{
					auxTipo[i]=raf.readChar();
				}
				
				tipoFich = new String(auxTipo);
				
				//Comparoel tipo del fichero con el que hemos introducido
				if (tipoFich.trim().equalsIgnoreCase(tipoConsola)){
					existeTipo = true;
					raf.seek(p);
					raf.skipBytes(4);
					
					//Recogemos el DNI
					char[] auxDni =new char[9];
					for(int i=0;i<9;i++)
					{
						auxDni[i]=raf.readChar();
					}
					dni = new String(auxDni);
					
					//Recogemos el nombre
					char[] auxNom =new char[10];
					for(int i=0;i<10;i++)
					{
						auxNom[i]=raf.readChar();
					}
					nom = new String(auxNom);
				
					//Recogemos la identidad secreta
					char[] auxIden =new char[20];
					for(int i=0;i<20;i++)
					{
						auxIden[i]=raf.readChar();
					}
					ident = new String(auxIden);
					
					//Saltamos el DNI porque ya lo he recogido
					raf.skipBytes(20);
					//Recogemos el peso
					peso = raf.readInt();
					//Recogemos la altura
					altura = raf.readInt();
				
					//Imprimimos los datos por consola
					System.out.println("Personaje [dni="+ dni +", nombre="+ nom + ", identidad=" + ident +", tipo=" + tipoFich +", peso="+ peso +", altura="+altura +"]");
					//System.out.println("\tDNI:" + dni);
					//System.out.println("\tNombre:" + nom);
					//System.out.println("\tIdentidad Secreta:" + ident);
					//System.out.println("\tTipo:" + tipoFich);
					//System.out.println("\tPeso:" + peso + " kilos.");
					//System.out.println("\tAltura:" + altura + " cms.");
					//cuento numero de personajes que hay
					contador = contador + 1;
				} 
		}	if(! existeTipo) {
			System.out.println("El tipo introducido no existe.");
		} else {
			System.out.println("Hay " + contador + " personajes del tipo " + tipoConsola + ".");
			}
		
		raf.close();
		
		} catch (FileNotFoundException e){
			
		}

	
}

}
