import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Modela un diccionario en el que cada palabra
 * tiene asociados una serie de sinónimos
 */


public class Tesauro {
    // a cada clave se le asocia un conjunto de sinónimos
    //los sinónimos no se repiten
    //NOTA: probad a cambiar HasMap por TreeMap y LinkedHashMap en el atributo tesauro de la clase y en el constructor
    // veréis cómo se ordenan de forma natural y por orden de inserción respectivamente
    private HashMap<String, HashSet<String>> tesauro;

    /**
     * Constructor de la clase Tesauro
     */
    public Tesauro() {
        tesauro = new HashMap<>();
    }

    /**
     * @param palabra la palabra a añadir
     *                sinonimo el sinónimo de la palabra
     */
    public void añadirSinonimo(String palabra, String sinonimo) {
        HashSet<String> setSinonimos = tesauro.get(palabra);
        if (setSinonimos == null) {//No estaba la palabra en las claves del tesauro
            setSinonimos = new HashSet<>();//Creamos el nuevo conjunto de sinónimos para la palabra
            tesauro.put(palabra, setSinonimos);//Lo añadimos junto con la palabra al tesauro
        }
        setSinonimos.add(sinonimo);//añadimos la palabra al conjunto de sinónimos
    }

    /**
     * añade una palabra junto con todos sus sinónimos
     *
     * @param linea contiene la palabra y sus sinónimos
     *              el separador entre palabras es el blanco
     *              la primera palabra es la clave, el resto sinónimos
     */
    public void añadirSinonimo(String linea) {
        String[] arrPalabras = linea.split(" ");
        //La palabra[0] es la palabra, y el resto, los sinónimos
        String palabra = arrPalabras[0].trim();
        for (int i = 1; i < arrPalabras.length; i++) {
            if (!arrPalabras[i].isBlank()) {
                añadirSinonimo(palabra, arrPalabras[i].trim());
            }
        }
    }

    /**
     * @param sin el sinónimo a borrar de cada conjunto
     *            de sinónimos
     * @return el conjunto de claves en las que estaba
     * el sinónimo borrado. Si no se borró
     * ninguno devuelve el conjunto vacío
     */
    public HashSet<String> borrarSinonimo(String sin) {
        HashSet<String> setClavesAfectadas = new HashSet<>();
        Set<String> claves = tesauro.keySet();
        for (String pal : claves) {
            HashSet<String> sinonimos=tesauro.get(pal);
            if(sinonimos.remove(sin)){//remove en un Set devuelve un booleano, True si el elemento a borrar estaba dentro del conjunto
                setClavesAfectadas.add(pal);//Guardamos la palabra cuyo sinónimo se ha borrado
            }
        }
        return setClavesAfectadas;
    }

    /**
     * representación textual del map
     * @return
     */
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (String palabra : tesauro.keySet()) {
            sb.append("Palabra: " + palabra + ", Sinónimos: ");
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
