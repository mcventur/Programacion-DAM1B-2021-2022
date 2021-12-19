/**
 * Clase que modela a un alumno
 */
public class Alumno
{
    public static final int MAX_ASIGNATURAS = 5;
    private String nombre;
    private int[] notas;
    private int pos;
    
    /**
     * @param nombre el nombre del alumno
     */
    public Alumno(String nombre)   {
        this.nombre = nombre;
        notas = new int[MAX_ASIGNATURAS];
        pos = 0;  
    }

     /**
     * @param nota la nota del alumno que hay que registrar
     */
    public void registrarNota(int nota)   {
        if (pos < notas.length)    {
            notas[pos] = nota;
            pos++;
        }
    }
    
     /**
      * Calcular y devolver el total de suspensos
     * @param nombre el nombre del alumno
     */
    public int totalSuspensos()   {
        int suspensos = 0; 
        for (int i = 0; i < pos; i++)     {
            if (notas[i] < 5)      {
                suspensos ++;
            }
        }
        return suspensos;
    }
    
     /**
     * Representación textual del alumno de la forma
     * 
     */
    public String toString()   {
        String str = "\nNombre: " + this.nombre + "\nNotas: ";
        for (int i = 0; i < pos; i++)    {
            str += notas[i] + "\t";
        }
        return str;
    }
} 
