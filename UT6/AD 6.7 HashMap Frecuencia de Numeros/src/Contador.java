
/**
 * Modela un contador
 */
public class Contador
{
    
    private int valor;

    /**
     * Constructor
     */
    public Contador()
    {
       valor = 0;
    }
    
    /**
     * Constructor parametrizado
     */
    public Contador(int valor)
    {
        if (valor >=0) {
            this.valor = valor;
		}
        else {
            valor=0;
		}
    }
    /**
     * Constructor parametrizado
     */
    public Contador(Contador otroContador)
    {
		valor = otroContador.getContador();
    }

    /**
     * accesor
     */

    public int getContador()
    {
        return valor;
    }
    
    /**
     * mutador
     */
    public void incrementar()
    {
        valor++;
    }
    
     /**
     * mutador
     */
    public void decrementar()
    {
        if (valor>0) {
            valor--;
		}
    }
    
    /**
     * Representación en formato texto del contador
     */
    public String toString()
    {
        return "Valor " + valor;
    }
    
    
}
