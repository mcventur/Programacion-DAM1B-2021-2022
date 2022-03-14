package pkgformacion.modelo;

import java.util.*;

/**
 * map con la relación de alumnos y su lista de cursillos asociados
 * La clase en el map es el nombre del alumno, el valor asociado es una colección ArrayList
 * de objetos pkgformacion.modelo.Cursillo
 */
public class Formacion {

    private TreeMap<String, ArrayList<Cursillo>> mapCursos;

    /**
     * Constructor
     */
    public Formacion() {
        mapCursos = new TreeMap<>();

    }

    /**
     * dado un nombre de alumno se añade un nuevo cursillo a su lista de cursos
     * si la clave no existe se crea, si ya existe únicamente se añade el cursillo
     * a la lista de cursillos siempre que éste no esté ya
     */
    public void addCursillo(String alumno, String curso, int horas) {
        ArrayList<Cursillo> alCursillos;//Declaramos el ArrayList que contendrá los cursillos del alumno
        alumno = alumno.toUpperCase();
        if (!mapCursos.containsKey(alumno)) {//Si no está el alumno, generamos un nuevo ArrayList y lo metemos en el maopa
            alCursillos = new ArrayList<>();
            mapCursos.put(alumno, alCursillos);
        }
        else{//Si ya está, recuperamos el ArrayList de cursillos actuales del alumno
            alCursillos = mapCursos.get(alumno);
        }

        //Ahora comprobaremos si el ArrayList de Cursillos contiene ya el cursillo a insertar
        //Si no, lo insertamos
        Cursillo nuevo = new Cursillo(curso, horas);
        if (!alCursillos.contains(nuevo)) {
            alCursillos.add(nuevo);
        }
    }

    /**
     * dado un alumno obtener el total horas de cursillos realizadas por él
     * si el alumno no existe se devuelve -1
     */
    public int totalHorasCursillosDe(String alumno) {
        alumno = alumno.toUpperCase();
        int totalHoras=0;
        if (mapCursos.containsKey(alumno)) {
            for (Cursillo cursillo : mapCursos.get(alumno)) {
                totalHoras+=cursillo.getHoras();
            }
        }
        else{
            return -1;
        }
        return totalHoras;


    }

    /**
     * Devuelve el nombre del alumno con más horas de cursillos realizadas
     */
    public String alumnoConMasHorasDeCursillos() {
        String alumMaxHoras="";
        int maxHoras=0;
        for (String alumno : mapCursos.keySet()) {
            int horasAlumno=totalHorasCursillosDe(alumno);
            if(horasAlumno>maxHoras){
                maxHoras=horasAlumno;
                alumMaxHoras=alumno;
            }
        }
        return alumMaxHoras;
    }


    /**
     * Mostrar cada alumno y nº total de cursillos realizados (usando keySet)
     */
    public void alumnosTotalCursillos() {
        for (String alumno : mapCursos.keySet()) {
            System.out.println(alumno + " Total cursos realizados " + mapCursos.get(alumno).size());
        }
    }

    /**
     * No estaba en el proyecto base, pero se pide en el enunciado y se usa en la clase Demo
     * Muestra cada alumno con su total de horas de cursillos realizados
     * USANDO Map.Entry
     */
    public void alumnosTotalHorasCursillos(){
        for (Map.Entry<String,ArrayList<Cursillo>> entrada: mapCursos.entrySet()) {
            String alumno=entrada.getKey();
            System.out.println(alumno + " Horas cursillos realizadas " + totalHorasCursillosDe(alumno));
        }
    }


    /**
     * Representación textual del map mostrando
     * cada alumno y los nombres de los cursillos realizados - Usando Map.Entry
     */
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Set<Map.Entry<String,ArrayList<Cursillo>>> setEntradas=mapCursos.entrySet();
        Iterator<Map.Entry<String,ArrayList<Cursillo>>> itEntradas=setEntradas.iterator();
        while (itEntradas.hasNext()) {
            Map.Entry<String, ArrayList<Cursillo>> entrada = itEntradas.next();
            String alumno=entrada.getKey();
            ArrayList<Cursillo> alCursillos=entrada.getValue();
            sb.append(alumno).append("\n");
            sb.append("\tCursos: ");
            for (Cursillo cursillo : alCursillos) {
                sb.append(cursillo.getNombre() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * mostrar el map
     */
    public void mostrar() {
        System.out.println(this.toString());
    }


}
