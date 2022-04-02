
/**
 *   clase FicheroMusica  
 *
 */
public class FicheroMusica extends Fichero{
    int duracion;

    /**
     * Constructor de la clase FicheroMusica
     */
    public FicheroMusica(String titulo, int tamaño, int duracion) {
        super(titulo, tamaño);
        this.duracion = duracion;
    }

    /**
     *  devuelve la duración en segundos  
     */
    public int getDuracion() {

        return duracion;
    }

    /**
     * Muestra los datos del fichero de música
     * La duración se muestra en formato  XX:XX  (minutos, segundos)
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Duración: " + duracionAMinSecs());
    }

    /**
     * Añadido al proyecto base
     * Pasa la duración en segundos como int
     * a duración en minutos segundos como String
     * en formato: XX:XX
     */
    private String duracionAMinSecs(){
        int minutos=getDuracion()/60;
        int segundos=getDuracion()%60;
        return String.format("%02d",minutos) + ":" + String.format("%02d",segundos);
    }
}
