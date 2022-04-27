
/**
 * 
 */
public class HoraExcepcion extends RuntimeException
{
     private String mensaje;

    /**
     * Constructor  
     */
    public HoraExcepcion(String mensaje)
    {
         this.mensaje = mensaje;
    }

    /**
     *  
     */
    public String toString()
    {
         return "Error producido " + mensaje;
    }
}
