package ut8.matrices.modelo;

public class MatrizExcepcion extends Exception {

    private String mensaje;

    public MatrizExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return mensaje;
    }

}
