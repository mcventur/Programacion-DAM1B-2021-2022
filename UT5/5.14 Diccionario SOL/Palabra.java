
/**
 * Modela una palabra de un diccionario inglés - castellano
 *  
 */
public class Palabra
{
        
        private String castellano;
        private String ingles;

        /**
         * Constructor de la clase Palabra
         */
        public Palabra(String castellano, String ingles)     {
                this.castellano = castellano;
                this.ingles = ingles;
        }

        /**
         *  
         * @return la palaba en castellano    
         */
        public String getCastellano()    {
                return castellano;
        }
        
         /**
         *  
         * @return la palaba en inglés    
         */
        public String getIngles()      {
                return ingles;
        }
        
         /**
         *  
         * @return la representación textual
         * de la palabra
         */
        public String toString()    {
                return castellano + " - " + ingles + "\n";
        }
}
