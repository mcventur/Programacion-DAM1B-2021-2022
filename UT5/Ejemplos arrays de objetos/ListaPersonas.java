
/**
 *  
 * Modela una lista de personas
 */
public class ListaPersonas
{
    private Persona[] personas;
    private int total; // total de personas en la lista

    /**
     * Constructor  
     * @param n tamaño máximo de la lista de personas
     */
    public ListaPersonas(int n)    {
         personas = new Persona[n];
         total = 0;
    }
    
    /**
     * @param p la persona a añadir en la lista
     */
    public void addPersona(Persona p)    {
        if (total < personas.length)  {
            personas[total] = p;
            total++;
        }
    }
    
     /**
     * @param p la persona a añadir en la lista
     */
    public void addPersona(String nombre, int edad)    {
        if (total < personas.length)   {
            personas[total] = new Persona(nombre, edad);
            total++;
        }
    }
    
    /**
     * Devuelve el nombre de la persona de menor edad
     */
    public  String masJoven()    {
        String nombreMinimo = "";
        int minimo = Integer.MAX_VALUE;
        for (int i = 0; i < total; i++) {
            int edad = personas[i].getEdad();
            if (edad < minimo)  {
                minimo = edad;
                nombreMinimo = personas[i].getNombre();
            }
        }
        return nombreMinimo;
    }
    
    /**
     * Devuelve el nombre de la persona de menor edad
     */
    public  String masJovenV2()    {
        int posMinimo = 0;
        int minimo = Integer.MAX_VALUE;
        for (int i = 0; i < total; i++) {
            int edad = personas[i].getEdad();
            if (edad < minimo)  {
                minimo = edad;
                posMinimo = i;
            }
        }
        return personas[posMinimo].getNombre();
    }


    /**
     *  Devuelve la cantidad de personas en la lista  
     * 
     */
    public int getTotal()   {
         return total;
    }
    
    /**
     * Representación textual de la lista de personas
     */
    public  String toString()    {
        String str = "";
        for (int i = 0; i < total; i++)   {
            str += personas[i].toString();
        }
        return str;
    }
}
