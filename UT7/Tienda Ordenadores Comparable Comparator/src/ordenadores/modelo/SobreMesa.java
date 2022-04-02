package ordenadores.modelo;

/**
 *    
 */
public class SobreMesa extends Ordenador
{
	private static final double	DESCUENTO	= 5;
	private String				descripcion;

	/**
	 * Constructor
	 */
	public SobreMesa(String codigo, double precio, String descripcion)
	{
		super(codigo, precio);
		this.descripcion = descripcion;
	}

	/**
	*  
	* 
	*/
	public String getDescripcion()
	{
		return descripcion;
	}

	/**
	 * 
	 */
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public double calcularDescuento()
	{
		return getPrecio() * DESCUENTO / 100;
	}

	/**
	* 
	*/
	public String getSlogan()
	{
		return "El que más pesa, el que menos cuesta";
	}

	/**
	 * 
	 */
	public String toString()
	{
		return super.toString() + "Descripción: " + descripcion + "\n\n";
	}
}
