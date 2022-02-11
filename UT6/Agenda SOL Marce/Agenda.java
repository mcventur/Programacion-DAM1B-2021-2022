import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Una clase que mantiene una lista
 * con un nº arbitrario de notas.
 * Las notas se numeran de forma externa
 * por el usuario
 */
public class Agenda {
    // Almacén de notas
    private ArrayList<String> notas;

    /**
     * Constructor
     */
    public Agenda() {
        notas = new ArrayList<>();
    }

    /**
     * Almacenar una nueva nota
     *
     * @param nota La nota que se almacena
     */
    public void apuntarNota(String nota) {
        notas.add(nota);
    }

    /**
     * @return El nº de notas actualmente almacenadas
     */
    public int numeroNotas() {
        return notas.size();
    }

    /**
     * Mostrar una nota
     *
     * @param numeroNota El nº de nota a mostrar
     *                   Si numeroNota es incorrecto mostrar mensaje de error
     */
    public void mostrarNota(int numeroNota) {
        if (numeroNota < 0 || numeroNota > numeroNotas() - 1) {
            System.out.println("El número de nota es incorrecto");
        } else {
            System.out.println(notas.get(numeroNota));
        }

    }

    /**
     * Borrar una nota
     * Si numeroNota es incorrecto mostrar mensaje de error
     */
    public void borrarNota(int numeroNota) {
        if (numeroNota < 0 || numeroNota > numeroNotas() - 1) {
            System.out.println("El número de nota es incorrecto");
        } else {
            notas.remove(numeroNota);
        }

    }

    /**
     * Mostar todas las notas
     */
    public void listarNotas() {
        for (int i = 0; i < numeroNotas(); i++) {
            System.out.print(notas.get(i) + "\n");
        }
    }

    /**
     * Mostar todas las notas con un for mejorado
     */
    public void listarNotasConForMejorado() {
        for (String n : notas) {
            System.out.print(n + "\n");
        }
    }

    /**
     * Mostar todas las notas con un iterador
     */
    public void listarNotasConIterador() {
        Iterator<String> itNotas = notas.iterator();
        while (itNotas.hasNext()) {
            System.out.println(itNotas.next() + "\n");
        }
    }

    /**
     * contar las notas que contienen el parámetro
     * utilizando for mejorado
     * SIN DIFERENCIAR MAYUSCULAS DE MINUSCULAS (Ver llamada en AppAgenda).
     */
    public int notasQueContienen(String str) {
        int cuenta = 0;
        str = str.toUpperCase();
        for (String n : notas) {
            if (n.toUpperCase().contains(str)) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * borrar las notas que empiezan con el parámetro
     * utilizando un iterador
     */
    public void borrarNotasQueEmpiezanPor(String str) {
        Iterator<String> itNotas = notas.iterator();
        while (itNotas.hasNext()) {
            String nota = itNotas.next();
            if (nota.startsWith(str)) {
                itNotas.remove();
            }
        }
    }

    /**
     * Devolver una colección con las notas que acaban en "ria"
     * ordenadas
     * Con for mejorado
     */
    public ArrayList<String> acabanEn(String str) {
        ArrayList<String> retorno = new ArrayList<>();
        for (String n : notas) {
            if (n.endsWith(str)) {
                retorno.add(n);
            }
        }
        Collections.sort(retorno);
        return retorno;
    }

    /**
     * Borrar las notas que estén repetidas
     * Ordenando la colección previamente , no siempre nos puede interesar
     */
    public void borrarRepetidasV1() {
        Collections.sort(notas);
        /*
        Aunque no es un array, el comportamiento interno es el mismo en borrados de varios elementos.
        Tenemos que usar los mismos métodos:
        Recorrer de derecha a izquierda con el for
         o usar un while de izquierda a derecha con el avance condicionado a que no se borre en esa posición
        Con el for de derecha a izquierda
        */


        /*
        for(int i=numeroNotas()-1;i>=0;i--){
            if(notas.get(i).equalsIgnoreCase(notas.get(i-1))){
                notas.remove(i);
            }
        }
         */

        //Con el while con avance condicionado a no borrar
        int i = 0;
        while (i < numeroNotas() - 1) {//Llegamos hasta la penúltima posición.
            if (notas.get(i).equalsIgnoreCase(notas.get(i + 1))) {
                notas.remove(i);
            } else {
                i++;
            }
        }

    }

    /**
     * Borrar las notas que estén repetidas
     * con indexOf (sin ordenar previamente)
     */
    public void borrarRepetidasV2() {
        for (int i = numeroNotas() - 1; i > 0; i++) {//Llegamos hasta la posicion 1 (la 0 no hace falta)
            if (notas.indexOf(notas.get(i)) != i) {//Significa que hemos encontrado un elemento repetido en una posicion anterior
                notas.remove(i);
            }
        }

    }

    /**
     * Invierte la lista de notas
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método contendrá  [ "ir dentista", "comprar leche", "comprar pan"]
     */
    public void invertir() {
         /*
        Lo que haremos será ir intercambiando valores, cada valor con su "espejo" correspondiente
        El 0 con el ultimo, el 1 con el pemúltimo, etc...
        Así  que sólo tenemos que recorrer la lista hasta la mitad
        */
        int mitad = numeroNotas() / 2;
        for (int i = 0; i < mitad; i++) {
            //Intercambio. Siempre con variable auxiliar
            String aux = notas.get(i);//Guardamos la nota i en aux
            notas.set(i, notas.get(numeroNotas() - i - 1));//Guardamos en i la equivalente por el lado derecho
            notas.set(numeroNotas() - i - 1, aux);
        }
    }

    /**
     * Invierte la lista de notas
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método contendrá  [ "ir dentista", "comprar leche", "comprar pan"]
     * USANDO UN MÉTODO DE LA CLASE Collections. Consultad la API
     */
    public void invertirV2() {
        Collections.reverse(notas);
    }

    /**
     * Duplica cada nota
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método contendrá  ["comprar pan", "comprar pan", "comprar leche", "comprar leche", "ir dentista", "ir dentista"]
     */
    public void duplicarNotas() {
        //La función add admite un primer parámetro opcional: la posición en que se inserta el elemento
        //Diapositiva 25 de UT6
        for (int i = 0; i < numeroNotas(); i += 2) {//IMPORTANTE: Vamos saltando de 2 en 2
            notas.add(i + 1, notas.get(i));
        }
    }

    /**
     * Reorganiza aleatoriamenta ls notas de la agenda
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     * después de ejecutar el método podría  contener ["comprar leche", ir dentista","comprar pan"]
     */
    public void reorganizar() {
        Collections.shuffle(notas);
    }

    /**
     * Coloca la primera nota al final de la lista borrándola de la primera posición
     */
    public void primeraAlFinal() {
        //Asumimos que hay notas, aunque se podría comprobar
        notas.add(notas.get(0));//Añadimos la nota a la lista. Si no se indica la posición, se añade al final
        notas.remove(0);//Borramos la nota de la primera posición
    }

    /**
     * Coloca la última nota al principio de la lista borrándola de la última posición
     */
    public void ultimaAlPrincipio() {
        notas.add(0, notas.get(numeroNotas() - 1));//Insertamos la última en la primera posición, usando el get con dos parámetros
        notas.remove(numeroNotas() - 1);
    }

    /**
     * Devuelve la posición de la primera ocurrencia de nota
     */
    public int posicionDeLaNota(String nota) {
        return notas.indexOf(nota);
    }

    /**
     * borrar las notas que empiezan con el parámetro
     * utilizando un for mejorado  INCORRECTO
     */
    public void borrarNotasAcabanEn(String str) {
        //Sería así. Pero el compilador no permitirá compilar si se llama a la función desde la AppAgenda.
        //NO SE PUEDE USAR EL FOR MEJORADO PARA MODIFICAR COLECCIONES
        /*
        for (String n : notas) {
            if (n.endsWith(str)) {
                notas.remove(n);
            }
        }
         */
    }

}
