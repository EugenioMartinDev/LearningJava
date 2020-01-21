package modelo.negocio;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidad.Libro;
import modelo.persistencia.DaoLibreria;
import vista.MainLibreria;

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
	
	//@Transactional   No haría falta. La transacción sí que es necesaria cuando se manipula la BBDD: alta, modifiacion y baja
	public Libro buscarPorIsbn(String isbn) {
		Libro libro = MainLibreria.context.getBean("libro", Libro.class);
		libro.setIsbn(isbn);
		/*
		Example<Libro> example = Example.of(libro);
		if (daoLibreria.findOne(example).get() != null) {
			libro = daoLibreria.findOne(example).get();
		}
		
		*/
		
		libro = daoLibreria.findByIsbn(isbn);
		
		/* O ejecutar esto si por query
		try {
			libro = daoLibreria.findTitleByIsbn(isbn).get();
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			libro = null;
		}
		*/

		return libro;
	}
	
	//@Transactional   No haría falta. La transacción sí que es necesaria cuando se manipula la BBDD: alta, modifiacion y baja
	public List<Libro> buscarPorEditorial(String editorial){
		List<Libro> listaLibrosPorEditorial = new ArrayList<Libro>();
		/*
		Libro libro = MainLibreria.context.getBean("libro", Libro.class);
		libro.setEditorial(editorial);		
		Example<Libro> example = Example.of(libro);
		listaLibrosPorEditorial = daoLibreria.findAll(example);
		*/
		
		return daoLibreria.findByEditorial(editorial);
		
		/* O esto si por query
		listaLibrosPorEditorial = daoLibreria.findTitleByEditorial(editorial);
		return listaLibrosPorEditorial;
		*/
		
	}
}
