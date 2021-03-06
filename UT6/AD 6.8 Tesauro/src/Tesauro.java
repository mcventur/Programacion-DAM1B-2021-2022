import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Modela un diccionario en el que cada palabra
 * tiene asociados una serie de sin?nimos
 */


public class Tesauro {
    // a cada clave se le asocia un conjunto de sin?nimos
    //los sin?nimos no se repiten
    //NOTA: probad a cambiar HasMap por TreeMap y LinkedHashMap en el atributo tesauro de la clase y en el constructor
    // ver?is c?mo se ordenan de forma natural y por orden de inserci?n respectivamente
    private HashMap<String, HashSet<String>> tesauro;

    /**
     * Constructor de la clase Tesauro
     */
    public Tesauro() {
        tesauro = new HashMap<>();
    }

    /**
     * @param palabra la palabra a a?adir
     *                sinonimo el sin?nimo de la palabra
     */
    public void a?adirSinonimo(String palabra, String sinonimo) {
        HashSet<String> setSinonimos = tesauro.get(palabra);
        if (setSinonimos == null) {//No estaba la palabra en las claves del tesauro
            setSinonimos = new HashSet<>();//Creamos el nuevo conjunto de sin?nimos para la palabra
            tesauro.put(palabra, setSinonimos);//Lo a?adimos junto con la palabra al tesauro
        }
        setSinonimos.add(sinonimo);//a?adimos la palabra al conjunto de sin?nimos
    }

    /**
     * a?ade una palabra junto con todos sus sin?nimos
     *
     * @param linea contiene la palabra y sus sin?nimos
     *              el separador entre palabras es el blanco
     *              la primera palabra es la clave, el resto sin?nimos
     */
    public void a?adirSinonimo(String linea) {
        String[] arrPalabras = linea.split(" ");
        //La palabra[0] es la palabra, y el resto, los sin?nimos
        String palabra = arrPalabras[0].trim();
        for (int i = 1; i < arrPalabras.length; i++) {
            if (!arrPalabras[i].isBlank()) {
                a?adirSinonimo(palabra, arrPalabras[i].trim());
            }
        }
    }

    /**
     * @param sin el sin?nimo a borrar de cada conjunto
     *            de sin?nimos
     * @return el conjunto de claves en las que estaba
     * el sin?nimo borrado. Si no se borr?
     * ninguno devuelve el conjunto vac?o
     */
    public HashSet<String> borrarSinonimo(String sin) {
        HashSet<String> setClavesAfectadas = new HashSet<>();
        Set<String> claves = tesauro.keySet();
        for (String pal : claves) {
            HashSet<String> sinonimos=tesauro.get(pal);
            if(sinonimos.remove(sin)){//remove en un Set devuelve un booleano, True si el elemento a borrar estaba dentro del conjunto
                setClavesAfectadas.add(pal);//Guardamos la palabra cuyo sin?nimo se ha borrado
            }
        }
        return setClavesAfectadas;
    }

    /**
     * representaci?n textual del map
     * @return
     */
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (String palabra : tesauro.keySet()) {
            sb.append("Palabra: " + palabra + ", Sin?nimos: ");
            sb.append(tesauro.get(palabra).toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Visualiza el tesauro
     */
    public void escribirTesauro() {

        System.out.println(toString());
    }

}
