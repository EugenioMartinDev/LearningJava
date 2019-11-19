package bean;

public class Persona {

	private String nombre;
	private String edad;
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
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

	

}
