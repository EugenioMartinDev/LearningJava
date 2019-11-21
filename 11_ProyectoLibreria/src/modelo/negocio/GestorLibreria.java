package modelo.negocio;

import java.util.ArrayList;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;

/*
 * Ejercicio de una libreria.
Gestionar una libreria, la libreria tendrá un nombre de la libreria y una lista de libros
De los libros queremos guardar la siguiente informacion
ISBN
titulo
editorial
año publicacion

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
	 * Método que incluye un libro en la libreria, con las restricciones: - El
	 * atributo isbn de libro no es nulo ni vacío y es único - El atributo titulo de
	 * libro no es nulo ni vacío.
	 * 
	 * @param libro    : libro a incluir
	 * @param libreria : librería repositorio
	 * @return : Devuelve una indicación de si se acepta o se rechaza el alta del
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
	 * Método interno que decide si ya existe un libro con el mismo isbn en la
	 * librería
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
	 * Método que busca el libro que coincide con el ISBN dado
	 * 
	 * @param libreria : librería repositorio
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
	 * Método que busca todos los libros de una editorial. Puede ser un array vacío
	 * si no se encuentran libros.
	 * 
	 * @param libreria  : librería repositorio
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
