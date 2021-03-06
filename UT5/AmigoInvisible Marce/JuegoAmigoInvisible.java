import java.util.Arrays;
import java.util.Random;

public class JuegoAmigoInvisible {
    private static final int MAX_PARTICIPANTES = 50;
    private static Random generador = new Random();
    private Participante[] participantes;
    private int pos;

    /**
     * crea la "bolsa" de participantes al tama?o m?ximo
     */
    public JuegoAmigoInvisible() {
         participantes = new Participante[MAX_PARTICIPANTES];
    }

    /**
     * A?ade un participante al final de la bolsa si no est? llena
     * se asume que el participante no existe
     */
    public void add(Participante participante) {
        if(!estaLlena()){
            participantes[pos]=participante;
            pos++;
        }
    }

    /**
     * devuelve el total de participantes
     */
    public int totalParticipantes() {
        return pos;
    }

    private boolean estaLlena(){
        return pos==participantes.length;
    }
    /**
     * devuelve una copia con el n?mero real de participantes
     */
    public Participante[] getParticipantes() {
        return Arrays.copyOf(participantes,pos);
    }

    /**
     * dado un nombre de participante devuelve la posici?n donde se encuentra o -1 si 
     * no est?
     * Nota -  para comparar cadenas haremos cadena1.equalsIgnoreCase(cadena2) 
     * que devuelve true si cadena1 es igual a cadena2 
     * (sin importar may?sculas o min?sculas)
     */
    private int buscarParticipante(String nombre) {
        for(int i=0;i<pos;i++){
            if(participantes[i].getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }

    /**
     *  dado un nombre de participante indica si est? ya en la bolsa
     */
    public boolean estaParticipante(String nombre) {
        return buscarParticipante(nombre)!=-1;
    }

    /**
     * dado un nombre de participante devuelve el objeto asociado a ?l 
     *  
     */
    public Participante datosDe(String nombre) {
        nombre = nombre.toUpperCase();
        int p=buscarParticipante(nombre);
        if (p == -1) {
            throw new RuntimeException("Error, no existe ese participante");
        }
        return participantes[p];
    }

    /**
     * Representaci?n textual de todos los participantes
     *  
     */
    public String toString() {
        //Soluci?n "vaga" sin bucle (queda sin saltos de l?nea tras cada participante)
        return Arrays.toString(Arrays.copyOf(participantes,pos));
    }

    /**
     * "Revuelve" la bolsa de participantes. 
     * Se puede hacer de forma sencilla
     * intercambiando un n? determinado de veces pares de elementos 
     * del array participantes de posiciones aleatorias
     * 
     */
    public void revolverParticipantes() {
        for(int i=0;i<100;i++){
            int pos1=generador.nextInt(pos);
            int pos2=generador.nextInt(pos);
            Participante aux=participantes[pos1];
            participantes[pos1]=participantes[pos2];
            participantes[pos2]=aux;
        }
    }

    /**
     * Elimina todas las asignaciones de emisor y receptor
     * de todos los participantes
     */
    public void reset() {
        for(int i=0;i<pos;i++){
            participantes[i].setEmisor(null);
            participantes[i].setReceptor(null);
        }
    }

    /**
     * Realiza la asignaci?n a cada participante del amigo invisible
     * previo "barajeo" de la bolsa inicial
     */
    public void asignarAmigos() {
        //Barajamos
        revolverParticipantes();
        //Recorremos el array al completo, controlando con dos if las dos posiciones especiales (primera y ?ltima)
        for(int i=0;i<pos;i++){
            if (i!=pos-1){
                participantes[i].setReceptor(participantes[i+1]);
            }
            if(i!=0){
                participantes[i].setEmisor(participantes[i-1]);
            }
        }
        //A?adimos las dos condiciones especiales que no cumplimentamos en el bucle
        //El emisor del primero es el ?ltimo
        participantes[0].setEmisor(participantes[pos-1]);
        //El receptor del ?ltimo es el primero
        participantes[pos-1].setReceptor(participantes[0]);
    }

    /**
     * dado un participante lo borra. Se devuelve true si la operaci?n ha tenido ?xito 
     * (estaba el participante) o false si no ha habido ?xito (el participante no exist?a)
     * Cada vez que se borra un participante hay que eliminar 
     * todas las asignaciones de emisor y receptor
     */
    public boolean borrarParticipante(String nombre) {
       int p=buscarParticipante(nombre);
       if(pos!=-1){//Est? en la lista. Procedemos a borrarlo
           //Movemos todos los elementos a la derecha del participante a borrar una posici?n a la izquierda
           System.arraycopy(participantes,p+1,participantes,p,pos-p-1);
           //Decrementamos el atributo con el tama?o l?gico
           pos--;
           reset();
           return true;
       }
       else{
           return false;
       }
       

    }

    /**
     * borra todos los participantes
     */
    public void borrarTodos() {
        pos=0;
    }
}
