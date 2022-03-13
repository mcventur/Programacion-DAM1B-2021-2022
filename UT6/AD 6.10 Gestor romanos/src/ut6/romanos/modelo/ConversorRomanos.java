package ut6.romanos.modelo;
/**
 * Clase ut6.romanos.modelo.ConversorRomanos representa a un
 * objeto que puede convertir u nº romano
 * a un nº arábigo
 */
import java.util.HashMap;

public class ConversorRomanos
{
    private HashMap<Character,Integer> tabla;
    
    /**
     * Constructor 
     */
    public ConversorRomanos()
    {
        tabla= new HashMap<>();
        inicializar();
    }

    /**
     * Da valores iniciales al map
     */
    private void inicializar()
    {
        String letras = "MDCLXVI";
        int[] numeros = {1000, 500, 100, 50, 10, 5, 1};
        //numeros y letras tienen el mismo tamaño, y sus posiciones son equivalentes.
        // Podemos recorrer hasta numeros.length o hasta letras.length()
        for(int i=0;i<numeros.length;i++){
            tabla.put(letras.charAt(i),numeros[i]);
        }
    }

    /**
     * convierte el nº romano a arábigo
     * @param romano el nº romano a convertir
     * @return el nº arábigo
     */
    public int convertir(String romano)
    {   
       //Al ser notacion romana antigua, no hay casos como el IX, o como el IV. Los valores equivalentes SIEMPRE SUMAN
        int arabigo=0;
        for(int i=0;i<romano.length();i++){
            arabigo+=tabla.get(romano.charAt(i));//Vamos sumando cada arabigo equivalente, carater a caracter del numero romano
        }
        return arabigo;
    }
}
