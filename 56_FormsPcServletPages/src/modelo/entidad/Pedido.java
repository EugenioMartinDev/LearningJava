package modelo.entidad;

public class Pedido {
	private String nombre;
	private String direccion;
	private String email;
	private Pc pc;
	private String comentario;
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pc
	 */
	public Pc getPc() {
		return pc;
	}
	@Override
	public String toString() {
		return "Pedido [nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", pc=" + pc
				+ ", comentario=" + comentario + "]";
	}
	/**
	 * @param pc the pc to set
	 */
	public void setPc(Pc pc) {
		this.pc = pc;
	}

	
	
}
