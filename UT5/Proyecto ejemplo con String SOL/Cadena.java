import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Arrays;

/**
 * clase Cadena  
 * Modela una cadena de caracteres y sus
 * operaciones asociadas
 */
public class Cadena
{
    public static final String EJEMPLO = "This    is     my small example "
        + "string which I'm going to " + "use for pattern matching.";
    public static final String SEPARADOR = ":";
    public static final char ASTERISCO = '*';
    public static final char ESPACIO = ' ';
    private String cadena; // atributo que representa una cadena de caracteres

    /**
     * Constructor  
     */
    public Cadena(String cadena)
    {
        this.cadena = cadena;
    }

    /**
     * Constructor  
     */
    public Cadena(Cadena cadena)
    {
        this.cadena = new String(cadena.getCadena());
         
    }

    /**
     * Constructor  
     */
    public Cadena()
    {
        cadena = "Ejemplo:de:cadena:::de:caracteres";
    }

    /**
     * accesor para la cadena 
     */
    public String getCadena()
    {
        return this.cadena;
    }

    /**
     * mutador para la cadena 
     */
    public void setCadena(String cadena)
    {
        this.cadena = cadena;
    }

    /**
     *  Longitud en caracteres de la cadena
     * 
     */
    public int longitud()
    { 
        return this.cadena.length();
         
    }

    /**
     *  devolver el primer caracter
     * 
     */
    public char primerCaracter()
    { 
        char caracter = this.cadena.charAt(0);
        return caracter;
    }

    /**
     *  devolver el último caracter
     * 
     */
    public char ultimoCaracter()
    { 
        return this.cadena.charAt(this.cadena.length() - 1);
        
    }

    /**
     *  devolver el  caracter de posición p
     *  Lanzamos una excepción StringIndexOutOfBoundsException si p es incorrecta
     * 
     */
    public char caracterDePosicion(int p)
    { 
        if (p < 0 || p >= longitud())
        {
            throw new StringIndexOutOfBoundsException("Posición incorrecta");
        }
        return this.cadena.charAt(p);
         
    }

    /**
     * concatena la cadena actual con la recibida como parámetro y devuelve un
     * nuevo objeto Cadena que la encapsula
     */
    public  Cadena concatenarCon(Cadena otra)
    {
        String strOtra = otra.getCadena();
        String nueva = this.cadena.concat(strOtra);
        return new Cadena(nueva);
    }

    /**
     *  paso a mayúsculas
     * 
     */
    public void aMayusculas()
    { 
        this.cadena = this.cadena.toUpperCase();

    }

    /**
     *  paso a minúsculas
     * 
     */
    public void aMinusculas()
    { 
        this.cadena = this.cadena.toLowerCase();

    }

    /**
     *  devuelve true si las dos cadenas son iguales
     * 
     */
    public boolean igualQue(String cadena)
    { 
        return this.cadena.equalsIgnoreCase(cadena);
    }

    /**
     * devuelve true si la cadena del objeto es mayor que
     * la cadena recibida como parámetro
     * 
     */
    public boolean mayorQue(String cadena)
    { 
        int resul =  this.cadena.compareToIgnoreCase(cadena);
        return resul > 0;
    }

    /**
     * devuelve true si la cadena del objeto empieza por
     * la recibida como parámetro - da lo mismo mayúsculas que minúsculas
     * 
     * 
     */
    public boolean empiezaPor(String str)
    { 
        return this.cadena.toLowerCase().startsWith(str.toLowerCase());

    }

    /**
     * devuelve true si la cadena del objeto contiene a la recibida como parámetro
     * da lo mismo mayúsculas que minúsculas
     */
    public boolean contiene(String str)
    { 
        str = str.toLowerCase();
        int resul =  this.cadena.toLowerCase().indexOf(str);
        return resul >= 0;
        
        // return this.cadena.toLowerCase().contains(str);

    }

    /**
     *   localiza la última aparición de str en cadena y extrae , a partir de ahí, 
     *   la subcadena existente hasta el final
     *   Si no existe str devuelve null
     */
    public String cadenaApartirDe(String str)
    {
        int pos = cadena.lastIndexOf(str);
        if (pos != -1) {
            return cadena.substring(pos);
        }
        return null;
    }

    /**
     * Cuenta el nº de 'A'
     */
    public  int cuantasA()
    {
        int cuantas = 0;
        for (int i = 0; i < this.cadena.length(); i++) {
            if (this.cadena.charAt(i) == 'A') {
                cuantas ++;
            }
        }
        return cuantas;
    }

    /**
     * Devuelve un objeto Cadena con la cadena actual invertida
     */
    public  Cadena invertirV1()
    {
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida = invertida + cadena.charAt(i);
        }

        return new Cadena(invertida);
    }

    /**
     * Devuelve un objeto Cadena con la cadena actual invertida
     */
    public  Cadena invertirV2()
    {
        String invertida = "";
        for (int i = 0; i < cadena.length(); i++) {
            invertida =  cadena.charAt(i) + invertida;
        }

        return new Cadena(invertida);
    }

    /**
     * Devuelve un objeto Cadena con la cadena actual invertida - usando StringBuilder
     */
    public  Cadena invertirV3()
    {
        StringBuilder sb = new StringBuilder(this.cadena);   
        return new Cadena(sb.reverse().toString());
    }

    /**
     * 
     * Devuelve un objeto Cadena con la cadena actual invertida 
     */
    public  Cadena invertirRecursivo()
    {
        return new Cadena(invertirRecursivo(this.cadena));
    }

    /**
     * 
     * Devuelve un objeto String con el argumento str invertido - método recursivo
     */
    public  String invertirRecursivo(String str)
    {
        if (str.length() == 0) {
            return "";
        }
        return str.charAt(str.length() - 1) + 
                invertirRecursivo(str.substring(0, str.length() - 1));
    }

    /**
     * Devuelve true si la cadena es un palíndromo
     * Versión iterativa
     */
    public  boolean esPalindromaIterativa()
    {
        int mitad = cadena.length() / 2;
        for (int i = 0; i < mitad; i++)   {
            if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Devuelve true si la cadena es un palíndromo
     * Versión recursiva
     */
    public  boolean esPalindromaRecursiva()
    {
        return esPalindromaRecursiva(this.cadena);
    }

    /**
     *  
     *
     */
    private boolean esPalindromaRecursiva(String cadena)
    {
        if (cadena.length() == 0) {
            return true;
        }
        if (cadena.length() == 1) {
            return true;  
        }
        return cadena.charAt(0) == cadena.charAt(cadena.length() - 1) &&
        esPalindromaRecursiva(cadena.substring(1, cadena.length() - 1));
    }

    /**
     * Devuelve los tres últimos caracteres de la cadena
     */
    public String tresUltimosCaracteres()
    {

        return this.cadena.substring(this.cadena.length() - 3);
    }

    /**
     * Si la cadena es "ejemplo" 
     * hay que escribir
     * e
     * ej
     * eje
     * ejem
     * ejemp
     * ejempl
     * ejemplo
     * 
     */
    public  void visualizarEnTrozos()
    {
        int lon = longitud();
        for (int i = 0; i < lon; i++)   {
            System.out.println(this.cadena.substring(0, i + 1));             
        }
    }

    /**
     *  
     * Si la cadena es "ejemplo" 
     * hay que mostrar
     * e
     *  j
     *   e
     *    m
     *     p
     *      l
     *       o
     * 
     */
    public  void visualizarEnDiagonal()
    {
        final String BLANCO = " ";
        String blancos = "";
        int lon = longitud();
        for (int i = 0; i < lon; i++){
            System.out.println(blancos + cadena.charAt(i));
            blancos = blancos.concat(BLANCO);
        }

    }

    /**
     * @param otra la cadena con la que comparar
     * @return true si la cadena actual empieza y termina por el mismo 
     * caracter que otra
     */
    public  boolean  empiezaYterminaIgualQue(Cadena otra)
    {
        return this.primerCaracter() == otra.primerCaracter() &&
            this.ultimoCaracter() == otra.ultimoCaracter();
    }

    /**
     * @param objetivo el caracter a buscar en la cadena actual
     *  @param nuevo  el caracter por el que se reemplazará
     *  
     */
    public  void reemplazarPor(char objetivo, char nuevo)
    {
        this.cadena = this.cadena.replace(objetivo, nuevo);
    }

    /**
     *  Contar las palabras de cadena, el separador entre palabras es
     *  el carácter SEPARADOR
     *
     */
    public int numeroPalabras()
    {
        String[] palabras = cadena.split(SEPARADOR);
        int pal = 0;
        for (int i = 0; i < palabras.length; i++){
            if (!palabras[i].isEmpty())    {
                pal++;
            }
        }
        return pal;
    }

    /**
     *  Cuenta las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  Usar indexOf() y substring()
     */
    public int aparicionesDe(String str)
    {
        int veces = 0;
        String aux = cadena.toLowerCase();
        str = str.toLowerCase();
        int pos = aux.indexOf(str);
        while (pos != -1) {
            veces++;
            aux = aux.substring(pos + str.length());
            pos = aux.indexOf(str);
        }

        return veces;

    }

    /**
     *  Cuenta las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  Usar solo indexOf()  
     */
    public int aparicionesDeV2(String str)
    {
        int veces = 0;
        String aux = cadena.toLowerCase();
        str = str.toLowerCase();
        int pos = aux.indexOf(str);
        while (pos != -1)  {
            veces++;
            pos = aux.indexOf(str, pos + str.length());
        }

        return veces;

    }

    /**
     *  Cuenta las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  versión recursiva 
     */
    public int aparicionesDeRecursiva(String str)
    {
        return aparicionesDeRecursiva(this.cadena, str);

    }

    /**
     *  Cuenta las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  versión recursiva 
     */
    private int aparicionesDeRecursiva(String cadena, String str)
    {
        if (cadena.length() == 0) {
            return 0;
        }
        String aux = cadena.toUpperCase();
        str = str.toUpperCase();
        int p = aux.indexOf(str);
        if (p == -1) {
            return 0;
        }
        return 1 + aparicionesDeRecursiva(aux.substring(p + str.length()), str);

    }

    /**
     *   Cuenta las vocales
     *   Hace uso del método privado esVocal()
     *
     */
    public int contarVocales()
    {
        int vocales = 0;
        int lon = longitud();
        for (int i = 0; i < lon; i++)  {
            if (esVocal(cadena.charAt(i))) {
                vocales++;               
            }
        }
        return vocales;
    }

    /**
     *  
     *
     */
    private boolean esVocal(char car)
    {
        //         String lasVocales = "aeiouAEIOU";
        //         return lasVocales.indexOf(car) != -1;
        return "aeiouAEIOUÁÉÍÓÚáéíóú".indexOf(car) != -1;
    }

    /**
     *   Suponiendo cadena = "examen" el array obtenido sería
     *   
     *   [e, e, e, e, e, e]
     *   [x, x, x, x, x, x]
     *   [a, a, a, a, a, a]
     *   [m, m, m, m, m, m]
     *   [e, e, e, e, e, e]
     *   [n, n, n, n, n, n]

     */
    public char[][]  cadenaToArray2D()
    {
        int n = this.cadena.length();
        char[][]  array2D = new char[n][n];
        for (int f = 0; f < n; f++)  {
            char car = cadena.charAt(f);
            for (int c = 0; c < n; c++)   {
                array2D[f][c] = car;
            } 
        }
        return array2D;
    } 

    /**
     *  
     *
     */
    public char[] toCharArray()
    {
        //         int lon = longitud();
        //         char[] caracteres = new char[lon];
        // 
        //         for (int i = 0; i < lon; i++)
        //         {
        //            caracteres[i] = cadena.charAt(i);
        //         }
        //         return caracteres;
        return cadena.toCharArray();
    }

    /**
     *  Eliminar los espacios - usando StringBuilder
     *
     */
    public void eliminarEspacios()
    {
        StringBuilder sb = new StringBuilder(this.cadena);
        int i = 0;
        while (i < sb.length())    {
            if (sb.charAt(i) == ESPACIO) {
                sb.deleteCharAt(i);
            }
            else {
                i++;
            }
        }

        this.cadena = sb.toString();
    }

    /**
     * Sustiyuye en cadena el caracter que coincida con objetivo por *
     */
    public  void sustituirPorAsterisco(char objetivo)
    {
        StringBuilder sb = new StringBuilder(this.cadena);
        for (int i = 0; i < sb.length(); i++)
        {
            if (sb.charAt(i) == objetivo) {
                sb.setCharAt(i, ASTERISCO);
            }
        }

        this.cadena = sb.toString();
    }
 
    /**
     *  escribe las palabras de cadena, el separador entre palabras es
     *  el carácter SEPARADOR - con Scanner
     *
     */
    public void printPalabrasV2()
    {
        Scanner sc = new Scanner(this.cadena);    
        sc.useDelimiter("de");
        while (sc.hasNext())   {
            String token = sc.next();
            if (!token.isEmpty()) {
                System.out.println(token + "\t");
            }
        }
    }

    /**
     * suma los enteros de la cadena
     *
     */
    public int sumarEnteros()
    {
        int suma = 0;
        Scanner sc = new Scanner(this.cadena);    
        while (sc.hasNextInt())  {
            int token = sc.nextInt();
            suma += token;
        }
        return suma;
    }

    /**
     *  Integer.toHexString(15) / Integer.toHexString('0')
     *
     */
    public int sumarDigitos()
    {
        int suma = 0;
        for (int i = 0; i < this.cadena.length(); i++)  {
            char c = this.cadena.charAt(i);
            if (c >= '0' && c <= '9')    {
                // suma += Integer.parseInt(c + "");
                // suma += c - 48;
                suma +=  Character.getNumericValue(c);
            }

        }
        return suma;
    }

    /**
     *  http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
     *  http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
     *
     */
    public void splitConExpresionesRegulares()
    {
        String[] tokens = EJEMPLO.split("\\s+");
        System.out.println(tokens.length);  
        for (String string : tokens) {
            System.out.println(string);
        }

        String linea = "elemento1     elemento2     elemento3,elemento4";
        String [] listaSeparada = linea.split("\\s+|\\,+");

        for (String token : listaSeparada)    {
            System.out.println(token.trim());
        }
    }

    /**
     *  Borrar las apariciones de str en cadena
     *  Sin diferenciar mayúculas de minúsculas
     *  Usar indexOf() y substring()
     */
    public String borrarOcurrenciasDe(String str)
    {
        String aux = cadena.toLowerCase();
        str = str.toLowerCase();

        String resul = "";            
        int pos = aux.indexOf(str);
        while (pos != -1)  {
            resul += aux.substring(0, pos);
            aux = aux.substring(pos + str.length());
            pos = aux.indexOf(str);
        }

        return resul + aux;

    }

    /**
     *  Código fuente del método compareTo() de la clase String
     */
    public static int compareTo(String str1, String str2)
    {
        char[] value1 = str1.toCharArray();
        int len1 = value1.length;
        char[] value2 = str2.toCharArray();
        int len2 = value2.length;
        int lim = Math.min(len1, len2);
        char v1[] = value1;
        char v2[] = value2;
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;

    }


}
