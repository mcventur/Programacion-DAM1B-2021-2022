import java.io.IOException;

/**
 *  
 */
public class Ejemplo01
{

    /**
     * Constructor  
     */
    public Ejemplo01()    {

    }

    /**
     *  
     *
     */
    public void m1()    {
        m2();
        System.out.println("Fin de m1()");
    }

    /**
     *  
     *
     */
    public void m2()    {
        m3(new int[]{2});
        System.out.println("Fin de m2()");
    }

    /**
     *  
     *
     */
    public void m3(int[] array)    {
        System.out.println(array[1]);
        System.out.println("Fin de m3()");
    }

    /**
     *  
     *
     */
    public void m1(int[] array)    {
        System.out.println(array[1]);
    }

    /**
     * 
     */
    public  void prueba1(int a, int b)    {
        // if (b == 0)     {
            // throw new IllegalArgumentException("Error en argumento");
        // }
        System.out.println(a / b);
    }

    /**
     *  
     *  Método que lanza una excepción no verificada IllegalArgumentException
     *   
     *  Se lanza y no se trata (las no verificadas  no es obligatorio tratarlas)
     * 
     */
    public void metodoV1(int n) throws IllegalArgumentException    {
        if (n < 0)  {
            throw new IllegalArgumentException("Error en argumento");
        }
        System.out.println("Método llamado");
    }

    /**
     *  
     *  Método cliente que llama a un método que lanza una excecpción no verificada
     * El cliente captura la excepción
     */
    public void clienteMetodoV1()    {
        try  {
            metodoV1(-8);
        }
        catch (IllegalArgumentException ex)  {
            System.out.println("Capturada la excepción no verificada " + ex.getMessage());
        }

    }

    /**
     *  
     *  Método que lanza una excepción  verificada
     *  La excepción   verificada es obligatorio tratarla
     *  El método avisa de que va a lanzar la excepción
     * 
     */
    public void metodoV2()   throws IOException    {
        // lanzamos la excepción IOException
        throw new IOException("Excepción verificada");

    }

    /**
     *  
     *  Método cliente que llama a un método que lanza una excecpción verificada
     *  La captura (si no quiere capturarla la tendrá que propagar)
     */
    public void clienteMetodoV2()  throws IOException    {
        metodoV2();

    }

    /**
     * Lanza una excepción no verificada ArithmeticException, no la trata  
     */
    public int dividir01(int x, int y)    {
        if (y == 0)  {
            throw new ArithmeticException("División entre 0");
        }
        return x / y;
    }

    /**
     * Lanza una excepción no verificada IllegalArgumentException
     * y otra propia NumeroNaturaException  verificada y avisa
     */
    public int  dividir(int dividendo, int divisor) throws NumeroNaturalException    {
        if (divisor == 0)  {
            throw new IllegalArgumentException("Error argumento igual a 0");
        }

        if (dividendo  < 0 || divisor < 0)   {
            throw new NumeroNaturalException("Error argumento menor que 0");
        }
        return dividendo / divisor;
    }

    /**
     * Método cliente del método dividir()
     * Captura las excepciones tanto verificadas como no verificadas que se pueden generar al ejecutar
     * el método anterior
     */
    public void demoDividir()    {
        int a =  -3;
        int b =  0;
        try    {
            //  System.out.println(4 / 0);
            System.out.println("Resultado " + dividir(a, b));
        }
        catch (IllegalArgumentException exc)   {

            exc.printStackTrace();
        }
        catch (NumeroNaturalException exc)    {
            System.out.println("Error " + exc.getMessage());
        }
        finally    {
            System.out.println("En finally");
        }
        System.out.println("Fin  del método");
    }


    /**
     * Avisa de que lanza una excepción no verificada (aunque no es obligatorio avisar en este caso)
     */
    public void aa() throws NumberFormatException    {
        throw new NumberFormatException("Error en formato");
    }

    /**
     * Ni captura ni propaga la excepción porque es no verificada
     * En este caso se para la ejecución del programa, es el sistema el
     * que se hace cargo de la excepción
     */
    public void bb()     {
        aa();
    }

    /**
     * Avisa de que lanza una excepción verificada
     */
    public void a() throws IOException    {
    }

    /**
     * Propaga la excepción que lanza a()
     */
    public void b() throws IOException    {
        a();
    }

    /**
     *  
     */
    public void pp(int a, int b) {

        System.out.println(a / b);
    }

    /**
     *  
     *
     */
    public static void main(String[] args) //throws Exception
    {

        Ejemplo01 ejemplo = new Ejemplo01();
        ejemplo.m1();
        // ejemplo.pp(8, 0);

    }

}
