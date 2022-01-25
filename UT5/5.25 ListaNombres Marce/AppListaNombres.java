
/**
 * 
 * Acepta como argumento del main el tamaño máximo de la lista
 * Si no se pasan argumentos se muestra un mensaje de error, se le informa al usuario
 * de la sintaxis a utilizar y se acaba el programa
 * 
 * En otro caso se crea la lista y:
 *  - se llama al método cargarDeFichero() 
 *  - se muestra la lista
 *  - se muestra el nombre más largo
 *  - se borran los que empiezan por 'r'
 *  - se muestra la lista
 *  - se muestra cuántos empiezan por 'aL'
 *  - se muestran los nombres que empiezan por "a"
 */
public class AppListaNombres
{

    /**
     *  
     */
    public static void main(String[] args)
    {
       if(args.length==0){
           System.out.println("Es necesario introducir el tamaño de la lista como argumento del main");
       }
       else{
           int tam=Integer.parseInt(args[0]);
           ListaNombres lista= new ListaNombres(tam);
           lista.cargarDeFichero();
           lista.printLista();
           System.out.println("El nombre más largo es " + lista.nombreMasLargo()+ "\n");
           lista.borrarLetra('r');
           System.out.println("Borrados los que empiezan por r\n");
           lista.printLista();
           System.out.println(lista.empiezanPor("aL") + " empiezan por aL\n");
           String[] empiezanPorA= lista.empiezanPorLetra('a');
           System.out.println("Empiezan por a:\n");
           for(int i=0;i<empiezanPorA.length;i++){
               System.out.println(empiezanPorA[i] + "\n");
           }

          /* System.out.println("AMPLICACIONES: \n");
           String[] invertida=lista.invertir();
           System.out.println("Sin invertir: \n");
           lista.printLista();
           System.out.println("Invertida: \n");
           for(int i=0;i<invertida.length;i++){
               System.out.println(invertida[i] + "\n");
           }*/
       }
        
        
    }
}
