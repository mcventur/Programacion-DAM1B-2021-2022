import java.util.*;

/**
 * Multimap - Un objeto de esta clase guarda
 * en un map claves String que representan n?meros
 * y m?ltiplos asociados a esas claves
 * 
 * Ejer. AD07
 * 
 */

public class SerieMultiplos
{

    public static final int NUM_MULTIPLOS = 10;//Constante a?adida al proyecto base
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
     * @param  num el n? que ser? la clave String
     *  
     */
    public void a?adirEntrada(int num) 
    {
        String numStr=String.valueOf(num);
        //No se indica en el enunciado. Hago un control simple de si el numero ya est? en la lista
        if(!mapMultiplos.containsKey(numStr)){
            ArrayList<Integer> multiplos=generarMultiplos(num);
            mapMultiplos.put(numStr,multiplos);
        }
        else{
            System.out.println("El n?mero ya existe en el map");
        }
    }

    /**
     * 
     * @param  num el n? del que se generear?n los m?ltiplos
     * @return una colecci?n ArrayLIst con los m?ltiplos generados
     */
    private ArrayList<Integer> generarMultiplos(int num)
    {
        ArrayList<Integer> multiplos=new ArrayList<>();
        //Generamos NUM_MULTIPLOS multiplos para cada numero
        for (int i = 1; i <= NUM_MULTIPLOS; i++) {
            multiplos.add(num*i);//Se hace autoboxing => Se envuelve el int en un Integer impl?citamente
        }
        return multiplos;
    }
    
    /**
     * 
     * @param  num el n? del que se obtendr?n los m?ltiplos
     * @return  la colecci?n asociada en el map   
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
        //Recuperamos las claves en un Set con la funci?n keySet
        Set<String> claves=mapMultiplos.keySet();
        for (String clave : claves) {
            System.out.print(clave  + ": ");
            escribirValor(mapMultiplos.get(clave));
        }
    }
    
    
    /**
     * M?todo privado de ayuda que visualiz aun ArrayList
     *    
     */
    private void escribirValor(ArrayList<Integer> lista)
    {
        System.out.println(lista.toString());
    }

    /**
     * borrar del map (de todas las entradas) el m?ltiplo indicado
     * y devuelve el total de m?ltiplos borrados
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
            //A continuaci?n, dos versiones de la misma funci?n, con diferencias importantes
            /*
             remove (int) borra el elemento de la posici?n recibida
             Devuelve el elemento borrado, el que estaba en esa posici?n. Por tanto
             no se puede usar en un if() tal y como hacemos despu?s.
             y adem?s NO es lo que necesitamos*/

            //multiplos.remove(multi);

            /*remove(Objeto) borra el objeto y devuelve true (si estaba en la lista) o false
            Borra S?LO la primera ocurrencia
            Es v?lido porque sabemos que una lista de m?ltiplos no habr? repetidos
            Si pens?ramos que pudiese haber repetidos, podr?amos hacerlo con un while en lugar de un if
            */
            if(multiplos.remove(Integer.valueOf(multi))){
                borrados++;
            }
        }
        return borrados;
    }

    public static void main(String[] args) {
        SerieMultiplos sm=new SerieMultiplos();
        sm.a?adirEntrada(3);
        sm.a?adirEntrada(5);
        sm.a?adirEntrada(6);
        sm.a?adirEntrada(8);
        sm.escribirMap();
        int borrados=sm.borrarMultiplo(30);
        System.out.println("Borrando el m?ltiplo 30 se borran " + borrados + " y el Map queda: ");
        sm.escribirMap();
    }
        
}
