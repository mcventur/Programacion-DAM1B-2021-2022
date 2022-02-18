import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 * La clase Secuencia almacena un serie de 
 * números enteros ordenados.
 */
 

public class Secuencia
{
    public static final int CANTALEATORIOS = 20;
    private ArrayList<Integer> lista;

    /**
     * Construye una lista a partir de la colección 
     * recibida como parámetro
     */        
    public Secuencia(ArrayList<Integer> otra)
    {
        if(otra==null){
            throw new IllegalArgumentException("Lista vacía");
        }
        else{
            lista=new ArrayList<>();
            lista.addAll(otra);
            Collections.sort(lista);
        }
    }

    /**
     * accesor para la secuencia ArrayList almacenada
     * devuelve  una copia, no el propio original. Para ello
     * crea una nueva colección de enteros y vuelve a utilizar addAll()
     */

    public ArrayList<Integer> getSecuencia()
    {
         ArrayList<Integer> retorno=new ArrayList<>();
         retorno.addAll(lista);
         return retorno;
    }

    /**
     * Obtiene la fusión (la unión) de dos listas 
     * de números ordenadas, la represetnada por el atributo lista y 
     * la representada por el parámetro otra
     * 
     */
    public ArrayList<Integer> fusionarCon(ArrayList<Integer> otra)
    {
        if(otra==null){
            throw new IllegalArgumentException("Lista vacía");
        }
        else{
            ArrayList<Integer> retorno=new ArrayList<>();
            retorno=getSecuencia();
            retorno.addAll(otra);
            Collections.sort(retorno);
            return retorno;
        }
    }

 

    /**
     * Obtiene la intersección de lista y el parámetro otra. La  intersección 
     * contiene los elementos comunes y no repetidos de ambas (en orden)
     */
    public  ArrayList<Integer> interseccionCon( ArrayList<Integer> otra)
    {
        if(otra==null){
            throw new IllegalArgumentException("Lista vacía");
        }
        else {
            //Hacemos la intersección de otra y de lista, quedando la misma en otra
            otra.retainAll(lista);
            //eliminamos duplicados, almacenando el resultado en interseccion
            ArrayList<Integer> interseccion=eliminarDuplicados(otra);
            //ordenamos
            Collections.sort(interseccion);
            return interseccion;
        }
    }

    public  ArrayList<Integer> interseccionConV2( ArrayList<Integer> otra)
    {
        if (otra == null)   {
            throw new IllegalArgumentException("Colección nula");
        }
        ArrayList<Integer> interseccion = new ArrayList<>();
        interseccion.addAll(lista);
        interseccion.retainAll(otra);
        return eliminarDuplicados(interseccion);

    }

    /**
     *  Elimina los duplicados de una lista
     *
     */
    private ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> lista)
    {
        //Declaramos nuestro HashSet, que nos sirve para eliminar duplicados
        HashSet<Integer> hs=new HashSet<>();
        //Al copiar todos los elementos de lista a al Set hs evitamos los duplicados
        hs.addAll(lista);
        //Pasamos todos los elementos de hs a la lista de retorno
        //Declaramos la lista sin duplicados para el retorno y le metemos el conjunto ya en el constructor
        ArrayList<Integer> sinDuplicados=new ArrayList<>(hs);
        return sinDuplicados;
    }


    /**
     * Representación textual de la secuencia guardada
     * por el objeto actual
     */
    public String toString()
    {
        return lista.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1=listaAleatoria(10);

        Secuencia sec=new Secuencia(l1);
        System.out.println("La secuencia es: ");
        System.out.println(sec);

        //Generamos otra lista aleatoria. APROVECHAMOS LA VARIABLE l1!!!
        l1=listaAleatoria(10);
        System.out.println("En la lista nueva hay lo siguiente: ");
        System.out.println(l1);

        //Fusionamos ambas listas
        System.out.println("La unión queda: ");
        System.out.println(sec.fusionarCon(l1));

        //Intersección
        System.out.println("La intersección queda: ");
        System.out.println(sec.interseccionCon(l1));
    }

    /**
     * Genera listas con numeros aleatorios
     * @param cuantos la cantidad de numeros a generar
     * @return un ArrayList con numeros aleatorios
     */
    public static ArrayList<Integer> listaAleatoria(int cuantos){
        Random gen=new Random();
        ArrayList<Integer> lista=new ArrayList<>();
        for (int i = 0; i < cuantos; i++) {
            lista.add(gen.nextInt(CANTALEATORIOS));
        }
        return lista;
    }

}
