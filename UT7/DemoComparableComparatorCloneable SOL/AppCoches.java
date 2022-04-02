import java.util.Arrays;
/**
 * 
 *  
 */
public class AppCoches
{

   
    public static void main(String[] args)    {
        if (args.length != 1)        {
            System.out.println("Error, Sintaxis: java AppCoches <n>");
        }
        else {
            int cuantos = Integer.parseInt(args[0]);
            Coche[] coches = new Coche[cuantos];
            for (int i = 0; i < cuantos; i++)      {
                int velocidad = (int) (Math.random() * 81 + 220);
                coches[i] = new Coche(velocidad);
            }
            Arrays.sort(coches);
            for (Coche co: coches)     {
                System.out.println(co.toString());
            }
        }
    }
}
