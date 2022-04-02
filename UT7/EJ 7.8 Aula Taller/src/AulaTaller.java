
/**
 *   un aula taller es un aula con un nº
 *   de ordenadores
 */
public class AulaTaller extends Aula {
    
    private int ordenadores;
    
    /**
     * Constructor  
     */
    public AulaTaller(String nombre, int pupitres, int ordenadores) {
        super(nombre, pupitres);
        this.ordenadores = ordenadores;
    }
    
    /**
     *
     */
    public void mostrar() {
        super.mostrar();
        System.out.println(ordenadores + " ordenadores");
    }
    
    
}
