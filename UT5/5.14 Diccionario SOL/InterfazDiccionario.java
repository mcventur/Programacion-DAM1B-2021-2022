
/**
 * clase InterfazDiccionario 
 *  
 */
import java.util.Scanner;
public class InterfazDiccionario
{
    private static final int AÑADIR = 1;
    private static final int MOSTRAR = 2;
    private static final int TRADUCIR = 3;
    private static final int SALIR = 4;
    
    private Scanner teclado;
    private Diccionario diccionario;

    /**
     * Constructor de objetos de la clase InterfazDiccionario
     */
    public InterfazDiccionario(Diccionario diccionario)    {
        teclado = new Scanner(System.in);
        this.diccionario = diccionario;
        
    }

    /**
     * Incluye la lógica de la aplicación
     *  
     */
    public void iniciar()   {
        borrarPantalla();
        int opcion = menu();
        while (opcion != SALIR)   {
            switch (opcion)        {
                case AÑADIR: añadirPalabra();
                              break;
                case MOSTRAR: mostrarDiccionario();
                              break;
                case TRADUCIR: traducirPalabra();
                              break;
                
            }
            opcion = menu(); 
        }
    }
    
    /**
     * Presenta el menú 
     * @return  la opción seleccionada
     */
    private int menu()    {
        System.out.println("********************************");
        System.out.println("Gestión de un diccionario\n");
        System.out.println("********************************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Mostrar diccionario");
        System.out.println("3. Traducir palabra");
        System.out.println("4. Salir");
        System.out.print("Teclea opción: ");
        int opcion = teclado.nextInt();
        while (!opcionValida(opcion))   {
             System.out.print("Opción incorrecta, Teclea opción: ");
             opcion = teclado.nextInt();
        }
        return opcion;
    }
    
    /**
     *  Devuelve true si la opción es correcta, false en otro caso
     *
     */
    private boolean opcionValida(int opcion)    {
        return opcion >= AÑADIR && opcion <= SALIR;
    }

 
    
    /**
     * Añade una nueva palabra al diccioanrio
     */
    private void añadirPalabra()   {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        System.out.println("Palabra a añadir");
        System.out.print("Castellano: ");
        String castellano = teclado.nextLine();
        System.out.print("Inglés: ");
        String ingles = teclado.nextLine();
        diccionario.insertarPalabra(new Palabra(castellano, ingles));
        
    }
    
     /**
     * Mostrar el diccioanrio
     */
    private void mostrarDiccionario()   {
        borrarPantalla();
        diccionario.escribirDiccionario();
        
    }
    
    /**
     * Traducir una  palabra al diccioanrio
     */
    private void traducirPalabra()    {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        System.out.println("Palabra a traducir");
        System.out.print("Posición: ");
        int posi = teclado.nextInt();
        String  traducción = diccionario.traducirPalabra(posi);
        if (traducción != null)   {
            System.out.println(traducción);
        }
        else   {
            System.out.println("No existe la palabra solicitada");
        }
        
    }
    
    
    /**
     * Borrar la pantalla
     */
    private void borrarPantalla()    {
        System.out.println("\u000C");
    }
    
    
    
    
    
    
    
}
