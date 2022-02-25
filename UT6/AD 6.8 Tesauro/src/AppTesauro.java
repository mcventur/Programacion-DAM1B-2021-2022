


/**
 * Clase AppTesauro -  incluye el método main()
 * Arranca la aplicación
 */
public class AppTesauro {

    /**
     *
     */
    public static void main(String[] args) {
        Tesauro tesauro = new Tesauro();
        tesauro.añadirSinonimo("obeso gordo");
        tesauro.añadirSinonimo("delgado enjuto fino flaco");
        tesauro.añadirSinonimo("delegar encargar encomendar facultar");
        //Añadimos algunas palabras extras, con sinónimos comunes
        tesauro.añadirSinonimo("excelente brillante colosal exquisito estupendo soberbio");
        tesauro.añadirSinonimo("maravilloso estupendo magnifico excelente soberbio");
        tesauro.añadirSinonimo("estupendo soberbio magnifico superior maravilloso");
        tesauro.escribirTesauro();

        String sinonimo = "soberbio";
        System.out.println("Se va a borrar el sinónimo " + sinonimo);
        System.out.println("Se ha borrado de las siguientes claves " + tesauro.borrarSinonimo(sinonimo).toString());
    }
}
