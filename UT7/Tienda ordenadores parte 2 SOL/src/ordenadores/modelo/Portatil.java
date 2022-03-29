package ordenadores.modelo;

/**
 * @author Marce Penide
 */
public class Portatil extends Ordenador{

    public static final String SLOGAN = "Ideal para viajes";
    public static final double DESCUENTO = 0.2;
    private double peso;



    /**
     * Constructor
     */
    public Portatil(String codigo, double precio, String slogan, double peso) {
        super(codigo, precio, slogan);
        this.peso=peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String getSlogan() {
        return SLOGAN;
    }

    /**
     * Calcula el precio del ordenador
     * Portátiles: 2% de dto.
     * Sobremesa: 10% de dto.
     *
     * @return el importe de descuento
     */
    @Override
    public double calcularDescuento() {
        return getPrecio() * DESCUENTO / 100;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Peso: " + peso + "\n\n";
    }
}
