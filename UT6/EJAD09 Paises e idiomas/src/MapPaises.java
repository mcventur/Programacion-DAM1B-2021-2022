import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

/**
 * Un map que asocia nombres de paises con el conjunto de  idiomas que se hablan en ellos
 * Se quiere recuperar los nombres de los paises ordenados alfab?ticamente
 * Se quiere recuperar los nombres de los idiomas ordenados alfab?ticamente
 * <p>
 * Define el atributo mapPaises de forma adecuada
 */
public class MapPaises {
    private TreeMap<String, TreeSet<String>> paises;

    /**
     * Constructor
     */
    public MapPaises() {
        paises = new TreeMap<>();

    }

    /**
     * a?ade un pa?s (siempre en may?sculas) y el idioma asociado
     * Si la clave ya existe se a?ade el idioma al conjunto de idiomas del pa?s
     * Si la clave no existe se a?ade una nueva entrada con el pais y el conjunto
     * formado por idioma
     */
    public void add(String pais, String idioma) {
        //Declaramos el TreeSet que contendr? la lista de idiomas del pais
        TreeSet<String> idiomas;
        if (!paises.containsKey(pais.toUpperCase())) {//Si no est? el pais en el Map
            idiomas = new TreeSet<>();//Inicializamos el Set de idiomas
            paises.put(pais.toUpperCase(), idiomas);//Lo metemos en el map asociado a su pais
        }
        else{//Si est? el pais en el map
            idiomas = paises.get(pais.toUpperCase());//guardamos el set actual de idiomas del pais
        }

        idiomas.add(idioma);//A?adimos el idioma al set de paises
    }

    /**
     * Devuelve el conjunto de idiomas que hablan en el pais indicado
     */
    public TreeSet<String> idiomasQueHablanEn(String pais) {
        return paises.get(pais.toUpperCase());
    }

    /**
     * Devuelve cu?ntos idiomas hablan en el pais indicado
     * 0 si el pais no existe
     */
    public int totalIdiomasQueHablanEn(String pais) {
        if(paises.containsKey(pais.toUpperCase())){
            return paises.get(pais.toUpperCase()).size();
        }
        else{
            return 0;
        }
    }

    /**
     * Representaci?n textual del map de la forma
     * Pais = {idioma1, idioma2, ....}
     * Usa StringBuilder para las concatenaciones
     * Para iterar sobre el map usa el conjunto de entradas y un for mejorado
     */
    public String toString() {
        Set<Map.Entry<String, TreeSet<String>>> setEntradas = paises.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TreeSet<String>> entrada : setEntradas) {
            sb.append(entrada.getKey() + " = ");
            sb.append(entrada.getValue().toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Conjunto de paises en los que se habla el idioma indicado
     * Importa el orden en el conjunto devuelto
     * Usa el conjunto de claves y un iterador
     */
    public TreeSet<String> paisesQueHablanIdioma(String idioma) {
        TreeSet<String> retorno = new TreeSet<>();
        Set<String> setPaises = paises.keySet();
        Iterator<String> itSetPaises = setPaises.iterator();
        while (itSetPaises.hasNext()) {
            String pais = itSetPaises.next();
            TreeSet<String> setIdiomas=paises.get(pais);
            if(setIdiomas.contains(idioma)){
                retorno.add(pais);
            }
        }

        return retorno;
    }

    /**
     * Dados dos pa?ses devuelve el conjunto de idioma/s comunes que se hablan en ellos
     * Si no hay devuelve el conjunto vac?o. Si los pa?ses no existen tambi?n se devuelve
     * conjunto vac?o
     */
    public TreeSet<String> idiomasComunes(String pais1, String pais2) {
        //Recogemos el conjunto de idiomas de cada pais en un TreeSet
        TreeSet<String> idiomasPais1=paises.get(pais1.toUpperCase());
        TreeSet<String> idiomasPais2=paises.get(pais2.toUpperCase());
        //Hacemos la conjunci?n sobre uno de ellos, y lo devolvemos
        if(idiomasPais1!=null && idiomasPais2!=null){
            idiomasPais1.retainAll(idiomasPais2);
        }
        else{//Si alguno de los dos paises no estaba
            idiomasPais1=new TreeSet<>();
        }
        return idiomasPais1;
    }

    /**
     *
     */
    public void printPaises() {
        System.out.println(this.toString());
    }


}
