import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * La clase guarda en una colecci?n ArrayList una
 * lista de n?meros enteros
 */
public class ListaNumeros {
    // define la colecci?n
    private List<Integer> lista;

    /**
     * Constructor  - instancia la colecci?n
     */
    public ListaNumeros() {
        lista = new ArrayList<>();
    }

    /**
     * a?ade un n?mero a la colecci?n
     */
    public void add(int numero) {
        lista.add(numero);
    }

    /**
     * detectar si la lista est? vac?a
     */
    public boolean estaVacia() {
        return lista.size() == 0;
    }

    /**
     * borrar todos los elementos de la lista, dejadla vac?a
     */
    public void borrarLista() {
        lista.clear();
    }

    /**
     * Crea un fichero de texto  cuyo nombre se
     * pasa como argumento
     * Para crear el fichero recorreremos la colecci?n y
     * guardaremos cada n? de la lista en el fichero, un n? por l?nea
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
     * Lo mismo que la funci?n anterior, pero usando un try-with-resources
     * Adem?s, usamos un objeto File para pasar al constructor de FileWriter
     * Nos ahorramos la inicializaci?n a null, y el finally con el close
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
     * como argumento una serie de n?s enteros y cada n? lo guarda en la lista
     * Al acabar se cierra el fichero
     * <p>
     * Usando BufferedReader
     * <p>
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversi?n de formato. Las l?neas con errores se ignoran
     * continuando la ejecuci?n del programa
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
                    System.out.println("Error de formato de n?mero " + e.getMessage());
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
                    System.out.println("Error de formato de n?mero " + e.getMessage());
                }
                linea = entrada.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de n?s enteros y cada n? lo guarda en la lista
     * Al acabar se cierra el fichero
     * <p>
     * Usando Scanner
     * <p>
     * <p>
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversi?n de formato. Las l?neas con errores se ignoran
     * continuando la ejecuci?n del programa
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
     * Representaci?n textual de la colecci?<n>	</n>
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de n?meros\n");
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
