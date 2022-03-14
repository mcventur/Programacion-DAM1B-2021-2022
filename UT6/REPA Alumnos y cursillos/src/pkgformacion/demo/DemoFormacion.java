package pkgformacion.demo;

import pkgformacion.modelo.Formacion;

/**
 *  
 */
public class DemoFormacion
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        Formacion formacion = new Formacion();
        formacion.addCursillo("pepe", "php", 20);
        formacion.addCursillo("pepe", "java", 90);
        formacion.addCursillo("ana", "php", 10);
        formacion.addCursillo("ana", "java", 70);
        formacion.addCursillo("luis", "seo", 10);
        formacion.addCursillo("jose", "java", 40);
        formacion.addCursillo("ana", "c#", 100);
        formacion.addCursillo("alberto", "xml", 70);
        formacion.addCursillo("jose", "joomla", 10);
        formacion.addCursillo("pepe", "php", 20);
        formacion.addCursillo("ana", "php", 10);
        formacion.addCursillo("jose", "joomla", 10);

        System.out.println("Después de añadir\n\n" + formacion.toString());

        System.out.println("\nAlumnos y total cursillos");
        formacion.alumnosTotalCursillos();
        System.out.println();

        System.out.print("\nTotal horas de cursillos realizadas por PEPE - ");
        System.out.println(formacion.totalHorasCursillosDe("pepe"));
        System.out.print("\nTotal horas de cursillos realizadas por ANA - ");
        System.out.println(formacion.totalHorasCursillosDe("ana"));
        System.out.print("\nTotal horas de cursillos realizadas por JESUS - ");
        System.out.println(formacion.totalHorasCursillosDe("jesus"));
        System.out.println();

        formacion.alumnosTotalHorasCursillos();
        System.out.println();

        System.out.println("\nAlumno con más horas de cursillos " + 
            formacion.alumnoConMasHorasDeCursillos());

    }

}
