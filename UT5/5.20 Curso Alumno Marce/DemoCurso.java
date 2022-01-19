
/**
 * 
 * Clase de prueba de Curso
 */
public class DemoCurso
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        Curso curso = new Curso("DAM Desarrollo Aplicaciones Multiplataforma");
        // añadir varias alumnos al  curso
        curso.addAlumno("Ana", 3);
        curso.addAlumno("Luis", 5);
        curso.addAlumno("Alberto", 7);
        curso.addAlumno("Juan", 3);
        curso.addAlumno("Miguel ", 8);
        curso.addAlumno("Elena ", 4);
        curso.addAlumno(new Alumno("Francisco ", 6));
        //          // Mostar el curso
        System.out.println(curso.toString());
        System.out.println("---------------------------------------------");
        //Alumnos con todo aprobado
        System.out.println("\nTotal alumnos que han aprobado " + curso.totalAprobados());
        String[] alumnos = curso.alumnosConTodoAprobado();
        for (int i = 0; i < alumnos.length; i++)  {
            System.out.println(alumnos[i]);
        }
        System.out.println("---------------------------------------------");
        // borrar  los de nota igual a 3 
        System.out.println("Se han borrado " + curso.borrarLosDeNota3() + " alumnos con nota 3\n");
        System.out.println("Después de borrar el curso queda " + curso.toString());

        System.out.println("---------------------------------------------");
        // ordenar por nota
        curso.ordenarPorSeleccionDirecta();
        System.out.println("Después de ordenar el curso queda ");
        System.out.println(curso.toString());

    }
}