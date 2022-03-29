import java.awt.*;

/**
 * Representa a un cuadrado
 *
 *
 */

public class Cuadrado extends Figura{
    private double lado;

    /**
     * Constructor de la clase Cuadrado
     *
     *
     */
    public Cuadrado(int x, int y, Color c, double lado) {
        super(x, y, c);
        this.lado = lado;
    }

    /**
     * Devuelve el �rea de la figura
     */
    @Override
    public double area() {
        return lado*lado;
    }

    /**
     * Devuelve el per�metro de la figura
     */
    @Override
    public double getPerimetro() {
        return lado*4;
    }

    /**
     * Representaci�n textual de una figura
     */
    @Override
    public String toString() {
        return super.toString() +
                "Lado: " + String.format("5.2f",lado) + "\n";
    }
}