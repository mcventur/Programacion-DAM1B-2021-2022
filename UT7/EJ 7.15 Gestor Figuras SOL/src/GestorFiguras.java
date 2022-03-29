import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase GestorFiguras
 */


public class GestorFiguras {
    //Declaramos como una Lista genérica de la interfaz List.
    private List<Figura> figuras; // la colección de figuras

    /**
     * Constructor de la clase GestorFiguras
     */
    public GestorFiguras() {
        //Inicializamos como un subtipo concreto: un ArrayList
        figuras = new ArrayList<>();
    }

    /**
     * @param f una nueva figura a añadir
     */
    public void addFigura(Figura f) {
        figuras.add(f);
    }

    /**
     * Mostrar todas las figuras
     */
    public void listarFiguras() {
        listarFiguras(figuras);
    }

    /**
     *
     */
    private void listarFiguras(List<Figura> figuras) {
        for (Figura figura : figuras) {
            System.out.println(figura);
        }
    }


    /**
     * @return la figura de mayor área
     */
    public Figura mayorArea() {
        Figura figMaxArea = figuras.get(0);
        for (Figura figura : figuras) {
            if(figura.area()>figMaxArea.area()){
                figMaxArea=figura;
            }
        }
        return figMaxArea;
    }

    /**
     * @param color el color de la figura a borrar
     */
    public void borrarDeColor(Color color) {
        Iterator<Figura> itFiguras = figuras.iterator();
        while (itFiguras.hasNext()) {
            Figura fig = itFiguras.next();
            if(fig.getColor().equals(color)){ //USAMOS equals siempre para comprobar si dos variables de tipo referencia son iguales
                itFiguras.remove();
            }
        }
    }

    /**
     * @param f la figura con la que comparar, se borrar
     *          las que son iguales a ella
     */
    public void borrarIguales(Figura f) {
        Iterator<Figura> itFiguras = figuras.iterator();
        while (itFiguras.hasNext()) {
            Figura fig = itFiguras.next();
            if(fig.equals(f)){
                itFiguras.remove();
            }
        }
    }


}
