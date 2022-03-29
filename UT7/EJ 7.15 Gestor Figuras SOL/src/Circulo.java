import java.awt.*;

/**
 * Modela un círculo de radio determinado
 *
 *
 */

public class Circulo extends Figura{
    private double radio;

    /**
     * Constructor de la clase Circulo
     *
     */
    public Circulo(int x, int y, Color c, double radio) {
        super(x, y, c);
        this.radio = radio;
    }

    /**
     *
     * @return el valor del radio
     */
    public double getRadio() {
        return radio;
    }


    /**
     * Devuelve el área de la figura
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radio,2);
    }

    /**
     * Devuelve el perímetro de la figura
     */
    @Override
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }

    /**
     * Representación textual de una figura
     */
    @Override
    public String toString() {
        return super.toString() +
                "Radio: " + String.format("%5.2f",radio) + "\n";
    }
}
