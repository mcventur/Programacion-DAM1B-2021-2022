
/**
 * Modela una clase Libreria
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Libreria {

    private String nombre;
    private ArrayList<Libro> libros;

    /**
     * Constructor de la clase Libreria
     */
    public Libreria(String nombre) {
        this.nombre = nombre;
        libros = new ArrayList<>();
    }

    /**
     * Accesor para el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return la cantidad de libros en la librer?a
     */
    public int numeroLibros() {
        return libros.size();
    }

    /**
     * A?ade un nuevo libro
     *
     * @param l el libro a a?adir
     */
    public void addLibro(Libro l) {
        libros.add(l);
    }

    /**
     * Localizar un libro dado su t?tulo
     *
     * @return el libro buscado o null si no
     * se encuentra
     */
    public Libro localizarLibro(String titulo) {
        Iterator<Libro> itLib=libros.iterator();
        while(itLib.hasNext()){
            Libro l=itLib.next();
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                return l;
            }
        }
        return null;
    }

    /**
     * @param autor el autor a buscar
     * @return true si hay en la librer?a libros
     * del autor dado
     */
    public boolean hayLibrosDe(String autor) {
        int i=0;
        while(i<numeroLibros()){
            if(libros.get(i).getAutor().equalsIgnoreCase(autor)){
                return true;
            }
            i++;
        }
        return false;

    }

    /**
     * Borrar los libros de un determinado autor
     *
     * @param autor el autor cuyos libros se borrar?n
     */
    public void borrarLibrosDe(String autor) {
        int i=0;
        /*
        Es un borrado masivo, usando ?ndices. As? que hay que usar el algoritmo de borrado
        Visto en la UT5: Incrementamos el contador S?LO si no se borra en esa posici?n
        */
        if(hayLibrosDe(autor)){
            while(i<numeroLibros()){
                if(libros.get(i).getAutor().equalsIgnoreCase(autor)){
                    libros.remove(i);
                }
                else{
                    i++;
                }
            }
        }
        else{
            System.out.println("No hay libros del autor indicado");
        }
    }

    /**
     * Mostar libros prestados
     */
    public void listarPrestados() {
        for(Libro l:libros){
            if(l.getEstado()==Estado.PRESTADO){
                System.out.println(l);
            }
        }
    }

    /**
     * Prestar un libro de un determinado t?tulo
     */
    public void prestarTitulo(String titulo) {
        Libro l=localizarLibro(titulo);
        if(l==null){
            System.out.println("El libro \"" + titulo + "\" no est? en la biblioteca");
        }
        else{
            if(l.estaPrestado()){
                System.out.println("El libro \"" + titulo + "\" est? prestado");
            }
            else{
                l.prestar();
            }
        }
    }

    /**
     * Representaci?n textual de la librer?a
     */
    public String toString() {

        iter



        StringBuilder sb=new StringBuilder("La librer?a contiene " + numeroLibros() + " libros:\n\n");
        for(Libro l:libros){
            sb.append(l).append("\n");
        }
        return sb.toString();
    }


}
