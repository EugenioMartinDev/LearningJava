package modelo.negocio;


import java.util.List;

import modelo.entidad.Libro;
import modelo.persistencia.DaoLibreria;

public class GestorLibreria {
	//En este caso lo que necesita la capa gestora
	//para funcionar es el dao del la librería
	//habria que adaptar todo el codigo a este dao
	private DaoLibreria daoLibreria;

	//Como no quiero que se me olvide poner la libreria
	//y ademas este gestor no funciona sin la libraria
	//creo INICAMENTE el constructor con la libreria
	//y quito set
	public GestorLibreria(DaoLibreria daoLibreria) {
		super();
		this.daoLibreria = daoLibreria;
	}

	public DaoLibreria getLibreria() {
		return daoLibreria;
	}


	public void setLibreria(DaoLibreria daoLibreria) {
		this.daoLibreria = daoLibreria;
	}

	public List<Libro> getListaLibros(){
		return daoLibreria.getListaLibros();
	}
	
	/**
	 * Dar de alta un libro
	 * @param libro libro a dar de alta
	 * @return 0 en caso de que haya ido bien, 1 en caso
	 * de que falte el isbn, 2 en caso de que falte el titulo
	 * y 3 en caso de que el isbn este duplicado
	 */
	public int alta(Libro libro) {
		if(libro.getIsbn().isEmpty()) {
			return 1;
		}
		
		if(libro.getTitulo().isEmpty()) {
			return 2;
		}
		//si buscamos un libro por isbn y existe
		//podemos concluir que este isbn va a estar 
		//duplicado, por lo que devolemos un 3
		if(buscarPorIsbn(libro.getIsbn()) != null) {
			return 3;
		}
		
		return daoLibreria.alta(libro);
	}
	
	public Libro buscarPorIsbn(String isbn) {
		return daoLibreria.buscarPorIsbn(isbn);
	}
	
	public List<Libro> buscarPorEditorial(String editorial){
		return daoLibreria.buscarPorEditorial(editorial);
	}
}
