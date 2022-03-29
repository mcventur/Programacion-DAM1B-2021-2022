package ordenadores.modelo;

/**
 * @author
 */
public class SobreMesa extends Ordenador{
    public static final String SLOGAN = "El que más pesa, pero el que menos cuesta";
    public static final double DESCUENTO = 0.10;
    private String descripcion;

    /**
     * Constructor
     */
    public SobreMesa(String codigo, double precio, String slogan, String descripcion) {
        super(codigo, precio, slogan);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return getPrecio() * DESCUENTO /100;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Descripcion: " + descripcion + "\n\n";
    }
}
