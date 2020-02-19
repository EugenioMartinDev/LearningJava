package curso.modelo.entidad;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//El ciclo de vida de este objeto sera de 30 minutos
//ojo con salvar este usuario
@Component
@SessionScope
public class Usuario {
	private String nombre;
	private int edad;
	private boolean registrado;
	
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
	public boolean isRegistrado() {
		return registrado;
	}
	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}
	
	
}
