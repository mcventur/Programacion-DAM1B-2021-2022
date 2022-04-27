import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *  class Prueba2  
 *  
 */
public class EjemplosUT8
{

    /**
     *  
     */
    public void m1()    {
        try    {
            int[] array = new int[1];
            array[0] = 10;
            array[1] = 20;  // error
            System.out.println("Esto no se imprimirá si hay error");

        }
        catch (ArrayIndexOutOfBoundsException e)   {
            System.out.println("Error");
        }
        System.out.println("Fin");
    }

    /**
     *  
     */
    public void m2()    {
        try   {
            int[] array = new int[1];
            array[0] = 10;
            array[1] = 20;  // error
            System.out.println("Esto no se imprimirá si hay error");

        }
        catch (ArrayIndexOutOfBoundsException e)   {
            System.out.println("Errror");
        }
        finally    {
            System.out.println("en finally");
        }
        System.out.println("Fin");
    }

    /**
     *  
     */
    public void m3()    {
        try    {
            int[] array = new int[1];
            throw new IllegalArgumentException();
            //             array[0] = 10;
            //             array[1] = 20;  // error
            //             System.out.println("Esto no se imprimirá si hay error");

        }
        catch (ArrayIndexOutOfBoundsException e)    {
            System.out.println("Error");
        }
        finally    {
            System.out.println("en finally");
        }
        System.out.println("Fin");
    }

    /**
     *  
     */
    public void m4()    {
        try     {
            int[] array = new int[1];
            throw new IllegalArgumentException();
            //             array[0] = 10;
            //             array[1] = 20;  // error
            //             System.out.println("Esto no se imprimirá si hay error");

        }
        catch (ArrayIndexOutOfBoundsException e)  {
            System.out.println("Error");
        }

        System.out.println("Fin");
    }

    /**
     *       
     */
    public void m5() {

        try   {
            String str = "2m";
            int n = Integer.parseInt(str);
            System.out.println("Resultado " + n / 0);
        }
        catch (NumberFormatException e)    {
            System.out.println("Error, formato incorrecto");
        }
        catch (ArithmeticException e)    {
            System.out.println("Error, división entre 0");
        }
        System.out.println("Fin");

    }

    /**
     *  
     */
    public void m6()    {
        Scanner teclado = new Scanner(System.in);
        int num = 0;
        boolean correcto = false;
        while (!correcto)     {
            try      { 
                System.out.print("Teclee nº: ");
                num = teclado.nextInt();            
                System.out.println("Correcto "  + num);
                correcto = true;
            } 
            catch (InputMismatchException ex )   { 
                System.out.println("Incorrecto ");
                teclado.next();
            }

        }

    }

    /**
     *  When a scanner throws an InputMismatchException, 
     *  the scanner will not pass the token that caused 
     *  the exception, so that it may be retrieved or 
     *  skipped via some other method. 
     */
    public void m7()    {
        Scanner teclado = new Scanner(System.in);
        int cantidad = 4;
        int i = 1;
        while (i <= cantidad)   {
            try       { 
                System.out.print("Teclee nº: ");
                int num = teclado.nextInt();            
                System.out.println("Correcto "  + num);
                i++; 
            } 
            catch (InputMismatchException ex )   { 
                System.out.println("Incorrecto ");
                teclado.next();

            }

        }

    }

    /**
     * Calcular la suma de los números de array, solo de aquellos que sean correctos
     * Mostrar también la cantidad de incorrectos
     */
    public void m8() {
        String[] array = {"12", "4p", "21", "33", "5g", "100"};
        int error = 0;
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            try {
                suma += Integer.parseInt(array[i]);
            }
            catch (NumberFormatException ex) {
                error++;
            }

        }
        System.out.println("Suma: " + suma + "\nErrores: " + error);

    }

    

}
