package ordenadores.modelo;

/**
 *   
 */
public abstract class Ordenador implements Comparable<Ordenador>, Cloneable
{

	private String codigo;
	private double precio;
	// private String slogan;

	/**
	 * Constructor  
	 */
	public Ordenador(String codigo, double precio) {

		this.codigo = codigo;
		this.precio = precio;
		// this.slogan = slogan;
	}

	/**
	 *  
	 * 
	 */
	public String getCodigo() {

		return codigo;
	}

	/**
	 *  
	 * 
	 */
	public double getPrecio() {

		return precio;
	}

	/**
	 *  
	 * 
	 */
	public abstract String getSlogan();

	/**
	 * 
	 */
	public void setCodigo(String codigo) {

		this.codigo = codigo;
	}

	/**
	 * 
	 */
	public void setPrecio(double precio) {

		this.precio = precio;
	}

	/**
	 * Aplicar un descuento a todos los ordenadores, variará dependiendo del tipo
	 */
	public abstract double calcularDescuento();

	/**
	 *  
	 */

	/**
	 * Redefinimos equals 
	 * @override
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Ordenador ord = (Ordenador) obj;
		return this.codigo.equalsIgnoreCase(ord.getCodigo());
	}

	/**
	 *  
	 */
	@Override
	public int hashCode() {

		return codigo.hashCode();
	}

	/**
	* implementación del método del interface Comparable
	*/
	@Override
	public int compareTo(Ordenador ord) {

		return this.codigo.compareToIgnoreCase(ord.getCodigo());
	}

	/**
	 *  
	 *
	 */
	@Override
	public Ordenador clone() {

		try {
			return (Ordenador) super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}

	}

	/**
	 * 
	 */
	@Override
	public String toString() {

		return this.getClass().getSimpleName() + "\nCódigo: " + codigo + "\n" +
		                "Precio: " + precio + "\n" +
		                "Slogan: " + getSlogan() + "\n" +
		                "Descuento aplicado "
		                + String.format("%7.2f", calcularDescuento()) + "\n";
	}

}
