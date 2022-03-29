package concesionario.modelo;

import java.awt.*;

/**
 *  clase CocheDeportivo 
 *
 */

public class CocheDeportivo extends Coche{
    //sin atributos, solo los heredados


    public CocheDeportivo(String conductor, String modelo, String color) {


        super(conductor, modelo, color,new Point(0,200));
    }

    @Override
    public void avanza() {
        double aleatorio=Math.random();
        Point pos=getPosicion();
        if(aleatorio>=0.7){
            //El método translate añade (o resta con valores negativos) a un objeto Point
            // lo que le indiquemos para la x y para la y
            //Recordad que la posicion es un Point, tal y como lo hemos declarado en Coche
            pos.translate(50,0);
        }
        else
            pos.translate(30,0);
    }

}
      
