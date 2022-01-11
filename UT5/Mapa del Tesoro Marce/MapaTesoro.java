import java.util.Random;

/**
 * Guarda mediante un array bidimensional de valores boolean
 * un mapa del tesoro indicando si en una determinada fila,columna
 * hay o no un tesoro (la posición del array guarda true o false)
 */
public class MapaTesoro {
    private static final char CARACTER = '\u0024';
    private static final char PUNTO = '.';
    private static Random generador = new Random();
    private boolean[][] mapa;

    /**
     * construye el mapa de las dimensiones indicadas
     * y lo inicializa a valores boolean aleatorios
     * 
     */
    public MapaTesoro(int filas, int columnas) {
        mapa = new boolean[filas][columnas];
        inicializar();
    }

    /**
     * inicializa el array mapa a valores aleatorios true / false
     *  
     */
    private void inicializar() {
        for(int i=0;i<mapa.length;i++){
            for(int j=0;j<mapa[i].length;j++){
                /*
                //Generamos aleatorios entre 0 y 1 ambos incluidos
                //int aleatorio=generador.nextInt(2);
                //si el aleatorio es 1, se guarda true. Si es 0, false
                //mapa[i][j]=(aleatorio==1);
                */
                mapa[i][j]=generador.nextBoolean();
            }
        }
    }

    /**
     *    
     * @return  el nº de filas del mapa    
     */
    public int getFilas() {
        return mapa.length;
    }
    
    /**
     *    
     * @return  el nº de columnas del mapa    
     */
    public int getColumnas() {
        /**
         * Es una matriz rectangular, así que todas las filas
         * tienen el mismo número de columnas.
         * Podemos devolver la cantidad de columnas de la primera fila
         */
        return mapa[0].length;
    }


    /**
     * representación textual del mapa
     * (leer enunciado)
     */
    public String toString() {
        //Empezamos inicializando el string a devolver con la línea de cabecera de columnas 0 1 2 3...
        String retorno= cabeceraColumnasStr(getColumnas()) + "\n";
        for(int i=0;i<getFilas();i++){
            //Añadimos el índice correspondiente a cada columna
            retorno+=String.format("%2d",i);
            for(int j=0;j<getColumnas();j++){
                if (mapa[i][j]==true){
                    retorno+=String.format("%2s",CARACTER);
                }
                else{
                    retorno+=String.format("%2s",PUNTO);
                }
            }
            retorno+="\n";
        }
        return retorno;
    }

    /**
     * Añadido al proyecto base
     * Devuelve la fila de cabecera necesaria en el método toString
     * @param columnas para cuantas columnas lo construimos
     * @return un string con la linea de cabecera correspondiente
     */
    private String cabeceraColumnasStr(int columnas){
        String linea=String.format("%2s","");//Añadimos 2 espacios previamente
        for(int i = 0; i<columnas; i++)
            linea+=String.format("%2d",i);
        return linea;
    }

    /**
     * devuelve true si en la posición indicada hay un tesoro
     * false si la posición (f,c) no está dentro de los límites del mapa
     * o no hay un tesoro en esa posición
     * 
     * Para saber si una posición está dentro de los límites
     * del mapa del tesoro se usará dentroLimites() 
     */
    public boolean hayTesoro(int f, int c) {
        if(dentroLimites(f,c)==false)
            return false;
        else return mapa[f][c];
        /**
         * Otra opción, by Adrian Lastra (explicado en clase):
         * return dentroLimites(f,c) && (mapa[f][c])
         */
    }

    /**
     * devuelve true si f,c está dentro de los límites, false en otro caso
     * 
     */
    private boolean dentroLimites(int f, int c) {
        if(f<0 || f>mapa.length-1)
            return false;
        if(c<0 || c > mapa[0].length-1)
            return false;
        //Pasadas las verificaciones ya se puede devolver true
        return true;
    }

    /**
     * devuelve el nº de tesoros  adyacentes a una posición dada f,c
     * Las posiciones adyacentes en el mapa a f,c son las ocho celdas (posiciones)
     * que la bordean (horizontal, vertical y diagonalmente)
     * Un tesoro en la posición dada f,c  no cuenta como adyacente.
     * El nº de tesoros adyacentes en una posición fuera de los límites es 0.
     */
    public  int calcularNumeroTesorosAdyacentes(int f, int c) {
        int tesoros=0;

        if(dentroLimites(f,c)==false)
            return 0;
        /* VERSIÓN SECUENCIAL
        //Adyacentes verticales
        if(hayTesoro(f+1,c)) tesoros++;
        if(hayTesoro(f-1,c)) tesoros++;
        //Adyacentes horizontales
        if(hayTesoro(f,c+1)) tesoros++;
        if(hayTesoro(f,c-1)) tesoros++;
        //Adyacentes diagonales
        if(hayTesoro(f+1,c-1)) tesoros++;
        if(hayTesoro(f+1,c+1)) tesoros++;
        if(hayTesoro(f-1,c-1)) tesoros++;
        if(hayTesoro(f-1,c+1)) tesoros++;
         */

        //VERSION EN BUCLE
        // Tenemos que comprobar todas las combinaciones posibles desde f-1 a f+1 y c-1 a c+1
        // Excluyendo la propia posición [f,c]
        for(int i=f-1;i<=f+1;i++){
            for(int j=c-1;j<=c+1;j++){
                if(hayTesoro(i,j) && !(i==f && j==c)){
                    tesoros++;
                }
            }
        }

        return tesoros;
    }

    /**
     * Crea y devuelve un array bidimensional de enteros 
     * En este nuevo array se asignará un 9 en la posición
     * f,c si hay un tesoro
     * Si no lo hay se asignará el nº de tesoros adyacentes
     * a la posición f,c
     * 
     */
    public int[][] calcularTesoros() {
        int [][] numTesoros= new int[getFilas()][getColumnas()];
        for(int i=0;i<getFilas();i++){
            for(int j=0;j<getColumnas();j++){
                if(hayTesoro(i,j))
                    numTesoros[i][j]=9;
                else
                    numTesoros[i][j]=calcularNumeroTesorosAdyacentes(i,j);
            }
        }

        return numTesoros;
    }
}
