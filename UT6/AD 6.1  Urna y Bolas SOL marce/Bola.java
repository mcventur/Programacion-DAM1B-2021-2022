import java.util.Random;

/**
 * Representa a una bola
 */

public class Bola {

    private Color color; // Color es un tipo enumerado

    /**
     * Constructor
     */
    public Bola() {
        /*
        Primera opción: Generar aquí un aleatorio y aplicarlo con un if
        Random generador=new Random();
        boolean aleatorio= generador.nextBoolean();
        if(aleatorio)
            color=Color.BLANCO;
        else
            color=Color.NEGRO;
         */

        //Segunda opción: usando un método programado en el propio enum
        //this.color = Color.getColorAleatorio();
        this.color = color.getColorAleatorio();
    }

    /**
     * Accesor para el color de la bola
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return true si es blanca
     */
    public boolean esBlanca() {
        return color == Color.BLANCO;
    }

    /**
     * @return true si es negra
     */
    public boolean esNegra() {
        return color == Color.NEGRO;
    }

    /**
     * return el color de la bola en formato String
     */
    public String getColorString() {
        return color.toString();
    }

    /**
     * Representación textual de una bola
     */
    public String toString() {
        return "Bola de color " + getColorString();
    }


}
