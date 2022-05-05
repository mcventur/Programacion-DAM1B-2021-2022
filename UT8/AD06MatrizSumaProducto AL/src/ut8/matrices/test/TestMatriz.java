package ut8.matrices.test;

import ut8.matrices.io.MatrizIO;
import ut8.matrices.modelo.Matriz;
import ut8.matrices.modelo.MatrizExcepcion;

import java.io.IOException;
import java.util.InputMismatchException;

public class TestMatriz {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Error de llamada. Sintaxis: java TestMatriz fich1 fich2 fich3");
        } else {
            try {
                //Leemos las 3 matrices desde los ficheros
                Matriz m1 = MatrizIO.leerDeFichero(args[0]);
                Matriz m2 = MatrizIO.leerDeFichero(args[1]);
                Matriz m3 = MatrizIO.leerDeFichero(args[2]);

                //Sumamos m1 y m2 y volcamos en fichero
                //m2 = null; //para generar una excepcion
                Matriz suma = m1.sumar(m2);
                MatrizIO.salvarEnFichero(suma, "suma.txt");
                System.out.println("Sumadas m1 y m2...");

                //Multiplicamos m1 y m3 y volcamos en fichero
                Matriz producto = m1.producto(m3);
                MatrizIO.salvarEnFichero(producto, "producto.txt");
                System.out.println("Multiplicadas m1 y m3...");

                //Intentamos multiplicar m1 y m2 para generar una excepcion de MatrizExcepcion
                //m1.producto(m2);
                //System.out.println("Multiplicadas m1 y m2");

            } catch (MatrizExcepcion e) {
                System.out.println("Error de matriz: " + e.toString());
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Error de formato numérico: " + e.getMessage());
            }
        }

    }
}
