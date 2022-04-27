import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * La clase guarda en una colección ArrayList una
 * lista de números enteros
 */
public class ListaNumeros {
    // define la colección
    private List<Integer> lista;

    /**
     * Constructor  - instancia la colección
     */
    public ListaNumeros() {
        lista = new ArrayList<>();
    }

    /**
     * añade un número a la colección
     */
    public void add(int numero) {
        lista.add(numero);
    }

    /**
     * detectar si la lista está vacía
     */
    public boolean estaVacia() {
        return lista.size() == 0;
    }

    /**
     * borrar todos los elementos de la lista, dejadla vacía
     */
    public void borrarLista() {
        lista.clear();
    }

    /**
     * Crea un fichero de texto  cuyo nombre se
     * pasa como argumento
     * Para crear el fichero recorreremos la colección y
     * guardaremos cada nº de la lista en el fichero, un nº por línea
     * <p>
     * Capturamos las excepciones que se puedan producir
     */
    public void salvarEnFicheroDeTexto(String nombre) {

//        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(nombre)));
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(nombre)));
            for (Integer n : lista) {
                salida.println(n);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (salida != null) {
                salida.close();
            }
        }

    }

    /**
     * Lo mismo que la función anterior, pero usando un try-with-resources
     * Además, usamos un objeto File para pasar al constructor de FileWriter
     * Nos ahorramos la inicialización a null, y el finally con el close
     */
    public void salvarEnFicheroDeTextoV2(String nombre) {
        File f = new File(nombre);
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
            for (Integer n : lista) {
                salida.println(n);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     * <p>
     * Usando BufferedReader
     * <p>
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTexto(String nombre) {

        File f = new File(nombre);
        BufferedReader entrada=null;
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea = entrada.readLine();
            while (linea != null) {
                try {
                    lista.add(Integer.parseInt(linea));
                }
                catch(NumberFormatException e){
                    System.out.println("Error de formato de número " + e.getMessage());
                }
                linea = entrada.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                entrada.close();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
            catch (NullPointerException e){
                System.out.println("Entrada no se ha llegado a inicializar");
            }
        }
    }

    public void leerFicheroDeTextoV2(String nombre) {
        File f = new File(nombre);
        try(BufferedReader entrada = new BufferedReader(new FileReader(f))){
            String linea = entrada.readLine();
            while (linea != null) {
                try {
                    lista.add(Integer.parseInt(linea));
                }
                catch(NumberFormatException e){
                    System.out.println("Error de formato de número " + e.getMessage());
                }
                linea = entrada.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     * <p>
     * Usando Scanner
     * <p>
     * <p>
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTextoConScanner(String nombre) {
        File f = new File(nombre);
        Scanner entrada = null;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNextLine()) {
                try {
                    String linea = entrada.nextLine();
                    lista.add(Integer.parseInt(linea));
                } catch (NumberFormatException e) {
                    System.out.println("Error en lectura de entero: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            if(entrada!=null){
                entrada.close();
            }
        }


    }

    /**
     * Representación textual de la colecció<n>	</n>
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de números\n");
        for (Integer n : lista) {
            sb.append(n + " ");
        }
        return sb.toString();
    }

    /**
     * Muestra la lista en pantalla
     */
    public void mostrarLista() {
        System.out.println(this.toString());
    }


}
