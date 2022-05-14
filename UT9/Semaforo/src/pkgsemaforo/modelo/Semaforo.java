package pkgsemaforo.modelo;

import javafx.scene.paint.Color;

/**
 * Modela un Semaforo
 */
public class Semaforo {

    private Color color;

    /**
     * Constructor de la clase Semaforo
     */
    public Semaforo() {

        color = Color.GREEN;
    }

    /**
     * Obtener el color del semáforo
     */
    public Color getColor() {

        return color;
    }

    /**
     * Actualizar color del semáforo
     */
    public void avanzar() {
        if(color == Color.GREEN){
            color = Color.RED;
        }
        else if(color == Color.RED){
            color = Color.ORANGE;
        }
        else{
            color = Color.GREEN;
        }

    }

    /**
     * Cambiar el color
     */
    public void setColor(Color color) {

        this.color = color;
    }

}
