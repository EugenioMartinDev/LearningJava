package modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author aula2m
 *
 *	Podemos dar de alta los beans también por anotaciones. Tenemos 4 tipos básicos:
 *  @Component, @Service, @Repository, @Controller
 *
 *  @Component da de alta la clase como bean en el contexto Spring
 *  El resto de anotaciones hacen los mismo, siendo anotaciones semánticas:
 *  @Service da de alta un objeto de tipo gestor de negocio (los gestores se llaman también servicios)
 *  @Repositorio da de alta un objeto de tipo DAO (Data Access Object)
 *  @Controller da de alta un objeto de tipo controlador (capas MVC)
 *  
 */

//@Component				//Se da de alta con el id como el nombre de la clase en lowerCamelCase. Es un bean singleton por defecto.
//@Component(value="directorPropio")	//Se puede cambiar el id
@Component				//Se cambia el
@Scope("prototype")		//scope

public class Director {
	
	private String nombre;
	private int edad;
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
	@Override
	public String toString() {
		return "Director [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
}
