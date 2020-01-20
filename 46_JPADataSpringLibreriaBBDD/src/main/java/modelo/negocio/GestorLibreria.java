package modelo.negocio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidad.Libro;
import modelo.persistencia.DaoLibreria;

@Service
public class GestorLibreria {

	@Autowired
	private DaoLibreria daoLibreria;

	@Transactional
	public List<Libro> getListaLibros(){
		return daoLibreria.findAll();
	}
	
	
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
		if(buscarPorIsbn(libro.getIsbn()) != null) {
			return 3;
		}
		
		if (daoLibreria.save(libro) == null) {
			return 4;
		}
		
		return 0;
	}
	
	@Transactional
	public Libro buscarPorIsbn(String isbn) {
		return daoLibreria.
	}
	
	@Transactional
	public List<Libro> buscarPorEditorial(String editorial){
		return daoLibreria.buscarPorEditorial(editorial);
	}
}
