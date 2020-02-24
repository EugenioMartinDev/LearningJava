package curso.modelo.entidad;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@XmlRootElement
@Component
@SessionScope
public class Libros {

	//Se incluye esta notación para que cada elemento tenga el nombre libro en lugar de listaLibros.
	@XmlElement(name="libro")
	private List<Libro> listaLibros;

	/**
	 * @return the listaLibros
	 */
	//Se cambia el nombre getListaLibros a getListaDeLibros para evitar el error de doble propiedad
	/*
	 * La clase tiene dos propiedades con el mismo nombre "listaLibros"
	this problem is related to the following location:
		at public java.util.List curso.modelo.entidad.Libros.getListaLibros()
		at curso.modelo.entidad.Libros
	this problem is related to the following location:
		at private java.util.List curso.modelo.entidad.Libros.listaLibros
		at curso.modelo.entidad.Libros
] with root cause
	 */
	public List<Libro> getListaDeLibros() {
		return listaLibros;
	}

	/**
	 * @param listaLibros the listaLibros to set
	 */
	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
}
