
/**
 * La clase mantiene un map en el
 * que se registran las veces que 
 * aparece cada uno de los números
 * de un fichero de texto
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FrecuenciaNumeros
{
    HashMap<String,Contador> frecuencias;

    /**
     * Constructor de la clase FrecuenciaNumeros
     */
    public FrecuenciaNumeros()
    {
        frecuencias=new HashMap<>();
    }

    /**
     * 
     *
     * @param  numero el nº a añadir
     */
    public void añadirNumero(int numero)
    {
        String strNum=String.valueOf(numero);
        Contador frecActual=frecuencias.get(strNum);
        if(frecActual==null){
            frecActual=new Contador(1);
            frecuencias.put(strNum,frecActual);
        }
        else{
            frecActual.incrementar();
        }
    }


    /**
     * lee los números de un fichero de texto 
     * Este método no hay que modificarlo
     *      
     */
    public void cargarDeFichero() 
    {
        try
        {
            Scanner sc = new Scanner(new File("numeros.txt"));
            while (sc.hasNext() )
            {
                añadirNumero(sc.nextInt());
            }
            sc.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Listar cada número aparecido y su frecuencia
     * Se utiliza Map.Entry
     */
    public void listarFrecuencias()
    {
        Set<Map.Entry<String,Contador>> setEntradas=frecuencias.entrySet();
        for (Map.Entry<String, Contador> entrada : setEntradas) {
            System.out.println("Nº " + entrada.getKey() + "\tFrecuencia " + entrada.getValue() );
        }
    }
    /**
     * 
     * Muestra cuántos números diferentes han aparecido
     * y la relación de todos ellos
     * 
     * Se utiliza la "vista" sobre las claves
     * y un for each
     */
    public void listarNumeros()
    {
        Set<String> claves=frecuencias.keySet();
        System.out.println("Números aparecidos " + claves.size() + "\n");
        for (String c : claves) {
            System.out.print(c + "\t");
        }
        System.out.println();//Salto de línea
    }

    /**
     * Método para probar la clase
     * @param args
     */
    public static void main(String[] args) {
        FrecuenciaNumeros fn=new FrecuenciaNumeros();
        fn.cargarDeFichero();
        fn.listarNumeros();
        fn.listarFrecuencias();
    }
}
