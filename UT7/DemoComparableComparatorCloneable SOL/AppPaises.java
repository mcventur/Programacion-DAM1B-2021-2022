import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;

/**
 *  a) ordenar ascendente de nombre (criterio natural)
 *  b) ordenar ascendente de superficie (con un comparador explícito)
 *  c) ordenar ascendente de habitantes (con un comparador usando clase anónima)
 *  
 *  d) ordenar descendente de nombre (criterio inverso natural)
 *  e) ordenar descendente de superficie (criterio inverso al del comparador por superficie)
 *  f) ordenar descendente de habitantes (criterio inverso al del comparador con clase anónima)
 */
public class AppPaises
{

    /**
     *  
     *  
     */
    public static void main(String[] args)    {
        List<Pais> paises = new ArrayList<Pais>();
        paises.add(new Pais("Francia", 234, 37));
        paises.add(new Pais("Noruega", 198, 15));
        paises.add(new Pais("Suecia", 200, 21));
        paises.add(new Pais("Dinamarca", 100, 9));

        // --------------------------------------    
        System.out.println("Ordenado  por nombre ascendente");  //  es el orden natural
        Collections.sort(paises);
        for (Pais p: paises)    {
            System.out.println(p.toString() + "\n");
        }

        // --------------------------------------    
        System.out.println("Ordenado  por superficie ascendente");   
        Collections.sort(paises, new ComparadorSuperficie()); 
        for (Pais p: paises)    {
            System.out.println(p.toString() + "\n");
        }

        // --------------------------------------  
        System.out.println("Ordenado  por habitantes ascendente");  // utilizando una clase anónima
        Collections.sort(paises, new Comparator<Pais>()   {
                public int compare(Pais p1, Pais p2)        {
                    return Integer.compare(p1.getHabitantes(), p2.getHabitantes());              

                }

            });

        for (Pais p: paises)     {
            System.out.println(p.toString() + "\n");
        }
        // --------------------------------------  
        System.out.println("Ordenado  por nombre descendente");
        Collections.sort(paises, Collections.reverseOrder());   // el orden inverso al orden natural
        for (Pais p: paises)    {
            System.out.println(p.toString() + "\n");
        }

        // --------------------------------------  
        System.out.println("Ordenado  por superficie descendente");
        Collections.sort(paises, Collections.reverseOrder(new ComparadorSuperficie()));   
        for (Pais p: paises)    {
            System.out.println(p.toString() + "\n"); 
        }

        // --------------------------------------   
        System.out.println("Ordenado  por habitantes descendente");
        Collections.sort(paises, Collections.reverseOrder(new Comparator<Pais>()     {
                    public int compare(Pais p1, Pais p2)      {
                        return Integer.compare(p1.getHabitantes(), p2.getHabitantes()) * -1;                    
                    }

                }));  
        for (Pais p: paises)    {
            System.out.println(p.toString() + "\n"); 
        }

        // --------------------------------------
        Set<Pais> paises2 = new TreeSet<>();
        paises2.add(new Pais("Francia", 234, 37));
        paises2.add(new Pais("Noruega", 198, 15));
        paises2.add(new Pais("Suecia", 200, 21));
        paises2.add(new Pais("Dinamarca", 100, 9));
        System.out.println("TreeSet de países ordenado de menor a mayor nombre\n " + paises2.toString());

        Set<Pais> paises3 = new TreeSet<>(new ComparadorSuperficie());
        paises3.addAll(paises2);
        System.out.println("TreeSet de países de menor a mayor superficie\n " + paises3.toString());

        Set<Pais> paises4 = new TreeSet<Pais>(Collections.reverseOrder());
        paises4.addAll(paises2);
        System.out.println("TreeSet de países en orden inverso a su orden natural (descendente nombre)\n " + paises4.toString());

        Set<Pais> paises5 = new TreeSet<Pais>(Collections.reverseOrder(new ComparadorSuperficie()));
        paises5.addAll(paises2);
        System.out.println("TreeSet de países en orden inverso al orden " + 
            " expresado por el comparador de superficie(descendente superficie)\n " + paises5.toString());

        
    }
}
