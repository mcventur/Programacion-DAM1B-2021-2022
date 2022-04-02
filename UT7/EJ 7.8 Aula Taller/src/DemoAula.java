import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 *
 */
public class DemoAula {
    
    
    public static void main(String[] args) {
        //         Aula a = new Aula("A17", 23);
        //         AulaTaller at = (AulaTaller) a; // ClassCastException
        
        Aula a1 = new Aula("A18", 21);
        Aula a11 = new Aula("A18", 21);
        Aula a2 = new Aula("A19", 17);
        Aula a3 = new Aula("A20", 14);
        Aula a33 = new Aula("A20", 14);
        AulaTaller at1 = new AulaTaller("Taller 1", 16, 15);
        AulaTaller at2 = new AulaTaller("Taller 2", 25, 141);
        AulaTaller at3 = new AulaTaller("Taller 3", 24, 13);
        AulaTaller at4 = new AulaTaller("Taller 3", 24, 13);
        
        System.out.println("--------------------------");
        HashSet<Aula> aulas = new HashSet<Aula>();
        aulas.add(a1);
        aulas.add(a11);
        aulas.add(a2);
        aulas.add(at1);
        aulas.add(at1);
        aulas.add(at3);
        aulas.add(at4);
        System.out.println("HashSet sin duplicados");
        for (Aula a : aulas) {
            a.mostrar();
        }
        
        System.out.println("--------------------------");
        
        TreeSet<Aula> aulas2 = new TreeSet<Aula>();
        aulas2.add(a1);
        aulas2.add(a11);
        aulas2.add(a2);
        aulas2.add(at3);
        aulas2.add(at1);
        aulas2.add(at1);
        System.out.println(" TreeSet sin duplicados y ordenado por nombre de " +
                "aula");
        for (Aula a : aulas2) {
            a.mostrar();
        }
        
        System.out.println("--------------------------");
        System.out.println("Aulas ordenadas por pupitres (ascendente)");
        List<Aula> tmp = new ArrayList<>(aulas);
        Collections.sort(tmp, new Comparator<Aula>() {
            public int compare(Aula a1, Aula a2) {
                return Integer.compare(a1.getPupitres(), a2.getPupitres());
            }
        });
        for (Aula a : tmp) {
            a.mostrar();
        }
        
        System.out.println("--------------------------");
        System.out.println("TreeSet Aulas ordenado por nombre (descendente)");
        // Comparator<Aula> comparador =  Collections.reverseOrder(new
        // Comparator<Aula>() {
        // public int compare(Aula a1, Aula a2)  {
        // return a1.getNombre().compareToIgnoreCase(a2.getNombre());
        // }
        // });
        // aulas2 = new  TreeSet<Aula>(comparador);
        aulas2 = new TreeSet<Aula>(Comparator.reverseOrder());
        aulas2.add(a1);
        aulas2.add(a11);
        aulas2.add(a2);
        aulas2.add(at3);
        aulas2.add(at1);
        aulas2.add(at1);
        for (Aula a : aulas2) {
            a.mostrar();
        }
        
    }
}
