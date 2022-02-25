
/**
 *  
 * Clase que incluye un map que asocia nombres de personas 
 * con el conjunto de sus colores favoritos
 * Ejemplo de uso de un multimap, un map en el que cada clave tiene
 * asociado una colección de valores
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Collection;

public class MultiMapColores
{

    private  HashMap<String, HashSet<String>> mapPersonas;

    /**
     * Constructor  
     */
    public MultiMapColores()
    {
        mapPersonas = new HashMap<>();
    }

    /**
     *   Añade una nueva persona al map con su color favorito
     *   Si la persona (clave) no existe se crea una nueva entrada con
     *   un conjunto vacío y se añade el color al conjunto
     *   Si la persona  (clave) existe se añade el color
     * 
     */
    public void addPersona(String nombre, String color)
    {
        nombre = nombre.toLowerCase();
        color = color.toLowerCase();
        if (!mapPersonas.containsKey(nombre)) {
            HashSet<String> colores = new HashSet<String>();
            colores.add(color);
            mapPersonas.put(nombre, colores);
        }
        else {
            HashSet<String> colores = mapPersonas.get(nombre);
            colores.add(color);
            // mapPersonas.get(nombre).add(color);
        }
    }

    /**
     *   Añade una nueva persona al map con su color favorito
     *   Si la persona (clave) no exite se crea una nueva entrada con
     *   un conjunto vacío y se añade el color al conjunto
     *   Si la personas (clave) existe se añade el color
     * 
     */
    public void addPersonaV2(String nombre, String color)
    {
        nombre = nombre.toLowerCase();
        color = color.toLowerCase();
        if (!mapPersonas.containsKey(nombre))        {
            HashSet<String> colores = new HashSet<>();
            mapPersonas.put(nombre, colores);
        }
        mapPersonas.get(nombre).add(color);

    }

    /**
     *   Añade una nueva persona al map con su color favorito
     *   Si la persona (clave) no existe se crea una nueva entrada con
     *   un conjunto vacío y se añade el color al conjunto
     *   Si la personas (clave) existe se añade el color
     * 
     */
    public void addPersonaV3(String nombre, String color)
    {
        nombre = nombre.toLowerCase();
        color = color.toLowerCase();
        HashSet<String> colores = mapPersonas.get(nombre);
        if (colores == null) {
            colores = new HashSet<>();
            mapPersonas.put(nombre, colores);

        }
        colores.add(color);
       
    }
    /**
     * Muestra el nombre de cada persona y sus colores favoritos
     * Con el conjunto de claves y un for mejorado
     */
    public  void escribirPersonasColores()
    {
        Set<String> conjuntoNombres = mapPersonas.keySet();
        for (String nombre:conjuntoNombres)   {
            HashSet<String> colores = mapPersonas.get(nombre);
            System.out.println(nombre);
            System.out.print("\t");
            for (String color: colores)   {
                System.out.print(color + "\t");
            }
            System.out.println();    
        }
    }

    /**
     * devuelve el nº de personas a las que les gusta el color pasado como parámetro
     * Con el conjunto de entradas y un iterador
     */
    public int personasLesGustaColor(String color)
    {
        color = color.toLowerCase();
        int cuantos = 0;
        Set<Map.Entry<String, HashSet<String>>> entradas = mapPersonas.entrySet();
        Iterator<Map.Entry<String, HashSet<String>>> it =  entradas.iterator();
        while (it.hasNext())       {
            Map.Entry<String, HashSet<String>> entrada = it.next();
            HashSet<String> colores = entrada.getValue();
            if (colores.contains(color))  {
                cuantos++;
            }
        }
        return cuantos;

    }
    
     /**
     * devuelve el nº de personas a las que les gusta el color pasado como parámetro
     * Con la colección de valores y un for mejorado
     */
    public int personasLesGustaColorV2(String color)
    {
        color = color.toLowerCase();
        int cuantos = 0;
        Collection<HashSet<String>> coloresPersonas = mapPersonas.values();
        for (HashSet<String> coloresPersona:coloresPersonas)     {             
            if (coloresPersona.contains(color))  {
                cuantos++;
            }
        }
        return cuantos;

    }

    /**
     * devuelve un conjunto ordenado con los nombres de las personas a las que les gusta 
     * el color pasado como parámetro
     * Con el conjunto de claves y un for
     */
    public TreeSet<String> conjuntoPersonasLesGustaColor(String color)
    {
        color = color.toLowerCase();
        TreeSet<String> conjunto = new TreeSet<>();
        for (String nombre: mapPersonas.keySet())  {
            HashSet<String> colores = mapPersonas.get(nombre);
            if (colores.contains(color))  {
                conjunto.add(nombre);
            }
        }
        return conjunto;

    }

    /**
     *  Borrar el color que le gusta a la persona indicada
     *
     */
    public void borrarColor(String persona, String color)
    {
        persona = persona.toLowerCase();
        color = color.toLowerCase();
        if (mapPersonas.containsKey(persona))    {
            mapPersonas.get(persona).remove(color);
        }
        
        // HashSet<String> colores = mapPersonas.get(persona);
        // if (colores != null) {
            // colores.remove(color);
        // }

    }

    /**
     *  Devuelve el conjunto de colores comunes que les gusta a persona1 y persona2
     *  No importa el orden en el conjunto resultado
     *  Si no hay colores comunes se devuelve el conjunto vacío
     */
    public HashSet<String> coloresComunes(String persona1, String persona2)
    {
        persona1 = persona1.toLowerCase();
        persona2 = persona2.toLowerCase();
        HashSet<String> comunes = new HashSet<>();
        if (!mapPersonas.containsKey(persona1) || !mapPersonas.containsKey(persona2))    {
            return comunes;
        }       
        comunes.addAll(mapPersonas.get(persona1));
        comunes.retainAll(mapPersonas.get(persona2));
        return comunes;
    }
    
    /**
     *  Devuelve el conjunto de colores comunes que les gusta a persona1 y persona2
     *  No importa el orden en el conjunto resultado
     *  Si no hay colores comunes se devuelve el conjunto vacío
     */
    public HashSet<String> coloresComunesV2(String persona1, String persona2)
    {
        persona1 = persona1.toLowerCase();
        persona2 = persona2.toLowerCase();
        HashSet<String> comunes = new HashSet<>();
        HashSet<String> coloresPersona1 = mapPersonas.get(persona1);
        HashSet<String> coloresPersona2 = mapPersonas.get(persona2);
        if (coloresPersona1 == null ||  coloresPersona2 == null) {
            return comunes;
        }
        comunes.addAll(coloresPersona1);
        comunes.retainAll(coloresPersona2);
        return comunes;
    }

}
