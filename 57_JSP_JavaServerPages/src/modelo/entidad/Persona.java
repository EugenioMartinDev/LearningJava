package modelo.entidad;

public class Persona {

	private String nombre;
	private Double peso;
	private Double libras;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	/**
	 * @return the libras
	 */
	public Double getLibras() {
		return libras;
	}
	/**
	 * @param libras the libras to set
	 */
	public void setLibras(Double libras) {
		this.libras = libras;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", peso=" + peso + ", libras=" + libras + "]";
	}
	
	
	
}
