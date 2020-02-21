package curso.controlador;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import curso.modelo.entidad.Pelicula;
import curso.modelo.entidad.Peliculas;
import curso.modelo.persistencia.DaoPelicula;

//Aquí NO anotamos la clase con @Controller (no devolvemos vistas)
//SI la anotamos con @RestController (devolvemos datos)
@RestController
public class ControladorPelicula {
	
	//OJO -> el controlador llevaria llamar al gestor,
	//pero por simplicidad lo hacemos aqui.
	@Autowired
	private DaoPelicula daoPelicula;

	//Ejemplo 1 : Devolver todas las peliculas
	//Paso 1 : url como recursos (path = "peliculas" dentro de GetMapping)
	//Paso 2 : Metodos como verbos (GetMapping para get -> pedir informacion)
	//Paso 3 : Estado de representacion (produces = MediaType... (sinonimos o incluir un string))
	//Paso 4 : Codigo de respuesta : 200_OK en ResponseEntity HttpStatus.OK.
	//Paso 5 : Uso de cabeceras : listaPeliculas en ResponseEntity ; y produces -> Content-Type
	
	//Por ultimo, probamos el uso de cabecera. Par ello enviamos varios media types y el cliente tiene que enviar 
	//la cabecera accept para indicar el format requerido
	@GetMapping(path = "peliculas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Peliculas> listar() {
		
		List<Pelicula> listaPeliculas = daoPelicula.findAll();
		
		Peliculas peliculas = new Peliculas();
		
		peliculas.setListaPeliculas(listaPeliculas);
		
		return new ResponseEntity<Peliculas>(peliculas, HttpStatus.OK);
		
	}
	
	
	//En Post, recibimos los datos como requestParam o en json o de otra forma. Eso se indica
	//con el tag consumes en su MediaType.
	//Enviamos los datos con el tag produces
	//Parseamos los datos con la notacion @RequestBody y el objeto recibido con su clase.
	//El cliente nos tiene que generar un body de esta forma:
	// BODY {"titulo":"La guerra de los mundos","director":"Manolo","genero":"accion":"year":1980}
	//(Si algunos de los nombres de los atributos es erroneo, ese atributo no se copia, pero el resto si.
	@PostMapping(path = "peliculas", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Pelicula> alta(@RequestBody Pelicula p) {
		
		daoPelicula.save(p); //actualiza el id
		
		return new ResponseEntity<Pelicula>(p, HttpStatus.CREATED);  //response 201
	}
	
	//Ejemplo de obtener una sola pelicula
	//El id que buscamos va como parametro de path, se incluye entre llaves
	@GetMapping(path = "pelicula/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable("id") Integer id) {

		Optional<Pelicula> opt = daoPelicula.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Pelicula>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	//Ejemplo de Put
	@PutMapping(path = "pelicula/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> modificar(@RequestBody Pelicula pelicula, @PathVariable("id") Integer id) {
		
		Optional<Pelicula> opt = daoPelicula.findById(id);
		if (opt.isPresent()) {
			pelicula.setId(id);
			daoPelicula.save(pelicula);
			return new ResponseEntity<Pelicula>(pelicula, HttpStatus.OK); 
		} else {
			pelicula.setId(id);	
			return new ResponseEntity<Pelicula>(pelicula, HttpStatus.NOT_FOUND); 
		}		
	}
	
	//Ejmplo de Delete
	//En realidad no hace falta marcar en pathvariable el nombre de la variable cuando coincide con el nombre del parametro de entrada al metodo
	@DeleteMapping(path = "pelicula/{id}")
	public ResponseEntity<Pelicula> borrar(@PathVariable Integer id) {
	
		Optional<Pelicula> opt = daoPelicula.findById(id);
		if (opt.isPresent()) {
			daoPelicula.deleteById(id);
			return new ResponseEntity<Pelicula>(opt.get(), HttpStatus.OK); 
		} else {
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND); 
		}	
		
	}
}
