import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Incluye la clase DemoCuenta en el paquete cuentas.test
 */
public class DemoCuenta {

    /**
     * La clase acepta a través de argumentos del main
     * el importe de la cuenta. Si el valor del importe es correcto se crea
     * la cuenta
     * A continuación de pide (con Scanner) al usuario la cantidad a ingresar
     * y se añade y después la cantidad a sacar y se reintegra.
     *
     * Hay que capturar todas las posibles excepciones que se puedan dar
     * indicando mensajes de error adecuados en cada caso
     * Incluye un bloque finally en el que se muestre el estado de la cuenta (toString() de Cuenta)
     * Puede que tengas que tratar otra excepción dentro de finally
     *
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cuenta c = null;
        try {
            double importe = Double.parseDouble(args[0]);
            c = new Cuenta(importe);
            System.out.print("\nIntroduce la cantidada a ingresar: ");
            c.ingresar(sc.nextDouble());
            System.out.print("\nIntroduce la cantidad a retirar: ");
            c.sacar(sc.nextDouble());
        } catch (NumberFormatException e) {
            System.out.println("Error en formato de argumento: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error en el número de argumentos del main");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear/ingresar/sacar: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error en el dato introducido: " + e);
        } finally {
            try{
                System.out.println(c.toString());
            }
            catch(NullPointerException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
