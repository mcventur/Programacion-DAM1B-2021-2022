import java.util.Scanner;

/**
 * 
 *
 */
public class DemoAlumno
{

    /**
     *  
     *  
     */
    public static void main(String[] args)    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Dame nombre del alumno/a: ");
        String nombre = teclado.nextLine();
        Alumno alumno1 = new Alumno(nombre);
        // pedimos sus asignatutra y las registramos
        for (int n = 1; n <= Alumno.MAX_ASIGNATURAS; n++)        {
            System.out.print("Dame nota " + n + " del alumno/a: ");
            int nota = teclado.nextInt();
            alumno1.registrarNota(nota);
        }
        System.out.println("\nInformación  del alumno/a: " + alumno1.toString());
        System.out.print("Total suspensos " + alumno1.totalSuspensos());

        teclado.nextLine();
        
        
        System.out.print("\nDame nombre del alumno/a: ");
        nombre = teclado.nextLine();
        Alumno alumno2 = new Alumno(nombre);
        alumno2.registrarNota(7);
        alumno2.registrarNota(5);
        System.out.println("\nInformación  del alumno/a: " + alumno2.toString());
        System.out.print("Total suspensos " + alumno2.totalSuspensos());
 
    }
}
