package Tarea01_3;

import java.io.File;

/*Katerin Sanz AD01 Tarea 3
 * Realiza un programa en Java que lea la cabecera de un fichero ZIP y comprueba si
realmente se trata de un fichero ZIP o no. Para que sea un ZIP válido la cabecera debe
comenzar con la siguiente secuencia de bytes {80, 75, 3, 4} (1 punto)

 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Tarea01_3 {
public static void main(String[] args) {
		
		File f = new File ("." + File.separator + "src" + File.separator + "Tarea01_3" + File.separator +"ficheroZip.zip");
		
		int[] zipSignature = {80, 75, 3, 4}; //cabecera de .zip en decimal
       
		
        try (InputStream fis = new FileInputStream (f)) {
		
			int[] lzip = new int[4];
			for (int i = 0; i<4; i++) {
				lzip[i] = fis.read();
			}
			if (!Arrays.equals(lzip, zipSignature)) {
				System.out.println("No es un fichero ZIP");
                System.exit(-1);
			} else {
				System.out.println("Es un fichero ZIP");
	           
			} fis.close();
		}catch (IOException ex) {
        ex.printStackTrace();
		}
	}
}

