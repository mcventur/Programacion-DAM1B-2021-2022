import java.awt.*;

/**
 * Clase Figura
 */


public abstract class Figura {

    private Point centro;
    private Color color;

    /**
     * Constructor de la clase Figura
     * Toda figura tiene un centro y un color
     */
    public Figura(int x, int y, Color c) {
        centro = new Point(x, y);
        color = c;
    }


    /**
     * Accesor para el centro de la figura
     *
     * @return el centro de la figura
     */
    public Point getCentro() {
        return centro;
    }

    /**
     * Accesor para el color de la figura
     *
     * @return el color de la figura
     */
    public Color getColor() {
        return color;
    }

    /**
     * Devuelve el ?rea de la figura
     */
    public abstract double area();

    /**
     * Devuelve el per?metro de la figura
     */
    public abstract double getPerimetro();

    /**
     * Representaci?n textual de una figura
     */
    public String toString() {
        return this.getClass().getName() + " con centro en " + centro.toString() + "\n" +
                "Color: " + color.toString() + "\n" +
                "?rea: " + String.format("%5.2f", area()) + "\n" +
                "Per?metro: " + String.format("%5.2f", getPerimetro()) + "\n";
    }


    //A?adidos para el m?todo borrarIguales de la clase GestorFiguras

    /**
     * Dos figuras son iguales si adem?s de ser del mismo tipo tienen el mismo
     * color y ?rea.
     *
     * @param otro el objeto con el comparamos
     * @return true si son iguales. false en caso contrario
     */
    @Override
    public boolean equals(Object otro) {
        if (otro == null) {
            return false;
        }
        if (otro == this) {
            return true;
        }
        if (this.getClass() != otro.getClass()) {
            return false;
        }
        //Tenemos que hacer cast previamente para poder usar m?todos y atributos de otro como si fuera una figura
        Figura f = (Figura) otro;
        return f.area()==this.area() && f.getColor().equals(this.getColor());

    }
}
