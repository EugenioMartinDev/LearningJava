package modelo.negocioFelix;

import java.util.ArrayList;

import vistaFelix.PeliculaFelix;


public class GestorPeliculasFelix {

	private ArrayList<PeliculaFelix> listaPeliculas = null;

	/**
	 * @return the listaPeliculas
	 */
	public ArrayList<PeliculaFelix> getListaPeliculas() {
		return listaPeliculas;
	}

	/**
	 * @param listaPeliculas the listaPeliculas to set
	 */
	public void setListaPeliculas(ArrayList<PeliculaFelix> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	/**
	 * Método que da de alta una película
	 * @param pelicula : representa la película a dar de alta
	 */
	public boolean alta(PeliculaFelix pelicula) {	
		// Si tenemos algún requisito funcionales o validaciones
		// debe ir al menos en la parte de negocio.
		// Se puede meter en la vista pero de manera opcional.
		if (pelicula.getTitulo().length() >= 5) {
			listaPeliculas.add(pelicula);
			return true;
		} else return false;		
	}
	
	/**
		Listar películas es una función de la vista	 
	 */
	
	/**
	 * Método que busca por título una película.
	 * @param titulo : El título de la película a buscar
	 * @return : La película encontrada o un valor null si no se encuentra
	 */
	public PeliculaFelix buscarPorTitulo(String titulo) {
		for (PeliculaFelix pelicula : listaPeliculas) {
			if (pelicula.getTitulo().equals(titulo))
				return pelicula;
		}		
		return null;
	}
	
	
	/**
	 * Método que busca por género una película.
	 * @param genero : El género de la película a buscar
	 * @return : Todas las películas encontradas por género o una lista vacía si no se encuentra ninguna
	 */
	public ArrayList<PeliculaFelix> buscarPorGenero(String genero) {		
		ArrayList<PeliculaFelix> listaEncontrada = new ArrayList<PeliculaFelix>();
		for (PeliculaFelix pelicula : listaPeliculas) {
			if (pelicula.getGenero().equals(genero))
				listaEncontrada.add(pelicula);
		}		
		return listaEncontrada;
	}
	
	
}
