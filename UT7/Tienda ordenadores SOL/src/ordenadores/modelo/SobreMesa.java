package ordenadores.modelo;

/**
 * @author
 */
public class SobreMesa extends Ordenador{
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
    public String toString() {
        return super.toString() +
                "Descripcion: " + descripcion + "\n\n";
    }
}
