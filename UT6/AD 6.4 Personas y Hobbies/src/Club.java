import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */


public class Club {

    private ArrayList<Persona> personas;

    /**
     * Constructor de la clase Club
     */
    public Club() {
        personas = new ArrayList<>();
    }

    /**
     * @param nombre el nombre de la persona que se añade
     * @param hob    el conjunto de hobbies de la persona a añadir
     */
    public void addPersona(String nombre, HashSet<String> hob) {
        //No hay un constructor de Persona que admita pasarle directamente los hobbies. Sólo el nombre
        //Tenemos que registrarla por partes: la creamos (sólo con nombre), y añadimos los hobbies uno a uno
        Persona p=new Persona(nombre);
        //Recorro con iterador, pero valdría un for mejorado
        Iterator<String> itHob=hob.iterator();
        while(itHob.hasNext()){
            p.addHobbie(itHob.next());
        }
        //Ya tenemos la persona lista para añadir a nuestro ArrayList
        personas.add(p);
    }

    /**
     * @param cual el hobbie a comprobar
     * @return el nº de personas del club que tienen ese hobbie
     */
    public int personasConHobbie(String cual) {
        int numPersonas=0;
        Iterator<Persona> itPer=personas.iterator();
        while(itPer.hasNext()){
            //Para cada persona de la lista, usamos el método tieneHobbie para verificar si tiene el hobbie buscado
            Persona persona = itPer.next();
            if(persona.tieneHobbie(cual)){
                numPersonas++;
            }
        }
        return numPersonas;
    }

    /**
     * visualiza la lista de personas
     */

    public void printClub() {
        for(Persona p:personas){
            System.out.println(p);
        }
    }

    /**
     * Borra de la lista las personas con un determinado hobbie
     * y las añade en el conjunto a devolver
     * Usa un iterador
     *
     * @param cual el hobbie a comprobar
     * @return el conjunto de nombres de personas con ese hobbie
     */

    public HashSet<String> borrarPersonasConHobbie(String cual) {
        HashSet<String> retorno=new HashSet<>();//Declaramos el conjunto de retorno. Será un conjunto de nombres, de Strings
        Iterator<Persona> itPer=personas.iterator();
        while (itPer.hasNext()) {
            Persona per = itPer.next();
            if(per.tieneHobbie(cual)){//Si tiene el hobbie
                retorno.add(per.getNombre());//Lo añadimos al conjunto a devolver
                itPer.remove();//Lo borramos de la lista de personas
            }
        }

        return retorno;
    }

    /**
     *
     */
    public static void main(String[] args) {
        Club club = new Club();

        HashSet<String> hobbiesP1 = new HashSet<>(Arrays.asList("bailar", "cantar",
                "leer", "nadar", "caminar", "deporte"));
        club.addPersona("Juan", hobbiesP1);
        HashSet<String> hobbiesP2 = new HashSet<>(Arrays.asList("bailar", "cantar",
                "leer"));
        club.addPersona("Elena", hobbiesP2);
        HashSet<String> hobbiesP3 = new HashSet<>(Arrays.asList("nadar", "caminar", "deporte"));
        club.addPersona("Isabel", hobbiesP3);
        HashSet<String> hobbiesP4 = new HashSet<>(Arrays.asList("bailar", "cantar", "caminar", "deporte"));
        club.addPersona("Amaia", hobbiesP4);

        System.out.println("Personas en el club y sus hobbies");
        club.printClub();
        System.out.println();

        String hobbie = "nadar";
        System.out.println("Personas con hobbie '" + hobbie + "'");
        System.out.println(club.personasConHobbie(hobbie));

        System.out.println("Borrar pesonas con hobbie '" + hobbie + "'");
        System.out.println("Se han borrado " + club.borrarPersonasConHobbie(hobbie));
    }


}
