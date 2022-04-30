package ut8.numeros.demo;

import ut8.numeros.modelo.ListaNumeros;

import java.io.IOException;

public class DemoLista {

    /**
     * - crea un objeto ut8.lista.ListaNumeros
     * - lee del fichero "numeros.txt" los nºs y guárdalos en la lista (usa leerDeFicheroV1())
     * - muestra la cantidad de valores erróneos leídos
     * <p>
     * - guarda en el fichero "resultado1.txt" el máximo y la lista en orden descendente
     * - vacia la lista
     * <p>
     * - lee del fichero "numeros.txt" los nºs y guárdalos en la lista (usa leerDeFicheroV2())
     * - guarda en el fichero "resultado2.txt" el máximo y la lista en orden descendente
     * <p>
     * Propaga todas las posibles excepciones
     */
    public static void main(String[] args) throws IOException {
        ListaNumeros lista = new ListaNumeros();
        int errores = lista.leerDeFicheroV1("numeros.txt");
        System.out.println("Nºs erróneos leídos " + errores);

        System.out.println("---------------");
        String nombre = "resultado1.txt";
        lista.salvarEnFichero(nombre);
        System.out.println("Guardados nºs en " + nombre);
        lista.vaciarLista();

        System.out.println("---------------");
        nombre = "resultado2.txt";
        errores = lista.leerDeFicheroV2("numeros.txt");
        lista.salvarEnFichero(nombre);
        System.out.println("Guardados nºs en " + nombre);
    }
}
