package modelo.negocio;

import java.util.ArrayList;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;

/*
 * Ejercicio de una libreria.
Gestionar una libreria, la libreria tendr� un nombre de la libreria y una lista de libros
De los libros queremos guardar la siguiente informacion
ISBN
titulo
editorial
a�o publicacion

quiero un menu con diferentes opcion
- Dar de alta un libro
- listar libros
- buscar libro por ISBN
- buscar libros por editorial

Requisitos
no pudeo haber un libro sin isbn
no puede haber un libro sin titulo
no puedo haber dos libros con el mismo isbn
 * 
 */

public class GestorLibreria {

	Libreria libreria;

	/**
	 * @return the libreria
	 */
	public Libreria getLibreria() {
		return libreria;
	}

	/**
	 * @param libreria the libreria to set
	 */
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}

	/**
	 * M�todo que incluye un libro en la libreria, con las restricciones: - El
	 * atributo isbn de libro no es nulo ni vac�o y es �nico - El atributo titulo de
	 * libro no es nulo ni vac�o.
	 * 
	 * @param libro    : libro a incluir
	 * @param libreria : librer�a repositorio
	 * @return : Devuelve una indicaci�n de si se acepta o se rechaza el alta del
	 *         libro.
	 */
	public boolean altaLibro(Libro libro) {

		if (libro.getIsbn() != null && libro.getIsbn().length() > 0 && libro.getTitulo() != null
				&& libro.getTitulo().length() > 0) {
			if (isbnUnico(libro)) {
				libreria.getListaLibros().add(libro);
				return true;
			}
		}

		return false;

	}

	/**
	 * M�todo interno que decide si ya existe un libro con el mismo isbn en la
	 * librer�a
	 * 
	 * @param libro
	 * @param libreria
	 * @return
	 */
	private boolean isbnUnico(Libro libro) {

		if (buscarLibroPorIsbn(libro.getIsbn()) != null) {
			return false;
		}
		return true;
	}

	/**
	 * M�todo que busca el libro que coincide con el ISBN dado
	 * 
	 * @param libreria : librer�a repositorio
	 * @param isbn     : Cadena del ISGN
	 * @return : Devuelve el libro o un valor nulo si no se encuentra.
	 */
	public Libro buscarLibroPorIsbn(String isbn) {

		for (Libro libro : libreria.getListaLibros()) {
			if (libro.getIsbn().equals(isbn)) {
				return libro;
			}
		}

		return null;

	}

	/**
	 * M�todo que busca todos los libros de una editorial. Puede ser un array vac�o
	 * si no se encuentran libros.
	 * 
	 * @param libreria  : librer�a repositorio
	 * @param editorial : Cadena editorial
	 * @return : Devuelve un array de libros.
	 */
	public ArrayList<Libro> buscarLibroPorEditorial(String editorial) {

		ArrayList<Libro> librosEncontrados = new ArrayList<Libro>();
		for (Libro libro : libreria.getListaLibros()) {
			if (libro.getEditorial().equals(editorial)) {
				librosEncontrados.add(libro);
			}
		}

		return librosEncontrados;

	}

}
