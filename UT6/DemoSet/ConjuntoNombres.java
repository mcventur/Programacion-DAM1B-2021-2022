import java.util.ArrayList;
import java.util.Arrays;
/**
 *  La clase representa a un conjunto de nombres
 *  
 */
import java.util.LinkedHashSet; 
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
public class ConjuntoNombres
{
    private HashSet<String> nombres;
    // private LinkedHashSet<String> nombres;
    // private TreeSet<String> nombres;
    /**
     * Constructor  
     */
    public ConjuntoNombres()
    {
        nombres = new HashSet<>();
        // nombres = new LinkedHashSet<>();
        // nombres = new TreeSet<>();
    }

    /**
     * Añade un nombre al conjunto
     */
    public  void addNombre(String nombre)
    {
        nombres.add(nombre);
    }

    /**
     *  Devuelve true si el conjunto contiene a nombre
     *
     */
    public boolean estaNombre(String nombre)
    {

        return nombres.contains(nombre);
    }

    /**
     *  Obtiene un nuevo conjunto de nombres, la unión
     *  del atributo nombres y del parámetro otro
     *  (el conjunto original nombres no se modifica)
     *
     */
    public HashSet<String> union(HashSet<String> otro)
    {
        HashSet<String> nuevo = new HashSet<>(this.nombres);
        nuevo.addAll(otro);
        return nuevo;
    }

    /**
     *  Obtiene un nuevo conjunto de nombres, la intersección (los nombres comunes)
     *  del atributo nombres y del parámetro otro
     *  (el conjunto original nombres no se modifica)
     *
     */
    public HashSet<String> interseccion(HashSet<String> otro)
    {

        HashSet<String> nuevo = new HashSet<>(this.nombres);
        nuevo.retainAll(otro);
        return nuevo;
    }

    /**
     *  Obtiene un nuevo conjunto de nombres, la diferencia  
     *  del conjunto nombres y del conjunto  otro 
     *  (el conjunto original nombres no se modifica)
     *
     */
    public HashSet<String> diferencia(HashSet<String> otro)
    {
        HashSet<String> nuevo = new HashSet<>(this.nombres);
        nuevo.removeAll(otro);
        return nuevo;
    }

    /**
     * Borrar un nombre al conjunto
     */
    public  void borrarNombre(String nombre)
    {
        nombres.remove(nombre);
    }

    /**
     *  
     * Nº de nombres (elementos del conjunto)
     */
    public int totalNombres()
    {
        return nombres.size();
    }

    /**
     * Mostrar todos los nombres con iterador
     */
    public  void escribirConjunto()
    {
        Iterator<String> it = nombres.iterator();
        while (it.hasNext())  {
            System.out.println(it.next());
        }
    }

    /**
     * Mostrar todos los nombres con for mejorado
     */
    public  void escribirConjuntoConFor()
    {
        // System.out.println(nombres.toString());

        for (String nombre: nombres) {
            System.out.println(nombre);
        }
    }

    /**
     *  
     */
    public static void main(String[] args)
    {
        ConjuntoNombres conjunto = new ConjuntoNombres();
        String[] nombres = {"luis", "ana", "pedro", "alberto", "pepa", "luis", "ana"};        
        for (String nombre: nombres)   {
            conjunto.addNombre(nombre);
        }
        conjunto.escribirConjunto();
        System.out.println("-------------------------");

        String nombre = "julio";
        System.out.println("Esta el nombre " + nombre + "? " + conjunto.estaNombre(nombre));
        System.out.println("-------------------------");

        
        //   HashSet<String> otro = new HashSet<String>(Arrays.asList("pedro", "ana"));
        HashSet<String> otro = new HashSet<String>();
        otro.addAll(Arrays.asList("pedro", "ana"));

        conjunto.escribirConjunto();
        System.out.println(otro.toString() + "\n");
        HashSet<String> union = conjunto.union(otro);
        System.out.println("Unión: " + union.toString());

        System.out.println("-------------------------");
        conjunto.escribirConjunto();
        System.out.println(otro.toString() + "\n");
        HashSet<String> inter = conjunto.interseccion(otro);
        System.out.println("Intersección: " + inter.toString());

        System.out.println("-------------------------");
        conjunto.escribirConjunto();
        System.out.println(otro.toString() + "\n");
        HashSet<String> difer = conjunto.diferencia(otro);
        System.out.println("Diferencia: " + difer.toString());
    }

}
