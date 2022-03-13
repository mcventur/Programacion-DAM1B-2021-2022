package ut6.romanos.demo;

import ut6.romanos.modelo.ConversorRomanos;
import ut6.romanos.modelo.GestorRomanos;

/**
 * La clase que inicia el gestor de romanos
 */
public class AppRomanos {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error, Sintaxis: java ut6.romanos.demo.AppRomanos <romano1> <romano2> <romano3> ....");
        }
        else{
            //Pasada la validación de argumento
            ConversorRomanos cr= new ConversorRomanos();
            GestorRomanos gr=new GestorRomanos(cr);
            for (String romano : args) {
                gr.añadirRomano(romano);
            }
            //Mostramos el resultado
            gr.escribirListaArabigos();
        }
    }


}
