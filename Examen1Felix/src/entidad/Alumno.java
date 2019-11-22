package entidad;

public class Alumno {

	private String dni;
	private String nombre;
	private String sexo;
	private int edad;
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
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
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * 
	 */
	public Alumno() {
		super();
	}
	
	
	/**
	 * @param dni
	 * @param nombre
	 * @param sexo
	 * @param edad
	 */
	public Alumno(String dni, String nombre, String sexo, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + "]";
	}

}
