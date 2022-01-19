
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
     * Constructor  - crea  un array de 2 dimensiones con las filas y columnas
     * indicadas
     * @param filas  nº de filas del array 
     *  @param columnas nº de columnas del array
     */
    public Array2D(int filas, int columnas)
    {
        matriz = new int[filas][columnas];

    }

    /**
     *  Inicializa la matriz con valores aleatorios entre 3 y 30 inclusive
     * Usa el mutador setValor
     */
    public void inicializar()
    {
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                /*
                Como la clase no incluye el import de la clase Random, utilizamos la función estática
                de la clase Math
                */
                int valor=(int)(Math.random()*28)+3;
                setValor(i,j,valor);
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
        matriz[f][c]=valor;
    }

    /**
     *  Representación textual de la matriz
     *
     */
    public String toString()
    {
        String str="";
        str+=String.format("%5s",LLAVE_APERTURA);
        for(int i=0;i<getFilas();i++){
            if(i!=0)//Excepto en primera fila
                str+=String.format("%5s","");//Hay que añadir 5 espacios para que quede bien alineado
            str+=String.format("%5s",LLAVE_APERTURA);
            for(int j=0;j<getColumnas();j++){
                str+=String.format("%5d",matriz[i][j]);
                /* Sólo añadimos la coma al final de cada elemento de cada fila,
                SI NO ES EL ÚLTIMO  de la fila */
                if(j<getColumnas()-1)
                    str+=",";
            }
            str+=String.format("%5s",LLAVE_CIERRE);
            if(i!=getFilas()-1)
                    str+="\n";
        }
        str+=String.format("%5s",LLAVE_CIERRE) + "\n";
        return str;

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
        int suma=0;
        //Tenemos que recorrer toda la fila f sumando sus elementos
        for(int col=0;col<matriz[f].length;col++){
            suma+=matriz[f][col];
        }
        return suma;
    }

    /**
     * @param c la columna cuyos valores hay que sumar
     *          suponemos c correcto
     */
    public   int sumarColumna(int c)
    {
        int suma=0;
        //Recorremos cada fila sumando los elementos de la columna c
        for(int fila=0;fila<getFilas();fila++){
            suma+=matriz[fila][c];
        }
        return suma;
    }

    /**
     * Calcula y devuelve un array en el que cada elemento es la suma de las filas de matriz
     */
    public  int[] sumarFilas()
    {
        int[] sumaFilas = new int[getFilas()];
        //Recorremos cada fila de la matriz, llamando a la función sumaFila
        for(int i=0;i<getFilas();i++){
            sumaFilas[i]=sumarFila(i);
        }
        return sumaFilas;
    }

    /**
     * Calcula y devuelve un array en el que cada elemento es la suma de las columnas de matriz
     */
    public  int[] sumarColumnas()
    {
        int[] sumaCols= new int[getColumnas()];
        for(int i=0;i<getColumnas();i++){
            sumaCols[i]=sumarColumna(i);
        }
        return sumaCols;
    }
    /**
     * @return calcula y devuelve la suma de la diagonal principal (suponiendo la
     * matriz cuadrada)
     */
    public   int sumarDiagonalPrincipal()
    {
        /*Si la matriz es cuadrada, entonces filas es igual a columnas
        * lo que tenemos que sumar son los elementos [0,0], [1,1], [2,2] ... [filas-1,columnas-1]*/
        int suma=0;
        if(getFilas()==getColumnas()){
            for(int i=0;i<getFilas();i++){
                suma+=matriz[i][i];
            }
        }
        return suma;
    }

    /**
     * @return calcula y devuelve la suma de la diagonal secundaria (suponiendo la
     * matriz cuadrada)
     */
    public   int sumarDiagonalSecundaria()
    {
        //Hay que sumar los elementos [0,totalCols-1] + [1,totalCols-2] + [2,totalCols-3]... + [ultimaFila,primeraColumna]
        int suma=0;
        int totalCols=getColumnas();
        if(getFilas()==totalCols){//Comprobamos que sea cuadrada la matriz
            for(int i=0;i<getFilas();i++){
                suma+=matriz[i][totalCols-i-1];
            }
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
        /*
        Fijaros en el ejemplo dado en el comentario previo a la función:

        1 - Qué hay que hacer para trasponer una matriz?
        Hay que intercambiar los valores [0,1] por el [1,0], el [0,2] por el [2,0], etc...

        2 - No asumimos que sea cuadrada la matriz. No es necesario para transponer.
        Así que la matriz traspuesta tendrá el tamaño inverso de la original
         */
        int [][] retorno = new int[getColumnas()][getFilas()];
        for(int fila=0;fila<getFilas();fila++){
            for(int col=0;col<getColumnas();col++){
                retorno[col][fila]=matriz[fila][col];
            }
        }
        return retorno;
    }

    /**
     * Calcula y devuelve la posición de la columna con suma máxima
     * Puedes ayudarte del método sumarColumna()
     */
    public  int columnaSumaMaxima()
    {
        //Recorremos cada columna buscando la de mayor suma
        //No devolvemos el máximo en sí, sino la columna a la que corresponde!!!
        int maximo=Integer.MIN_VALUE;
        int colMaximo=0;
        for(int i=0;i<getColumnas();i++){
            int sumaCol=sumarColumna(i);
            if(maximo<sumaCol){
                maximo=sumaCol;
                colMaximo=i;
            }
        }
        return colMaximo;
    }
    /**
     * Intercambia la columna de suma máxima con la primera columna
     * Si son la misma no hace falta el intercambio
     */
    public  void intercambiar()
    {
        int colMaxima=columnaSumaMaxima();
        if(colMaxima!=0){//Si no es la primera columna, intercambiamos
            //Recorremos la columna con el maximo, fila a fila
            for(int i=0;i<getFilas();i++){
                //Seguimos el procedimiento habitual para intercambiar valores, usando una variable auxiliar o temporal
                int aux=matriz[i][colMaxima];
                //La primera columna es la de índice 0
                matriz[i][colMaxima]=matriz[i][0];
                matriz[i][0]=aux;
            }
        }
    }

    /**
     *  Devuelve un ragged array donde la 1ª fila
     *  contiene el primer elemento de la 1ª fila de matriz,
     *  la 2ª fila los 2 primeros elementos de la 2ª fila de matriz, 
     *  la 3ª fila los 3 primeros elementos de la 3ª fila de matriz, ...
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
        //Podemos inicializar la cantidad de filas del array a devolver
        //Pero la cantidad de columnas de cada fila es variable
        int[][] ragged = new int[getFilas()][];
        for(int i=0;i<getFilas();i++){
            /*
            En la fila 0 el array ragged tendrá 1 columna
            En la fila 1 tendrá 2 columnas
            ..
            En la fila n tendrá n+1 columnas
            */
            ragged[i]=new int[i+1];
            for(int j=0;j<i+1;j++){
                ragged[i][j]=matriz[i][j];
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
        System.out.println(toString());
    }

    /**
     *  Calcula y devuelve el total de impares en el array
     *  Hay que hacer uso del método contarImpares(int[], int n)
     *
     */
    public int contarImpares()
    {
        int impares=0;
        for(int i=0;i<getFilas();i++){
            impares+=contarImpares(matriz[i],matriz[i].length);
        }
        return impares;

    }

    /**
     *  Cuenta los impares en el array unidimensional array de tamaño n
     *   
     *
     */
    private int contarImpares(int[] array, int n)
    {
        int impares=0;
        for(int i=0;i<n;i++){
            if(array[i]%2!=0)
                impares++;
        }
        return impares;
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
        //Fijaros en el ejemplo para entender cómo sacar de los parámetros la cantidad de filas y de columnas
        int [][] sub=new int[fila2 - fila1 +1][col2 - col1 + 1];
        for(int i=fila1;i<=fila2;i++){
            for(int j=col1;j<=col2;j++){
                //Haced cuentas para entender la fórmula que hay que usar para saber en qué fila y columna del array destino guardar cada elemento                
                sub[i-fila1][j-col1]=matriz[i][j];
            }
        }
        return sub;
    } 

}
