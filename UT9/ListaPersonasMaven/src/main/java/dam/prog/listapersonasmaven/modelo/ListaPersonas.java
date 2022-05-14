package dam.prog.listapersonasmaven.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ListaPersonas {

    private List<Persona> personas;

    public ListaPersonas() {
        personas = new ArrayList<>();
    }


    public void addPersona(Persona p) {

        personas.add(p);
    }

    /**
     * @param cual el hobbie a comprobar
     * @return el nº de personas del club que tienen ese hobbie
     */
    public int personasConHobbie(String cual) {
        cual = cual.toUpperCase();
        int cuantas = 0;
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()) {
            Persona persona = it.next();
            if (persona.tieneHobbie(cual)) {
                cuantas++;
            }
        }
        return cuantas;

    }


    /**
     * Borra de la lista las personas con un determinado hobbie y las añade en
     * el conjunto a devolver
     *
     * @param cual el hobbie a comprobar
     * @return el conjunto de nombres de personas con ese hobbie
     */

    public HashSet<String> borrarPersonasConHobbie(String cual) {
        HashSet<String> resul = new HashSet<String>();
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            if (p.tieneHobbie(cual)) {
                resul.add(p.getNombre());
                it.remove();
            }
        }
        return resul;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Persona p : personas) {
            sb.append(p.toString());
        }
        return sb.toString();
    }


}
