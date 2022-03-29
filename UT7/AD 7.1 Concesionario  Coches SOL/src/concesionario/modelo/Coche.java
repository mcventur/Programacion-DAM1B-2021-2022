package concesionario.modelo;

import java.awt.*;
import java.util.Objects;

/**
 * Modela un cohe
 */

public abstract class Coche {
    private String conductor;
    private String modelo;
    private String color;
    private Point posicion;

    /**
     * Constructor
     */

    public Coche(String conductor, String modelo, String color,
                 Point posicion) {
        this.conductor = conductor;
        this.modelo = modelo;
        this.color = color;
        this.posicion = posicion;
    }

    /**
     * accesor para el conductor
     */
    public String getConductor() {
        return conductor;
    }

    /**
     * accesor para el modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * accesor para el color
     */
    public String getColor() {
        return color;
    }

    /**
     * accesor para la posición
     */
    public Point getPosicion() {
        return posicion;
    }

    /**
     * mutador para el conductor
     */
    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    /**
     * mutador para el modelo
     */
    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    /**
     * mutador para el color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * mutador para la posición
     */
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }


    /**
     * Representación textual del coche
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\nConductor: " + conductor
                + "\nModelo: " + modelo + "\nColor: " + color + "\nPosicion: "
                + posicion.toString();
    }

    @Override
    public int hashCode() {
        return conductor.hashCode() + modelo.hashCode() + color.hashCode();
    }

    /**
     * Define si dos coches son iguales
     * Dos coches son iguales si coinciden color, modelo y conductor (la posición nos da igual)
     * @param obj
     * @return true si sonj iguales. false si no lo son
     */
    @Override
    public boolean equals(Object obj) {
        //Las comparaciones estándar previas:
        if(obj==null) return false; //Si obj es nulo
        if(obj==this) return true; //si apuntan al mismo objeto. Son el mismo objeto
        if(this.getClass()!=obj.getClass()) return false; //Si son de tipos distintos

        //Nuestras comparaciones, nuestro criterio, pasadas las validaciones anteriores
        //Empezamos siempre haciendo casting
        Coche elOtro=(Coche)obj;
        return this.getColor().equals(elOtro.getColor()) &&
                this.getConductor().equals(elOtro.getConductor()) &&
                this.getModelo().equals(elOtro.getModelo());

    }

    /**
     * Modifica el valor de la coordenada x de cada coche: avanza en X
     */
    public abstract void avanza();

}
