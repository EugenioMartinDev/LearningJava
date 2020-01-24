package modelo.negocio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidad.Libro;
import modelo.persistencia.DaoLibreria;

@Service
public class GestorLibreria {
	//En este caso lo que necesita la capa gestora
	//para funcionar es el dao del la librería
	//habria que adaptar todo el codigo a este dao
	@Autowired
	private DaoLibreria daoLibreria;

	public List<Libro> getListaLibros(){
		return daoLibreria.findAll();
	}
	
	/**
	 * Dar de alta un libro
	 * @param libro libro a dar de alta
	 * @return 0 en caso de que haya ido bien, 1 en caso
	 * de que falte el isbn, 2 en caso de que falte el titulo
	 * y 3 en caso de que el isbn este duplicado
	 */
	@Transactional
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
		/*if(buscarPorIsbn(libro.getIsbn()) != null) {
			return 3;
		}*/
		
		daoLibreria.save(libro);
		return 0;
	}
	
	public Libro buscarPorIsbn(String isbn) {
		//return daoLibreria.buscarPorIsbn(isbn);
		return null;
	}
	
	public List<Libro> buscarPorEditorial(String editorial){
		//return daoLibreria.buscarPorEditorial(editorial);
		return null;
	}
}
