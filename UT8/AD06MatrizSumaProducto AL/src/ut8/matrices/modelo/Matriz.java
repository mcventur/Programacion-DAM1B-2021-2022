package ut8.matrices.modelo;

public class Matriz {
    private int[][] matriz;

    /**
     * Constructor de la clase Matriz
     * Crea una matriz vacía con el nº de filas y
     * columnas especificado
     */
    public Matriz(int filas, int columnas) {
        matriz = new int[filas][columnas];
    }

    /**
     * obtiene el valor de una determinada fila y columna de la matriz
     */
    public int getValor(int f, int c) {
        return matriz[f][c];
    }

    /**
     * accesor para las filas de la matriz
     *
     * @return el nº de filas de la matriz
     */
    public int getFilas() {
        return matriz.length;
    }

    /**
     * accesor para las columnas de la matriz
     *
     * @return el nº de columnas
     */
    public int getColumnas() {
        return matriz[0].length;
    }

    /**
     * mutador establece el nuevo valor en una fila y columnas determinadas
     */
    public void setValor(int valor, int f, int c) throws MatrizExcepcion {
        if(f<0 || f>getFilas())
            throw new MatrizExcepcion("setValor(): Fila inválida para matriz de filas " + getFilas() + ": " + f);
        if (c<0 || c>getColumnas())
            throw new MatrizExcepcion("setValor(): Columna inválida para matriz de columnas " + getColumnas() + ": " + c);
        matriz[f][c]=valor;
    }

    /**
     * Suma la matriz actual con la que recibe como parámetro
     */
    public Matriz sumar(Matriz otra) throws MatrizExcepcion {
        if(otra==null)
            throw new MatrizExcepcion("sumar(): el parámetro otra es nulo");

        int filas = getFilas();
        int columnas = getColumnas();

        if(filas!=otra.getFilas()){
            throw new MatrizExcepcion("sumar(): las filas no coinciden. " +
                    "Actual: " + filas + ", Otra: " + otra.getFilas());
        }

        if(columnas!=otra.getColumnas()){
            throw new MatrizExcepcion("sumar(): las columnas no coinciden. " +
                    "Actual: " + columnas + ", Otra: " + otra.getColumnas());
        }

        //Creamos la matriz resultado, con el mismo tamaño que la actual
        //y vamos seteando la suma, posicion por posicion
        Matriz suma = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma.setValor(getValor(i,j)+otra.getValor(i,j),i,j);
            }
        }
        return suma;
    }

    /**
     * Multiplica la matriz actual por la que recibe como parámetro
     */
    public Matriz producto(Matriz otra) throws MatrizExcepcion {
        if(otra==null)
            throw new MatrizExcepcion("producto(): el parámetro otra es nulo");

        int filas = getFilas();
        int columnas = getColumnas();

        if(columnas!=otra.getFilas()){
            throw new MatrizExcepcion("producto(): las matrices no se pueden multiplicar. " +
                    "Columnas Actual: " + columnas + ", Filas Otra: " + otra.getFilas());
        }
        //Reglas de la multiplicación de matrices: https://www.uv.mx/personal/aherrera/files/2014/08/11a.-ALGEBRA-DE-MATRICES-1.pdf
        //Creamos la matriz resultado, con las filas de la actual y las columnas de la otra
        //y vamos seteando el producto, posicion por posicion
        Matriz producto = new Matriz(filas, otra.getColumnas());
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < otra.getColumnas(); j++) {
                int resultado = sumaArrays(i,otra,j);
                producto.setValor(resultado,i,j);
            }
        }
        return producto;
    }

    /**
     * Añadido al proyecto base. Devuelve los elementos de una columna de una matriz en forma de array unidimensional
     */
    public int[] columnaToArray(int col){
        int[] retorno = new int[getFilas()];
        for (int i = 0; i < getFilas(); i++) {
            retorno[i]=getValor(i,col);
        }
        return retorno;
    }

    /**
     * Añadido al proyecto base. Devuelve los elementos de una fila específica de la
     * matriz en forma de array unidimensional
     */
    private int[] filaToArray(int fila){
        int[] retorno = new int[getColumnas()];
        for (int i = 0; i < getColumnas(); i++) {
            retorno[i]=getValor(fila,i);
        }
        return retorno;
    }

    /**
     * Añadido al proyecto base. Devuelve la suma de los productos elemento a elemento de
     * toda la fila f de la Matriz actual, y toda la columna c de la Matriz otra.
     * Facilita el producto de matrices
     */
    private int sumaArrays(int f, Matriz otra, int c){
        int[] arr1 = filaToArray(f);
        int[] arr2 = otra.columnaToArray(c);
        int resultado=0;

        //Vamos sumando productos
        for (int i = 0; i < arr1.length; i++) {
            resultado += arr1[i]*arr2[i];
        }
        return resultado;
    }

    /**
     *
     * Otra solución más atómica para la multiplicación de matrices
     */
    public Matriz productoV2(Matriz otra) throws MatrizExcepcion {

        if (otra == null) {
            throw new MatrizExcepcion("Matriz null");
        }
        if (this.getColumnas() != otra.getFilas()) {
            throw new MatrizExcepcion(
                    "Columns de la 1ª no coinciden con filas "
                            + "de la 2ª");
        }

        int filas = getFilas();
        int columnas = getColumnas();
        Matriz producto = new Matriz(filas, otra.getColumnas());
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < otra.getColumnas(); c++) {
                int valor = 0;
                for (int k = 0; k < getColumnas(); k++) {
                    valor += matriz[f][k] * matriz[k][c];
                }

                producto.setValor(valor, f, c);
            }
        }
        return producto;
    }

    /**
     * @return String representación textual de la matriz
     */
    @Override
    public String toString() {
        //Voy a formatear cada dato numérico a 8 espacios rellenados a la derecha, para que quede bien alineado
        //Filas y columnas en la primera linea
        StringBuilder sb=new StringBuilder(String.format("%-8d%-8d",getFilas(),getColumnas()));
        sb.append("\n");
        //Valores
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                sb.append(String.format("%-8d",getValor(i,j)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
