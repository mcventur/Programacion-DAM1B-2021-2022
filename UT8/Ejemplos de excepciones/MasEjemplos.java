
/**
 *  
 */
public class MasEjemplos
{

    private int a, b;
    private String cadena;

    /**
     * Constructor de la clase MasEjemplos
     */
    public MasEjemplos(int a, int b, String cadena)    {
        this.a = a;
        this.b = b;
        this.cadena = cadena;
    }
 
    
    public int factorial1()  throws FactorialNegativoExcepcion    {
        if ( a < 0 )    {
            throw new FactorialNegativoExcepcion(a);
        }
        int f = 1;
        for (int i = 1; i < a; i++)   {
            f *= i;
        }
        return f;
    }

    public void escribirLongitudCadena1()    {
        try    {
            System.out.println(cadena.length());
        }
        catch (NullPointerException e)    {
            System.out.println("Referencia null");
            e.printStackTrace();
        }
    }

    public void escribirLongitudCadena2() throws NullPointerException    {
        if (cadena == null) {
            throw new NullPointerException("Referencia null");
        }
        System.out.println(cadena.length());        
    }

 
    public void escribirLongitudCadena3()   {  //no se avisa, es posible porque no es verificada
        if (cadena == null) {
            throw new NullPointerException("Referencia null");
        }
        System.out.println(cadena.length());        
    }

}
