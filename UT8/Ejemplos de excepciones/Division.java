/**
 * Ejemplo que muestra que se pueden generar varios tipos de excepciones en
 * un mismo método
 * Posibles excepciones no verificadas que se pueden generar
 * ArrayIndexOutOfBoundsException, NumberFormatException, ArithmeticException.
 * Aunque son no verificadas las vamos a tratar capturándolas
 */
public class Division
{
    public static void main(String[] args)    {

        try    {
            //System.out.println("Antes de dividir ");
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println(num1 / num2); 
            // System.out.println("Después de dividir ");
            throw new IllegalArgumentException();
        } 
        catch (ArithmeticException exc)    {
            System.out.println(exc.getMessage() + "Excepción aritmética");
            //exc.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException  exc)  {
            System.out.println(exc.getMessage() + " Indice fuera de rango");        
            //exc.printStackTrace();
        }
        catch (NumberFormatException  exc)  {
            System.out.println(exc.getMessage() + " Formato erróneo");   
            //exc.printStackTrace();
        }
        finally  {

            System.out.println("Bloque finally");        
        }
        System.out.println("Fin del main");   
    }
}

