import java.util.Scanner;

public class TestMapaTesoro {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Teclee filas del mapa del tesoro: ");
        int filas = teclado.nextInt();
        System.out.println("Teclee columnas del mapa del tesoro: ");
        int columnas = teclado.nextInt();

        System.out.println();
        MapaTesoro mapa = new MapaTesoro(filas, columnas);
        System.out.println("Mapa del tesoro:(" + mapa.getFilas() + " filas , "
                + mapa.getColumnas() + " columnas)\n");
         System.out.println( mapa.toString());

        System.out.println("------------------------------------------------\n");

        int[] posFilas = {0, 0, 2, 2, 4};
        int[] posColumnas = {2, -1, 3, 2, 9};
        System.out.println("Hay tesoro en las siguientes posiciones del mapa?");
        for (int i = 0; i < posFilas.length; i++) {
            System.out.println("(" + posFilas[i] + ", " +
                posColumnas[i] + "): " + mapa.hayTesoro(posFilas[i],
                    posColumnas[i]));

        }

        System.out.println("------------------------------------------------\n");

        System.out.println("Tesoros adyacentes a las siguientes posiciones del mapa?");
        for (int i = 0; i < posFilas.length; i++) {
            System.out.println("(" + posFilas[i] + "," +
                " " +
                posColumnas[i] + "): " + mapa.calcularNumeroTesorosAdyacentes(posFilas[i],
                    posColumnas[i]));

        }

        System.out.println("------------------------------------------------\n");

        System.out.println("Mapa de enteros");
        System.out.println("Si hay tesoro en esa posición => 9");
        System.out.println("Si no hay tesoro en esa posición =>" +
            "nº de tesoros adyacentes a la misma\n");
        int[][] tesoros = mapa.calcularTesoros();
        for (int f = 0; f < tesoros.length; f++) {
            for (int c = 0; c < tesoros[0].length; c++) {
                System.out.printf(String.format("%2d", tesoros[f][c]));

            }
            System.out.println();

        }
    }
}
