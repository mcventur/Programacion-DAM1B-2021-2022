import java.util.Arrays;
import java.util.Random;

public class JuegoAmigoInvisible {
    private static final int MAX_PARTICIPANTES = 50;
    private static Random generador = new Random();
    private Participante[] participantes;
    private int pos;

    /**
     * crea la "bolsa" de participantes al tamaño máximo
     */
    public JuegoAmigoInvisible() {
         participantes = new Participante[MAX_PARTICIPANTES];
    }

    /**
     * Añade un participante al final de la bolsa si no está llena
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
     * devuelve una copia con el número real de participantes
     */
    public Participante[] getParticipantes() {
        return Arrays.copyOf(participantes,pos);
    }

    /**
     * dado un nombre de participante devuelve la posición donde se encuentra o -1 si 
     * no está
     * Nota -  para comparar cadenas haremos cadena1.equalsIgnoreCase(cadena2) 
     * que devuelve true si cadena1 es igual a cadena2 
     * (sin importar mayúsculas o minúsculas)
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
     *  dado un nombre de participante indica si está ya en la bolsa
     */
    public boolean estaParticipante(String nombre) {
        return buscarParticipante(nombre)!=-1;
    }

    /**
     * dado un nombre de participante devuelve el objeto asociado a él 
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
     * Representación textual de todos los participantes
     *  
     */
    public String toString() {
        //Solución "vaga" sin bucle (queda sin saltos de línea tras cada participante)
        return Arrays.toString(Arrays.copyOf(participantes,pos));
    }

    /**
     * "Revuelve" la bolsa de participantes. 
     * Se puede hacer de forma sencilla
     * intercambiando un nº determinado de veces pares de elementos 
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
     * Realiza la asignación a cada participante del amigo invisible
     * previo "barajeo" de la bolsa inicial
     */
    public void asignarAmigos() {
        //Barajamos
        revolverParticipantes();
        //Recorremos el array al completo, controlando con dos if las dos posiciones especiales (primera y última)
        for(int i=0;i<pos;i++){
            if (i!=pos-1){
                participantes[i].setReceptor(participantes[i+1]);
            }
            if(i!=0){
                participantes[i].setEmisor(participantes[i-1]);
            }
        }
        //Añadimos las dos condiciones especiales que no cumplimentamos en el bucle
        //El emisor del primero es el último
        participantes[0].setEmisor(participantes[pos-1]);
        //El receptor del último es el primero
        participantes[pos-1].setReceptor(participantes[0]);
    }

    /**
     * dado un participante lo borra. Se devuelve true si la operación ha tenido éxito 
     * (estaba el participante) o false si no ha habido éxito (el participante no existía)
     * Cada vez que se borra un participante hay que eliminar 
     * todas las asignaciones de emisor y receptor
     */
    public boolean borrarParticipante(String nombre) {
       int p=buscarParticipante(nombre);
       if(pos!=-1){//Está en la lista. Procedemos a borrarlo
           //Movemos todos los elementos a la derecha del participante a borrar una posición a la izquierda
           System.arraycopy(participantes,p+1,participantes,p,pos-p-1);
           //Decrementamos el atributo con el tamaño lógico
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
