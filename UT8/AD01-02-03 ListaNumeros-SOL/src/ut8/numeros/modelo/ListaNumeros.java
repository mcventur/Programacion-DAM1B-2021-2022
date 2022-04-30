package ut8.numeros.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Guarda en una lista una serie de nºs enteros
 */
public class ListaNumeros {

    private List<Integer> lista;

    /**
     * Constructor de la clase ut8.lista.ListaNumeros
     */
    public ListaNumeros() {
        lista = new ArrayList<>();
    }



    /**
     *
     */
    public void add(int numero) {
        lista.add(numero);
    }

    /**
     * Vacia la lista de números
     */
    public void vaciarLista() {
        lista.clear();
    }

    /**
     * lee del fichero de texto especificado como parámetro
     * una serie de números y los añade a la lista en memoria
     * El fichero de texto contiene una serie de líneas con formato
     * n1:n2:n3:.... , es decir, en cada línea hay una serie de números separados por
     * el caracter :
     * <p>
     * El fichero se lee línea a línea (con BufferedReader) y con ayuda del
     * método parserLinea() se extrae cada nº y se añade a la lista.
     * Se capturarán aquí todas las posibles excepciones
     * <p>
     * <p>
     * El método devuelve la cantidad total de valores erróneos leídos
     */
    public int leerDeFicheroV1(String nombre) {
        BufferedReader entrada = null;
        int errores = 0;
        try {
            File f = new File(nombre);
            entrada = new BufferedReader(new FileReader(f));
            String linea = entrada.readLine();
            while (linea != null) {
                errores += parsearLinea(linea);
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error de IO " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error de IO " + e.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    System.out.println("Error de IO al cerrar el fichero");
                }
            }

        }

        return errores;
    }

    /**
     * A partir de una línea de texto extrae los números y los añade a la lista
     * Las excepciones de formato se capturarán contabilizando los nºs erróneos
     * que se detectan. El programa no para cuando encuentra un error
     */
    private int parsearLinea(String linea) {
        int errores = 0;
        String[] datos = linea.split(":");
        for (String dato : datos) {
            try {
                lista.add(Integer.parseInt(dato.trim()));
            } catch (NumberFormatException e) {
                errores++;
            }

        }
        return errores;
    }

    /**
     * Haz lo mismo que en leerDeFicheroV1() pero ahora usando la clase Scanner
     * <p>
     * El fichero se lee línea a línea (con Scanner) y con ayuda del
     * método parserLinea() se extrae cada nº y se añade a la lista.
     * Se capturarán aquí todas las posibles excepciones
     * <p>
     * <p>
     * El método devuelve la cantidad total de valores erróneos leídos
     */
    public int leerDeFicheroV2(String nombre) {
        Scanner entrada = null;
        int errores = 0;
        try {
            File f = new File(nombre);
            entrada = new Scanner(f);
            while (entrada.hasNextLine()) {
                errores += parsearLinea(entrada.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error de IO al leer el fichero con Scanner");
        } finally {
            entrada.close();
        }
        return errores;
    }

    /**
     * Calcula y devuelve el valor máximo de la colleción (usa la clase Collections)
     */
    public int maximo() {
        return Collections.max(lista);
    }

    /**
     * Devuelve una colección ordenada de mayor a menor
     * Sin modificar la coleción original
     */
    public List<Integer> ordenarDescendente() {
        List<Integer> tmp = new ArrayList<>(lista);
        Collections.sort(tmp, Collections.reverseOrder());
        return tmp;
    }

    /**
     * Guarda en el fichero cuyo nombre indica el parámetro
     * el valor máximo de la colección en una línea y
     * la colección ordenada descendentemente en otra línea
     *
     * Se propagarán todas las posibles excepciones
     */
    public void salvarEnFichero(String nombre) throws IOException {
        File f = new File(nombre);
        PrintWriter salida =
                new PrintWriter(new BufferedWriter(new FileWriter(f)));
        salida.println("Máximo de la lista: " + maximo());
        salida.println(ordenarDescendente());

        salida.close();
    }

}
