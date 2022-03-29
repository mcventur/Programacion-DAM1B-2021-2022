package concesionario.modelo;

import java.awt.*;

/**
 * Representa a un taxi
 */

public class Taxi extends Coche{

    public Taxi(String conductor, String modelo, String color, int posx, int posy) {
        super(conductor, modelo, color, new Point(posx,posy));
    }

    @Override
    public void avanza() {
        double aleatorio=Math.random();
        Point pos=getPosicion();
        if(aleatorio>=0.33){
            //El método translate añade (o resta con valores negativos) a un objeto Point
            // lo que le indiquemos para la x y para la y
            //Recordad que la posicion es un Point, tal y como lo hemos declarado en Coche
            pos.translate(35,0);
        }
        else
            pos.translate(15,0);
    }
}
