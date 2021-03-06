package ut6.romanos.modelo;

import java.util.TreeMap;

/**
 * La clase GestorArabigos genera una lista
 * de n?s ar?bigos con sus correspondientes
 * n?s romanos.
 * La lista est? ordenada por n? ar?bigo
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
     * A?adir un romano. Se a?ade la clave que es
     * su valor ar?bigo y el valor asociado que es
     * el n? romano
     *
     * @param romano el n? romano se a?ade como
     *               valor asociado.
     */
    public void a?adirRomano(String romano) {
        int arabigo = conversor.convertir(romano);
        listaArabigos.put(arabigo, romano);
    }

    /**
     * A?adir varios romanos.
     *
     * @param romanos el array con los n?s romanos
     */
    public void a?adirRomanos(String[] romanos) {
        for (String romano : romanos) {
            a?adirRomano(romano);//Aprovechamos la funci?n anterior
        }
    }

    /**
     * representaci?n  textual del map
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Cabecera
        sb.append(String.format("%20s", "Ar?bigos"));
        sb.append(String.format("%20s", "Romanos"));
        sb.append("\n");
        //Cuerpo con cada una de las entradas del map
        for (Integer arabigo : listaArabigos.keySet()) {//Usamos keySet para recorrer el conjunto de claves
            sb.append(String.format("%20d", arabigo));//Se hace unboxing autom?tico
            sb.append(String.format("%20s", listaArabigos.get(arabigo)));
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Mostrar la lista de ar?bigos
     */
    public void escribirListaArabigos() {
        System.out.println(this.toString());
    }

}
