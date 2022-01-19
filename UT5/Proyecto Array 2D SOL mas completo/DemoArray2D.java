import java.util.Arrays;
/**
 *  
 * 
 * @author  
 * @version  
 */
public class DemoArray2D
{

    private Array2D uno;
    private Array2D dos;
    private Array2D tres;

    /**
     * Constructor  
     */
    public DemoArray2D()
    {
        uno = new Array2D();  // lo creamos usando el primer constructor
        dos = new Array2D(4, 5);  // lo creamos usando el segundo constructor e inicializando
        dos.inicializar();

    }

    /**
     *  
     */
    public void demoSumarFila()
    {
        int filaAleatoria = (int) (Math.random() * uno.getFilas()); 
        int suma = uno.sumarFila(filaAleatoria);
        uno.escribir();
        System.out.println("La suma de la fila " + filaAleatoria + " es " + suma);
    }

    /**
     *  
     */
    public void demoSumarColumna()
    {
        int columnaAleatoria = (int) (Math.random() * uno.getColumnas()); 
        int suma = uno.sumarColumna(columnaAleatoria);
        uno.escribir();
        System.out.println("La suma de la columna " + columnaAleatoria + " es " + suma);
    }

    /**
     *  
     */
    public void demoSumarFilas()
    {
        dos.escribir();
        int[] suma = dos.sumarFilas();
        System.out.println("\n" + Arrays.toString(suma));
    }

    /**
     *  
     */
    public void demoSumarColumnas()
    {
        dos.escribir();
        int[] suma = dos.sumarColumnas();
        System.out.println("\n" + Arrays.toString(suma));
    }

    /**
     *  
     */
    public void demoSumarDiagonalPrincipal()
    {
        uno.escribir();
        int  suma = uno.sumarDiagonalPrincipal();
        System.out.println("La suma de la diagonal principal es " + suma);
    }

    /**
     *  
     */
    public void demoSumarDiagonalSecundaria()
    {
        uno.escribir();
        int  suma = uno.sumarDiagonalSecundaria();
        System.out.println("La suma de la diagonal secundaria  es " + suma);
    }

    /**
     *  
     */
    public void demoTraspuesta()
    {
        dos.escribir();
        int[][]  traspuesta = dos.traspuesta(); 
        System.out.println("Traspuesta\n ");
        for (int f = 0; f < traspuesta.length; f++) {
            System.out.println(Arrays.toString(traspuesta[f]));
        }
    }

    /**
     *  
     */
    public void demoColumnaSumaMaxima()
    {
        dos.escribir();        
        System.out.println("Posición columna suma máxima " + dos.columnaSumaMaxima());

    }

    /**
     *  
     */
    public void demoIntercambiar()
    {
        demoColumnaSumaMaxima();
        dos.intercambiar();
        System.out.println("Después del intercambio\n ");
        dos.escribir();

    }

    /**
     *  
     *
     */
    public void demoArrayRagged()
    {
        uno.escribir();
        int[][] ragged = uno.arrayRagged();
        for (int f = 0; f < ragged.length; f++) {
            System.out.println(Arrays.toString(ragged[f]));
        }
    }

    /**
     *  
     *
     */
    public void demoEscribirConLlaves()
    {
        uno.escribirConLlaves();
    }

    /**
     *  
     *
     */
    public void demoContarImpares()
    {
        uno.escribirConLlaves();
        System.out.println("Total impares " + uno.contarImpares());
        uno.inicializar();
        uno.escribirConLlaves();
        System.out.println("Total impares " + uno.contarImpares());

    }

    /**
     *  
     *
     */
    public void demoSubArray()
    {
        dos.escribir();
        System.out.println("Subarray desde filas  1 a  3 y columnas 2 a 3");
        int[][] sub = dos.obtenerSubArray(1, 3, 2, 3);
        for (int f = 0; f < sub.length; f++) {
            System.out.println(Arrays.toString(sub[f]));
        }

    }

    /**
     *  
     *
     */
    public void aUnaDimension()
    {
        System.out.println("De dos dimensión");
        dos.escribir();
        System.out.println("A una dimensión");
        int[]  resul = dos.aUnaDimension();
        System.out.println(Arrays.toString(resul));

    }

    /**
     *  
     *
     */
    public void demoTercerConstructor()
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(Arrays.toString(array));
        tres = new Array2D(array, 4);
        System.out.println("Construida matriz de array 1D a 2D");       
        tres.escribir();

    }

    /**
     *  
     */
    public void demoGirarDerecha()
    {
        System.out.println("Antes de rotar a la derecha");    
        dos.escribir();
        int[][] giradaDerecha = dos.girarDerecha();
        System.out.println("Después de rotar a la derecha");    
        for (int f = 0; f < giradaDerecha.length; f++) {
            System.out.println(Arrays.toString(giradaDerecha[f]));
        }
    }
    
     /**
     *  
     */
    public void demoGirarIzquierda()
    {
        System.out.println("Antes de rotar a la izquierda");    
        dos.escribir();
        int[][] giradaIzquierda = dos.girarIzquierda();
        System.out.println("Después de girar a la izquierda");    
        for (int f = 0; f < giradaIzquierda.length; f++) {
            System.out.println(Arrays.toString(giradaIzquierda[f]));
        }
    }

     /**
     *  
     */
    public void demoEspejo()
    {
        System.out.println("Antes de obtener espejo");    
        dos.escribir();
        int[][] espejo = dos.espejo();
        System.out.println("Después de obtener espejo");    
        for (int f = 0; f < espejo.length; f++) {
            System.out.println(Arrays.toString(espejo[f]));
        }
    }
    
     /**
     *  
     */
    public void demoEscribirAdyacentes()
    {
        System.out.println("Antes de escribir adyacentes");    
        dos.escribir();        
        System.out.println("Después de escribir adyacentes"); 
        int fila = 3;
        int col = 4;
        System.out.println("Adyacentes a elemento de posición (" + fila + "," + col + ")"); 
        dos.escribirAdyacentes(fila, col);
    }

}
