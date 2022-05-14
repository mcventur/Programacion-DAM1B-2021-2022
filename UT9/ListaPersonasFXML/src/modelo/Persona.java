package modelo;

import java.util.HashSet;
import java.util.Set;

public class Persona {
    private String nombre;
    private int edad;
    private Genero genero;
    private Set<String> hobbies;


    public Persona(String nombre, int edad, Genero genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        hobbies = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }


    public void addHobbie(String h) {
        h = h.toLowerCase();
        if (!tieneHobbie(h)) {
            hobbies.add(h);
        }
    }

    public void addHobbies(Set<String> hobbies) {
        for (String hob : hobbies) {
            addHobbie(hob);
        }
    }


    public boolean tieneHobbie(String h) {
        return hobbies.contains(h.toLowerCase());
    }


    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\tEdad:" + edad + ", \tGenero: " + genero
                + "\nHobbies=" + hobbies.toString() + "\n";
    }


}
