 
public class ExcepcionPropia extends Exception
{
    
   private String mensaje;

    /**
     * Constructor de la clase ExcepcionPropia
     */
    public ExcepcionPropia(String mensaje)    {
         this.mensaje = mensaje;
    }

    /**
     *       
     */
    public String toString()    {
         return "Error, " + mensaje;
    }
}
