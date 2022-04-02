import java.util.Comparator;

/**
 *  
 * 
 *  Esta clase encapsula un nuevo criterio de ordenación del país, 
 *  en orden ascendente de superficie
 */
public class ComparadorSuperficie implements Comparator<Pais>
{

    /**
     *   
     * 
     */
    public int compare(Pais p1, Pais p2)    {
        return Double.compare(p1.getSuperficie() , p2.getSuperficie());
        // if (p1.getSuperficie() < p2.getSuperficie())    {
            // return -1;
        // }
        // if (p1.getSuperficie() > p2.getSuperficie())   {
            // return 1;
        // }
        // return 0;

      
    }
}

