package ordenadores.modelo;

/**
 * @author
 */
public abstract class Ordenador {

    private String codigo;
    private double precio;

    /**
     * Constructor
     */
    public Ordenador(String codigo, double precio, String slogan) {
        this.codigo = codigo;
        this.precio = precio;
    }

    /**
     *
     */
    public String getCodigo() {
        return codigo;
    }


    /**
     *
     */
    public double getPrecio() {
        return precio;
    }


    /**
     *
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract String getSlogan();

    /**
     * Calcula el precio del ordenador
     * Portátiles: 2% de dto.
     * Sobremesa: 10% de dto.
     * @return el importe de descuento
     */
    public abstract double calcularDescuento();



    /**
     *
     */
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Precio: " + precio + "\n" +
                "Slogan: " + getSlogan() + "\n" +
                "Descuento: " + calcularDescuento() + "\n";
    }

}
