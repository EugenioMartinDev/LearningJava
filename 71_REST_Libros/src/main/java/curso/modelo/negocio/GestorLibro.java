package curso.modelo.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Libro;
import curso.modelo.entidad.Libros;
import curso.modelo.persistencia.DaoLibro;

@Service
public class GestorLibro {

	@Autowired
	private DaoLibro daoLibro;
	
	public Libro alta(Libro libro) {
		
		boolean validado = validar(libro);
		
		if (validado) {
			daoLibro.save(libro);
			return libro;
		} else {
			return null;
		}
		
	}

	private boolean validar(Libro libro) {
		
		boolean validado = true;
		
		System.out.println(libro);
		
		//1.- Validar todos los campos no vacíos		
		if (libro.getAutor() == null
				||
				libro.getAutor().isEmpty()
				||
				libro.getEditorial() == null
				||
				libro.getEditorial().isEmpty()
				||
				libro.getTitulo() == null
				||
				libro.getTitulo().isEmpty()
				||
				libro.getIsbn() == null
				||
				libro.getIsbn().isEmpty()
				||
				libro.getYear() == null) {
			
			return false;		
		}

		//2.- Campo isbn único		
		String isbn = libro.getIsbn();
		
		Libro l = daoLibro.findByIsbn(isbn);
		if (l != null) {
			return false;
		}
		
		//3.- Combinación autor&título única
		
		String titulo = libro.getTitulo();
		String autor = libro.getAutor();
		
		List<Libro> listaLibros = daoLibro.findByAutorAndTitulo(autor, titulo);
		
		if (listaLibros != null
			&&
			!listaLibros.isEmpty()) {
			return false;
		}
		
		//4.- Año igual o inferior al actual
		
		Integer year = libro.getYear();
		
		if (year > Calendar.getInstance().get(Calendar.YEAR)) {
			return false;
		}		
		return validado;
	}
	
	
	public boolean modificar(Libro libro) {	
		Libro foundLibro = findLibro(libro);
		if (foundLibro != null) {
			if (libro.getTitulo() == null) libro.setTitulo(foundLibro.getTitulo());
			if (libro.getEditorial() == null) libro.setEditorial(foundLibro.getEditorial());
			if (libro.getAutor() == null) libro.setAutor(foundLibro.getAutor());
			if (libro.getIsbn() == null) libro.setIsbn(foundLibro.getIsbn());
			if (libro.getYear() == null) libro.setYear(foundLibro.getYear());
			daoLibro.save(libro);
			return true;
		} else {
			return false;
		}		
	}
	
	public Libro obtener(Libro libro) {	
		Libro l = findLibro(libro);
		if (l != null) {
			return l;
		} else {
			return null;
		}
	}
	
	public Libros listar() {	
		Libros libros = new Libros();
		
		List<Libro> listaLibros = daoLibro.findAll();
		
		if (listaLibros == null) {
			libros.setListaLibros(new ArrayList<Libro>());
		} else {
			libros.setListaLibros(listaLibros);
		}
		
		return libros;
						
	}
	
	public boolean borrar(Libro libro) {		
		if (findLibro(libro) != null) {
			daoLibro.deleteById(libro.getId());
			return true;
		}		
		return false;
	}
	
	
	private Libro findLibro(Libro libro) {
		
		System.out.println(libro);
		
		Optional l = daoLibro.findById(libro.getId());		
		if (l.isPresent()) {
			System.out.println(l.get());
			return (Libro)l.get();
		} 
		return null;
	}
	
}
