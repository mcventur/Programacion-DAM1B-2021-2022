import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestListaNumeros {
    public static void main(String args[]) {
        ListaNumeros lista = new ListaNumeros();
        List<Integer> datos = Arrays.asList(4, 6, 7, 8, 3, 2, 1, 9, 80);
        for (int i : datos) {
            lista.add(i);
        }
        lista.salvarEnFicheroDeTexto("numeros.txt");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulse enter para continuar...");
        teclado.nextLine();
        lista.borrarLista();
        lista.leerFicheroDeTexto("numeros.txt");
        if (!lista.estaVacia()) {
            System.out.println("Después de leerFicheroDeTexto() con BufferedReader");
            System.out.println(lista.toString() + "\n");
        }
        lista.borrarLista();
        System.out.println("Pulse enter para continuar...");
        teclado.nextLine();
        teclado.nextLine();
        lista.leerFicheroDeTextoConScanner("numeros.txt");
        if (!lista.estaVacia()) {
           System.out.println("Después de leerFicheroDeTextoConScanner()");
            System.out.println(lista.toString() + "\n");
        }
        lista.borrarLista();

    }
}
