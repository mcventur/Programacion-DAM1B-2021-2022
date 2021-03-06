
/**
 * Un objeto de esta clase modela una urna
 * que guarda una serie de bolas blancs y/o negras
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Urna {

    private ArrayList<Bola> urna;

    /**
     * Constructor
     */
    public Urna() {
        urna = new ArrayList<>();
    }

    /**
     * A?ade una nueva bola a la urna
     *
     * @param b la bola a a?adir
     */
    public void meterBola(Bola b) {
        urna.add(b);
    }


    /**
     * Saca una bola aleatoria de la urna
     *
     * @return la bola sacada
     * @throws RuntimeException si la urna est? vac?a
     */
    public Bola sacarBola() {
        if (urna.isEmpty()) {
            throw new RuntimeException("Urna vac?a");
        }
        else{
            return urna.remove(obtenerPosicionAleatoria(urna.size()));
        }
    }

    /**
     * @param hasta el l?mite hasta el que generar valores
     *              aleatorios
     * @return un valor que representa una posici?n
     * en la urna
     */
    private int obtenerPosicionAleatoria(int hasta) {
        Random generador = new Random();
        return generador.nextInt(hasta);
    }

    /**
     * @return cantidad de bolas blancas en la urna
     */
    public int cuantasBlancas() {
        int numBlancas = 0;
        for (Bola b : urna) {
            if (b.esBlanca()) {
                numBlancas++;
            }
        }
        return numBlancas;
    }

    /**
     * @return cantidad de bolas negras en la urna
     */
    public int cuantasNegras() {
        int numNegras = 0;
        for (int i = 0; i < urna.size(); i++) {
            if (urna.get(i).esNegra()) {
                numNegras++;
            }
        }
        return numNegras;
    }

    /**
     * Muestra la urna
     */
    public void mostrarUrna() {
        Iterator<Bola> itUrna = urna.iterator();
        while (itUrna.hasNext()) {
            System.out.println(itUrna.next() + "\n");
        }
    }

    /**
     * Borra las bolas de color blanco
     */
    public void borrarBlancas() {
        Iterator<Bola> itUrna = urna.iterator();
        while (itUrna.hasNext()) {
            if (itUrna.next().esBlanca()) {
                itUrna.remove();
            }
        }
    }


}
