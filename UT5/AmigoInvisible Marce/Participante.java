
public class Participante 
{
    private String nombre;
    private Participante emisor;
    private Participante receptor;

    /**
     * Constructor
     * Cuando se crea un participante emisor y receptor
     * están a null (ni se regala ni se recibe de nadie)
     */
    public Participante(String nombre) {
        this.nombre = nombre.toUpperCase();
        this.emisor = null;
        this.receptor = null;
    }

    /**
     * accesor para el nombre del participante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre del participante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para el emisor del participante
     * (a quién regala)
     */
    public Participante getEmisor() {
        return emisor;
    }

    /**
     * mutador para el emisor del participante
     * Establecer a quién regala
     */
    public void setEmisor(Participante emisor) {
        this.emisor = emisor;
    }

    /**
     * accesor para el receptor (de quién recibe)
     */
    public Participante getReceptor() {
        return receptor;
    }

    /**
     * mutador para el receptor (establecer de quién recibe)
     */
    public void setReceptor(Participante receptor) {
        this.receptor = receptor;
    }

    /**
     * Representación textual del participante
     */
    public String toString() {
        String str = nombre + " envía a ";

        if (emisor == null) {
            str += " NADIE";
        } else {
            str += emisor.getNombre();
        }
        str += " y recibe de ";
        if (receptor == null) {
            str += " NADIE";
        } else {
            str += receptor.getNombre();
        }
        return str;
    }
}
