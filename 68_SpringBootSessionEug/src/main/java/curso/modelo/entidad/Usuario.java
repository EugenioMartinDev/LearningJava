package curso.modelo.entidad;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Usuario {

	private String nombre;
	private int edad;
	private boolean registrado;
	
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
	 * @return the registrado
	 */
	public boolean isRegistrado() {
		return registrado;
	}
	/**
	 * @param registrado the registrado to set
	 */
	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}
	
	
	
}
