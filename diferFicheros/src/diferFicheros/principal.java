package diferFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class principal {

	public static void main(String[] args) {
		File fichero = new File("fch1.txt");
		File fichero2 = new File("fch2.txt");
		File fDiff = new File("diferencias.txt");
		lecturaComparada(fichero, fichero2, fDiff);
	}

	private static void lecturaComparada(File fichero, File fichero2, File fDiff) {

		try {

			BufferedReader bufFch = new BufferedReader(new FileReader(fichero));
			BufferedWriter bufFch3 = new BufferedWriter(new FileWriter(fDiff));
			
	
			String lineaLeida1;

			lineaLeida1 = bufFch.readLine();
			byte bCont=0;
			while (lineaLeida1 != null) {

				BufferedReader bufFch2 = new BufferedReader(new FileReader(fichero2));
				String lineaLeida2 = bufFch2.readLine();

				while (lineaLeida2 != null) {

					if (lineaLeida1.equals(lineaLeida2)) {
						bCont++;
						System.out.println(lineaLeida1);
						if (bCont!=1) {
							bufFch3.newLine();
						}
						bufFch3.append(lineaLeida1);

					}

					lineaLeida2 = bufFch2.readLine();

				}
				lineaLeida1 = bufFch.readLine();
				bufFch2.close();

			}
			bufFch3.close();

		} catch (FileNotFoundException e) {
			System.out.println("Alguno de los ficheros no se puede encontrar");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hay un error con alguno de los ficheros");
			e.printStackTrace();
		}

	}
}
