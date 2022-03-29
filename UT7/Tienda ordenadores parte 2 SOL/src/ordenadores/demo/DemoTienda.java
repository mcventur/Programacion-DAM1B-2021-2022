package ordenadores.demo;

import ordenadores.modelo.Portatil;
import ordenadores.modelo.SobreMesa;
import ordenadores.modelo.Tienda;

/**
 * @author
 */
public class DemoTienda {

    public static void main(String[] args) {
        Tienda tienda = new Tienda("PeCeOrdenador");
        Portatil p1 = new Portatil("P1", 799, "Ideal para viajes", 1.5);
        Portatil p2 = new Portatil("P2", 599, "Ideal para viajes", 2);
        Portatil p3 = new Portatil("P3", 599, "Ideal para viajes", 2.200);
        SobreMesa s1 = new SobreMesa("s1", 599, "La mejor oferta", "Intel Core i5 2,5 GHz");
        SobreMesa s2 = new SobreMesa("s2", 1300, "Oferta semanal", "Intel Core i7 2600");
        tienda.addOrdenador(p1);
        tienda.addOrdenador(p2);
        tienda.addOrdenador(p3);
        tienda.addOrdenador(s1);
        tienda.addOrdenador(s2);

        System.out.println(tienda.toString());

        System.out.println("Los ordenadores más baratos son " + tienda.masBaratos());

        System.out.println("Nº portátiles: " + tienda.cuantosPortatiles());

        tienda.borrarMasBaratos();

        System.out.println("Después de borrar los más baratos: " + tienda.toString());

    }

}
