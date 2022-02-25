
/***
 * la clase ListaNombres guarda en una lista ordenada
 * de nombres en mayúsculas
 *
 * Ejercicio AD06
 *
 */

import java.util.*;
import java.io.File;
import java.io.IOException;

public class ListaNombres
{

    private ArrayList<String> lista;

    /**
     * Constructor de la clase ListaNombres
     */
    public ListaNombres()
    {
        lista = new ArrayList<String>();
    }

    /**
     * Añade un nuevo nombre en la posición que
     * le corresponde.  Indiferente mayúsculas o minúsculas al ordenar
     * @param  nombre el nombre a añadir
     *
     */
    public void añadirNombre(String nombre)
    {
        int posInsercion=buscarPosicion(nombre);
        lista.add(posInsercion,nombre);
    }

    /**
     * @return la posición en la que hay que insertar 
     * el nombre - Importan mayúsculas / minúsculas al insertar en orden
     */
    private int buscarPosicion(String nombre)
    {
        int i=0;
        while(i<lista.size() && lista.get(i).compareTo(nombre)<0){
            i++;
        }
        return i;
    }

    /**
     * Obtiene y devuelve el conjunto de caracteres del nombre de la posición indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public TreeSet<Character> obtenerConjuntoDeCaracteres(int pos)
    {
        verificarPosicion(pos);
        return UtilsString.getConjuntoCaracteres(lista.get(pos));
    }

    /**
     * Obtiene y devuelve el conjunto de dígitos numéricos del nombre de la posición indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public HashSet<Character> obtenerConjuntoDeDigitos(int pos)
    {
        verificarPosicion(pos);
        return UtilsString.getConjuntoDigitos(lista.get(pos));
    }

    /**
     * Obtiene y devuelve el conjunto de letras mayúsculas del nombre de la posición indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public LinkedHashSet<Character> obtenerConjuntoMayusculas(int pos)
    {
        verificarPosicion(pos);
        return UtilsString.getConjuntoMayusculas(lista.get(pos));
    }

    /**
     * Añadido al proyecto base (por refactorizacion)
     * @param pos
     */
    private void verificarPosicion(int pos) {
        if(pos <0 || pos >=lista.size()){
            throw new IllegalArgumentException("Posición incorrecta");
        }
    }


    /**
     * Representación textual de la lista de nombres 
     * de la forma          Nombre  [conjunto de caracteres ]  [conjunto dígitos]  [conjunt de letras mayúsculas]
     */
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<lista.size();i++) {
            sb.append(lista.get(i)).append("\t");
            sb.append(obtenerConjuntoDeCaracteres(i)).append("\t");
            sb.append(obtenerConjuntoDeDigitos(i)).append("\t");
            sb.append(obtenerConjuntoMayusculas(i)).append("\n");
        }
        return sb.toString();
    }

    /**
     *  
     *
     */
    public void printLista()
    {
        System.out.println(this.toString());
    }

     /**
     * lee los nombres de un fichero de texto 
     *      
     */
    public void leerDeFichero() 
    {
        try
        {
            Scanner sc = new Scanner(new File("nombres.txt"));
            while (sc.hasNextLine() )
            {
                añadirNombre(sc.nextLine());
            }
            sc.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Añadido al proyecto base. Para probarlo
     * @param args
     */
    public static void main(String[] args) {
        ListaNombres ln=new ListaNombres();
        ln.leerDeFichero();
        ln.printLista();
    }
}
