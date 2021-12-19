
/**
 *  la clase Diccionario representa a un diccionario
 *  de palabras
 *  
 */

public class Diccionario
{
    public static final int MAX_PALABRAS = 10;
    private Palabra[] listaPalabras;
    private int pos;

    /**
     * Constructor de la clase Diccionario
     * @param numPalabras la cantidad de palabras máxima
     * que guardará el diccionario
     */
    public Diccionario(int numPalabras)    {
        int size = Math.min(numPalabras, MAX_PALABRAS);
        listaPalabras = new Palabra[size];
        pos = 0;
    }

    /**
     * 
     * @param nuevaPalabra la palabra a añadir     
     */
    public void insertarPalabra(Palabra nuevaPalabra)   {
        if (pos < listaPalabras.length)   {
            listaPalabras[pos] = nuevaPalabra;
            pos++;
        } 
        else   {
            System.out.println("Diccionario completo");
        }

    }

    /**
     * @param posicion la posición de la palabra
     *        a devolver. A partir de 1.
     * @return la palabra de posicion
     */
    public Palabra obtenerPalabra(int posicion)    {
        if (posicion < 1 ||  posicion > pos)    {
            return null;            
        }
        return listaPalabras[posicion - 1];
    }

    /**
     * @param posicion la posición de la palabra
     *        a traducir. A partir de 1.
     * @return la traducción al inglés de la palabra
     *          de posición 
     */
    public String traducirPalabra(int posicion)    {
        Palabra p = obtenerPalabra(posicion);
        if (p != null)    {
            return p.getIngles();
        }
        return null;
    }

    /**
     * Mostrar el diccionario
     */
    public void escribirDiccionario()    {
        System.out.println(toString());
    }

    /**
     * Representación textual del diccionario
     */
    public String toString()    {
        String str = "";
        for (int i = 0; i < pos; i++)  {
            str = str + (i + 1) + ". " + listaPalabras[i].toString();
        }
        return str;
    }

}
