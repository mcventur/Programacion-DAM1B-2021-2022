package ordenadores.modelo;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author
 */
public class Tienda {

    private String nombre;
    private ArrayList<Ordenador> ordenadores;

    /**
     * Constructor
     */
    public Tienda(String nombre) {
        this.nombre = nombre;
        ordenadores = new ArrayList<>();
    }

    /**
     * A?ade un ordenador a la tienda
     */
    public void addOrdenador(Ordenador ordenador) {
        ordenadores.add(ordenador);
    }

    /**
     * Cuenta la cantidad de port?tiles
     */
    public int cuantosPortatiles() {
        int numPortatiles=0;
        for (Ordenador ordenador : ordenadores) {
            if(ordenador instanceof Portatil){
                numPortatiles++;
            }
        }
        return numPortatiles;
    }

    /**
     * CAMBIAMOS UN POCO EL ENUNCIADO
     * DEVUELVO UN HashSet de Ordenadores en lugar de un HashSet de c?digos de ordenador
     */
    public HashSet<Ordenador> masBaratos() {
        HashSet<Ordenador> setBaratos=new HashSet<>();
        double precioMin= Double.MAX_VALUE;
        for (Ordenador ord : ordenadores) {
            if(ord.getPrecio()<precioMin){//Si hallamos un nuevo "menor precio"
                //Nos guardamos el nuevo precio en nuestra variable precioMin, que rige el algoritmo
                precioMin=ord.getPrecio();
                //Tenemos que vaciar el set de cualquier otro c?digo que pudiese tener
                setBaratos.clear();
                //A?adimos el c?digo
                setBaratos.add(ord);
            }
            else if(ord.getPrecio()==precioMin){//Si hallamos otro ordenador con el mismo precio
                //En este caso, no limpiamos el set. S?lo a?adimos
                setBaratos.add(ord);
            }
        }
        return setBaratos;
    }

    /**
     * Borra de la tienda los ordenadores m?s baratos
     */
    public void borrarMasBaratos() {
        ordenadores.removeAll(masBaratos());
    }


    /**
     * Representaci?n textual de la tienda
     */
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("\nTienda: ").append(nombre).append("\n");
        sb.append("******* Lista de ordenadores *******\n");
        for (Ordenador ord : ordenadores) {
            sb.append(ord);
        }
        return sb.toString();
    }

}
