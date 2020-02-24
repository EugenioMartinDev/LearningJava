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
import curso.modelo.persistancia.DaoPelicula;

//Aqui no anotamos la clase con @Controller
//ya que con esa anotacion lo que se esperan los
//metodos que devuelvas son vistas
//Aqui en rest devolvemos directamente datos
@RestController
public class ControladorPelicula {

	//ESTO NO DEBE HACERSE NUNCA NUNCA NUNCA JAMAS
	//NO HAGA ESTO EN SU CASA, SOLO BAJO SUPERVISION
	//DE SU PROFESOR. SIEMPRE HAY QUE PASAR POR EL GESTOR
	//ESTE EJEMPLO SOLO DEBE SER USADO PARA FINES EDUCATIVOS
	@Autowired
	private DaoPelicula daoPelicula;
	
	@GetMapping(path = "peliculas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Peliculas> listar(){
		List<Pelicula> lista = daoPelicula.findAll();
		Peliculas peliculas = new Peliculas();
		peliculas.setListaPelicula(lista);
		return new ResponseEntity<Peliculas>(peliculas,HttpStatus.OK);
	}

	// BODY {"titulo":"La guerra de los mundos","director":"Manolo","genero":"accion","year":1980}
	@PostMapping(path = "peliculas", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> alta(@RequestBody Pelicula p){
		daoPelicula.save(p);//actualiza el id
		return new ResponseEntity<Pelicula>(p,HttpStatus.CREATED);
	}
	
	//como el id que buscamos va como parametro de path o rutas
	//debemos de ponerlo entre llaves
	//la manera de recogerlo sera con la anotacion @PathParam
	@GetMapping(path ="peliculas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> obtener(@PathVariable("id") Integer id){
		Optional<Pelicula> opt = daoPelicula.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Pelicula>(opt.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path="peliculas/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE,
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> modificar(@RequestBody Pelicula pelicula,
					@PathVariable Integer id){
		Optional<Pelicula> opt = daoPelicula.findById(id);
		if(opt.isPresent()) {
			pelicula.setId(id);
			daoPelicula.save(pelicula);
			return new ResponseEntity<Pelicula>(pelicula,HttpStatus.OK);
		}else {
			pelicula.setId(id);
			return new ResponseEntity<Pelicula>(pelicula,HttpStatus.NOT_FOUND);
		}	
		
	}
	
	@DeleteMapping(path="peliculas/{id}")
	public ResponseEntity<Pelicula> borrar(@PathVariable Integer id){
		Optional<Pelicula> opt = daoPelicula.findById(id);
		if(opt.isPresent()) {
			daoPelicula.deleteById(id);
			return new ResponseEntity<Pelicula>(opt.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		}	
	}
}
