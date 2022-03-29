import java.awt.*;

/**
 * Modela un triángulo
 *
 */


public class Triangulo extends Figura{
    private double lado1, lado2, lado3;
    /**
     * Constructor de la clase Triángulo
     *
     */
    public Triangulo(int x, int y, Color c, double lado1, double lado2, double lado3) {
        super(x, y, c);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    /**
     * Devuelve el área de la figura
     */
    @Override
    public double area() {
        double semiper=getSemiPerimetro();
        return Math.sqrt(semiper * (semiper-lado1) * (semiper-lado2) * (semiper-lado3));
    }

    /**
     * Devuelve el perímetro de la figura
     */
    @Override
    public double getPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public double getSemiPerimetro(){
        return getPerimetro()/2;
    }

    /**
     * Representación textual de una figura
     */
    @Override
    public String toString() {
        return super.toString() +
                "Lado1: " + lado1 + "\n" +
                "Lado2: " + lado2 + "\n" +
                "Lado3: " + lado3 + "\n";
    }

    @Override
    public boolean equals(Object otro) {
        /*
        Hay que usar un if para condicionar el casting
        Si se hace el casting antes de pasar la validación de super
        puede pasar que dos objetos no sean de la misma clase, dando un error
        invalidClassCastException
        */
        if(super.equals(otro)){
            Triangulo t = (Triangulo) otro;
            return t.getLado1()==this.lado1 &&
                    t.getLado2()==this.lado2 &&
                    t.getLado3()==this.lado3;
        }
        else return false;

    }


}

