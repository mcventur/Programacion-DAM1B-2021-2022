import pkgpruebas.utilidades.UtilsString;

import java.util.Scanner;

public class UsandoClassPath {

    /**
     *
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        UtilsString us=new UtilsString();
        System.out.print("Dame cadena ");
        String cadena = teclado.nextLine();
        System.out.println("Conjunto de caracteres " + us.getConjuntoCaracteres(cadena).toString());
        System.out.println("Conjunto de dígitos " + us.getConjuntoDigitos(cadena).toString());
        System.out.println("Conjunto de mayúsculas " + us.getConjuntoMayusculas(cadena).toString());


    }
}
