import java.util.Comparator;

/**
 * Añadida al proyecto base
 * Usamos dos veces este comparador, para ordenación y para ordenación inversa por tamaño
 * Así que genero una implementación y la uso las dos veces
 */
public class ComparadorFicherosTam implements Comparator<Fichero> {

    @Override
    public int compare(Fichero o1, Fichero o2) {
        return Integer.compare(o1.getTamaño(),o2.getTamaño());
    }

}
