
/**
 *
 */
public class Aula implements Comparable<Aula>, Cloneable {
    
    private String nombre;
    private int pupitres;
    
    /**
     * Constructor  
     */
    public Aula(String nombre, int pupitres) {
        this.nombre = nombre;
        this.pupitres = pupitres;
        
    }
    
    /**
     *  accesor para el nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     *  accesor para los pupitres
     */
    public int getPupitres() {
        return pupitres;
    }
    
    /**
     *  mutador para el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *  mutador para los pupitres
     */
    public void setPupitres(int pupitres) {
        this.pupitres = pupitres;
    }
    
    /**
     *
     */
    public void mostrar() {
        System.out.println(this.getClass().getSimpleName() +
                "\t" + nombre + "\t" + pupitres + " pupitres");
    }
    
    /**
     *
     *
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Aula a = (Aula) obj;
        return this.nombre.equalsIgnoreCase(a.getNombre());
    }
    
    /**
     *
     *
     */
    public int hashCode() {
        return nombre.hashCode();
    }
    
    /**
     *
     *
     */
    public int compareTo(Aula a) {
        
        return this.nombre.compareToIgnoreCase(a.getNombre());
    }
    
    /**
     *
     */
    public Aula clone() {
        try {
            return (Aula) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
        
    }
    
}
