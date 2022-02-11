
/**
 * La clase mantiene información sobre un estudiante
 * 
 */

public class Estudiante 
{
    private String nombre;
    private int nota;
  
    /**
     * constructor para los objetos de la clase Estudiante
     */
    public Estudiante(String nombre, int nota)
    {
        this.nombre = nombre;
        this.nota = nota;
    }

    /**
     * Accesor para el nombre   
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Accesor para la nota 
     */
    public int getNota()
    {
        return nota;
    }
          
     /**
     * Mutador para la nota 
     */
    public void setNota(int nota)
    {
        this.nota = nota;
    }
        
    /**
     * Representación textual del estudiante
     */
    public String toString()
    {
        return "Nombre: " + nombre  + "\n" +
           "Nota: " + getNota() + "\n";
       
    }
       
}
