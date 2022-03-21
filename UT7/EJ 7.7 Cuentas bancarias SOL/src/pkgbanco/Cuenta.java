package pkgbanco;

/**
 * Modela una cuenta bancaria
 *
 */
public class Cuenta {

    private String nombre;
    private double importe;

    public Cuenta() {
    }

    /**
     */
    public Cuenta(String nombre, double importe) {

        this.nombre = nombre;
        this.importe = importe;
    }

    /**
     * accesor para el nombre del cliente
     */
    public String getNombre() {

        return nombre;
    }

    /**
     * mutador para el nombre del cliente
     */
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    /**
     * accesor para el importe
     */
    public double getImporte() {

        return importe;
    }

    /**
     * añade cantidad al importe
     */
    public void ingresar(double cantidad) {

        if (cantidad > 0) {
            this.importe += cantidad;
        }
    }

    /**
     * reintegra (saca) cantidad de importe
     */
    public void reintegrar(double cantidad) {

        if (cantidad > 0) {
            if (importe >= cantidad) {
                this.importe -= cantidad;
            }
        }
    }

    /**
     * Representación textual de la cuenta
     */
    public String toString() {

        return "Nombre: " + nombre + "\nImporte: " + importe + "\n";
    }

}
