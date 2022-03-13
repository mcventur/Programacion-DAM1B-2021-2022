

/**
 *
 */


public class TestUrna {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Número de parámetros incorrecto. Sintaxis: \n java TestUrna <numBolas>");
        }
        else{
            //Creamos la urna y vamos metiendo bolas
            Urna miUrna = new Urna();
            for(int i=0;i<Integer.parseInt(args[0]);i++){
                Bola b=new Bola();
                miUrna.meterBola(b);
            }
            //Mostramos la urna
            miUrna.mostrarUrna();
            //Sacamos una bola aleatoria
            Bola sacada=miUrna.sacarBola();
            System.out.println("Sacada una " + sacada);
            System.out.println("Me quedan " + miUrna.cuantasBlancas() + " blancas y " + miUrna.cuantasNegras() + " negras");
            //Borramos blancas
            miUrna.borrarBlancas();
            System.out.println("Tras borrar blancas mi urna queda \n");
            miUrna.mostrarUrna();
        }
    }


}
