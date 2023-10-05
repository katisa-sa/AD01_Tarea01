package Tarea01_3;

import java.io.File;
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

