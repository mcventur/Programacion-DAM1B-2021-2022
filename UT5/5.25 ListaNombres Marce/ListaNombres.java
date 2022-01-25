
/**
 * La clase mantiene una lista de nombres
 * en orden léxicográfico
 *
 */
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
 

public class ListaNombres
{
        private String[]  lista;
        private int pos;

        /**
         * Constructor de la clase ListaNombres
         * n es el tamaño máximo de la lista
         */
        public ListaNombres(int n) 
        {              
              lista = new String[n];
              pos=0;
        }

        /**
         * @return  true si la lista está vacía   
         */
        public boolean  listaVacia()
        {
                 return pos==0;
            
        }
        
        /**
         * 
         * @return  true si la lista está llena   
         */
        public boolean  listaLlena()
        {
                return pos==lista.length;
            
        }
        
        /**
         * Inserta un nombre en la lista únicamente
         * si no está y la lista no está llena. La inserción se hace de tal
         * manera que el nombre queda colocado en el 
         * lugar que le corresponde manteniendo el orden 
         * de la lista (no se utiliza ningún algoritmo de ordenación)
         * Importan mayúsculas y minúsculas 
         * 
         * @param nombre el nombre a insertar
         * @return  true si la inserción se hace con éxito   
         *
         */
        public boolean insertarNombre(String nombre)
        {
            String recibido=nombre;
            if(!listaLlena() && !estaNombre(nombre)){
                /*
                Inserción en orden (Diapositiva 98 de 111 de la presentación I de la UT5)
                Recorremos el array de derecha a izquierda, moviendo cada elemento "mayor" (alfabéticamente)
                una posición a la derecha
                */
                int i=pos-1;
                while(i>=0 && lista[i].compareTo(nombre)>0){
                    lista[i+1]=lista[i];
                    i--;
                }
                lista[i+1]=nombre;
                pos++;
                return true;
            }
            return false;


        }
        
        /**
         *  Busca un nombre en la lista
         *  Puesto que la lista está en todo momento ordenada
         *  se hace una búsqueda binaria
         *  @param  nombre el nombre a buscar
         *  @return   true si ya existe el nombre en la lista  
         *   
         */
        private boolean estaNombre(String nombre)
        {
            //Version abreviada, usando un array auxiliar.
            //No podemos usar el array original porque binarySearch() rompe al tener posiciones a null
            /*
            String[] aux=Arrays.copyOf(lista,pos);
            return Arrays.binarySearch(aux,nombre)>=0;
            */

            //Versión más abreviada, usando parámetros adicionales de la función binarySearch
            //return Arrays.binarySearch(lista,0,pos,nombre)>=0;

            //Implementando la búsqueda binaria por nosotros mismos
            //Diapositiva 87 de 111 de a presentación I de la UT5
            boolean encontrado=false;
            int izquierda=0;
            int derecha=pos-1;
            while(izquierda <= derecha){
                int mitad= (derecha+izquierda)/2;
                int comp=lista[mitad].compareTo(nombre);
                if(comp==0){
                    return true;
                }
                else if(comp>0){
                    derecha=mitad-1;
                }
                else{
                    izquierda=mitad+1;
                }
            }
            return encontrado;
        }
        
        /**
         *  Busca y devuelve el nombre de mayor longitud
         *  en la lista. Si hay varios devuelve el
         *  primero encontrado
         *  Si la lista está vacía devuelve null
         *  
         *  @return   el nombre más largo  
         *  
         */
        public String nombreMasLargo()
        {
            if(listaVacia()) return null;

            int longMax=0;
            int posMax=0;
            //Recorremos la lista completa comparando lo que devuelve .length(), y nos quedamos con la posición del mayor
            for(int i=0;i<pos;i++){
                if(lista[i].length()>longMax){
                    longMax=lista[i].length();
                    posMax=i;
                }
            }

            return lista[posMax];

            
        }
        
        /**
         * Borra de la lista los nombres que empiezan por 
         * una letra determinada (sí importan mayúsculas y minúsculas)
         * No es lo mismo borrarLetra('A') que borrarLetra('a')
         *
         * @param letra la letra por la que han de empezar los nombres 
         *    
         */
        public void borrarLetra(char letra)
        {
            //Recorremos el array buscando nombres que empiecen por letra
            for(int i=0;i<pos;i++){
                if(lista[i].charAt(0)==letra){
                    borrarDePosicion(i);
                }
            }
            
            
        }
        
        /**
         * Borra un nombre de la posición indicada
         * 
         *
         * @param  p posición del nombre a borrar
         *  
         */
        private void borrarDePosicion(int p)
        {
             System.arraycopy(lista, p+1, lista, p, pos-p-1);
             pos--;
        }
         
       
        
        /**
         * Cuenta cuántos nombres empiezan por una determinada 
         * cadena sin importar   mayúsculas o minúsculas
         *
         * @param  inicio la cadena de comienzo
         * @return  la cantidad de nombres calculados   
         */
        public int empiezanPor(String inicio)
        {
            int cuantos=0;
            String inicioMayus=inicio.toUpperCase();
            for(int i=0;i<pos;i++){
                if(lista[i].toUpperCase().startsWith(inicioMayus))
                    cuantos++;
            }
            return cuantos;
        }
        
         /** 
         * 
         * Devuelve un array con los  nombres que empiezan por una determinada 
         * letra sin importar si es mayúscula o minúscula
         * 
         * @param   letra de comienzo
         * @return  el array de nombres encontrados
         *          con esa letra   
         */ 
        public String[] empiezanPorLetra(char letra)
        {
            //Paso la letra de char a String
            String letraString=String.valueOf(letra);
            //Calculamos cuántos elementos tendrá el nuevo Array usando la función empiezanPor
            int tam=empiezanPor(letraString);
            //Declaramos el array
            String[] retorno=new String[tam];
            //Esto es muy parecido a la búsqueda de los aprobados en el array de alumnos del 5.20 - Curso Alumno.
            //Tenemos que ir contando cuántos introducimos, para saber dónde toca introducir al siguiente
            int actual=0;
            //Empezamos a buscar
            for(int i=0;i<pos;i++){
                if(lista[i].startsWith(letraString)){
                    retorno[actual]=lista[i];
                    actual++;
                }
            }
            return retorno;
        }
        
       /**
         * Representación textual de la cadena
         * 
         * @return la cadena resultante    
         */
        public String toString()
        {
           StringBuilder retorno= new StringBuilder();
           for(int i=0;i<pos;i++){
               retorno.append(lista[i]).append("\n");
           }
           return retorno.toString();
        }
        
          /**
         *  Mostrar la lista en pantalla 
         */
        public void printLista()
        {
                System.out.println(this.toString());
        }
        
          /**
         * Lee de un fichero de texto una serie 
         * de nombres con ayuda de un objeto de la 
         * clase Scanner y los almacena en la lista
         */
        public void cargarDeFichero() 
        {
			Scanner sc = null;
            try    {
                     sc = new Scanner(new File("nombres.txt"));
                     while (sc.hasNextLine() && !listaLlena()) {
                         String nombre=sc.nextLine();
                         insertarNombre(nombre);
					 }                          
                     
             }
             catch (IOException e)      {
                     e.printStackTrace();
             }
			 finally {
				 sc.close();
			 }
			 
        }




        /*
        AMPLIACIONES
         */


        /**
         *  Devuelve un  array con la misma cantidad de elementos de lista pero en orden inverso.
         *  Y con el orden de los caracteres también invertido, respetando las mayúsculas y minúsculas
         * @return el array invertido
         */
        public String[] invertir(){
            String[] ret = new String[pos];
            int posRet=0;//Usaremos un índice adicional para llevar la cuenta de cada posición. No es necesario pero simplifica la tarea
            for(int i=pos-1;i>=0;i--){//Recorremos la lista de derecha a izquierda
                ret[posRet]=invertir(lista[i]);
                posRet++;
            }
            return ret;
        }

        /**
         * Invierte el orden de los caracteres de nombre
         * @param nombre el nombre o cadena a invertir
         * @return el nombre invertido
         */
        private static String invertir(String nombre){
            String inv="";
            for(int i=nombre.length()-1;i>=0;i--){//Recorremos el string desde el final hacia el principio
                inv+=nombre.charAt(i);
            }
            return inv;
        }
        
}
