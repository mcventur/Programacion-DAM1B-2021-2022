package pkgbanco;

/**
 * Clase para probar la jerarquía de herencia
 *
 */
public class AppCuenta {


    public static void main(String[] args) {
        //Cuenta de Ahorro
        CuentaAhorro miCuenta = new CuentaAhorro("Elena",1200,2);
        System.out.println("Situación inicial de la cuenta de ahorro...");
        System.out.println(miCuenta.toString() + "\n");
        System.out.println("Ingresando 2000€ en la cuenta...\n");
        miCuenta.ingresar(2000);
        System.out.println("Retirando 150€ de la cuenta...\n");
        miCuenta.reintegrar(150);
        System.out.println("Situación final de la cuenta");
        System.out.println(miCuenta.toString()+"\n");

        //Cuenta Corriente
        CuentaCorriente tuCuenta=new CuentaCorriente("Juan",1000,600);
        System.out.println("Situación inicial de la Cuenta Corriente...");
        System.out.println(tuCuenta.toString() + "\n");

        System.out.println("Retiramos 500€ de la cuenta...");
        tuCuenta.reintegrar(500);
        System.out.println("Situación actual de la Cuenta Corriente...");
        System.out.println(tuCuenta.toString() + "\n");

        System.out.println("Ingresamos 2000€ en la cuenta...");
        tuCuenta.reintegrar(2000);
        tuCuenta.ingresar(2000);
        System.out.println("Situación final de la Cuenta Corriente...");
        System.out.println(tuCuenta.toString());
    }

}
