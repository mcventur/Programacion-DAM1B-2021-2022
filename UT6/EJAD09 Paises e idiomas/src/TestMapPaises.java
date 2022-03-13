
/**
 * Clase para probar los métodos de MapPaises  
 */
public class TestMapPaises
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        MapPaises map = new MapPaises();
        map.add("portugal", "portugués");
        map.add("brasil", "portugués");
        map.add("alemania", "alemán");
        map.add("suiza", "alemán");
        map.add("suiza", "francés");
        map.add("bélgica", "francés");
        map.add("bélgica", "flamenco");
        map.add("bélgica", "alemán");
        map.add("españa", "castellano");
        map.add("españa", "gallego");
        map.add("españa", "euskera");
        map.add("españa", "catalán");

        map.printPaises();
        String pais = "España";
        System.out.println("En " + pais + " se habla " + map.idiomasQueHablanEn(pais));

        pais = "Suiza";
        System.out.println("En " + pais + " hablan " + map.totalIdiomasQueHablanEn(pais) + " idioma/s");

        String idioma = "alemán";
        System.out.println("El idioma " + idioma + " se habla en " + map.paisesQueHablanIdioma(idioma));

        String pais2 = "Bélgica";
        System.out.println(pais + " y " +  pais2 + " hablan " + map.idiomasComunes(pais, pais2).toString());
    }
}
