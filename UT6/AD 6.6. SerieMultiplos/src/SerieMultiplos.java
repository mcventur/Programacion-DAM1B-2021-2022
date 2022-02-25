import java.util.*;

/**
 * Multimap - Un objeto de esta clase guarda
 * en un map claves String que representan números
 * y múltiplos asociados a esas claves
 * 
 * Ejer. AD07
 * 
 */

public class SerieMultiplos
{

    public static final int NUM_MULTIPLOS = 10;
    private HashMap<String, ArrayList<Integer>> mapMultiplos;

    /**
     * Constructor de la clase SeriePotencias
     */
    public SerieMultiplos()
    {
        mapMultiplos=new HashMap<>();
    }
    /**
     * 
     * @param  num el nº que será la clave String
     *  
     */
    public void añadirEntrada(int num) 
    {
        String numStr=String.valueOf(num);
        if(!mapMultiplos.containsKey(numStr)){
            ArrayList<Integer> multiplos=generarMultiplos(num);
            mapMultiplos.put(numStr,multiplos);
        }
        else{
            System.out.println("El número ya existe en el map");
        }
    }

    /**
     * 
     * @param  num el nº del que se generearán los múltiplos
     * @return una colección ArrayLIst con los múltiplos generados
     */
    private ArrayList<Integer> generarMultiplos(int num)
    {
        ArrayList<Integer> multiplos=new ArrayList<>();
        //Generamos NUM_MULTIPLOS multiplos para cada numero
        for (int i = 1; i <= NUM_MULTIPLOS; i++) {
            multiplos.add(num*i);
        }
        return multiplos;
    }
    
    /**
     * 
     * @param  num el nº del que se obtendrán los múltiplos
     * @return  la colección asociada en el map   
     */
    public ArrayList<Integer> obtenerMultiplosDe(int num)
    {
        return mapMultiplos.get(String.valueOf(num));
    }
    
    
    /**
     * Visualiza el map (claves y valores asociados)
     *    
     */
    public void escribirMap()
    {
        Set<String> claves=mapMultiplos.keySet();
        for (String clave : claves) {
            System.out.print(clave  + ": ");
            escribirValor(mapMultiplos.get(clave));
            System.out.println();//Añadimos un salto de línea
        }
    }
    
    
    /**
     * Método privado de ayuda que visualiz aun ArrayList
     *    
     */
    private void escribirValor(ArrayList<Integer> lista)
    {
        System.out.println(lista.toString());
    }

    /**
     * borrar del map (de todas las entradas) el múltiplo indicado
     * y devuelve el total de múltiplos borrados
     * Con Map.Entry y un iterador
     */
    public  int borrarMultiplo(int multi)
    {
        int borrados=0;
        //Guardamos el conjunto de entradas en un Set de elementos Map.Entry
        Set<Map.Entry<String,ArrayList<Integer>>> setEntradas=mapMultiplos.entrySet();
        //Declaramos nuestro iterador para recorrer ese Set de Map.Entry
        Iterator<Map.Entry<String,ArrayList<Integer>>> itEntradas=setEntradas.iterator();
        while (itEntradas.hasNext()) {
            Map.Entry<String, ArrayList<Integer>> entrada = itEntradas.next();
            String clave=entrada.getKey();
            ArrayList<Integer> multiplos=entrada.getValue();
            if(multiplos.remove(Integer.valueOf(multi))){//Si le pasamos a remove el int sin envolver, lo entiende como índice, no como objeto
                borrados++;
            }
        }
        return borrados;
    }

    public static void main(String[] args) {
        SerieMultiplos sm=new SerieMultiplos();
        sm.añadirEntrada(3);
        sm.añadirEntrada(5);
        sm.añadirEntrada(6);
        sm.añadirEntrada(8);
        sm.escribirMap();
        int borrados=sm.borrarMultiplo(30);
        System.out.println("Borrando el múltiplo 30 se borran " + borrados + " y el Map queda: ");
        sm.escribirMap();
    }
        
}
