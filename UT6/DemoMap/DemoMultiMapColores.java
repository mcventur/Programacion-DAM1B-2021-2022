
/**
 * 
 * 
 * @author  
 * @version  
 */
public class DemoMultiMapColores
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        MultiMapColores multiMap = new MultiMapColores();
        multiMap.addPersona("pepe", "verde");
        multiMap.addPersona("pepe", "negro");
        multiMap.addPersona("luisa", "amarillo");
        multiMap.addPersona("luisa", "verde");
        multiMap.addPersona("luisa", "naranja");
        multiMap.addPersona("pepe", "naranja");
        multiMap.addPersona("pepe", "azul");

        multiMap.escribirPersonasColores();
        String color = "verde";
        System.out.println("El color " + color + " le gusta a " + 
            multiMap.personasLesGustaColor(color) + " personas");
        System.out.println("El color " + color + " le gusta a " + 
            multiMap.personasLesGustaColorV2(color) + " personas");

        System.out.println("El color " + color + " le gusta a " + 
            multiMap.conjuntoPersonasLesGustaColor(color).toString());  

        String persona1 = "pepe";
        String persona2 = "luisa";
        System.out.println("\nColores comunes que les gusta a " + persona1 + " y " + persona2 + " " +
            multiMap.coloresComunes(persona1, persona2).toString());
        System.out.println("\nColores comunes que les gusta a " + persona1 + " y " + persona2 + " " +
            multiMap.coloresComunesV2(persona1, persona2).toString());
    }
}
