
/**
 *  Clase que guarda un array bidimensional
 *  y permite hacer ciertas operaciones sobre él
 */
public class Array2D
{
    public static char LLAVE_APERTURA = '{';
    public static char LLAVE_CIERRE = '}';
    private int[][] matriz;

    /**
     * Constructor  
     */
    public Array2D()
    {
        matriz = new int[][]{  {1, 2, 3, 4},
            {14, 5, 26, 7},
            {17, 8, 19, 10},
            {10, 11, 12, 13} } ;
    }

    /**
     * Constructor  - crea 
     * @param filas  nº de filas del array 
     *  @param columnas nº de columnas del array
     */
    public Array2D(int filas, int columnas)
    {
        matriz = new int[filas][columnas];

    }

    /**
     * Constructor  - crea matriz a partir del array unidimensional array
     * @param array  el array de donde se tomarán los valores
     *  @param n nº de elementos de cada fila de matriz
     *  
     *  Si la longitud de array no es divisible entre n se lanza la excepión
     *    throw new IllegalArgumentException("Error, "Longitud del array no divisible entre n")
     *  
     */
    public Array2D(int[] array, int n)
    {
        if (array.length %  n != 0) {
            throw new IllegalArgumentException("Error, Longitud del array no divisible entre " + n);
        }

        int filas = array.length / n;
        matriz = new int[filas][n];
        for (int f = 0; f < filas; f++)        {
            for (int c = 0; c < n; c++)            {
                setValor(f, c, array[f * n + c]);
            }
        }

    }

    /**
     *  Inicializa la matriz con valores aleatorios entre 3 y 30 inclusive
     * Usa el mutador setValor
     */
    public void inicializar()
    {
        for (int f = 0; f < matriz.length; f++)   {
            for (int c = 0; c < matriz[f].length; c++)    {
                setValor(f, c, (int) (Math.random() * 28)  + 3);
            }
        }
    }

    /**
     * @return el nº total de filas de la matriz 
     */
    public int getFilas()
    {
        return matriz.length;
    }

    /**
     * @return el nº total de columnas de la matriz 
     */
    public int getColumnas()
    {
        return matriz[0].length;
    }

    /**
     *  deja un valor en la fila y columna indicadas como parámetro
     *  asumimos f y c correctos
     *
     */
    public void setValor(int f, int c, int valor)
    {
        matriz[f][c] = valor;
    }

    /**
     *  Representación textual de la matriz
     *
     */
    public String toString()
    {
        String resul = "";
        for (int f = 0; f < matriz.length; f++)      {
            for (int c = 0; c < matriz[f].length; c++)       {
                resul += matriz[f][c] + "\t";
            }
            resul += "\n";
        }
        return resul;
    }

    /**
     *  
     * Escribir la matriz bidimensional en pantalla
     */
    public void escribir()
    {
        System.out.println(this.toString());
    }

    /**
     * @param f la fila cuyos valores hay que sumar
     *          suponemos f correcto
     */
    public   int sumarFila(int f)
    {
        int suma = 0;
        for (int c = 0; c < matriz[f].length; c++)    {
            suma += matriz[f][c];
        }
        return suma;
    }

    /**
     * @param c la columna cuyos valores hay que sumar
     *          suponemos c correcto
     */
    public   int sumarColumna(int c)
    {
        int suma = 0;
        for (int f = 0; f < matriz.length; f++)    {
            suma += matriz[f][c];
        }
        return suma;
    }

    /**
     * Calcula y devuelve un array en el que cada elemento es la suma de las filas de matriz
     */
    public  int[] sumarFilas()
    {
        int[] sumaFilas = new int[matriz.length];
        for (int f = 0; f < matriz.length; f++)
        {
            int suma = 0;
            for (int c = 0; c < matriz[f].length; c++)
            {
                suma += matriz[f][c];
            }
            sumaFilas[f] = suma;
        }
        return sumaFilas;
    }

    /**
     * Calcula y devuelve un array en el que cada elemento es la suma de las columnas de matriz
     */
    public  int[] sumarColumnas()
    {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[] sumaColumnas = new int[columnas];
        for (int c = 0; c < columnas; c++)
        {
            int suma = 0;
            for (int f = 0; f < filas ; f++)
            {
                suma += matriz[f][c];
            }
            sumaColumnas[c] = suma;
        }
        return sumaColumnas;
    }

    /**
     * @return calcula y devuelve la suma de la diagonal principal (suponiendo la
     * matriz cuadrada)
     */
    public   int sumarDiagonalPrincipal()
    {
        int suma = 0;
        for (int f = 0; f < matriz.length; f++)
        {
            suma += matriz[f][f];
        }
        return suma;
    }

    /**
     * @return calcula y devuelve la suma de la diagonal secundaria (suponiendo la
     * matriz cuadrada)
     */
    public   int sumarDiagonalSecundaria()
    {
        int columnas = getColumnas();
        int suma = 0;
        for (int f = 0; f < matriz.length; f++)
        {
            suma += matriz[f][columnas - f - 1];
        }
        return suma;
    }

    /**
     *   1  22  3   44
     *   3  7   5   11
     *   4  5   6   9
     *   La traspuesta es
     *   1   3   4
     *   22  7   5
     *   3   5   6
     *   44  11   9
     */
    public  int[][] traspuesta()
    {
        int[][] resul = new int[getColumnas()][getFilas()];
        for (int f = 0; f < matriz.length; f++)
        { 
            for (int c = 0; c < matriz[f].length; c++)
            {
                resul[c][f] = matriz[f][c];
            }

        }
        return resul;
    }

    /**
     * Calcula y devuelve la posición de la columna con suma máxima
     * Puedes ayudarte del método sumarColumna()
     */
    public  int columnaSumaMaxima()
    {
        int max = Integer.MIN_VALUE;
        int posColumnaMax = 0;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int c = 0; c < columnas; c++)
        {
            int suma = sumarColumna(c);
            if (suma > max)
            {
                posColumnaMax = c;
                max = suma;
            }
        }
        return posColumnaMax;
    }

    /**
     * Intercambia la columna de suma máxima con la primera columna
     * Si son la misma no hace falta el intercambio
     */
    public  void intercambiar()
    {
        int posMaxima = columnaSumaMaxima();
        if (posMaxima != 0)  // es distinta de la primera
        {
            for (int f = 0; f < matriz.length; f++)
            { 
                int aux = matriz[f][0];
                matriz[f][0] = matriz[f][posMaxima];
                matriz[f][posMaxima] = aux;
            }
        }
    }

    /**
     *  Devuelve un ragged array donde la 1ª fila contiene el primer elemento de la 1ª fila de matriz,
     *  la 2ª fila los 2 primeros elementos de la 2ª fila de matriz, la 3ª fila los 3 primeros elementos de la 3ª fila de matriz, ...
     *  1   2   3   4   
     *  14  5   26  7   
     *  17  8   19  10  
     *  10  11  12  13  
     *  Resultado
     *  [1]
     *  [14, 5]
     *  [17, 8, 19]
     *  [10, 11, 12, 13]
     *  
     */
    public int[][] arrayRagged()
    {
        int[][] ragged = new int[matriz.length][];
        for (int f = 0; f < matriz.length; f++)
        { 
            ragged[f] = new int[f + 1];
            for (int c = 0; c <= f; c++)
            {
                ragged[f][c] = matriz[f][c];
            }
        }
        return ragged;
    }

    /**
     *  Muestra el array pero de la forma indicada. Cada nº formateado a 5 posiciones.
     *  Usa las constantes definidas en la clase
     *  
     *  {   {    1,     2,     3,     4    }
     *      {   14,     5,    26,     7    }
     *      {   17,     8,    19,    10    }
     *      {   10,    11,    12,    13    }    }

     */
    public void escribirConLlaves()
    {
        System.out.printf("%c", LLAVE_APERTURA);
        for (int f = 0; f < matriz.length ; f++)
        { 
            String formato;
            if (f == 0)
                formato = "%4c";
            else
                formato = "%5c";
            System.out.printf(formato, LLAVE_APERTURA);
            for (int c = 0; c < matriz[f].length - 1; c++)
            {
                System.out.printf("%5d, ", matriz[f][c]);
            }
            System.out.printf("%5d", matriz[f][matriz[f].length - 1]);
            System.out.printf("%5c", LLAVE_CIERRE);
            if ( f < matriz.length - 1)
                System.out.println();
        }
        System.out.printf("%5c\n", LLAVE_CIERRE);
    }

    /**
     *  Calcula y devuelve el total de impares en el array
     *  Hay que hacer uso del método contarImpares(int[], int n)
     *
     */
    public int contarImpares()
    {
        int totalImpares = 0;
        for (int f = 0; f < matriz.length; f++)
        { 
            totalImpares += contarImpares(matriz[f], matriz[f].length);

        }
        return totalImpares;
    }

    /**
     *  Cuenta los impares en el array unidimensional array de tamaño n
     *  y lo hace de forma recursiva
     *
     */
    private int contarImpares(int[] array, int n)
    {
        //         if (n == 1)
        //         {
        //             if (array[0] % 2 != 0)
        //                 return 1;
        //             else
        //                 return 0;
        //         }
        //         else
        //         {
        //             if (array[n - 1] % 2 != 0)
        //                 return 1 + contarImpares(array, n - 1);
        //             else
        //                 return contarImpares(array, n - 1);
        //         }
        if (n >= 1)
        {
            if (array[n - 1] % 2 != 0)
                return 1 + contarImpares(array, n - 1);
            else
                return contarImpares(array, n - 1);
        }
        else
            return 0;

    }

    /**
     *  Devuelve el subarray obtenido a partir de matriz entre las filas fila1 y fila2
     *  y columnas col1 y col2 (ambas inclusive)
     *  Asumimos todos los valores correctos
     *  13  20  30  25  16  
     *  12  27  24  17  27  
     *  3   12  11  28  29  
     *  21  11  20  25  8   

     *  Subarray desde filas  1 a  3 y columnas 2 a 3
     *  [24, 17]
     *  [11, 28]
     *  [20, 25]
     *  
     *
     */
    public  int [][] obtenerSubArray(int fila1, int fila2, int col1, int col2)
    {
        int[][] sub = new int[fila2 - fila1 + 1][col2 - col1 + 1];
        for (int f = fila1; f <= fila2; f++)
        { 
            for (int c = col1; c <=col2; c++)
            {
                sub[f - fila1][c - col1] = matriz[f][c];
            }
        }
        return sub;
    } 

    /**
     *  devuelve un array unidimensional de filas x columnas, siendo filas  el nº de filas de matriz 
     *  y columnas el nº de columnas, conteniendo los mismos números.
     *  Los primeros n números del nuevo array se obtienen de la primera fila, los siguientes de la segunda y así sucesivamente.
     *  
     *  Si matriz es 
     *  1   2   3   4   
     *  14  5   26  7   
     *  17  8   19  10  
     *  10  11  12  13 
     *  
     *  aUnaDimension() devuelve
     *  1  2  3  4  14  5  26  7  17  8  19  10  10  11  12  13
     */
    public int[] aUnaDimension()
    {
        int filas = getFilas();
        int columnas = getColumnas();
        int[] resul = new int[filas * columnas];
        for (int f = 0; f < filas; f++)
        { 
            for (int c = 0; c < columnas; c++)
            {
                resul[f * columnas + c] = matriz[f][c];
            }
        }
        return resul;
    }

    /**
     *  Gira a la derecha 90º matriz 
     *  devolviendo el resultado
     */
    public int[][] girarDerecha()
    {
        int filas = getFilas();
        int columnas = getColumnas();
        int[][] girada = new int[columnas][filas];
        for (int f = 0; f < filas; f++)
        { 
            for (int c = 0; c < columnas; c++)
            {
                int colGirada = filas - (f + 1);
                girada[c][colGirada] = matriz[f][c];
            }
        }
        return girada;
    }

    /**
     *  Gira a la izquierda 90º matriz 
     *  devolviendo el resultado
     */
    public int[][] girarIzquierda()
    {
        int filas = getFilas();
        int columnas = getColumnas();
        int[][] girada = new int[columnas][filas];
        for (int f = 0; f < filas; f++)
        { 
            for (int c = 0; c < columnas; c++)
            {
                int filGirada = columnas - (c + 1);
                girada[filGirada][f] = matriz[f][c];
            }
        }
        return girada;
    }

    /**
     * Obtiene el espejo de matriz
     *   1  22  3   44
     *   3  7   5   11
     *   4  5   6   9
     *   El espejp es
     *   44   3   22    1
     *   11   5   7   3
     *   9    6   5   4
     *    
     */
    public int[][] espejo() {
        int filas = getFilas();
        int columnas = getColumnas();
        int[][] espejo = new int[filas][columnas];
        for (int f = 0; f < filas; f++)  { 
            for (int c = 0; c < columnas; c++)      { 
                espejo[f][columnas - c - 1] = matriz[f][c];
            }
        }
        return espejo;
    }
    
    /**
     * Obtiene el espejo de matriz
     *   1  22  3   44
     *   3  7   5   11
     *   4  5   6   9
     *   El espejp es
     *   44   3   22    1
     *   11   5   7   3
     *   9    6   5   4
     *    
     */
    public int[][] flipHorizontal() {
        int filas = getFilas();
        int columnas = getColumnas();
        int[][] espejo = new int[filas][columnas];
        for (int f = 0; f < filas; f++)  { 
            for (int c = 0; c < columnas; c++)      { 
                espejo[f][columnas - c - 1] = matriz[f][c];
            }
        }
        return espejo;
    }
    
    /**
     * escribir los valores adyacentes al elemento de posición (fila, col)
     * incluyendo a él mismo
     * 
     * fila y col asumimos valores correctos
     * 
     */
    public void escribirAdyacentes(int fila, int col) {
         for (int f = Math.max(0, fila - 1); f < Math.min(fila + 2, matriz.length) ; f++)  { 
            for (int c = Math.max(0, col - 1); c < Math.min(col + 2, matriz[f].length); c++)      { 
               System.out.printf("%5d", matriz[f][c]);
            }
            System.out.println();
        }
    }
    
     /**
     * escribir los valores adyacentes al elemento de posición (fila, col)
     * incluyendo a él mismo
     * 
     * fila y col asumimos valores correctos
     * 
     */
    public void escribirAdyacentesV2(int fila, int col) {
         for (int f = -1; f < 1 ; f++)  { 
            for (int c = -1; c < 1; c++)      { 
               System.out.printf("%5d", matriz[f + fila][c + col]);
            }
            System.out.println();
        }
    }


    //     /**
    //      *   Calcula y devuelve la posición de la columna que tiene
    //      *   el mayor número de valores iguales al objetivo
    //      *  {  {-1,  2,   10,   10  -2},
    //      *     {-14, -5,  -26,  -7,  13},
    //      *     {17,  8,   19,  10,  10},
    //      *     {10, 11,   10,  13,  19},
    //      *     {-1 , 5,   -2 , 10, -3} }
    // 
    //     el resultado será 23
    // 
    //      */
    //     public static int  columnaMayor(int[][] array2d, int objetivo)
    //     {
    //         int cont = 0;
    //         int max = 0;
    //         int colMax = 0;
    //         for (int c = 0; c < array2d[0].length; c++)
    //         {
    //             for (int f = 0; f < array2d.length; f++)
    //             {
    //                 if (array2d[f][c] == objetivo)
    //                 {
    //                     cont ++;
    //                 }
    //             }
    //             if (cont > max)
    //             {
    //                 colMax = c;
    //             }
    // 
    //         }
    //         return colMax;
    //     } 

}
