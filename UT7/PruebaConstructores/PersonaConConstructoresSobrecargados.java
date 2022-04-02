
public class PersonaConConstructoresSobrecargados
{

    private String nombre;
    private int edad;
    private double sueldo;

    /**
     * Constructor  por defecto, es el constructor sin parámeteros
     */
    public PersonaConConstructoresSobrecargados()    {
        this ("Ana", 18, 1200);

    }
    
    /**
     * Constructor  
     */
    public PersonaConConstructoresSobrecargados(String nombre, int edad)    {
        this (nombre, edad, 1200);

    }

    /**
     * Constructor  
     */
    public PersonaConConstructoresSobrecargados(String nombre, int edad, double sueldo)    {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }
}
