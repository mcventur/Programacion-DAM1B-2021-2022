
/**
 *  
 */
public class Alumno implements Cloneable
{

    private String nombre;
    private int nota;
    private Coche coche;

    /**
     * Constructor  
     */
    public Alumno(String nombre, int nota, Coche c)    {
        this.nombre = nombre;
        this.nota = nota;
        this.coche = c;
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
     *  
     * 
     */
    public Coche getCoche()    {
        return coche;
    }

    /**
     *  
     * 
     */
    public void setCoche(Coche c)    {
        this.coche = c;
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
        if (this.getClass() != obj.getClass())        {
            return false;
        }
        Alumno a = (Alumno) obj;       
        return this.nombre.equalsIgnoreCase(a.getNombre()) && this.nota == a.getNota();
    }

    /**
     * Redefinición de hashCode
     */
    public int hashCode()    {
        return  nota + nombre.hashCode() * 11; 
    }
// 
//     /**
//      * redefinición de clone con copia profunda
//      */
    // public  Alumno clone() throws CloneNotSupportedException {
//         Alumno al = (Alumno) super.clone();  
//         Coche c = this.coche.clone();
//         al.setCoche(c);
//         return al;
//     }

     /**
     * redefinición de clone con copia ligera (shallow copy)
     */
    public  Alumno clone()  throws CloneNotSupportedException    {
         
         return (Alumno) super.clone();
    }

    /**
     *  
     * 
     */
    public String toString()    {
        return this.getClass().getName() + "\n" + nombre + " - " + nota +
        "\nCoche " + coche.toString();
    }

    /**
     * 
     */
    public  void print()    {
        System.out.println(this.toString());
    }

}

