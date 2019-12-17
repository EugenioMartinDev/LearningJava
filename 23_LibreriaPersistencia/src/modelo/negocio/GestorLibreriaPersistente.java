package modelo.negocio;

import java.util.List;

import modelo.entidad.Libro;
import modelo.persistencia.DaoLibreria;


public class GestorLibreriaPersistente {

	private DaoLibreria daoLibreria = new DaoLibreria();

	/**
	 * @return the daoLibreria
	 */
	public DaoLibreria getDaoLibreria() {
		return daoLibreria;
	}

	/**
	 * @param daoLibreria the daoLibreria to set
	 */
	public void setDaoLibreria(DaoLibreria daoLibreria) {
		this.daoLibreria = daoLibreria;
	}

	public List<Libro> listarLibreria() {
		return daoLibreria.listar();
		
	}

	/**
	 * Dar de alta un libro
	 * @param libro : libro a dar de alta
	 * @return 0 en caso de inserción; 1 en caso de que falte ISBN
	 *         2 en caso de que falte título; 3 en caso de que ISBN esté duplicado
	 */
	public int alta(Libro libro) {
		
		//Error 1 : falta ISBN
		if (libro.getIsbn().isEmpty()) {
			return 1;
		}
		
		//Error 2 : falta título
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
		//Después de codificar el método buscarPorIsbn, que hace lo mismo que el for anterior, 
		//reemplazamos ese código por el método.
		if (buscarPorIsbn(libro.getIsbn()) != null) {
			return 3;
		}
				
		if (daoLibreria.alta(libro)) return 0;
		else return 4;
		
	}
	
	/**
	 *  Buscar un libro por ISBN
	 * @param isbn : identificador ISBN del libro
	 * @return libro buscado o nulo si no se encuentra
	 */
	public Libro buscarPorIsbn(String isbn) {
		return daoLibreria.buscarPorIsbn(isbn);
	}
	
	
	/**
	 * Buscar todos los libros de una editorial
	 * @param editorial : identificador de la editorial
	 * @return ArrayList de todos los libros encontrados ó un 
	 * 	 	arrayList vacío si no se encuentra ninguno
	 */
	public List<Libro> buscarPorEditorial(String editorial) {
		return daoLibreria.buscarPorEditorial(editorial);
		
	}
	
	
	/**
	 * @return
	 */
	public List<Libro> lista() {
		return daoLibreria.listar();
	}
	
}
