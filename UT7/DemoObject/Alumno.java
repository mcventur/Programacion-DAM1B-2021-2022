
/**
 *  
 */
public class Alumno  implements Comparable<Alumno> 
{

    private String nombre;
    private int nota;

    /**
     * Constructor  
     */
    public Alumno(String nombre, int nota)    {
        this.nombre = nombre;
        this.nota = nota;
    }

    /**
     *  
     * 
     */
    public String getNombre()    {
        return nombre;
    }

    /**
     *  
     * 
     */
    public int getNota()    {
        return nota;
    }

    /**
     * Redefinición de equals()
     */
    public  boolean equals(Object obj)    {
        if (obj == null)    {
            return false;
        }
        if (this == obj)    {
            return true;
        }        
        if (this.getClass() != obj.getClass())   {
            return false;
        }
        Alumno a = (Alumno) obj;    
        return  a.getNombre().equalsIgnoreCase(this.nombre) &&
            a.getNota() == this.nota;
    }

    /**
     * Redefinición de hashCode
     */
    public int hashCode()    {
        return  nota + nombre.hashCode() * 11; 
    }

    /**
     *  
     * 
     */
    public int compareTo(Alumno a)    {
        int r = this.nombre.compareToIgnoreCase(a.getNombre());
        if (r == 0)  {
            // return  this.nota - a.getNota();
            return Integer.compare(this.nota, a.getNota());

        }
        return r;
    }

    /**
     *  
     * 
     */
    public String toString()    {
        //Class c = this.getClass();        
        return this.getClass().getName() + ": " + nombre + " - " + nota;
    }


}

