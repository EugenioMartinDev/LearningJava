package modelo.negocio;

//Esta parte del modelo se encargaría de realizar
//la logica de negocio de nuestra aplicacion, es decir
//de realizar las tareas que tiene que hacer. En este
//caso se encarga de dar de alta las peliculas, de devolver
//la lista de las peliculas y de buscar las peliculas
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidad.Pelicula;
import vista.MainPelicula;

//esto da de alta un objeto GestorPelicula con el id "gestorPeliculas"
@Service
public class GestorPeliculas {
	//con anotaciones no es necesario tener los getter y los setter
	//pero sigo necesitando el getListaPeliculas() para la vista
	@Autowired
	private ArrayList<Pelicula> listaPeliculas;

	public ArrayList<Pelicula> getListaPeliculas(){
		return listaPeliculas;
	}
	/**
	 * Metodo que da de alta una pelicula, pero el titulo 
	 * debe de tener al menos 5 caracteres
	 * @param p representa la pelicula a dar de alta
	 * @return true si el titulo tiene al menos 5 caracteres
	 * false en caso contrario
	 */
	public boolean alta(Pelicula p) {
		//si tenemos algun requisito funcinales o validacion
		//deben de ir al menos en la parte de negocio.
		//se puede meter en la vista pero de manera opcional
		if(p.getTitulo().length() > 5) {
			listaPeliculas.add(p);//add una pelicula a la vista
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Metodo que busca por titulo una pelicula
	 * @param titulo el titulo de la pelicula a busdcar
	 * @return pelicula en caso de que se encuetre, null
	 * en caso de que no se encuentre
	 */
	public Pelicula buscarPorTitulo(String titulo) {
		for(Pelicula p : listaPeliculas) {
			if(p.getTitulo().equals(titulo)){
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Metodo que devuelve un array de peliculas que se encuentren
	 * a partir de un genero de la pelicula
	 * @param genero el genero a buscar en la lista
	 * @return un array con las peliculas que tengan el mismo
	 * genero que el pasado por el parametro de entrada. Si
	 * no hay coincidencias el array estaría vacio
	 */
	public ArrayList<Pelicula> buscarPorGenero(String genero) {
		ArrayList<Pelicula> listaPeliculasGenero = 
				MainPelicula.context.getBean("peliculasPorGenero",ArrayList.class);
		for(Pelicula p : listaPeliculas) {
			if(p.getGenero().equals(genero)){
				listaPeliculasGenero.add(p);
			}
		}
		return listaPeliculasGenero;
	}
}
