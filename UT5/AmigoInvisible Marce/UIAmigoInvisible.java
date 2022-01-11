import java.util.Scanner;

public class UIAmigoInvisible {
    private static final int CREAR = 1;
    private static final int ASIGNAR = 2;
    private static final int MOSTRAR = 3;
    private static final int CONSULTAR = 4;
    private static final int BORRAR = 5;
    private static final int SALIR = 6;

    private static Scanner teclado = new Scanner(System.in);

    private JuegoAmigoInvisible juego;

    public UIAmigoInvisible(JuegoAmigoInvisible juego) {
        this.juego = juego;
    }

    public void ejecutar() {
        int opcion = menu();
        while (opcion != SALIR) {
            borrarPantalla();
            switch (opcion) {
                case CREAR:
                    crearParticipantes();
                    break;
                case ASIGNAR:
                    asignarAmigoInvisible();
                    break;
                case MOSTRAR:
                    mostrarParticipantes();
                    break;
                case CONSULTAR:
                    consultar();
                    break;
                case BORRAR:
                    borrar();
                    break;

            }
            opcion = menu();
        }

    }

    private void consultar() {
        System.out.println("Consultando ....\n");
        if (juego.totalParticipantes() == 0) {
            System.out.println("Añada primero los participantes en el juego");
        } else {
            teclado.nextLine();
            String nombre = "";
            try {
                System.out.println("Teclee nombre participante");
                nombre = teclado.nextLine();
                Participante p = juego.datosDe(nombre);
                Participante regalaA = p.getEmisor();
                Participante recibeDe = p.getReceptor();
                String nombreRegalaA = "NADIE";
                if (regalaA != null) {
                    nombreRegalaA = regalaA.getNombre();
                }
                String nombreRecibeDe = "NADIE";
                if (recibeDe != null) {
                    nombreRecibeDe = recibeDe.getNombre();
                }
                System.out.println(nombre + " envía a "
                    + nombreRegalaA);
                System.out.println(nombre + " recibe de "
                    + nombreRecibeDe);
            } catch (RuntimeException e) {
                System.out.println("Error, no existe el participante " + nombre);
            }
        }
    }

    private void borrar() {
        System.out.println("Borrando ....\n");
        teclado.nextLine();
        if (juego.totalParticipantes() == 0) {
            System.out.println("Añada primero los participantes en el juego");
        } else {
            System.out.println("Teclee nombre participante  a borrar");
            String nombre = teclado.nextLine();
            boolean exito = juego.borrarParticipante(nombre);
            if (exito) {
                System.out.println("Borrado el participante " + nombre);
                System.out.println("Vuelva asignar amigos");
            } else {
                System.out.println("No existe ese participante");
            }
        }

    }

    private void asignarAmigoInvisible() {
        System.out.println("Asignando amigos ....\n");
        if (juego.totalParticipantes() == 0) {
            System.out.println("Añada primero los participantes en el juego");
        } else {
            juego.asignarAmigos();
            System.out.println("Se ha hecho el reparto del amigo invisible");
        }

    }

    private void mostrarParticipantes() {
        System.out.println("Mostrando participantes ....\n");
        if (juego.totalParticipantes() == 0) {
            System.out.println("Añada primero los participantes en el juego");
        } else {
            System.out.println(juego.toString());
        }

    }

    private void crearParticipantes() {
        System.out.println("Creando participantes ....\n");
        juego.borrarTodos();
        System.out.println("Teclee nº participantes en el amigo invisible");
        int n = teclado.nextInt();
        teclado.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Teclee nombre participante " + i + ": ");
            String nombre = teclado.nextLine();            
            while (juego.estaParticipante(nombre)) {
                System.out.println("Ya existe el participante, Teclee nombre participante " + i + ": ");

                nombre = teclado.nextLine();
            }
            Participante participante = new Participante(nombre);
            juego.add(participante);

        }

    }

    /**
     * Presenta el menú 
     * @return  la opción seleccionada
     */
    private int menu() {

        System.out.println("********************************");
        System.out.println("El amigo invisible");
        System.out.println("********************************");
        System.out.println("1. Crear participantes");
        System.out.println("2. Asignar amigos");
        System.out.println("3. Mostrar participantes");
        System.out.println("4. Consultas");
        System.out.println("5. Borrar");
        System.out.println("6. Salir");
        System.out.print("Teclea opción: ");
        int opcion = teclado.nextInt();
        while (!opcionValida(opcion)) {
            System.out.print("Opción incorrecta, Teclea opción: ");
            opcion = teclado.nextInt();
        }
        return opcion;
    }

    private boolean opcionValida(int opcion) {
        return opcion >= CREAR && opcion <= SALIR;
    }

    public void borrarPantalla() {
        System.out.println("\u000C");

    }

    public static void main(String[] args) {
        UIAmigoInvisible interfaz = new UIAmigoInvisible(
                new JuegoAmigoInvisible());
        interfaz.ejecutar();
    }
}
