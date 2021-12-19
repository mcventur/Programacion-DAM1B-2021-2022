
/**
 * Clase que cuenta las horas de sol en el año
 * 
 */
public class EstadisticaLuzSolar
{

    private static final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio",
            "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    private int[] horas;

    public EstadisticaLuzSolar()    {
        horas = new int[]{100, 90, 120, 150, 210, 250, 
            300, 310, 280, 230, 160, 120};

    }

    /**
     * Calcula y devuelve la media de horas de sol
     *
     *  
     */
    public double getMediaSol()    {
        int suma = 0;
        for (int i = 0; i < horas.length; i++)  {
            suma += horas[i];

        }
        return (double) suma / horas.length;
    }

    /**
     * devuelve el nombre del mes con más horas de sol
     */
    public String mesMasSoleado()   {
        int masSoleado = 0;
        for (int i = 0; i < horas.length; i++)  {
            if (horas[i] > horas[masSoleado]) {
                masSoleado = i;
            }
        }

        return MESES[masSoleado];
    }

    /**
     * mes con menos horas de sol
     *
     * @return el nombre del mes
     */
    public String mesMenosSoleado()   {

        int menosSoleado = 0;
        for (int i = 0; i < horas.length; i++)   {
            if (horas[i] < horas[menosSoleado])    {
                menosSoleado = i;
            }
        }

        return MESES[menosSoleado];
    }
}