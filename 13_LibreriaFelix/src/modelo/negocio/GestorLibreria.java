package modelo.negocio;

import java.util.ArrayList;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class GestorLibreria {

	private Libreria libreria;

	/**
	 * @return the libreria
	 */
	public Libreria getLibreria() {
		return libreria;
	}

	/**
	 * @param liberaria the libreria to set
	 */
	public void setLiberaria(Libreria libreria) {
		this.libreria = libreria;
	}
	
	
	//En lugar de setter, crear un constructor que obligue a introducir el objeto libreria
	//De esta manera no habr� excepci�n si se olvida hacer el setter.
	//Si se quita el setter, ya no se podr� cambiar la libreria
	/**
	 * @param libreria
	 */
	public GestorLibreria(Libreria libreria) {
		super();
		this.libreria = libreria;
	}

	/**
	 * Dar de alta un libro
	 * @param libro : libro a dar de alta
	 * @return 0 en caso de inserci�n; 1 en caso de que falte ISBN
	 *         2 en caso de que falte t�tulo; 3 en caso de que ISBN est� duplicado
	 */
	public int alta(Libro libro) {
		
		//Error 1 : falta ISBN
		if (libro.getIsbn().isEmpty()) {
			return 1;
		}
		
		//Error 2 : falta t�tulo
		if (libro.getTitulo().isEmpty()) {
			return 2;
		}
		
		//Error 3: ISBN duplicado
		/*
		for (Libro elemento : libreria.getListaLibros()) {
			if (elemento.getIsbn().equals(libro.getIsbn())) {
				return 3;
			}
		}
		*/
		//Despu�s de codificar el m�todo buscarPorIsbn, que hace lo mismo que el for anterior, 
		//reemplazamos ese c�digo por el m�todo.
		if (buscarPorIsbn(libro.getIsbn()) != null) {
			return 3;
		}
		
		libreria.getListaLibros().add(libro);
		//Exito : libro dado de alta
		return 0;
	}
	
	/**
	 *  Buscar un libro por ISBN
	 * @param isbn : identificador ISBN del libro
	 * @return libro buscado o nulo si no se encuentra
	 */
	public Libro buscarPorIsbn(String isbn) {	
		for (Libro elemento : libreria.getListaLibros()) {
			if (elemento.getIsbn().equals(isbn)) {
				return elemento;
			}
		}
		
		return null;
	}
	
	
	/**
	 * Buscar todos los libros de una editorial
	 * @param editorial : identificador de la editorial
	 * @return ArrayList de todos los libros encontrados � un 
	 * 	 	arrayList vac�o si no se encuentra ninguno
	 */
	public ArrayList<Libro> buscarPorEditorial(String editorial) {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		for (Libro libro : libreria.getListaLibros()) {
			if (libro.getEditorial().equals(editorial)) {
				listaLibros.add(libro);
			}
		}
		return listaLibros;
		
	}
	
}
