import java.util.InputMismatchException;
/**
 *  Programa que muestra que no es necesario parar
 *  un programa siempre que se produzca una excepción
 *  Leer una serie de nºs por teclado, tantos como el valor pasado
 *  como argumento del main
 *   
 *  Todas las excepciones van a ser no verificadas, las vamos a tratar capturándolas
 *  Capturaremos - errores en nº argumentos del main, conversión de formato del argumento del main,
 *  error de formato de cada nº leído (ignoraremos el nº y leeremos otro)
 *  
 *  Veremos además como las sentencias try .. catch se pueden anidar
 */
import java.util.Scanner;
public   class OtraPrueba
{

    public static void main(String[] args)    {
        try    {
            int cantidad = Integer.parseInt(args[0]);
            Scanner sc = new Scanner(System.in);    
            int suma = 0;
            int i = 1;
            while (i <= cantidad)   {

                try   {
                    System.out.println("Dame número: ");
                    //   int num =  Integer.parseInt(sc.nextLine());
                    int num =  sc.nextInt();
                    suma += num;
                    i++;

                }
                catch (NumberFormatException e)  {
                    System.out.println("Error en formato de número, introduzca otro correcto");

                }                
                // catch (InputMismatchException e)  {
                    // System.out.println("Error en formato de número, introduzca otro correcto");
                    // sc.nextLine();

                // }
            }  

            System.out.println("La suma es: " + suma);

        }
        catch (IndexOutOfBoundsException e)  {
            System.out.println("Error, no hay argumentos en el main() ");
        }
        catch (NumberFormatException e) {
            System.out.println("Error, parámetros incorrectos en el main() " + e.getMessage());
        }
    }
}