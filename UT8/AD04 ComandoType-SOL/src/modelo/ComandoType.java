package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase modelo.ComandoType
 */

public class ComandoType {

    /**
     * Muestra el contenido de un fichero de texto con las líneas numeradas
     * usando BufferedReader y propagando las excepciones
     */
    public void mostrarFicheroV1(String nombre) throws IOException {
        int numeroLinea = 0;
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(
                    new FileReader(new File(nombre)));
            String linea = entrada.readLine();
            while (linea != null) {
                numeroLinea++;
                System.out.println(numeroLinea + ": " + linea);
                linea = entrada.readLine();
            }

        } finally {
            entrada.close();
        }

    }

    /**
     * Muestra el contenido de un fichero de texto con las líneas numeradas
     * usando Scanner y propagando las excepciones
     */
    public void mostrarFicheroV2(String nombre) throws FileNotFoundException {
        int numeroLinea = 0;
        Scanner entrada = null;
        try {
              entrada = new Scanner(new File(nombre));
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                numeroLinea++;
                System.out.println(numeroLinea + ": " + linea);
            }

        } finally {
            entrada.close();
        }

    }
}
