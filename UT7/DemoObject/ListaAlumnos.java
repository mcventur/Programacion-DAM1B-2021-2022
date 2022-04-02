import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 *  
 * 
 * @author  
 * @version  
 */
public class ListaAlumnos
{

    private List<Alumno> alumnos;

    /**
     * Constructor  
     */
    public ListaAlumnos()    {
        alumnos = new ArrayList<>();
    }

    /**
     *  
     * 
     * @param   
     * 
     */
    public void addAlumno(Alumno al)    {
        if (!alumnos.contains(al))    {
            alumnos.add(al);
        }

    }

    /**
     * 
     */
    public  void printAlumnos()    {
        for (Alumno al: alumnos)  {
            System.out.println(al.toString());
        }
    }

    /**
     *  
     */
    public void ordenar()    {
        System.out.println("Ordenados por nombre y nota - Orden natural");    
        List<Alumno> tmp = new ArrayList<>(this.alumnos);
        Collections.sort(tmp);
        System.out.println(tmp.toString());


    }
    /**
     *  
     */
    public void ordenarPorNombre()    {
        System.out.println("Ordenados por nombre y nota - Orden natural");
        alumnos.sort(Comparator.naturalOrder());
        alumnos.forEach(a ->  System.out.println(a.toString()));
    }

    /**
     *  
     */
    public void ordenarPorNotaV1()    {
        System.out.println("Ordenados solo por nota");
        Comparator<Alumno> comparador = new Comparator<Alumno>() {
                public int compare(Alumno a1, Alumno a2) {
                    return a1.getNota() - a2.getNota();
                }
            };
        alumnos.sort(comparador);

    }


    /**
     *  Con expresiones Lambda
     */
    public void ordenarPorNotaV2()    {
        System.out.println("Ordenados solo por nota");
        alumnos.sort((a1, a2) -> a1.getNota() - a2.getNota());
        alumnos.forEach(a ->  System.out.println(a.toString()));
    }

    public static void main(String[] args)    {
        ListaAlumnos lista = new ListaAlumnos();
        lista.addAlumno(new Alumno("ana", 6));
        lista.addAlumno(new Alumno("ana", 6));
        lista.addAlumno(new Alumno("juan", 8));
        lista.addAlumno(new Alumno("ana", 5));
        lista.addAlumno(new Alumno("ana", 9));
        lista.printAlumnos();

        lista.ordenar();
        lista.printAlumnos();

        // lista.ordenarPorNombre();
        // lista.ordenarPorNotaV1();
        // lista.printAlumnos();
    }
}
