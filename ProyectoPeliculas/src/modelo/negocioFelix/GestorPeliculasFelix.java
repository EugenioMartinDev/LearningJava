package modelo.negocioFelix;

import java.util.ArrayList;

import vistaFelix.PeliculaFelix;


public class GestorPeliculasFelix {

	private ArrayList<PeliculaFelix> listaPeliculas;

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
	
	public void alta(PeliculaFelix pelicula) {		
		listaPeliculas.add(pelicula);		
	}
	
	//Listar películas es una función de la vista
	
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
	
	
	
}
