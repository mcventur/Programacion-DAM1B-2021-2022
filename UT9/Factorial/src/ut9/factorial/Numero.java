
package ut9.factorial;

/**
 * Guarda un nº natural
 */
public class Numero {

    private int numero;

    public Numero() {

        this.numero = 1;
    }

    public Numero(int numero) throws IllegalArgumentException {
        if (numero <= 0) {
            throw new IllegalArgumentException("Nº no positivo");
        }

        this.numero = numero;
    }

    public int getNumero() {

        return numero;
    }


    public void setNumero(int numero) throws IllegalArgumentException {
        if (numero <= 0) {
            throw new IllegalArgumentException("Nº no positivo");
        }
        this.numero = numero;
    }


    public int factorial() {

        int facto = 1;
        for (int i = 2; i <= numero; i++) {
            facto *= i;
        }
        return facto;
    }


    public boolean esPrimo() {

        int divisor = 2;
        while (divisor <= (numero / 2)) {
            if (numero % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }

}
