import java.util.ArrayList;

/**
 *
 */
public class AppAgenda {

    /**
     *
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.apuntarNota("comprar pan");
        agenda.apuntarNota("comprar leche");
        agenda.apuntarNota("ir dentista");
        agenda.apuntarNota("recargar móvil");
        agenda.listarNotas();

        System.out.println("Total notas: " + agenda.numeroNotas());
        System.out.println("Nota tercera: ");
        agenda.mostrarNota(2);
        System.out.println("Borramos Nota tercera y mostramos listado: ");
        agenda.borrarNota(2);
        agenda.listarNotas();
        System.out.println("-------------");
        System.out.println("Notas que contienene 'ar': " + agenda.notasQueContienen("AR"));
        System.out.println("-------------");
        System.out.println("Borradas notas que empiezan por \"co\": ");
        agenda.borrarNotasQueEmpiezanPor("co");
        agenda.listarNotas();
        System.out.println("-------------");
        System.out.println("Añadimos nuevas, quedando: ");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir fruteria");
        System.out.println("-------------");
        System.out.println("Notas que acaban en \"ria\": ");
        ArrayList<String> resul = agenda.acabanEn("ria");
        System.out.println(resul.toString());
        System.out.println("-------------");
        System.out.println("Añadimos repetidas, quedando: ");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("comprar leche");
        System.out.println("------ Listamos Con Iterator -------");
        agenda.listarNotasConIterador();
        System.out.println("------ Borradas las repetidas -------");
        agenda.borrarRepetidasV1();
        agenda.listarNotasConForMejorado();
        //System.out.println("------ Borradas las que terminen en \"ria\" con el for mejorado (NO DEBE FUNCIONAR)-------");
        //agenda.borrarNotasAcabanEn("ria");
        //agenda.listarNotas();
        System.out.println("------ Primera al final -------");
        agenda.primeraAlFinal();
        agenda.listarNotas();

        System.out.println("------ Última al principio -------");
        agenda.ultimaAlPrincipio();
        agenda.listarNotas();

        System.out.println("------ Reorganizar -------");
        agenda.reorganizar();
        agenda.listarNotas();

        System.out.println("------ Duplicar -------");
        agenda.duplicarNotas();
        agenda.listarNotasConIterador();


        // System.out.println("-------------");
        // agenda.invertirV2();
        // agenda.listarNotas(); 

        // System.out.println("-------------");
        // agenda.borrarNotasAcabanEn("a");  // da error
        // agenda.listarNotas(); 

    }
}
