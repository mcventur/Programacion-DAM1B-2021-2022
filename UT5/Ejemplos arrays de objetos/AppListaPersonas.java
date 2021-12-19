
/**
 *  
 * 
 * @author  
 * @version  
 */
public class AppListaPersonas
{

    /**
     *  
     */
    public static void main(String[] args)    {
        ListaPersonas lista = new ListaPersonas(10);
        lista.addPersona(new Persona("Ana", 22));
        lista.addPersona(new Persona("Luis", 32));
        lista.addPersona(new Persona("Isabel", 15));
        lista.addPersona("Julia", 44);
        System.out.println(lista.toString());
        System.out.println("Más joven: " + lista.masJoven());
        System.out.println("Más joven V2: " + lista.masJovenV2()); 
    }
}
