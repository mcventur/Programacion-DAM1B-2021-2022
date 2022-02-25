
/**
 *  La clase guarda una frase como conjunto de palabras
 */
import java.util.TreeSet;
import java.util.Scanner;
public class Frase
{

    private TreeSet<String> conjuntoPalabras;

    /**
     * Constructor  
     * @param frase la frase desde la que extraeremos las palabras
     * Cada palabra está separada por espacios
     */
    public Frase(String frase)
    {
        conjuntoPalabras = new TreeSet<>();
        String[] palabras = frase.trim().split("\\s+");
        for (String p: palabras)    {            
                conjuntoPalabras.add(p);            
        }

        
        // Scanner sc = new Scanner(frase);
        // while (sc.hasNext()) {
            // conjuntoPalabras.add(sc.next());
        // }

    }

    /**
     * 
     */
    public void mostrarFrase()
    {
        for (String palabra: conjuntoPalabras)    {
            System.out.println(palabra);
        }
    }
    
    /**
     *  
     */
    public static void main(String[] args)
    {
       Frase frase = new Frase(" un ejemplo de   un conjunto   Set");
       frase.mostrarFrase();
    }

}
