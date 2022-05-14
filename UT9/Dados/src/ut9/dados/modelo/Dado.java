package ut9.dados.modelo;

/**
 * Modela un dado de de 6 caras
 */

import java.util.Random;

import javafx.scene.image.Image;

public class Dado {
    private int cara;
    private Random generador;

    /**
     * Constructor de la clase Dado
     */
    public Dado() {
        generador = new Random();
        cara = 1;
    }

    /**
     * Accesor
     *
     * @return el valor actual de la cara del dado
     */
    public int getCara() {

        return cara;
    }

    /**
     * Simula el lanzamiento del dado
     */

    public void tirarDado() {

        cara = generador.nextInt(6) + 1;
    }

    /**
     * Obtener imagen del dado
     */
    public Image getImagen() {
        String[] nombreImagenes = {"1.gif", "2.gif", "3.gif", "4.gif", "5.gif",
                "6.gif"};
        return new Image(getClass().getResourceAsStream(
                "/images/" + nombreImagenes[getCara() - 1]));


    }

}
