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
    private ArrayList<Integer> lista;

    /**
     * Construye una lista a partir de la colección 
     * recibida como parámetro
     */        
    public Secuencia(ArrayList<Integer> otra)
    {
        lista = new ArrayList<>();
        if(otra!=null){
            lista.addAll(otra);
            Collections.sort(lista);
        }
        else{
            throw new IllegalArgumentException("Colección vacía");
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
        if(otra!=null){
            otra.addAll(lista);
            Collections.sort(otra);
        }
        else{
            throw new IllegalArgumentException("Colección vacía");
        }
        return otra;
    }

 

    /**
     * Obtiene la intersección de lista y el parámetro otra. La  intersección 
     * contiene los elementos comunes y no repetidos de ambas (en orden)
     */
    public  ArrayList<Integer> interseccionCon( ArrayList<Integer> otra)
    {
       otra.retainAll(lista);//Borramos los elementos de otra que NO estén en lista
       otra=eliminarDuplicados(otra);//Eliminamos duplicados con nuestra función
       Collections.sort(otra);//Ordenamos
       return otra;
    }

    /**
     *  Elimina los duplicados de una lista
     *
     */
    private ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> lista)
    {
        HashSet<Integer> sinDuplicados=new HashSet<>();//Declaramos un HashSet vacío
        sinDuplicados.addAll(lista);//Añadimos todos los elementos de lista en el HashSet. Con esto ya evitamos duplicados
        lista.clear();//Vaciamos la lista
        lista.addAll(sinDuplicados);//Volvemos a meter todos los elementos en el ArrayList lista, ya sin duplicados
        return lista;
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
        //Creamos un ArrayList para almacenar las listas inicial y la de retorno
        ArrayList<Integer> al1=generarListaAleatorios();
        ArrayList<Integer> resultados=generarListaAleatorios();


        Secuencia sec=new Secuencia(al1);
        System.out.println("Nuestra secuencia es: " + sec.toString());

        //Creamos otro ArrayList. Aprovechamos la variable al1
        al1=generarListaAleatorios();
        System.out.println("La segunda lista es: " + al1.toString());

        //Unión y ordenación
        System.out.println("La fusión es: ");
        resultados=sec.fusionarCon(al1);
        System.out.println(resultados.toString());

        //Cruce y ordenación
        System.out.println("La intersección es: ");
        resultados=sec.interseccionCon(al1);
        System.out.println(resultados.toString());
    }

    /**
     * Añadido al proyecto base, para usar en el main para testeo
     * @return ArrayList de 10 aleatorios entre 1 y 15
     */
    private static ArrayList<Integer> generarListaAleatorios(){
        ArrayList<Integer> retorno=new ArrayList<>();
        //Generamos 5 aleatorios entre 1 y 10 (incluido) y los guardamos en el ArrayList
        for(int i=0;i<5;i++){
            int valor = new Random().nextInt(10) + 1;
            retorno.add(valor);
        }
        return retorno;
    }
}
