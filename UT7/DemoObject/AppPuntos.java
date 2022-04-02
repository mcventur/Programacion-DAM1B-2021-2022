import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;


public class AppPuntos
{

   
    public static void main(String[] args)    {
        Punto p = new Punto(8, 9);
        Punto r = new Punto(8, 9);
        ArrayList<Punto> puntos = new ArrayList<>();
        puntos.add(p);
        if (!puntos.contains(r))  {
            puntos.add(r);
        }
        System.out.println(puntos.toString());
        System.out.println("--------------------------");

        int pos = puntos.indexOf(new Punto(8, 9));
        System.out.println(pos);
        System.out.println("--------------------------");

        HashSet<Punto> set = new HashSet<>();
        set.add(new Punto(8, 8));
        set.add(new Punto(8, 8));
        System.out.println(set.toString());
        System.out.println("--------------------------");

        HashMap<Punto, String> map = new HashMap<>();
        map.put(new Punto(8, 9), "a");
        map.put(new Punto(8, 9), "b");
        System.out.println(map.toString());
        System.out.println("--------------------------");

        TreeSet<Punto> set2 = new TreeSet<>();
        set2.add(new Punto(8, 8));
        set2.add(new Punto(8, 8));
        set2.add(new Punto(8, 18));
        set2.add(new Punto(-8, 8));          
        System.out.println(set2.toString());
        System.out.println("--------------------------");

        TreeSet<Punto3D> set3 = new TreeSet<>();
        set3.add(new Punto3D(8, 8, 18));
        // set3.add(new Punto3D(8, 8, 8));
        set3.add(new Punto3D(8, 8, -8));
        // set3.add(new Punto3D(7, 8, 8));
        System.out.println(set3.toString());

        System.out.println("--------------------------");

        Imprimible imp = new Punto3D(4, 5, 6);
        imp.print();

        // Punto3D pp = new Punto3D(8, 8, -8);
        // Punto x = pp;
        //   x = imp; // tipos imcompatibles
        //   pp = imp; // tipos imcompatibles

    }
}
