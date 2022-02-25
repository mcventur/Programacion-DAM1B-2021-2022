import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *  Clase de utilidades. Contiene solo métodos
 *  estáticos
 *  
 */
 

public class UtilsString
{
    /**
     *  Dada una cadena obtiene y devuelve su conjunto de caracteres
     *  Importa el orden en el conjunto
     *
     */
    public static TreeSet<Character> getConjuntoCaracteres(String cadena)
    {
        TreeSet<Character> setCaracteres=new TreeSet<>();
        for (int i = 0; i < cadena.length(); i++) {
            setCaracteres.add(cadena.charAt(i));//Se hace autoboxing (se envuelve automáticamente en un objeto Character)
        }
        return setCaracteres;
    }

     /**
     *  Dada una cadena obtiene su conjunto de caracteres numéricos
     *  No importa el orden en el conjunto
     *  
     *  Usa algún método de la clase Character  para comprobar si un caracter es  
     *  numérico o no
     *
     */
    public static HashSet<Character> getConjuntoDigitos(String cadena)
    {
        HashSet<Character> setDigitos=new HashSet<>();
        for (int i = 0; i < cadena.length(); i++) {
            if(Character.isDigit(cadena.charAt(i))){
                setDigitos.add(cadena.charAt(i));
            }
        }
        return setDigitos;
    }
    
     /**
     *  Dada una cadena obtiene su conjunto de letras mayúsculas
     *  en el orden en el que aparecen   en la cadena
     *   
     *
     */
    public static LinkedHashSet<Character> getConjuntoMayusculas(String cadena)
    {
        LinkedHashSet<Character> setMayus=new LinkedHashSet<>();
        for (int i = 0; i < cadena.length(); i++) {
            if(Character.isUpperCase(cadena.charAt(i))){
                setMayus.add(cadena.charAt(i));
            }
        }
        return setMayus;
    }
        
        
}
