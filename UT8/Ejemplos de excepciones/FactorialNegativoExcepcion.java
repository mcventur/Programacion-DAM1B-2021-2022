
/**
 * Clase FactorialNegativoExcepcion 
 *  
 */
public class FactorialNegativoExcepcion extends Exception
{
	private int num;
	
	/**
	 * Constructor de la clase FactorialNegativoExcepcion
	 */
	public FactorialNegativoExcepcion(int num)
	{
		this.num = num;
	}

	/**
	 *  
	 */
	public String toString()
	{
		return "Factorial negativo " + num;
	}
	
	/**
	 *  
	 */
	public String getMessage()
	{
		return "Redefinido getMessage() - Factorial negativo " + num;
	}
}
