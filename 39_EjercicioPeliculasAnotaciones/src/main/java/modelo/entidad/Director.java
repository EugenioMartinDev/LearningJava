package modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author felix de pablo
 *
 */
@Component
@Scope("prototype")
public class Director {
	private String nombre;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Director [nombre=" + nombre + ", edad=" + edad + "]";
	}	
}
