package ordenadores.modelo;

import java.util.Comparator;

/**
 * Esta clase encapsula un nuevo criterio de ordenación de los ordenadores, el precio
 */
public class ComparadorPrecio implements Comparator<Ordenador> {

    /**
     *
     */
    @Override
    public int compare(Ordenador ord1, Ordenador ord2) {
        return Double.compare(ord1.getPrecio(), ord2.getPrecio());
    }
}
