package pkgformacion.modelo;


/**
 *  Representa un cursillo
 */
public class Cursillo
{

    private String nombre;
    private int horas;

    /**
     * Constructor  
     */
    public Cursillo(String nombre, int horas)
    {
        this.nombre = nombre;
        this.horas = horas;
    }

    /**
     *  accesor para el nombre
     *  
     * 
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * accesor para las horas
     */
    public int getHoras()
    {
        return horas;
    }

     
     /**
     * Dos cursillos son iguales si
     * tienen el mismo nombre y mismo nº de horas de duración
     * 
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;        
        }
        Cursillo c = (Cursillo) obj;        
        return this.getNombre().equalsIgnoreCase(c.getNombre()) &&
            this.getHoras() == c.getHoras();

    }

    /**
     * Redefinición de hashCode()
     */
    public  int hashCode()
    {
        return this.nombre.hashCode();
    }
	
    /**
     * Representación textual de un cursillo
     */
    public  String toString()
    {
        return nombre + " - " + horas + " horas";
    }

}
