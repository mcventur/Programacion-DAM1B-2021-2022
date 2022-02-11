import java.util.ArrayList;
import java.util.Iterator;

/**
 * Un objeto de esta clase mantiene una colección Arraylist de objetos estudiante
 */


public class Curso {

    private ArrayList<Estudiante> curso;

    /**
     * Constructor
     */
    public Curso() {
        curso = new ArrayList<>();
    }

    /**
     * Añade un estudiante a la colección
     */
    public void añadirEstudiante(String nombre, int nota) {
        curso.add(new Estudiante(nombre, nota));
    }

    /**
     * nº de alumnos en el curso
     */
    public int cuantosAlumnos() {
        return curso.size();
    }

    /**
     * Representación en formato texto del curso
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Lista de estudiantes del curso: \n");
        Iterator<Estudiante> itEstudiante = curso.iterator();
        while (itEstudiante.hasNext()) {
            sb.append(itEstudiante.next()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Calcula la media de notas del curso. Utiliza for mejorado
     */
    public double getMedia() {
        double suma = 0;
        for (Estudiante e : curso) {
            suma += e.getNota();
        }
        return suma / cuantosAlumnos();
    }

    /**
     * Nombre del alumno con nota máxima. Con for mejorado
     */
    public String alumnoNotaMaximaV1() {
        String nomMax = "";
        double notaMax = -1;
        for (Estudiante e : curso) {
            if (e.getNota() > notaMax) {
                nomMax = e.getNombre();
                notaMax = e.getNota();
            }
        }
        return nomMax;
    }

    /**
     * Nombre del alumno con nota máxima. Utiliza un iterador
     */
    public String alumnoNotaMaximaV2() {
        String nomMax = "";
        double notaMax = -1;
        Iterator<Estudiante> itEstudiante = curso.iterator();
        while (itEstudiante.hasNext()) {
            Estudiante e = itEstudiante.next();
            if (e.getNota() > notaMax) {
                notaMax = e.getNota();
                nomMax = e.getNombre();
            }
        }
        return nomMax;


    }

    /**
     * Borrar el primer estudiante de la colección. Esta no puede estar vacía
     */
    public void borrarPrimero() {
        if (curso.size() > 0) {
            curso.remove(0);
        } else {
            System.out.println("El curso está vacío");
        }
    }


    /**
     * Borrar los alumnos que han suspendido. Con un interador
     */
    public void borrarSuspensos() {
        Iterator<Estudiante> itEstudiante = curso.iterator();
        while (itEstudiante.hasNext()) {
            int nota = itEstudiante.next().getNota();
            if (nota < 5) {
                itEstudiante.remove();
            }
        }
    }

    /**
     * Devuelve true si hay algún notable. Con for mejorado
     */
    public boolean hayAlgunNotable() {
        for (Estudiante e : curso) {
            if (e.getNota() >= 7 && e.getNota() < 9) {
                return true;
            }
        }
        return false;
    }

    /**
     * cuantos estudiantes tienen un nombre que empieza por la cadena indicada
     */
    public int empiezanPor(String str) {
        int cuantos = 0;
        for (Estudiante e : curso) {
            if (e.getNombre().startsWith(str)) {
                cuantos++;
            }
        }
        return cuantos;
    }

    /**
     * Devuelve el suspenso más alto del curso
     */
    public int suspensoMasAlto() {
        int maxSusp = 0;
        Iterator<Estudiante> itEstudiante = curso.iterator();
        while (itEstudiante.hasNext()) {
            int nota = itEstudiante.next().getNota();
            if (nota < 5 && nota > maxSusp) {
                maxSusp = nota;
            }
        }
        return maxSusp;
    }

    /**
     * Calcula y devuelve el total de suspensos. Con un iterador.
     */
    public int totalSuspensosIterador() {
        Iterator<Estudiante> itEstudiante = curso.iterator();
        int totalSusp = 0;
        while (itEstudiante.hasNext()) {
            int nota = itEstudiante.next().getNota();
            if (nota < 5) {
                totalSusp++;
            }
        }
        return totalSusp;
    }


    /**
     * Calcula y devuelve como un string las dos notas más altas del curso.
     * Con un while normal.
     */
    public String dosNotasMasAltas() {
        int max = 0;
        int segMax = 0;
        int i = 0;
        while (i < cuantosAlumnos()) {
            int nota = curso.get(i).getNota();
            if (nota > max) {
                segMax = max;
                max = nota;
            } else if (nota > segMax) {
                segMax = nota;
            }
            i++;
        }
        if (cuantosAlumnos() == 1) {
            return String.valueOf(max);
        }
        //else
        return segMax + " - " + max;
    }


}
