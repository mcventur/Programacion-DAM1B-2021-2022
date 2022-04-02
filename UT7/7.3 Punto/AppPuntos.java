import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class AppPuntos
{

    public static void main(String[] args)
    {
        Punto a = new Punto(8, 9);        
        Punto3D b = new Punto3D(1, 2, 3);   
        Punto c = new Punto3D(18, 19, 20);
        
        a = b;                
        a =  c;
        b =  (Punto3D) c;
        // b = (Punto3D) a; // fallo en ejecución
        

        Punto r = new Punto(8, 9);
        ArrayList<Punto> puntos = new ArrayList<>();
        puntos.add(a);
        if (!puntos.contains(r))  {
            puntos.add(r);
        }
        System.out.println(puntos.toString());

        int pos = puntos.indexOf(new Punto(8, 9));
        System.out.println(pos);

        HashSet<Punto> set = new HashSet<>();
        set.add(new Punto(8, 8));
        set.add(new Punto(8, 8));
        System.out.println(set.toString());

        HashMap<Punto, String> map = new HashMap<>();
        map.put(new Punto(8, 9), "a");
        map.put(new Punto(8, 9), "b");
        System.out.println(map.toString());

        
    }
}
