import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

/**
 *  
 * Modela una lista de números 
 * Tiene un atributo que es un array
 */
public class ListaNumeros
{
    private int[] numeros;
    private int pos;

    /**
     * @param n el tamaño máximo del array
     */
    public ListaNumeros(int n)    {
        numeros = new int[n];
        pos = 0;  // longitud lógica
    }

    /**
     * Constructor sobrecargado
     * Creamos el array a partir de otro que se recibe como parámetro
     */
    public ListaNumeros(int[]  array)    {
        //         numeros = array;  //esto no es una copia
        //         pos =  array.length;
        numeros = new int[array.length];
        System.arraycopy(array, 0, numeros, 0, array.length);
        pos =  array.length;
        // numeros = Arrays.copyOf(array, array.length);

    }

    /**
     * Añadir un nº a la lista solo si no está completa
     */
    public void addNumero(int valor)    {
        if (pos < numeros.length)   {   
            numeros[pos] = valor;
            pos++;
        }
    }

    /**
     * Representación textual de la lista
     */
    public  String toString()    {
        String str = "";
        for (int i = 0; i < pos; i++)  {
            str += numeros[i] + "\t";
        }
        return str;
    }

    /**
     * 
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * Comprueba si la lista de números está completa o no
     */
    public  boolean estaLlena()    {
        return pos == numeros.length;
    }

    /**
     * 
     */
    public void vaciarLista() {
        this.pos = 0;
    }

    /**
     * Borrar un elemento de una posición
     */
    public void borrar(int posicion)    {
        if (posicion >= 0 && posicion < pos)   {   
            for (int i = posicion + 1; i < pos; i++) {
                numeros[i - 1] = numeros[i];
            }
            pos--;

        }
    }

    /**
     * Borrar un elemento de una posición
     */
    public void borrarV2(int posicion)    {
        if (posicion >= 0 && posicion < pos)    {   
            System.arraycopy(numeros, posicion + 1, 
                    numeros, posicion, pos - posicion - 1);
            pos--;

        }
    }

    /**
     *  Búsqueda binaria con Array.binarySearch()
     *  Prerequisito el array numeros debe estar ordenado
     *  (o hemos insertado en orden o 
     *  hemos llamado a Arrays.sort(numeros, 0 , pos); )
     *
     */
    public boolean buscarBinario(int valor)    {
        return Arrays.binarySearch(numeros, 0, pos, valor) >= 0;
    }

    /**
     * Borrar varios elementos
     */
    public void borrarImpares()  {
        int i = 0;
        while (i < pos)    {
            if (numeros[i] % 2 != 0)  {
                borrar(i);
            }
            else   {
                i++;
            }
        }
    }

    /**
     * Borrar varios elementos
     * Con for solo si se empieza por el final 
     */
    public void borrarImparesConForV2()    {
        for (int i = pos - 1; i >= 0; i--)  {
            if (numeros[i] % 2 != 0)  {
                borrar(i);
            }

        }
    }

    /**
     * Borrar varios elementos - Mal hecho
     */
    public void borrarImparesConForV1()   {

        for (int i = 0; i < pos; i++)    {
            if (numeros[i] % 2 != 0)  {
                borrar(i);
            }

        }
    }

    /**
     * Añadir un nº a la lista en una posición
     */
    public void insertarEnPosición(int valor, int p)   {
        if (!estaLlena())     {   
            if (p >= 0 && p <= pos)     {
                for (int i = pos - 1; i >= p; i--)    {
                    numeros[i + 1] = numeros[i];
                }
                numeros[p] = valor;
                pos++;
            }
        }
    }

    /**
     * Añadir un nº a la lista en una posición
     */
    public void insertarEnPosiciónV2(int valor, int p)    {
        if (!estaLlena())    {   
            if (p >= 0 && p <= pos)  {
                System.arraycopy(numeros, p, numeros, p + 1, pos - p);
                numeros[p] = valor;
                pos++;
            }
        }
    }

    /**
     * Añadir un nº a la lista de forma que quede ordenada
     */
    public void insertarEnOrden(int valor)   {
        if (!estaLlena())    {   
            // buscar posición para insertar al tiempo que se desplzan los números a la derecha
            int j = pos - 1;
            while (j >= 0 && numeros[j] > valor)   {
                numeros[j + 1] = numeros[j];
                j = j - 1;
            }
            // insertar el valor nuevo
            numeros[j + 1] = valor;
            pos++;
        }
    }

    /**
     * Añadir un nº a la lista de forma que quede ordenada menos eficiente
     * Los dos pasos separados: 1 - buscar hueco 2 - desplazar a la derecha
     */
    public void insertarEnOrdenV2(int valor)   {
        if (!estaLlena())   {   
            // buscar hueco para valor
            int i = 0;
            while (i < pos && numeros[i] <= valor)   {
                i++;
            }
            // desplazar a la derecha 
            int j = pos - 1;
            while (j >= i)   {
                numeros[j + 1] = numeros[j];
                j --;
            }
            // System.arraycopy(numeros, i, numeros, i + 1, pos - i);

            // insertar el valor nuevo
            numeros[i] = valor;
            pos++;
        }
    }

    

}
