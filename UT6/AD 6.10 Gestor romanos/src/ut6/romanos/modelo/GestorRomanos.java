package ut6.romanos.modelo;

import java.util.TreeMap;

/**
 * La clase GestorArabigos genera una lista
 * de nºs arábigos con sus correspondientes
 * nºs romanos.
 * La lista está ordenada por nº arábigo
 * Para modelar la lista se utiliza un TreeMap
 */


public class GestorRomanos {

    private TreeMap<Integer, String> listaArabigos;
    private ConversorRomanos conversor;

    /**
     * Constructor
     */
    public GestorRomanos(ConversorRomanos conversor) {
        this.conversor = conversor;
        listaArabigos = new TreeMap<>();
    }

    /**
     * Añadir un romano. Se añade la clave que es
     * su valor arábigo y el valor asociado que es
     * el nº romano
     *
     * @param romano el nº romano se añade como
     *               valor asociado.
     */
    public void añadirRomano(String romano) {
        int arabigo = conversor.convertir(romano);
        listaArabigos.put(arabigo, romano);
    }

    /**
     * Añadir varios romanos.
     *
     * @param romanos el array con los nºs romanos
     */
    public void añadirRomanos(String[] romanos) {
        for (String romano : romanos) {
            añadirRomano(romano);//Aprovechamos la función anterior
        }
    }

    /**
     * representación  textual del map
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Cabecera
        sb.append(String.format("%20s", "Arábigos"));
        sb.append(String.format("%20s", "Romanos"));
        sb.append("\n");
        //Cuerpo con cada una de las entradas del map
        for (Integer arabigo : listaArabigos.keySet()) {//Usamos keySet para recorrer el conjunto de claves
            sb.append(String.format("%20d", arabigo));//Se hace unboxing automático
            sb.append(String.format("%20s", listaArabigos.get(arabigo)));
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Mostrar la lista de arábigos
     */
    public void escribirListaArabigos() {
        System.out.println(this.toString());
    }

}
