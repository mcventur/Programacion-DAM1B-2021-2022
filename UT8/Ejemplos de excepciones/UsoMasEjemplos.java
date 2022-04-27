
/**
 *  
 */
public class UsoMasEjemplos 
{

    private MasEjemplos  ej;

    /**
     * Constructor de la clase UsoMasEjemplos
     */
    public UsoMasEjemplos()    {
        ej = new MasEjemplos(-6, 9, null);
    }

    /**
     *  
     */
    public void demoFactorial()    {
        try    {
            ej.factorial1();
        }
        catch (FactorialNegativoExcepcion e)    {
            System.out.println(e.getMessage());
           
        }

    }
}