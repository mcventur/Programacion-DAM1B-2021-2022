
/**
 *  DemoFecha   
 *  https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.util.Locale;

public class DemoFechaJava8
{

    /**
     * Constructor  
     */
    public DemoFechaJava8()
    {

    }

    /**
     *  
     *      
     */
    public void printHoy()
    {
        LocalDate hoy = LocalDate.now();
        System.out.println("Escribimos fecha con toString() ");
        System.out.println(hoy.toString()); 
        System.out.println("Escribimos día, mes y año separademante ");
        System.out.println(hoy.getDayOfMonth() + " / "  + hoy.getMonth() + " / " +   hoy.getYear());
        System.out.println("Escribimos fecha formateada con un determinado patrón");
        System.out.println(hoy.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
    }

    /**
     *   
     *      
     */
    public void printOtraFecha()
    {
        LocalDate fecha1 = LocalDate.of(2013, Month.AUGUST, 10); // 10 de Agosto de 2013
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String strFecha1 =  fecha1.format(formateador);
        System.out.println(strFecha1);

        LocalDate fecha2 = LocalDate.of(2013, 3, 11); // 11 de Marzo de 2013
        formateador = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String strFecha2 =  fecha2.format(formateador);
        System.out.println(strFecha2);

        /* ----------------------------------------- */

        Locale spanishLocale = new Locale("es", "ES");
        LocalDate fechaLocal = LocalDate.of(2021, 01, 01);
        String str = fechaLocal.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",
                                            spanishLocale));
        System.out.println("'2021-01-01' en Spanish: " + str);

        fechaLocal = LocalDate.now();
        formateador = DateTimeFormatter.ofPattern("dd MMMM yyyy", spanishLocale);
        System.out.println(fechaLocal.format(formateador));
    }

    /**
     *  Obtener y escribir la hora
     *      
     */
    public void printHora()
    {
        LocalTime ahora = LocalTime.now();
        System.out.println(ahora.toString()); 
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("H:m:s");
        System.out.println(ahora.format(formateador));
        System.out.println(ahora.getHour() + ":"  + ahora.getMinute() + ":" +   ahora.getSecond());

        LocalTime otraHora = LocalTime.of(22, 33); //10:33 PM
        System.out.println(otraHora.toString()); 
    }

    /**
     *  
     *
     */
    public void parsearFechaHora()
    {
        LocalDate fechaParseada = LocalDate.parse("2015-01-29");
        System.out.println(fechaParseada.toString()); 

        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str,  formatter);
        System.out.println(dateTime.toString()); 

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "16/08/2016";
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(date.toString()); 


    }

}
