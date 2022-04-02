package ordenadores.modelo;

/**
 *
 */
public class Portatil extends Ordenador implements Portable {
    private static final double DESCUENTO = 2;
    private double peso;

    /**
     * Constructor
     */
    public Portatil(String codigo, double precio,
                    double peso) {
        super(codigo, precio);
        this.peso = peso;
    }

    /**
     *
     */
    public double getPeso() {
        return peso;
    }

    /**
     *
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     *
     */
    public String getSlogan() {
        return "Ideal para viajes";
    }

    public double calcularDescuento() {
        return getPrecio() * DESCUENTO / 100;
    }


    /**
     *
     */
    public String toString() {
        return super.toString() +
                "Peso: " + peso + "\n\n";
    }

    /**
     *
     */
    public void cargarBateria() {
        System.out.println("Cargando batería ...");
    }

    /**
     *
     */
    public void funcionarConBateria() {
        System.out.println("Funcionado con batería ...");
    }
}
