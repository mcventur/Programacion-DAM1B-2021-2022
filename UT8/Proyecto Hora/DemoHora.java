
/**
 *   
 */
public class DemoHora
{

    private Hora h1;

    /**
     * Constructor  
     */
    public DemoHora()    {

    }

    /**
     *  Crea una hora incorrecta  y comprueba que aunque no captures la excepción
     *  el compilador no se queja
     *  Captura a continuación la excepción
     *  
     *  Cambia en la clase Hora la excepción a IOException y comprueba el aviso del compilador
     *  Deshaz los cambios
     *  
     *  Crea ahora una clase propia HoraExcepcion que herede de RuntimeException con constructor,
     *  atributo y toString()
     *  Haz los cambios en la clase Hora para que lance esta nueva excepción. 
     *  Es verificada o no verificada? Verificada
     *  
     *  
     * 
     */
    public static void demo()    {
        try    {
            Hora h1 = new Hora(32, 22, 33);
            System.out.println(h1.toString());
        }
        catch (HoraExcepcion ex)    {
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
