package ordenadores.modelo;

/**
 * @author
 */
public class Ordenador {

    private String codigo;
    private double precio;
    private String slogan;

    /**
     * Constructor
     */
    public Ordenador(String codigo, double precio, String slogan) {
        this.codigo = codigo;
        this.precio = precio;
        this.slogan = slogan;
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
    public String getSlogan() {
        return slogan;
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

    /**
     *
     */
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    /**
     *
     */
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Precio: " + precio + "\n" +
                "Slogan: " + slogan + "\n";
    }

}
