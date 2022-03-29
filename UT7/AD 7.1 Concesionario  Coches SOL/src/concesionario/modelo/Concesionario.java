package concesionario.modelo; /**
 * Clase Concesionario 
 *
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class Concesionario {

    private String nombre;
    private List<Coche> coches;

    /**
     * Constructor de la clase Concesionario
     */
    public Concesionario(String n) {
        nombre = n;
        coches = new ArrayList<>();
    }

    /**
     * acccsor para el nombre del concesionario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Añade un coche
     */
    public void añadir(Coche c) {
        if(!coches.contains(c)){
            coches.add(c);
        }
        else {
            System.out.println("Coche duplicado\n" + c.toString());
            System.out.println();
        }
    }

    /**
     *   obtiene un listado ordenado por nombre de conductor especificando además el
     *   tipo de coche que posee. No se modifica la colección de coches
     */
    public void listarOrdenadoConductor() {
        //Como no podemos modificar la lista original, generamos otra
        //y la inicializamos cargándole nuestra lista de coches
        List<Coche> retorno=new ArrayList<>(coches);

        //Queremos ordenar los coches por el nombre del conductor
        //Imaginemos que es un criterio distinto al natural (que sería, por ejemplo, por velocidad)
        //así que necesitamos usar un Comparator de Java. Se lo pasamos a Collections.sort
        //En este caso se lo paso directamente como una clase anónima que implementa Comparator
        Collections.sort(retorno,new Comparator<Coche>(){
            @Override
            public int compare(Coche o1, Coche o2) {
                return o1.getConductor().compareToIgnoreCase(o2.getConductor());
            }
        });

        //Una vez tenemos la lista ordenada, la mostramos
        for (Coche c : retorno) {
            System.out.println(c + "\n");
        }


    }

    /**
     * Leer del fichero de texto "concesionario.txt" los datos de cada coche
     * y añadirlos al concesionario
     *
     * Con ayuda del método privado parsearLinea()  extraeremos los datos de un coche
     *
     */
    public void leerConcesionarioDeFicheroTexto() {

        Scanner entrada = new Scanner(
                this.getClass().getResourceAsStream("/concesionario.txt"));
        while (entrada.hasNextLine()) {
            String linea = entrada.nextLine();
            Coche coche = parsearLinea(linea);
            añadir(coche);
        }
        entrada.close();

    }

    /**
     *  parsea una línea de texto extrayendo los datos y devolviendo un objeto Coche
     *  El formato de la línea en el fichero ser:
     * 		 tipocoche:conductor:modelo:color  para  tipocoche 'D' (deportivo)
     *       tipocoche:conductor:modelo:color:posx:posy  para  tipocoche 'E' (económico)
     *  	 tipocoche:conductor:modelo:color:posx:posy:plazas  para  tipocoche 'T' (taxi)
     *
     */
    private Coche parsearLinea(String linea) {
        String[] trozos=linea.split(":");
        String tipo=trozos[0];
        //Los deportivos no llevan datos de posicion (se inicializan por defecto a 0,200)
        //Economicos y Taxis sí
        if(tipo.equals("D")){
            return new CocheDeportivo(trozos[1],trozos[2],trozos[3]);
        }
        else{
            int posx=Integer.parseInt(trozos[4]);
            int posy=Integer.parseInt(trozos[5]);
            if(tipo.equals("E"))
                return new CocheEconomico(trozos[1],trozos[2],trozos[3], posx, posy);
            else//taxi
                return new Taxi(trozos[1],trozos[2],trozos[3], posx, posy);
        }
    }

    /**
     * Borrar del concesionario los coches del conductor indicado por el
     * parámetro quien
     */
    public void borrarDeConductor(String quien) {
        //Recordad: no podemos usar un for mejorado si hay que hacer borrados!
        //Usaremos un iterador.
        //Valdría un for con índices, pero recorriendo desde el final hasta el principio
        Iterator<Coche> itCoches=coches.iterator();
        while (itCoches.hasNext()) {
            Coche c = itCoches.next();
            if(c.getConductor().equals(quien)){
                itCoches.remove();
            }
        }
    }

    /**
     * listado del concesionario
     */
    public void listarCoches() {
        System.out.println("Concesionario: " + nombre + "\n");
        for (Coche c : coches) {
            System.out.println(c + "\n");
        }
    }

    /**
     *
     *  borrar del concesionario los taxis
     */
    public void borrarTaxis() {
        Iterator<Coche> itCoches=coches.iterator();
        while (itCoches.hasNext()) {
            Coche c = itCoches.next();
            if(c instanceof Taxi){
                itCoches.remove();
            }
        }
    }

    /**
     * avanzar todos los coches
     */
    public void avanzarTodos() {
        //No vamos a modificar la lista realmente
        //sino datos de sus componentes
        //podemos usar un for mejorado
        for (Coche c : coches) {
            c.avanza();//polimorfismo de método
        }
    }

}
