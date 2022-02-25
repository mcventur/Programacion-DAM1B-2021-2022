import java.util.HashSet;

/**
 * Representa un conjunto de puntos
 */
public class ConjuntoPuntos
{
    private HashSet<Punto> puntos;

    /**
     * Constructor  
     */
    public ConjuntoPuntos()
    {
        puntos = new HashSet<>();
    }

    /**
     *  Añade un punto al conjunto
     */
    public boolean add(Punto p)
    {
        return puntos.add(p);
    }

    /**
     * 
     */
    public void mostrar()
    {
        for (Punto punto: puntos)   {
            System.out.println(punto.toString());
        }
    }

    /**
     *  
     */
    public static void main(String[] args)
    {
        ConjuntoPuntos conjunto = new ConjuntoPuntos();
        conjunto.add(new Punto(2, 3));
        conjunto.add(new Punto(4, 5));
        conjunto.add(new Punto(2, 3));
        conjunto.mostrar();
    }
}
