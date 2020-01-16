package modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 *  Class Cliente (int id - String dni - String nombre - int edad)
 * @author aula2m
 *
 */
@Component
@Scope("prototype")
public class Cliente {

	private int id;
	private String dni;
	private String nombre;
	private int edad;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
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
	 * @param id
	 * @param dni
	 * @param nombre
	 * @param edad
	 */
	public Cliente(int id, String dni, String nombre, int edad) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	/**
	 * 
	 */
	public Cliente() {
		super();
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
}
