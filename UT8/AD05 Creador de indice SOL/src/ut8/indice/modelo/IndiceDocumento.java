package ut8.indice.modelo; /**
 * Clase IndiceDocumento
 */

import java.util.*;

public class IndiceDocumento {

    private Map<String,Set<Integer>>  indice; // representa el índice del documento

    /**
     * Constructor de la clase IndiceDocumento
     * ¿Cómó instanciamos nuestro índice?
     * Las claves van ordenadas en el map => TreeMap
     * Los números de línea también van ordenados => TreeSet. Pero no tenemos que instanciarlo aquí
     */
    public IndiceDocumento() {
        indice = new TreeMap<>();
    }

    /**
     * Añade una palabra al índice junto con la línea en la que aparece
     * Si la palabra aparece por primera vez se creará una nueva entrada en el índice
     * en caso contario, se añade el nº de línea a la palabra ya existente (solo
     * si no está)
     * Siempre se añade en mayúsculas
     *
     * Aquí es donde instanciaremos el tipo de Set usando para los valores como un TreeSet
     *
     * @param palabra la palabra a añadir
     * @param num     el nº de línea donde aparece la palabra
     */
    public void addPalabra(String palabra, int num) {
        palabra = palabra.toUpperCase();
        if(indice.containsKey(palabra)){ //La palabra ya está en el índice. Ya hay un conjunto de lineas vinculado
            //Añadimos el número de líne a su Set
            indice.get(palabra).add(num);
        }
        else{//La palabra aún no está en el índice
            Set<Integer> tsLineas = new TreeSet<>(); //Instanciamos el Set como un TreeSet, para que se ordenen los valores de forma natural
            tsLineas.add(num);//Añadimos la línea al TreeSet
            indice.put(palabra,tsLineas);//Añadimos la entrada al map
        }
    }

    /**
     * Añade múltiples palabras (separadas por blancos) al índice, todas ellas
     * en el nº de línea indicada por num
     */
    public void addTodasPalabras(String linea, int num) {
        if (linea!=null) {
            linea = linea.toUpperCase(); //Paso toda la línea a mayúsculas
            //En lugar de usar split y trim(), usaré scanner para recorrer cada token (cada palabra)
            Scanner lectura = new Scanner(linea);
            while(lectura.hasNext()){
                String palabra = lectura.next(); //Scanner ya recorre token a token con la función next(), obviando los espacios repetidos
                addPalabra(palabra,num);
            }
            lectura.close();//Ojo: Si usamos scanner como flujo para leer palabra a palabra, hay que cerrarlo al terminar
        }
    }

    /**
     * Representación textual del índice
     * Usa el conjunto de entradas y
     * StringBuilder
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Indice del documento\n\n");
        //Declaramos y referenciamos el conjunto de entradas con entrySet
        Set<Map.Entry<String,Set<Integer>>> setEntradas = indice.entrySet();
        //Lo recorremos. Usaré un foreach
        for (Map.Entry<String, Set<Integer>> entrada : setEntradas) {
            String palabra = entrada.getKey();
            Set<Integer> tsLineas = entrada.getValue();
            sb.append(palabra + " ");
            //Recorremos el conjunto de líneas
            //Cada número llevará una coma después, salvo el último. Usaré un iterador para recorrerlo
            Iterator<Integer> itLineas = tsLineas.iterator();
            while(itLineas.hasNext()){
                sb.append(itLineas.next());
                if(itLineas.hasNext()) sb.append(","); //Sólo añadimos la coma si no es el último registro del iterador
            }
            sb.append("\n");
        }

        return  sb.toString();

    }

}
