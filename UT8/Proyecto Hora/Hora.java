
/**
 * Clase Hora cuyos objetos almacenan la hora
 * el formato hh, mm, ss
 * 
 *  
 */
public class Hora
{
    private int hora;
    private int minutos;
    private int segundos;

    
    /**
     * constructor parametrizado para los objetos de la clase Hora
     * Avisa de que en la creación se puede lanzar una excepción de tipo 
     * IllegalArgumentException
     * Si la hora es incorrecta se lanza la excepción
     * Idem para minutos y segundos
     */
    public Hora(int hora, int minutos, int segundos) throws HoraExcepcion    {
        if (hora < 0 || hora > 23)     {
            throw new HoraExcepcion("Hora incorrecta");
        }
        this.hora = hora;
        if (minutos < 0 || minutos > 59)   {
            throw new HoraExcepcion("Minutos incorrectos");
        }
        this.minutos = minutos;
        if (segundos < 0 || segundos > 59) {
            throw new HoraExcepcion("Segundos incorrectos");
        }
        this.segundos = segundos;


    }   

    /**
     * Obtener la hora
     */
    public int getHora()    {
        return hora;
    }

    /**
     * Obtener los minutos 
     */
    public int getMinutos()    {
        return minutos;
    }

    /**
     * Obtener lossegundos  
     */
    public int getSegundos()   {
        return segundos;
    }

    /**
     * Establecer una nueva hora
     */
    public void setHora(int hora) throws HoraExcepcion    {
        if (hora < 0 || hora > 23)  {
            throw new HoraExcepcion("Hora incorrecta");
        }
        this.hora = hora;
    }

    /**
     * Establecer minutos
     */
    public void setMinutos(int minutos) throws HoraExcepcion   {
        if (minutos < 0 || minutos > 59)  {
            throw new HoraExcepcion("Minutos incorrectos");
        }
        this.minutos = minutos;
    }

    /**
     * Establecer segundos
     */
    public void setSegundos(int segundos) throws HoraExcepcion    {
        if (segundos < 0 || segundos > 59)    {
            throw new HoraExcepcion("Segundos incorrectos");
        }
        this.segundos = segundos;
    }

    /**
     * Representación textual de la hora hh:mm:ss
     */
    public String  toString()    {        
        return String.format("%02d:%02d:%02d", hora, minutos, segundos);
    }

    /**
     * Devolver nº de segundos transcurridos
     */
    public int aSegundos()    {
        return hora * 3600 + minutos * 60 + segundos;
    }

    /**
     * Avanzar un segundo la hora
     */
    public void avanzarSegundo()    {
        segundos++;
        if (segundos == 60)     {
            segundos = 0;
            minutos++;
            if (minutos == 60)      {
                minutos = 0;
                hora++;
                if (hora == 24)          {
                    hora = 0;
                }
            }

        }
    }

    /**
     * Retrasar un segundo la hora
     */
    public void retrasarSegundo()  {
        segundos--;
        if (segundos == -1)     {
            segundos = 59;
            minutos--;
            if (minutos == -1)       {
                minutos = 59;
                hora--;
                if (hora == -1)    {
                    hora = 23;
                }
            }

        }
    }
}


