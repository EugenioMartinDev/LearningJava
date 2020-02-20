package curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.modelo.entidad.Pelicula;
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
	@PostMapping(path = "peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pelicula>> listar() {
		
		List<Pelicula> listaPeliculas = daoPelicula.findAll();
		
		return new ResponseEntity<List<Pelicula>>(listaPeliculas, HttpStatus.OK);
		
	}
	
	
	
}
