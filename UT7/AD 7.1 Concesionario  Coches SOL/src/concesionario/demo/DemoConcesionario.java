package concesionario.demo;

import concesionario.modelo.Concesionario;

/**
 * Clase DemoConcesionario 
 *
 */

public class DemoConcesionario {

    private Concesionario con;

    /**
     * Constructor de la clase DemoConcesionario
     */
    public DemoConcesionario(String nombre) {
        con = new Concesionario(nombre);
        con.leerConcesionarioDeFicheroTexto();

    }

    /**
     *
     */
    public void demoListarCoches() {
        con.listarCoches();

    }

    /**
     *
     */
    public void demoAvanzar() {
        con.avanzarTodos();

    }

    /**
     *
     */
    public void demoBorrarDeConductor(String conductor) {
        con.borrarDeConductor(conductor);
    }

    /**
     *
     */
    public void demoBorrarTaxis() {

        con.borrarTaxis();

    }

    /**
     *
     */
    public void demoListarOrdenadoConductor() {

        con.listarOrdenadoConductor();

    }

    /**
     * Aceptar como argumento el nombre del concesionario y -
     * listar el concesionario -
     * avanzar todos los coches y volver a listar -
     * borrar los del conductor "Jesus" -
     * listar el concesionario -
     * borrar los taxis -
     * listar el concesionario
     * mostrar el listado ordenado por conductor -
     */
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Error en nº argumentos\n" +
                    "Sintaxis: java DemoConcesionario <nombreconcesionario>");
        }
        else{
            Concesionario c = new Concesionario(args[0]);
            c.leerConcesionarioDeFicheroTexto();
            c.listarCoches();
            System.out.println("------------------------------------------");
            System.out.println("\n Avanzamos todos los coches, quedando la lista: \n");
            c.avanzarTodos();
            c.listarCoches();
            System.out.println("------------------------------------------");
            System.out.println("\nBorramos los coches que conduce \"Jesus\"\n");
            c.borrarDeConductor("Jesus");
            c.listarCoches();
            System.out.println("------------------------------------------");
            System.out.println("\nBorramos los taxis: \n");
            c.borrarTaxis();
            c.listarCoches();
            System.out.println("------------------------------------------");
            System.out.println("\nOrdenado por conductor: \n");
            c.listarOrdenadoConductor();

            //Para ejecutar el jar, si se ha indicado bien el main
            //basta con indicar la ruta correcta con el comando java -jar
            //sin necesidad de indicar classpath, ya que no se usan clases externas
        }
    }
}
