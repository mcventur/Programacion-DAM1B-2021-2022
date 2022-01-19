
/**
 * Ejer 5.20  
 */
public class Alumno
{
        private String nombre;
        private int nota;
        
        /**
         * Constructor de la clase Alumno
         */
        public Alumno(String nombre, int nota)
        {
                this.nombre = nombre;
                this.nota = nota;
        }

        /**
         * accesor para el nombre 
         */
        public String getNombre()
        {
             return nombre;              
        }
        
          /**
         * accesor para la nota
         */        
        public int getNota()
        {
             return nota;              
        }
        
        /**
         * mutador para el nombre
        */ 
        public void setNombre(String nombre)
        {
                this.nombre = nombre;
        }
        
        /**
         * mutador para la nota
        */ 
        public void setNota(int nota)
        {
                this.nota = nota;
        }
        
     
        /**
         * representación textual de un alumno
         */
        public  String toString()
        {
            return nombre + " - " + nota + "\n";
        }

        
        
}
