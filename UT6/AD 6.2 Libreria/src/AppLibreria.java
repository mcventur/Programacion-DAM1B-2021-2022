public class AppLibreria {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Número de argumentos incorrecto. Sintaxis: \n" +
                    "Java AppLibreria <nombre_libreria>\n");
        }
        else{
            Libreria lib=new Libreria(args[0]);
            //Creamos varios libros y los añadimos
            Libro l1=new Libro("La historia interminable","Michael Ende",350);
            lib.addLibro(l1);

            Libro l2=new Libro("La Colmena","Camilo José Cela",250);
            lib.addLibro(l2);

            Libro l3=new Libro("El despertar del Leviatán","James S. A. Corey",310);
            lib.addLibro(l3);

            Libro l4=new Libro("Momo","Michael Ende",220);
            lib.addLibro(l4);

            System.out.println(lib.toString());

            //Prestamos alguno y mostramos resultado
            System.out.println("\n******* Prestamos algunos libros *******");
            lib.prestarTitulo("LA HISTORIA INTERMINABLE");
            lib.prestarTitulo("Este no va a estar");
            System.out.println("Libros prestados: ");
            lib.listarPrestados();
            //Intentamos prestar de nuevo uno de los prestados
            lib.prestarTitulo("LA HISTORIA INTERMINABLE");
            System.out.println("\n******* Borramos los de un autor *******");
            lib.borrarLibrosDe("michael ende");
            System.out.println(lib.toString());

        }
    }
}
