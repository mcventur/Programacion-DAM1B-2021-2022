package ut8.matrices.io;

import ut8.matrices.modelo.Matriz;
import ut8.matrices.modelo.MatrizExcepcion;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrizIO {

    /**
     * Crea y devuelve una matriz cargando sus valores a partir de un fichero de
     * texto.
     * La primera línea del fichero siempre contiene dos nºs, las filas y
     * columnas de la natriz - Luego siguen tantas líneas de texto como marquen
     * las filas y cada línea con tantos números como marquen las columnas. El
     * separador es el tabulador ('\t')
     *
     * Todas las excepciones se propagan
     *
     * Usar try-with-resources
     */
    public static Matriz leerDeFichero(String nombre) throws IOException, MatrizExcepcion, InputMismatchException {
        Matriz m= null;
        try(BufferedReader entrada = new BufferedReader(new FileReader(nombre))){
            //Leemos la primera linea
            String linea=entrada.readLine();
            //De esa linea, leemos dos enteros. Con otro scanner
            Scanner scLinea = new Scanner(linea);
            int filas = scLinea.nextInt();
            int columnas = scLinea.nextInt();
            scLinea.close();
            //Creamos la matriz
            m = new Matriz(filas,columnas);
            //La rellenamos. Vamos recorriendo linea a linea. Usaré el scanner para extraer los números de cada linea
            for (int i = 0; i < filas; i++) {
                linea = entrada.readLine();//Leemos la segunda linea y posteriores
                scLinea = new Scanner(linea);//Se la pasamos a un flujo scanner
                for (int j = 0; j < columnas; j++) {
                    m.setValor(scLinea.nextInt(),i,j);//Leemos enteros de la línea uno a uno con nuestro scanner
                }
                scLinea.close();
            }
        }

        return m;
    }

    /**
     * Guarda en el fichero especificado la matriz recibida como argumento
     * La primera línea del fichero contendrá las filas y columnas de la matriz
     * Luego habrá tantas líneas filas como filas tenga la matriz y en
     * cada línea tantos números como columnas
     *
     * Todas las excepciones se propagan
     *
     * Usar try-with-resources
     */
    public static void salvarEnFichero(Matriz matriz, String nombre) throws IOException {

        try(PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(nombre)))){
            salida.println(matriz.toString());
        }
    }
}
