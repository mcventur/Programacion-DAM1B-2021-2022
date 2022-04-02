
/**
 *   Criterio natural de ordenación (orden ascendente de nombre)
 *   Es el que marca el interface Comparable
 */
public class Pais implements  Comparable<Pais>, Cloneable
{
    private String nombre;
    private double superficie;
    private int habitantes;

    /**
     * 
     */
    public  Pais(String nombre, double superficie, int habitantes)    {
        this.nombre = nombre;
        this.superficie = superficie;
        this.habitantes = habitantes;
    }

    /**
     * 
     */
    public  String getNombre()    {
        return nombre;
    }

    /**
     * 
     */
    public  double getSuperficie()    {
        return superficie;
    }

    /**
     * 
     */
    public  void setSuperficie(double superficie)    {
        this.superficie = superficie;

    }

    /**
     * 
     */
    public  int getHabitantes()    {
        return habitantes;
    }

    /**
     * 
     */
    public  void setHabitantes(int habitantes)    {
        this.habitantes = habitantes;

    }

    /**
     *  
     */
    public int compareTo(Pais p)    {
        return this.nombre.compareToIgnoreCase(p.getNombre());

    }

    /**
     * 
     */
    public  Pais clone()  throws CloneNotSupportedException {
        return (Pais) super.clone();
    }
    
    


    /**
     *  
     */
    public boolean equals(Object obj)
    {
        if (obj == null)     {
            return false;
        }
        if (this == obj)    {
            return true;
        }
        if (this.getClass() != obj.getClass())   {
            return false;
        }
        Pais p = (Pais) obj;
        return this.getNombre().equalsIgnoreCase(p.getNombre());
    }

    /**
     *  
     */
    public  int hashCode()
    {
        return nombre.hashCode();
    }

    /**
     * 
     */
    public  String toString()
    {
        return this.getClass().getName() + ": " + nombre + 
        "\nSuperficie: " + superficie +
        "\nHabitantes: " + habitantes;
    }
}