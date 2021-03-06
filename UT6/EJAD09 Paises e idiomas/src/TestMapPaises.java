
/**
 * Clase para probar los m?todos de MapPaises  
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
        map.add("portugal", "portugu?s");
        map.add("brasil", "portugu?s");
        map.add("alemania", "alem?n");
        map.add("suiza", "alem?n");
        map.add("suiza", "franc?s");
        map.add("b?lgica", "franc?s");
        map.add("b?lgica", "flamenco");
        map.add("b?lgica", "alem?n");
        map.add("espa?a", "castellano");
        map.add("espa?a", "gallego");
        map.add("espa?a", "euskera");
        map.add("espa?a", "catal?n");

        map.printPaises();
        String pais = "Espa?a";
        System.out.println("En " + pais + " se habla " + map.idiomasQueHablanEn(pais));

        pais = "Suiza";
        System.out.println("En " + pais + " hablan " + map.totalIdiomasQueHablanEn(pais) + " idioma/s");

        String idioma = "alem?n";
        System.out.println("El idioma " + idioma + " se habla en " + map.paisesQueHablanIdioma(idioma));

        String pais2 = "B?lgica";
        System.out.println(pais + " y " +  pais2 + " hablan " + map.idiomasComunes(pais, pais2).toString());
    }
}
