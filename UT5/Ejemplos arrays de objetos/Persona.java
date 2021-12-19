
/**
 * Representa a una persona 
 * 
 */
public class Persona
{
    private String nombre;
    private int edad;
     
    /**
     * Constructor de la clase Persona
     */
    public Persona(String nombre, int edad)    {
       this.nombre = nombre;
       this.edad = edad;
    }
    
      
    /**
     * Accesor para el nombre
     *
     */
    public String getNombre()   {
        return nombre;
    }
    
     /**
     * Mutador para el nombre
     *
     */
    public void setNombre(String nombre)   {
         this.nombre = nombre;
    }
     /**
     * Accesor para la edad
     *
     */
    public int getEdad()   {
        return edad;
    }

      /**
     * Mutador para la edad
     *
     */
    public void setEdad(int edad)   {
         this.edad = edad;
    }
    
  
    
    /**
     * Representación textual de un objeto Persona
     *  
     */
    public String toString()   {
        return "Nombre: " + nombre +
               "\nEdad: " + edad + "\n";
                
    }
}
