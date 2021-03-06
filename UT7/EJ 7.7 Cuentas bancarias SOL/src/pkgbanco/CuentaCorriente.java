package pkgbanco;

public class CuentaCorriente extends Cuenta{
    private final double RECARGO=20;
    private double importeMinimo;

    public CuentaCorriente(String nombre, double importe, double importeMinimo) {
        super(nombre, importe);
        this.importeMinimo = importeMinimo;
    }

    /**
     * ObtenerRecargo
     * Devuelve el recargo. 0 si el importe de la cuenta no est? por debajo del m?nimo
     */
    public double obtenerRecargo(){
        if(getImporte()<importeMinimo){
            return RECARGO;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Importe m?nimo: " + importeMinimo + "\n" +
                "Recargo: " + obtenerRecargo();
    }
}
