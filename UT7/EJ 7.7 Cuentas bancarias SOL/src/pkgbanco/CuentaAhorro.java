package pkgbanco;

public class CuentaAhorro extends Cuenta {
    private double tipoInteres;

    /**
     * Crea una CuentaAhorro con su tipo de inter?s
     * @param nombre
     * @param importe
     * @param tipoInteres
     */
    public CuentaAhorro(String nombre, double importe, double tipoInteres) {
        super(nombre, importe);
        this.tipoInteres = tipoInteres;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }


    /**
     * @return el inter?s calculado
     */
    public double obtenerInteres(){
        return getImporte()*tipoInteres/100;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Inter?s aplicado: (" + tipoInteres + ") " + obtenerInteres() + "\n";
    }
}
