
/**
 *  
 * 
 * @author  
 * @version  
 */
public class AppListaNumeros
{

    /**
     *  
     */
    public static void main(String[] args)    {
        int[] valores = {3, 7, 9, 12, 14, 17, 19, 2, 5, 8};
        ListaNumeros lista = new ListaNumeros(valores);
        System.out.println(lista.toString() + "\n");

        lista.borrarImpares();
        System.out.println("Después de borrar impares");
        System.out.println(lista.toString() + "\n");

        lista.vaciarLista();
        for (int i = 0; i < valores.length; i++) {
            lista.insertarEnOrden(valores[i]);            
        }
        System.out.println("Después de vaciar e insertar en orden");
        System.out.println(lista.toString() + "\n");

        int valor = 17;
        System.out.println("Búsqueda binaria del valor " + valor + 
            " existe? " + lista.buscarBinario(valor));

        System.out.println();
        System.out.println("Después de borrar el primero");
        lista.borrar(0);
        System.out.println(lista.toString() + "\n");

        valor = 100;
        System.out.println("Después de insertar en la posición 0 el valor " + valor);
        lista.insertarEnPosición(valor, 0);
        System.out.println(lista.toString() + "\n");
    }
}
