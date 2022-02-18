import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 * La clase Secuencia almacena un serie de 
 * n�meros enteros ordenados.
 */
 

public class Secuencia
{
    private ArrayList<Integer> lista;

    /**
     * Construye una lista a partir de la colecci�n 
     * recibida como par�metro
     */        
    public Secuencia(ArrayList<Integer> otra)
    {
        lista = new ArrayList<>();
        if(otra!=null){
            lista.addAll(otra);
            Collections.sort(lista);
        }
        else{
            throw new IllegalArgumentException("Colecci�n vac�a");
        }
    }

    /**
     * accesor para la secuencia ArrayList almacenada
     * devuelve  una copia, no el propio original. Para ello
     * crea una nueva colecci�n de enteros y vuelve a utilizar addAll()
     */

    public ArrayList<Integer> getSecuencia()
    {
         ArrayList<Integer> retorno=new ArrayList<>();
         retorno.addAll(lista);
         return retorno;
    }

    /**
     * Obtiene la fusi�n (la uni�n) de dos listas 
     * de n�meros ordenadas, la represetnada por el atributo lista y 
     * la representada por el par�metro otra
     * 
     */
    public ArrayList<Integer> fusionarCon(ArrayList<Integer> otra)
    {
        if(otra!=null){
            otra.addAll(lista);
            Collections.sort(otra);
        }
        else{
            throw new IllegalArgumentException("Colecci�n vac�a");
        }
        return otra;
    }

 

    /**
     * Obtiene la intersecci�n de lista y el par�metro otra. La  intersecci�n 
     * contiene los elementos comunes y no repetidos de ambas (en orden)
     */
    public  ArrayList<Integer> interseccionCon( ArrayList<Integer> otra)
    {
       otra.retainAll(lista);//Borramos los elementos de otra que NO est�n en lista
       otra=eliminarDuplicados(otra);//Eliminamos duplicados con nuestra funci�n
       Collections.sort(otra);//Ordenamos
       return otra;
    }

    /**
     *  Elimina los duplicados de una lista
     *
     */
    private ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> lista)
    {
        HashSet<Integer> sinDuplicados=new HashSet<>();//Declaramos un HashSet vac�o
        sinDuplicados.addAll(lista);//A�adimos todos los elementos de lista en el HashSet. Con esto ya evitamos duplicados
        lista.clear();//Vaciamos la lista
        lista.addAll(sinDuplicados);//Volvemos a meter todos los elementos en el ArrayList lista, ya sin duplicados
        return lista;
    }

  

    /**
     * Representaci�n textual de la secuencia guardada
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

        //Uni�n y ordenaci�n
        System.out.println("La fusi�n es: ");
        resultados=sec.fusionarCon(al1);
        System.out.println(resultados.toString());

        //Cruce y ordenaci�n
        System.out.println("La intersecci�n es: ");
        resultados=sec.interseccionCon(al1);
        System.out.println(resultados.toString());
    }

    /**
     * A�adido al proyecto base, para usar en el main para testeo
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
