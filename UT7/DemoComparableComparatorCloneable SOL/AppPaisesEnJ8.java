import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;

/**
 *  
 */
public class AppPaisesEnJ8
{

    
    public static void main(String[] args)    {
        List<Pais> paises = new ArrayList<Pais>();
        paises.add(new Pais("Francia", 234, 37));
        paises.add(new Pais("Noruega", 198, 15));
        paises.add(new Pais("Suecia", 200, 21));
        paises.add(new Pais("Dinamarca", 100, 9));

        // --------------------------------------
        // con el nuevo método sort() del interface List de Java 8
        System.out.println("Ordenado ascendente de nombre");
        paises.sort(Comparator.naturalOrder());
        System.out.println(paises.toString() + "\n");  
        
        System.out.println("Ordenado descendente de nombre");
        paises.sort(Comparator.reverseOrder());
        System.out.println(paises.toString() + "\n");  

        System.out.println("Ordenado de menor a mayor superficie Lambda");  
        Collections.sort(paises,  (p1, p2) -> (int) Math.signum(p1.getSuperficie() - p2.getSuperficie()) );  

        paises.sort((p1, p2) -> (int) Math.signum(p1.getSuperficie() - p2.getSuperficie()));
        System.out.println(paises.toString() + "\n");  

        System.out.println("Ordenado de mayor a menor superficie Lambda");  
        Collections.sort(paises, (p1, p2) -> (int) Math.signum(p2.getSuperficie() - p1.getSuperficie()));  
        System.out.println(paises.toString() + "\n");  

        System.out.println("Ordenado de mayor a menor habitantes Lambda");  
        Collections.sort(paises, (p1, p2) ->  (p2.getHabitantes() - p1.getHabitantes()));  
        System.out.println(paises.toString() + "\n"); 

        // paises.sort(new ComparadorSuperficie());
        // System.out.println(paises.toString() + "\n");   

        // System.out.println("Ordenado de mayor a menor superficie");  
        // paises.sort(Collections.reverseOrder(new ComparadorSuperficie()));
        // System.out.println(paises.toString() + "\n"); 

        Comparator<Pais> comparador = (p1, p2) -> (int) Math.signum(p1.getSuperficie() - p2.getSuperficie());
        Set<Pais> paises2 = new TreeSet<>(comparador);
        paises2.add(new Pais("Francia", 234, 37));
        paises2.add(new Pais("Noruega", 198, 15));
        paises2.add(new Pais("Suecia", 200, 21));
        paises2.add(new Pais("Dinamarca", 100, 9));
        System.out.println("TreeSet de países de menor a mayor superficie Lambda\n " + paises2.toString());

        Set<Pais> paises3 = new TreeSet<>((p1, p2) -> p1.getHabitantes() - p2.getHabitantes());
        paises3.addAll(paises2);
        System.out.println("TreeSet de países de menor a mayor habitantes Lambda\n " + paises3.toString());
        
        // --------------------------------------
        // con expresiones Lambda
        System.out.println("Con expresiones Lambda");
        System.out.println("Ordenado de menor a mayor superficie");  
        paises.sort((p1, p2) -> Double.compare(p1.getSuperficie(), p2.getSuperficie()));
        System.out.println(paises.toString() + "\n"); 

        System.out.println();

        System.out.println("Con expresiones Lambda");
        System.out.println("Ordenado de mayor a menor nº habitantes");  
        paises.sort((p1, p2) -> Double.compare(p2.getHabitantes(), p1.getHabitantes()));
        System.out.println(paises.toString() + "\n"); 

        System.out.println();

        System.out.println("Con expresiones Lambda");
        System.out.println("Ordenado de mayor a menor nombre");  
        paises.sort((p1, p2) -> p2.getNombre().compareTo(p1.getNombre()));
        System.out.println(paises.toString() + "\n"); 
    }
        
        
        
      
}
