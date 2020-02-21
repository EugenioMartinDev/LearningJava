package curso.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import curso.modelo.entidad.Libro;
import curso.modelo.entidad.Libros;
import curso.modelo.negocio.GestorLibro;

@Controller
public class ControladorLibro {

	@Autowired
	private GestorLibro gl;
	
	@Autowired
	private Libro libro;
	
	@Autowired
	private Libros libros;
	
	@GetMapping(path = "libros", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Libros> listar(){
		libros = gl.listar();
		return new ResponseEntity<Libros>(libros,HttpStatus.OK);
	}

	// BODY {"titulo":"La guerra de los mundos","director":"Manolo","genero":"accion","year":1980}
	@PostMapping(path = "libro", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> alta(@RequestBody Libro l){
		if (gl.alta(l) != null) {
			return new ResponseEntity<Libro>(l,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//como el id que buscamos va como parametro de path o rutas
	//debemos de ponerlo entre llaves
	//la manera de recogerlo sera con la anotacion @PathParam
	@GetMapping(path ="libro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> obtener(@PathVariable("id") Integer id){
		libro.setId(id);
		libro = gl.obtener(libro);
		if (libro != null) {
			return new ResponseEntity<Libro>(libro,HttpStatus.OK);
		} else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path="libro/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE,
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> modificar(@RequestBody Libro libro,
					@PathVariable Integer id){
		libro.setId(id);
		if (gl.modificar(libro)) {			
			return new ResponseEntity<Libro>(libro,HttpStatus.OK);
		}else {
			return new ResponseEntity<Libro>(libro,HttpStatus.NOT_FOUND);
		}	
		
	}
	
	@DeleteMapping(path="libro/{id}")
	public ResponseEntity<Libro> borrar(@PathVariable Integer id){
		libro.setId(id);
		if (gl.borrar(libro)) {
			return new ResponseEntity<Libro>(libro,HttpStatus.OK);
		}else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}	
	}
	
}
